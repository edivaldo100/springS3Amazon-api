package com.edivaldo.s3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
 
@Configuration
public class S3Config {
	@Value("${edi.aws.access_key_id}")
	private String awsId;
 
	@Value("${edi.aws.secret_access_key}")
	private String awsKey;
	
	@Value("${edi.s3.region}")
	private String region;

	@Bean
	public AmazonS3 s3client() {
		System.out.println(" ");System.out.println(" ");System.out.println(" ");
		System.out.println(" awsId: "+awsId);System.out.println(" awsKey:"+awsKey);System.out.println(" ");
		System.out.println(" ");System.out.println(" ");System.out.println(" ");

		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
								.withRegion(Regions.fromName(region))
		                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
		                        .build();
		
		return s3Client;
	}
}
package com.redventures.ramengo.admin.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSnsConfiguration {

    @Value("${aws.region}")
    private String region;
    @Value("${aws.accessKeyId}")
    private String accessKeyId;
    @Value("${aws.secretKey}")
    private String secretKey;
    @Value("${aws.sns.topic.broth.arn}")
    private String brothTopicArn;
    @Value("${aws.sns.topic.protein.arn}")
    private String proteinTopicArn;

    @Bean
    public AmazonSNS amazonSNSBuilder(){
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKeyId, secretKey);
        return AmazonSNSClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)

                .build();
    }

    @Bean(name = "broth-catalog")
    public Topic snsBrothTopicBuilder(){
        return new Topic().withTopicArn(brothTopicArn);
    }

    @Bean(name = "protein-catalog")
    public Topic snsCatalogTopicBuilder(){
        return new Topic().withTopicArn(proteinTopicArn);
    }
}

package com.redventures.ramengo.admin.services.aws;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.Topic;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redventures.ramengo.admin.domain.Broth;
import com.redventures.ramengo.admin.domain.Protein;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AwsSnsService {

    private AmazonSNS snsClient;
    private Topic brothTopic;
    private Topic proteinTopic;
    private final ObjectMapper mapper = new ObjectMapper();
    private Logger LOG = LoggerFactory.getLogger(AwsSnsService.class);


    public AwsSnsService(AmazonSNS snsClient, @Qualifier("broth-catalog") Topic brothTopic,
                         @Qualifier("protein-catalog") Topic proteinTopic) {
        this.snsClient = snsClient;
        this.brothTopic = brothTopic;
        this.proteinTopic = proteinTopic;
    }

    private void publish(String message, Topic topic) {
        PublishRequest publishRequest = new PublishRequest()
                .withTopicArn(topic.getTopicArn())
                .withMessage(message);
        snsClient.publish(publishRequest);
        LOG.info("Send " + message);
    }

    public void publishBroth(Broth broth){
        try{
            String message = mapper.writeValueAsString(broth);
            this.publish(message, brothTopic);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
    }

    public void publishProtein(Protein protein){
        try{
            String message = mapper.writeValueAsString(protein);
            this.publish(message, proteinTopic);
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
    }
}

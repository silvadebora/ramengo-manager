package com.redventures.ramengo.admin.services.impl;

import com.google.gson.Gson;
import com.redventures.ramengo.admin.domain.Broth;
import com.redventures.ramengo.admin.repository.BrothRepository;
import com.redventures.ramengo.admin.services.IManagerService;
import com.redventures.ramengo.admin.services.aws.AmazonS3Service;
import com.redventures.ramengo.admin.services.aws.AwsSnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Service
public class ManagerBrothService implements IManagerService {

    @Autowired
    private AmazonS3Service amazonS3Service;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    @Value("${api.broth.url}")
    private String apiUrl;

    @Autowired
    private AwsSnsService awsSnsService;

    @Autowired
    private BrothRepository brothRepository;

    @Override
    public ResponseEntity save(String name, MultipartFile imageActive, MultipartFile imageInactive, String description, BigDecimal price) {
        String uploadImageActive = amazonS3Service.uploadFile(imageActive);
        String uploadImageInactive = amazonS3Service.uploadFile(imageInactive);
        Broth broth = populateBroth(name, uploadImageActive, uploadImageInactive, description, price);
        Broth save = brothRepository.save(broth);
        return ResponseEntity.ok(save);
    }

    @Override
    public ResponseEntity callRamengoToSave(Object object) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);
        Gson gson = new Gson();
        String json = gson.toJson(object);
        HttpEntity<String> entity = new HttpEntity<>(json, headers);
        try{
            ResponseEntity response = restTemplate.exchange(
                    apiUrl, HttpMethod.POST, entity, ResponseEntity.class);
            return response;
        } catch(RestClientException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Broth populateBroth(String name, String uploadImageActive, String uploadImageInactive, String description, BigDecimal price){
        Broth brothRequest = new Broth();
        brothRequest.setName(name);
        brothRequest.setDescription(description);
        brothRequest.setPrice(price);
        brothRequest.setImageActive(uploadImageActive);
        brothRequest.setImageInactive(uploadImageInactive);
        return brothRequest;
    }


}

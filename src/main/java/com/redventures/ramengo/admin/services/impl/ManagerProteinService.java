package com.redventures.ramengo.admin.services.impl;

import com.redventures.ramengo.admin.domain.Protein;
import com.redventures.ramengo.admin.services.IManagerService;
import com.redventures.ramengo.admin.services.aws.AmazonS3Service;
import com.redventures.ramengo.admin.services.aws.AwsSnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Service
public class ManagerProteinService implements IManagerService {

    @Autowired
    private AmazonS3Service amazonS3Service;

    @Autowired
    private AwsSnsService awsSnsService;

    @Override
    public void save(String name, MultipartFile imageActive, MultipartFile imageInactive, String description, BigDecimal price) {
        String uploadImageActive = amazonS3Service.uploadFile(imageActive);
        String uploadImageInactive = amazonS3Service.uploadFile(imageInactive);
        Protein protein = populateProtein(name, uploadImageActive, uploadImageInactive, description, price);
        awsSnsService.publishProtein(protein);
        //proteinServiceClient.addProtein(protein);
    }

    private Protein populateProtein(String name, String uploadImageActive, String uploadImageInactive, String description, BigDecimal price){
        Protein proteinRequest = new Protein();
        proteinRequest.setName(name);
        proteinRequest.setDescription(description);
        proteinRequest.setPrice(price);
        proteinRequest.setImageActive(uploadImageActive);
        proteinRequest.setImageInactive(uploadImageInactive);
        return proteinRequest;
    }
}

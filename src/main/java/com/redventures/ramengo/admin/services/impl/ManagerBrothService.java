package com.redventures.ramengo.admin.services.impl;

import com.redventures.ramengo.admin.domain.Broth;
import com.redventures.ramengo.admin.repository.BrothRepository;
import com.redventures.ramengo.admin.services.IManagerService;
import com.redventures.ramengo.admin.services.aws.AmazonS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Service
public class ManagerBrothService implements IManagerService {

    @Autowired
    private AmazonS3Service amazonS3Service;

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

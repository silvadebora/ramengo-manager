package com.redventures.ramengo.admin.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface IAmazonS3Service {

    String uploadFile(MultipartFile multipartFile);
    void uploadFileToS3Bucket(String filename, File file);
}

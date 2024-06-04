package com.redventures.ramengo.admin.services.aws;

import com.amazonaws.services.s3.model.PutObjectRequest;
import com.redventures.ramengo.admin.configuration.AwsS3Configuration;
import com.redventures.ramengo.admin.services.IAmazonS3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Component
public class AmazonS3Service implements IAmazonS3Service{

    @Autowired
    private AwsS3Configuration awsS3Configuration;

    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @Value("${aws.s3.endpointUrl}")
    private String endpointUrl;

    @Override
    public String uploadFile(MultipartFile multipartFile) {
        String fileUrl = "";
        try{
            File file = convertMultiPartFileToFile(multipartFile);
            String filename = generateFilename(multipartFile);
            fileUrl = awsS3Configuration.amazonS3Client().getUrl(bucketName, filename).toString();
            uploadFileToS3Bucket(filename, file);
            file.delete();
        } catch(Exception e){
            e.printStackTrace();
        }
        return fileUrl;
    }

    @Override
    public void uploadFileToS3Bucket(String filename, File file) {
        awsS3Configuration.amazonS3Client().
                putObject(new PutObjectRequest(bucketName, filename, file));
    }

    private File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convertedFile;
    }

    private String generateFilename(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

}

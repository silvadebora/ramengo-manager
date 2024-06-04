package com.redventures.ramengo.admin.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public interface IManagerService {

    ResponseEntity save(String name, MultipartFile imageActive,
              MultipartFile imageInactive, String description,
              BigDecimal price);

    ResponseEntity callRamengoToSave(Object object);
}

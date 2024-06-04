package com.redventures.ramengo.admin.services;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public interface IManagerService {

    void save(String name, MultipartFile imageActive,
              MultipartFile imageInactive, String description,
              BigDecimal price);
}

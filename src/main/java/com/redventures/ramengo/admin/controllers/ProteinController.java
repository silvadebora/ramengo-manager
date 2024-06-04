package com.redventures.ramengo.admin.controllers;

import com.redventures.ramengo.admin.services.impl.ManagerProteinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@RestController
@RequestMapping("/manager/proteins")
public class ProteinController {

    @Autowired
    private ManagerProteinService managerProteinService;

    @PostMapping
    public ResponseEntity save(@RequestParam("name") String name,
                               @RequestPart("imageActive") MultipartFile imageActive,
                               @RequestPart("imageInactive") MultipartFile imageInactive,
                               @RequestParam("description") String description,
                               @RequestParam("price") BigDecimal price){
        managerProteinService.save(name, imageActive, imageInactive, description, price);
        return ResponseEntity.ok().body(HttpStatus.CREATED);
    }
}

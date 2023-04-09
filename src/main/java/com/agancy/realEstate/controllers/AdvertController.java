package com.agancy.realEstate.controllers;

import com.agancy.realEstate.dto.AdvertCreationCommand;
import com.agancy.realEstate.services.AdvertService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/adverts")
public class AdvertController {

    private final AdvertService advertService;

    @PostMapping
    public ResponseEntity<?> createAdvert(@RequestBody AdvertCreationCommand command){
        advertService.createAdvert(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

package com.agancy.realEstate.controllers;

import com.agancy.realEstate.services.AdvertService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/adverts")
public class AdvertController {

    private final AdvertService advertService;
}

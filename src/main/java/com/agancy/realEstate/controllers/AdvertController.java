package com.agancy.realEstate.controllers;

import com.agancy.realEstate.dto.AdvertCreationCommand;
import com.agancy.realEstate.dto.AdvertFormInitData;
import com.agancy.realEstate.dto.AdvertListItem;
import com.agancy.realEstate.services.AdvertService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/adverts")
public class AdvertController {

    private final AdvertService advertService;

    @GetMapping("/formData")
    public ResponseEntity<AdvertFormInitData> getFormInitData(){
        return new ResponseEntity<>(advertService.getFormInitData(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAdvert(@RequestBody AdvertCreationCommand command){
        advertService.createAdvert(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AdvertListItem>> getAdvertList(){
        List<AdvertListItem> list = advertService.getAdvertList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}

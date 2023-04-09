package com.agancy.real_estate.controllers;

import com.agancy.real_estate.dto.AdvertCreationCommand;
import com.agancy.real_estate.dto.AdvertDetails;
import com.agancy.real_estate.dto.AdvertFormInitData;
import com.agancy.real_estate.dto.AdvertListItem;
import com.agancy.real_estate.services.AdvertService;
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
    public ResponseEntity<Void> createAdvert(@RequestBody AdvertCreationCommand command){
        advertService.createAdvert(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AdvertListItem>> getAdvertList(){
        List<AdvertListItem> list = advertService.getAdvertList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvertDetails> getAdvertDetails(@PathVariable Long id){
        return new ResponseEntity<>(advertService.getAdvertDetails(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvert(@PathVariable Long id){
        advertService.deleteAdvert(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

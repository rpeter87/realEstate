package com.agancy.realEstate.services;

import com.agancy.realEstate.dto.AdvertCreationCommand;
import com.agancy.realEstate.entities.Advert;
import com.agancy.realEstate.repositories.AdvertRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Transactional
@Service
@AllArgsConstructor
public class AdvertService {

    private final AdvertRepository advertRepository;

    public void createAdvert(AdvertCreationCommand command) {
        advertRepository.save(new Advert(command));
    }
}

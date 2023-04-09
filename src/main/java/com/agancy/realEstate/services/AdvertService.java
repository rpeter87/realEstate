package com.agancy.realEstate.services;

import com.agancy.realEstate.dto.*;
import com.agancy.realEstate.entities.Advert;
import com.agancy.realEstate.entities.CategoryType;
import com.agancy.realEstate.entities.SubCategoryType;
import com.agancy.realEstate.repositories.AdvertRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@AllArgsConstructor
public class AdvertService {

    private final AdvertRepository advertRepository;

    public void createAdvert(AdvertCreationCommand command) {
        advertRepository.save(new Advert(command));
    }

    public AdvertFormInitData getFormInitData() {
        return new AdvertFormInitData(
                Arrays.stream(CategoryType.values())
                        .map(CategoryTypeOption::new)
                        .collect(Collectors.toSet()),
                Arrays.stream(SubCategoryType.values())
                        .map(SubCategoryTypeOption::new)
                        .collect(Collectors.toSet())
        );
    }

    public List<AdvertListItem> getAdvertList() {
        return advertRepository.findAllActiveAdverts().stream()
                .map(AdvertListItem::new)
                .collect(Collectors.toList());
    }
}

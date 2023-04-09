package com.agancy.real_estate.services;

import com.agancy.real_estate.dto.*;
import com.agancy.real_estate.entities.Advert;
import com.agancy.real_estate.entities.CategoryType;
import com.agancy.real_estate.entities.SubCategoryType;
import com.agancy.real_estate.repositories.AdvertRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public AdvertDetails getAdvertDetails(Long id) {
        Advert advert = findActiveAdvertById(id);
        return new AdvertDetails(advert);
    }

    public void deleteAdvert(Long id) {
        Advert advert = findActiveAdvertById(id);
        advert.setActive(false);
        advertRepository.save(advert);
    }

    public void updateAdvert(Long id, AdvertCreationCommand command) {
            Advert advert = findActiveAdvertById(id);
            advert.setForSale(command.isForSale);
            advert.setCategoryType(CategoryType.valueOf(command.categoryType));
            advert.setSubCategoryType(SubCategoryType.valueOf(command.subCategoryType));
            advert.setZipCode(command.zipCode);
            advert.setSettlementName(command.settlementName);
            advert.setSettlementName(command.streetName);
            advert.setHouseNumber(command.houseNumber);
            advert.setParcelNumber(command.parcelNumber);
            advert.setFloorArea(command.floorArea);
            advert.setRoomNumber(command.roomNumber);
            advert.setHalfRoomNumber(command.halfRoomNumber);
            advert.setDescription(command.description);
            advert.setPrice(command.price);
            advert.setOverheadCost(command.overheadCost);
            advert.setPictureUrl(command.pictureUrl);
            advertRepository.save(advert);
        }

    private Advert findActiveAdvertById(Long id) {
        return advertRepository.findByIdAndActiveAdvert(id).orElseThrow(
                () -> new EntityNotFoundException("Advert with id: " + id + " not found"));
    }
}

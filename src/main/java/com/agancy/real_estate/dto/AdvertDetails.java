package com.agancy.real_estate.dto;

import com.agancy.real_estate.entities.Advert;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AdvertDetails {

    public Long id;
    public boolean forSale;
    public String categoryType;
    public String subCategoryType;
    public String zipCode;
    public String settlementName;
    public String streetName;
    public String houseNumber;
    public String parcelNumber;
    public Integer floorArea;
    public Integer roomNumber;
    public Integer halfRoomNumber;
    public String description;
    public Integer price;
    public Integer overheadCost;
    public LocalDateTime creationTimeStamp;

    public AdvertDetails(Advert advert) {
        this.id = advert.getId();
        this.forSale = advert.isForSale();
        this.categoryType = advert.getCategoryType().getDisplayName();
        this.subCategoryType = advert.getSubCategoryType().getDisplayName();
        this.zipCode = advert.getZipCode();
        this.settlementName = advert.getSettlementName();
        this.streetName = advert.getStreetName();
        this.houseNumber = advert.getHouseNumber();
        this.parcelNumber = advert.getParcelNumber();
        this.floorArea = advert.getFloorArea();
        this.roomNumber = advert.getRoomNumber();
        this.halfRoomNumber = advert.getHalfRoomNumber();
        this.description = advert.getDescription();
        this.price = advert.getPrice();
        this.overheadCost = advert.getOverheadCost();
        this.creationTimeStamp = advert.getCreationTimeStamp();
    }

}

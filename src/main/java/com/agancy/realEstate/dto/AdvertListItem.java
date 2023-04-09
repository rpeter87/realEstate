package com.agancy.realEstate.dto;

import com.agancy.realEstate.entities.Advert;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AdvertListItem {

    public Long id;
    public String settlementName;
    public Integer floorArea;
    public Integer roomNumber;
    public Integer price;
    public String pictureUrl;
    public LocalDateTime creationTimeStamp;

    public AdvertListItem(Advert advert) {
        this.id = advert.getId();
        this.settlementName = advert.getSettlementName();
        this.floorArea = advert.getFloorArea();
        this.roomNumber = advert.getRoomNumber();
        this.price = advert.getPrice();
        this.pictureUrl = advert.getPictureUrl();
        this.creationTimeStamp = advert.getCreationTimeStamp();
    }
}

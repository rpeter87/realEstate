package com.agancy.realEstate.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvertCreationCommand {

    public boolean isForSale;
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
    public String pictureUrl;
}

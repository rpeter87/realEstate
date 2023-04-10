package com.agancy.real_estate.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvertCreationCommand {

    @NotNull
    public boolean isForSale;

    @NotNull
    @NotBlank
    public String categoryType;

    @NotNull
    @NotBlank
    public String subCategoryType;

    @NotNull
    @Size(min = 4, max = 4)
    public String zipCode;

    @NotBlank
    @Size(max = 65)
    public String settlementName;

    @NotBlank
    @Size(min = 2, max = 35)
    public String streetName;

    @Size(max = 6)
    public String houseNumber;

    @Size(max = 12)
    public String parcelNumber;

    @NotNull(message = "Please enter a valid number")
    @Min(5)
    @Max(1000)
    public Integer floorArea;

    @NotNull(message = "Please enter a valid number")
    @Min(1)
    @Max(80)
    public Integer roomNumber;

    @Max(80)
    public Integer halfRoomNumber;

    @NotNull
    @NotBlank
    public String description;

    @NotNull(message = "Please enter a valid number")
    @Min(1)
    @Max(999999999)
    public Integer price;

    @Max(12000000)
    public Integer overheadCost;
    public String pictureUrl;
}

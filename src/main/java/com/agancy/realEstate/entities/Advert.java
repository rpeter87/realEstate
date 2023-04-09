package com.agancy.realEstate.entities;

import com.agancy.realEstate.dto.AdvertCreationCommand;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "advert")
public class Advert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "is_for_sale")
    private boolean forSale;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private CategoryType categoryType;

    @Enumerated(EnumType.STRING)
    @Column(name = "sub_category")
    private SubCategoryType subCategoryType;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "settlement_name")
    private String settlementName;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "parcel_number")
    private String parcelNumber;

    @Column(name = "floor_area")
    private Integer floorArea;

    @Column(name = "room_number")
    private Integer roomNumber;

    @Column(name = "half_room_number")
    private Integer halfRoomNumber;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "overhead_cost")
    private Integer overheadCost;

    @Column(name = "creation_time")
    private LocalDateTime creationTimeStamp;

    @Column(name = "picture")
    private String pictureUrl;

    @Column(name = "is_active")
    private boolean isActive;

    public Advert(AdvertCreationCommand command) {
        this.forSale = command.isForSale;
        this.categoryType = CategoryType.valueOf(command.getCategoryType());
        this.subCategoryType= SubCategoryType.valueOf(command.getSubCategoryType());
        this.zipCode = command.zipCode;
        this.settlementName = command.settlementName;
        this.streetName = command.streetName;
        this.houseNumber = command.houseNumber;
        this.parcelNumber = command.parcelNumber;
        this.floorArea = command.floorArea;
        this.roomNumber = command.roomNumber;
        this.halfRoomNumber = command.halfRoomNumber;
        this.description = command.description;
        this.price = command.price;
        this.overheadCost = command.overheadCost;
        this.creationTimeStamp = LocalDateTime.now();
        this.pictureUrl = command.getPictureUrl();
        this.isActive = true;
    }
}

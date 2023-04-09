package com.agancy.real_estate.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum SubCategoryType {

    //  Flat
    PANEL("Panel"),
    BRICK("Tégla"),

    // House
    FAMILY_HOUSE("Családi ház"),
    TWIN_HOUSE("Ikerház"),
    ROW_HOUSE("Sorház"),
    HOUSE_PART("házrész"),
    FARM("Tanya"),

    // Land
    RESIDENTIAL_LAND("Lakóövezeti telek"),
    RESORT_LAND("Üdülőövezeti telek"),
    OTHER_LAND("Egyéb telek"),

    // Summer resort
    WEEKEND_RESORT("Hétvégi házas nyaraló"),
    HOLIDAY_RESORT("Üdülő házas nyaraló"),

    // Garage
    INDEPENDENT_GARAGE("Önálló garázs"),
    GARAGE_HALL("Teremgarázs"),
    PROTECTED_PLACE("Beálló");

    private String displayName;
}

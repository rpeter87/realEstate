package com.agancy.real_estate.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CategoryType {

    FLAT("Lakás"),
    HOUSE("Ház"),
    LAND("Telek"),
    SUMMER_RESORT("Nyaraló"),
    GARAGE("Garázs");

    private String displayName;
}

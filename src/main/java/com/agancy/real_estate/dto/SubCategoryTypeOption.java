package com.agancy.real_estate.dto;

import com.agancy.real_estate.entities.SubCategoryType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubCategoryTypeOption {

    public String name;
    public String displayName;

    public SubCategoryTypeOption(SubCategoryType subCategoryType) {
        this.name = subCategoryType.name();
        this.displayName = subCategoryType.getDisplayName();
    }
}

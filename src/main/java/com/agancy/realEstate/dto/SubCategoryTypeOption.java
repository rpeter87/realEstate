package com.agancy.realEstate.dto;

import com.agancy.realEstate.entities.SubCategoryType;
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

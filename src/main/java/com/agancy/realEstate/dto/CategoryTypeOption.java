package com.agancy.realEstate.dto;

import com.agancy.realEstate.entities.CategoryType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryTypeOption {

    public String name;
    public String displayName;

    public CategoryTypeOption(CategoryType category) {
        this.name = category.name();
        this.displayName = category.getDisplayName();
    }
}

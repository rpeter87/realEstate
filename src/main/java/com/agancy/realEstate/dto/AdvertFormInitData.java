package com.agancy.realEstate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertFormInitData {

    public Set<CategoryTypeOption> categoryTypes;
    public Set<SubCategoryTypeOption> subCategoryTypes;
}

package com.tms.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Setter
@Getter
public class DistrictDto {
    private Integer id;
    private String name;
    private Set<FulfillmentDto> fulfillmentDtoSet;
    private Set<LastmileDto> lastmileDtoSet;
    private Set<WarehouseDto> warehouseDtoSet;

    public DistrictDto(){}

    public DistrictDto(Integer id, String name, Set<FulfillmentDto> fulfillmentDtoSet,
                       Set<LastmileDto> lastmileDtoSet, Set<WarehouseDto> warehouseDtoSet){
        this.id = id;
        this.name = name;
        this.fulfillmentDtoSet = fulfillmentDtoSet;
        this.lastmileDtoSet = lastmileDtoSet;
        this.warehouseDtoSet = warehouseDtoSet;
    }
}

package com.tms.api.dto;

import com.tms.api.datacollection.ProvinceDataCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ProvinceDto {
    private Integer id;
    private String name;
    private Set<FulfillmentDto> fulfillmentDtoSet ;
    private Set<LastmileDto> lastmileDtoSet;
    private Set<WarehouseDto> warehouseDtoSet;

    public ProvinceDto(){
    }
    public ProvinceDto(Integer id, String name, Set<FulfillmentDto> fulfillmentDtoSet,
                       Set<LastmileDto> lastmileDtoSet, Set<WarehouseDto> warehouseDtoSet){
        this.id = id;
        this.name = name;
        this.fulfillmentDtoSet = fulfillmentDtoSet;
        this.lastmileDtoSet =  lastmileDtoSet;
        this.warehouseDtoSet =  warehouseDtoSet;
    }


}

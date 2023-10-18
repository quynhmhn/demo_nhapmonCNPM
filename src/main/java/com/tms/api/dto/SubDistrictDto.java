package com.tms.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubDistrictDto {
    private Integer id;
    private String name;
    private List<FulfillmentDto> fulfillmentDtoList;
    private List<LastmileDto> lastmileDtoList;
    private List<WarehouseDto> warehouseDtoList;
}

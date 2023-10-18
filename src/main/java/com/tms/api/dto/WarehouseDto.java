package com.tms.api.dto;

import com.tms.api.datacollection.ProvinceDataCollection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseDto {
    private Integer id;
    private String name;
    public WarehouseDto(Integer id, String name){
        this.id = id;
        this.name= name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof WarehouseDto){
            WarehouseDto warehouseDto = (WarehouseDto) obj;
            if(this.id.equals(warehouseDto.id) && this.name.equals(warehouseDto.name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode() ^ name.hashCode();
    }
}

package com.tms.api.dto;

import com.tms.api.datacollection.ProvinceDataCollection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FulfillmentDto {
    private Integer id;
    private String name;

    public FulfillmentDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FulfillmentDto) {
            FulfillmentDto fulfillmentDto = (FulfillmentDto) obj;
            if (this.id.equals(fulfillmentDto.id) && this.name.equals(fulfillmentDto.name)) {
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

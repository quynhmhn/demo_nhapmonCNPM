package com.tms.api.dto;


import com.tms.api.datacollection.ProvinceDataCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class LastmileDto {
    private Integer id;
    private String name;

    public LastmileDto(Integer id, String name){
        this.id = id;
        this.name = name;
    }
    //ghi de phuong thuc equal va hashcode de cac phan tu trong set khong bị trung lap

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof LastmileDto){
            LastmileDto lastmileDto = (LastmileDto) obj;
            if(this.id.equals(lastmileDto.id) && this.name.equals(lastmileDto.name)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode() ^ name.hashCode();
    }

    //tại sao dùng equal và hashcode có thể loại bỏ phần tử trùng lặp,
    //vậy tại sao trong province lại phải dùng map để check trùng
    //tìm hiểu cách sử dụng set để check trùng với province
}

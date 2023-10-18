package com.tms.api.service;

import com.tms.api.dto.ProvinceDto;

import java.util.List;

public interface ProvinceService {
    List<ProvinceDto> getProvinceLogisticLevel1();
    List<ProvinceDto> getProvinceLogisticLevel2();
    List<ProvinceDto> getProvinceLogisticLevel3();
    List<ProvinceDto> getLevel();


}

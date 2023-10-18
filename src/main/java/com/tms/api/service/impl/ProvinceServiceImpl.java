package com.tms.api.service.impl;

import com.tms.api.consts.Const;
import com.tms.api.datacollection.ProvinceDataCollection;
import com.tms.api.dto.FulfillmentDto;
import com.tms.api.dto.LastmileDto;
import com.tms.api.dto.ProvinceDto;
import com.tms.api.dto.WarehouseDto;
import com.tms.api.repository.ProvinceRepository;
import com.tms.api.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Value("${level.level-mapping}")
    public int level;

    private final ProvinceRepository provinceRepository;

    @Autowired
    public ProvinceServiceImpl(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    public List<ProvinceDto> getLogistics(List<ProvinceDataCollection> listResultQuery) {
        Map<Integer, ProvinceDto> provinceDtoMap = new LinkedHashMap<>();
        for (ProvinceDataCollection provinceDataCollection : listResultQuery) {
            ProvinceDto provinceDto;
            if (!provinceDtoMap.containsKey(provinceDataCollection.getProvinceId())) {
                provinceDto = new ProvinceDto();
                provinceDto.setId(provinceDataCollection.getProvinceId());
                provinceDto.setName(provinceDataCollection.getProvinceName());
                provinceDto.setFulfillmentDtoSet(new LinkedHashSet<>());
                provinceDto.setLastmileDtoSet(new LinkedHashSet<>());
                provinceDto.setWarehouseDtoSet(new LinkedHashSet<>());
                provinceDtoMap.put(provinceDataCollection.getProvinceId(), provinceDto);
            }
            provinceDto = provinceDtoMap.get(provinceDataCollection.getProvinceId());
            FulfillmentDto fulfillmentDto =
                    new FulfillmentDto(provinceDataCollection.getFulfillmentId(),
                            provinceDataCollection.getFulfillmentName());
            provinceDto.getFulfillmentDtoSet().add(fulfillmentDto);
            LastmileDto lastmileDto =
                    new LastmileDto(provinceDataCollection.getLastmileId(),
                            provinceDataCollection.getLastmileName());
            provinceDto.getLastmileDtoSet().add(lastmileDto);
            WarehouseDto warehouseDto =
                    new WarehouseDto(provinceDataCollection.getWarehouseId(),
                            provinceDataCollection.getWarehouseName());
            provinceDto.getWarehouseDtoSet().add(warehouseDto);
        }
        return new ArrayList<>(provinceDtoMap.values());
    }

    @Override
    public List<ProvinceDto> getProvinceLogisticLevel1() {
        List<ProvinceDataCollection> listResultQuery =
                provinceRepository.getProvinceLogisticLevel1();
        return getLogistics(listResultQuery);
    }

    @Override
    public List<ProvinceDto> getProvinceLogisticLevel2() {
        List<ProvinceDataCollection> listResultQuery =
                provinceRepository.getProvinceLogisticLevel2();
        return getLogistics(listResultQuery);
    }

    @Override
    public List<ProvinceDto> getProvinceLogisticLevel3() {
        List<ProvinceDataCollection> listResultQuery =
                provinceRepository.getProvinceLogisticLevel3();
        return getLogistics(listResultQuery);
    }

    @Override
    public List<ProvinceDto> getLevel() {
        if (level == Const.LEVEL1) {
            return getProvinceLogisticLevel1();
        }
        if (level == Const.LEVEL2) {
            return getProvinceLogisticLevel2();
        }
        return getProvinceLogisticLevel3();
    }
}



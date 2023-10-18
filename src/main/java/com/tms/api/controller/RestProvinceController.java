package com.tms.api.controller;

import com.tms.api.consts.Const;
import com.tms.api.dto.ProvinceDto;
import com.tms.api.exception.TMSException;
import com.tms.api.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/provinces")
@RequiredArgsConstructor
public class RestProvinceController {
    private final ProvinceService provinceService;

    @GetMapping(value = "/logistic-province")
    public List<ProvinceDto> getProvinceLogisticLevel1() {
        List<ProvinceDto> result = provinceService.getProvinceLogisticLevel1();
        return ResponseEntity.ok(result).getBody();
    }

    @GetMapping(value = "/logistic-district")
    public List<ProvinceDto> getProvinceLogisticLevel2() {
        List<ProvinceDto> result = provinceService.getProvinceLogisticLevel2();
        return ResponseEntity.ok(result).getBody();
    }

    @GetMapping(value = "/logistic-subdistrict")
    public ResponseEntity<List<ProvinceDto>> getprovinceLogisticLevel3(){
        List<ProvinceDto> result = provinceService.getProvinceLogisticLevel3();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ProvinceDto>> getLevels(){
        List<ProvinceDto> result = provinceService.getLevel();
        return ResponseEntity.ok(result);
    }
}

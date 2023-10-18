package com.tms.api.repository;

import com.tms.api.datacollection.ProvinceDataCollection;
import com.tms.api.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer> {
    @Query(value = "SELECT p.prv_id AS provinceId, p.code AS provinceCode, p.NAME AS provinceName, " +
            " cfdd.fulfillment_id AS fulfillmentId, ptn1.name AS fulfillmentName, " +
            " cfdd.lastmile_id AS lastmileId, ptn2.name AS lastmileName, " +
            " wh.warehouse_id AS warehouseId, wh.warehouse_name AS warehouseName " +
            " FROM cf_default_delivery cfdd " +
            " INNER JOIN  lc_province p ON cfdd.location_id = p.prv_id " +
            " INNER JOIN bp_partner ptn1 ON cfdd.fulfillment_id = ptn1.pn_id " +
            " INNER JOIN bp_partner ptn2 ON cfdd.lastmile_id = ptn2.pn_id " +
            " INNER JOIN bp_warehouse wh ON cfdd.warehouse_id = wh.warehouse_id " +
            " ORDER BY p.prv_id ASC", nativeQuery = true)
    List<ProvinceDataCollection> getProvinceLogisticLevel1();

    @Query(value = " SELECT p.prv_id AS provinceId, p.name AS provinceName, " +
            " cfdd.fulfillment_id AS fulfillmentId , bp_ffm.name AS fulfillmentName," +
            " cfdd.lastmile_id AS lastmileId, bp_lm.name AS lastmileName, " +
            " wh.warehouse_id AS warehouseId, wh.warehouse_name AS warehouseName " +
            " FROM cf_default_delivery cfdd " +
            " INNER JOIN lc_district dt ON cfdd.location_id = dt.dt_id " +
            " INNER JOIN lc_province p ON dt.prv_id = p.prv_id " +
            " INNER JOIN bp_partner bp_ffm ON cfdd.fulfillment_id = bp_ffm.pn_id " +
            " INNER JOIN bp_partner bp_lm ON cfdd.lastmile_id = bp_lm.pn_id " +
            " INNER JOIN bp_warehouse wh ON cfdd.warehouse_id = wh.warehouse_id " +
            " ORDER BY p.prv_id ASC ",
            nativeQuery = true)
    List<ProvinceDataCollection> getProvinceLogisticLevel2();

    @Query(value = " SELECT p.prv_id AS provinceId , p.name AS provinceName, " +
            "p.code AS provinceCode, cfdd.fulfillment_id AS fulfillmentId, " +
            "ptn1.name AS fulfillmentName , cfdd.lastmile_id AS lastmileid , " +
            "ptn2.name AS lastmileName , wh.warehouse_id AS warehouseId , " +
            "wh.warehouse_name AS warehouseName " +
            " FROM cf_default_delivery cfdd " +
            " INNER JOIN lc_province p ON p.prv_id = cfdd.location_id " +
            " INNER JOIN bp_partner ptn1 ON cfdd.fulfillment_id = ptn1.pn_id " +
            " INNER JOIN bp_partner ptn2 ON cfdd.lastmile_id = ptn2.pn_id " +
            " INNER JOIN bp_warehouse wh ON cfdd.warehouse_id = wh.warehouse_id " +
            " INNER JOIN lc_district dt ON cfdd.location_id = dt.prv_id " +
            " INNER JOIN lc_subdistrict sdt ON dt.dt_id = sdt.dt_id " +
            " ORDER BY p.prv_id ASC",
            nativeQuery = true)
    List<ProvinceDataCollection> getProvinceLogisticLevel3();
}

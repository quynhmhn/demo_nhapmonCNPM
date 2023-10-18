package com.tms.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lc_subdistrict")
public class SubDistrict {

    @Column(name = "sdt_id" )
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "dt_id")
    private Integer districtId;
}

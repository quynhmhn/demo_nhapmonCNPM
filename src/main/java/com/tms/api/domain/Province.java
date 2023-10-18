package com.tms.api.domain;


import com.tms.api.dto.FulfillmentDto;

import javax.persistence.*;

@Entity
@Table(name = "lc_province")
public class Province {
    @Column(name = "prv_id")
    @Id
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;

}

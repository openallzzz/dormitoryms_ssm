package org.zzzzzz.entity;

import lombok.Data;

@Data
public class Dormitory {
    private Integer id;
    private Integer buildingId;
    private String buildingName;
    private String name;
    private Integer type;
    private Integer available;
    private String telephone;
}

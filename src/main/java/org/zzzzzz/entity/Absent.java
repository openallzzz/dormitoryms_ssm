package org.zzzzzz.entity;

import lombok.Data;

@Data
public class Absent {

    private Integer id;
    private Integer buildingId;
    private String buildingName;
    private Integer dormitoryId;
    private String dormitoryName;
    private Integer studentId;
    private String studentName;
    private Integer dormitoryAdminId;
    private String dormitoryAdminName;
    private String createDate;
    private String reason;

}


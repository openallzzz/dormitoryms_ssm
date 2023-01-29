package org.zzzzzz.entity;

import lombok.Data;

@Data
public class Moveout {
    private Integer studentId;
    private Integer dormitoryId;
    private String reason;
    private String createDate;
}

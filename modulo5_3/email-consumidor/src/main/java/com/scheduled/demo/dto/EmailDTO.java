package com.scheduled.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EmailDTO {

    @NotEmpty
    private String to;

    @NotEmpty
    private String subject;

    @NotEmpty
    private String text;
}

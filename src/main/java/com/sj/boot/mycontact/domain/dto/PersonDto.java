package com.sj.boot.mycontact.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonDto {

    private String name;
    private int age;
    private String hobby;
    private String bloodType;
    private String address;
    private LocalDate birthday;
    private String job;
    private String phoneNumber;

}

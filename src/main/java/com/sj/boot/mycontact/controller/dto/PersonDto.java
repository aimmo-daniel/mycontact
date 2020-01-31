package com.sj.boot.mycontact.controller.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Data
public class PersonDto {

    private String name;
    private String hobby;
    private String address;
    private LocalDate birthday;
    private String job;
    private String phoneNumber;

}

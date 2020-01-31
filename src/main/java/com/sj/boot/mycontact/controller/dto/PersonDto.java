package com.sj.boot.mycontact.controller.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Data
public class PersonDto {

    @NotBlank(message = "이름은 필수값입니다.")
    private String name;
    private String hobby;
    private String address;
    private LocalDate birthday;
    private String job;
    private String phoneNumber;

}

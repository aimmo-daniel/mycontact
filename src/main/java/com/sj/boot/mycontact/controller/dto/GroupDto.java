package com.sj.boot.mycontact.controller.dto;

import lombok.*;

@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Data
public class GroupDto {

    private String description;

}

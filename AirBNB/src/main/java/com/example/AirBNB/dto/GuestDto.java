package com.example.AirBNB.dto;

import com.example.AirBNB.entity.User;
import com.example.AirBNB.entity.enums.Gender;
import lombok.Data;

@Data
public class GuestDto {

    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;

}

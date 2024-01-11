package com.anotsky.testbit.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {
    private Long id;
    private String number;
    private String fullAddress;
    private Long apartmentCount;


}

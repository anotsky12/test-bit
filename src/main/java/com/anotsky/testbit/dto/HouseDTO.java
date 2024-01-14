package com.anotsky.testbit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {
    private Long id;
    private String number;
    private String fullAddress;
    private Long apartmentCount;


}

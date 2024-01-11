package com.anotsky.testbit.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
    private Long id;
    private String name;
    private Long houseCount;
}

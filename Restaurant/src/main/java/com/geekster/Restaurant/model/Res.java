package com.geekster.Restaurant.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Res {


    private String restaurantName;
    @NotBlank(message = "name cannot be blank")
    private String restaurantAddress;
    @NotBlank(message = "name cannot be blank")
    private Integer restaurantId;

    private String restaurantSpeciality;
    @Min(value = 3)
    private Integer restaurantStaffs;

}

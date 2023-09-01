package com.homework.darkmode.DTO;

import com.homework.darkmode.model.Car;
import lombok.Data;

import java.util.List;
@Data
public class CarsDto {

    private boolean darkmode;

    private List<Car> carList;

    public CarsDto(Boolean darkmode , List<Car> cars){
        this.darkmode=darkmode;
        this.carList=cars;

    }


}

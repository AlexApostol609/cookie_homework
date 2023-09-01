package com.homework.darkmode.service;

import com.homework.darkmode.model.Car;
import com.homework.darkmode.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

}

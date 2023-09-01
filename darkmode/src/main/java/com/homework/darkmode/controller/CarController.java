package com.homework.darkmode.controller;

import com.homework.darkmode.DTO.CarsDto;
import com.homework.darkmode.DTO.DarkmodeDto;
import com.homework.darkmode.model.Car;
import com.homework.darkmode.service.CarService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CarController {

    @Autowired
    CarService carService;
    @GetMapping(value = "/cars")
    private ResponseEntity<CarsDto> getDarkModeAndCars(@CookieValue(name = "darkmode" , defaultValue = "false") Boolean darkmode){
        List<Car> cars = carService.getAllCars();
        CarsDto objectDto = new CarsDto(darkmode,cars);
        return ResponseEntity.ok(objectDto);
    }

    @GetMapping(value = "/dark-mode")
    private ResponseEntity<Void> setDarkMode(@RequestBody DarkmodeDto darkmode ){
        Boolean darkMode = darkmode.isDarkmode();

        ResponseCookie springCookie = ResponseCookie.from("darkmode", darkMode.toString())
                .path("/")
                .maxAge(3600)
                .build();

        return ResponseEntity .ok()
                .header(HttpHeaders.SET_COOKIE, springCookie.toString()) .build();

    }

}

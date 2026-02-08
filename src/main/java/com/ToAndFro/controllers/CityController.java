package com.ToAndFro.controllers;

import com.ToAndFro.models.dto.request.CityRequestDto;
import com.ToAndFro.models.dto.request.UpdateCityRequestDto;
import com.ToAndFro.models.dto.response.CityResponseDto;
import com.ToAndFro.service.CityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<CityResponseDto> findAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public CityResponseDto findCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityResponseDto createCity(@RequestBody CityRequestDto cityRequestDto) {
        return cityService.createCity(cityRequestDto);
    }

    @PutMapping("/{id}")
    public CityResponseDto updateCity(@PathVariable Long id, @RequestBody CityRequestDto cityRequestDto) {
        return cityService.updateCity(id, cityRequestDto);
    }

    @PatchMapping
    public CityResponseDto patchCity(@PathVariable Long id, @RequestBody UpdateCityRequestDto cityRequestDto) {
        return cityService.patchCity(id, cityRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}

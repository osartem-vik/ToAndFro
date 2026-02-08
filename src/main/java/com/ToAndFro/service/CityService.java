package com.ToAndFro.service;

import com.ToAndFro.exceptions.CityAlreadyExistsException;
import com.ToAndFro.exceptions.CityNotFoundException;
import com.ToAndFro.models.dto.request.CityRequestDto;
import com.ToAndFro.models.dto.request.UpdateCityRequestDto;
import com.ToAndFro.models.dto.response.CityResponseDto;
import com.ToAndFro.models.entities.City;
import com.ToAndFro.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final RegionService regionService;
    private final ModelMapper modelMapper;

    public List<CityResponseDto> getAllCities() {
        return cityRepository.findAll()
                .stream()
                .map(city -> modelMapper.map(city, CityResponseDto.class))
                .toList();
    }


    public CityResponseDto getCityById(Long id) {
        City city = cityRepository.findById(id).orElseThrow(
                () -> new CityNotFoundException("City with id " + id + " not found"));
        return modelMapper.map(city, CityResponseDto.class);
    }


    public CityResponseDto createCity(CityRequestDto cityRequestDto) {
        if (cityRepository.existsByName(cityRequestDto.getName())) {
            throw new CityAlreadyExistsException("City with name " + cityRequestDto.getName() + " already exists");
        }

        City city = modelMapper.map(cityRequestDto, City.class);
        city.setRegion(regionService.getRegionById(cityRequestDto.getRegionId()));

        return modelMapper.map(cityRepository.save(city), CityResponseDto.class);
    }

    public CityResponseDto updateCity(Long id, CityRequestDto cityRequestDto) {
        City city = cityRepository.findById(id).orElseThrow(
                () -> new CityNotFoundException("City with id " + id + " not found"));
        if (!city.getName().equals(cityRequestDto.getName()) && cityRepository.existsByName(cityRequestDto.getName())) {
            throw new CityAlreadyExistsException("City with name " + cityRequestDto.getName() + " already exists");
        }

        modelMapper.map(cityRequestDto, city);
        city.setRegion(regionService.getRegionById(cityRequestDto.getRegionId()));

        return modelMapper.map(cityRepository.save(city), CityResponseDto.class);
    }

    public CityResponseDto patchCity(Long id, UpdateCityRequestDto cityRequestDto) {
        City city = cityRepository.findById(id).orElseThrow(
                () -> new CityNotFoundException("City with id " + id + " not found"));

        if (cityRequestDto.getName() != null &&
            !city.getName().equals(cityRequestDto.getName()) && cityRepository.existsByName(cityRequestDto.getName()))
        {
            throw new CityAlreadyExistsException("City with name " + cityRequestDto.getName() + " already exists");
        }

        modelMapper.map(cityRequestDto, city);

        if (cityRequestDto.getRegionId() != null) {
            city.setRegion(regionService.getRegionById(cityRequestDto.getRegionId()));
        }

        return modelMapper.map(cityRepository.save(city), CityResponseDto.class);
    }

    public void deleteCity(Long id) {
        City city = cityRepository.findById(id).orElseThrow(
                () -> new CityNotFoundException("City with id " + id + " not found"));
        cityRepository.delete(city);
    }
}

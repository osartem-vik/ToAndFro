package com.ToAndFro.service;

import com.ToAndFro.exceptions.RegionNotFoundException;
import com.ToAndFro.models.dto.request.RegionRequestDto;
import com.ToAndFro.models.dto.response.RegionResponseDto;
import com.ToAndFro.models.entities.Region;
import com.ToAndFro.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;
    private final ModelMapper modelMapper;


    public List<RegionResponseDto> findAllRegions() {
        return regionRepository.findAll()
                .stream()
                .map(region -> modelMapper.map(region, RegionResponseDto.class))
                .toList();
    }

    public RegionResponseDto findRegionById(Long id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException("Region with id " + id + " not found"));
        return modelMapper.map(region, RegionResponseDto.class);
    }

    public RegionResponseDto createRegion(RegionRequestDto regionRequestDto) {
        Region region = modelMapper.map(regionRequestDto, Region.class);
        return modelMapper.map(regionRepository.save(region), RegionResponseDto.class);
    }


    public RegionResponseDto updateRegion(Long id, RegionRequestDto regionRequestDto) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new RegionNotFoundException("Region with id " + id + " not found"));

        modelMapper.map(regionRequestDto, region);
        return modelMapper.map(regionRepository.save(region), RegionResponseDto.class);
    }

    public void deleteRegion(Long id) {
        if (!regionRepository.existsById(id)) {
            throw new RegionNotFoundException("Region with id " + id + " not found");
        }
        regionRepository.deleteById(id);
    }
}

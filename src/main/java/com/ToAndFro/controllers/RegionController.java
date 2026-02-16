package com.ToAndFro.controllers;

import com.ToAndFro.models.dto.request.RegionRequestDto;
import com.ToAndFro.models.dto.response.RegionResponseDto;
import com.ToAndFro.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/regions")
@RequiredArgsConstructor
public class RegionController {
    private final RegionService regionService;

    @GetMapping
    public List<RegionResponseDto> findAllRegions() {
        return regionService.findAllRegions();
    }

    @GetMapping("/{id}")
    public RegionResponseDto findRegionById(@PathVariable Long id) {
        return regionService.findRegionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegionResponseDto createRegion(@RequestBody RegionRequestDto regionRequestDto) {
        return regionService.createRegion(regionRequestDto);
    }

    @PutMapping("/{id}")
    public RegionResponseDto updateRegion(@PathVariable Long id,
                                          @RequestBody RegionRequestDto regionRequestDto) {
        return regionService.updateRegion(id, regionRequestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRegion(@PathVariable Long id) {
        regionService.deleteRegion(id);
    }
}

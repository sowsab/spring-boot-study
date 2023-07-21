package com.example.hr1.domain.main.dto;

import com.example.hr1.model.regions.entity.RegionsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class ResUpdateMainDTO {
    private Integer regionsId;
    private String regionsName;

    public static ResUpdateMainDTO fromEntity(RegionsEntity regionsEntity) {
        return ResUpdateMainDTO.builder()
        .regionsId(regionsEntity.getRegionId())
        .regionsName(regionsEntity.getRegionName())
        .build();
    }

}

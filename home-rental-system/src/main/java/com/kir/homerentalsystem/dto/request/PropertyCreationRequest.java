package com.kir.homerentalsystem.dto.request;

import com.kir.homerentalsystem.entity.Amenity;
import com.kir.homerentalsystem.entity.Location;
import com.kir.homerentalsystem.entity.PropertyImage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropertyCreationRequest {
    private Long ownerId;
    private Long categoryId;
    private Location location;
    private String title;
    private String description;
    private Integer bedrooms;
    private Integer bathrooms;
    private BigDecimal area;
    private BigDecimal pricePerMonth;
    private BigDecimal securityDeposit;

    private Set<Amenity> amenities = new HashSet<>();
    private Set<PropertyImage> images = new HashSet<>();
}

package com.aluraLatam.Booking.model;

import com.aluraLatam.Booking.dto.LibroDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ApiResult(
        @JsonAlias("results") List<LibroDTO> respuestaApi
) {
}

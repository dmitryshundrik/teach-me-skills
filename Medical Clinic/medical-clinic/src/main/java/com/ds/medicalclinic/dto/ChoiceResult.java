package com.ds.medicalclinic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChoiceResult {
    private Long specialtyId;
    private Long doctorId;
    private Long serviceId;
    private String date;
}

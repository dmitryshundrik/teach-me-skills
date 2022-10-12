package com.ds.medicalclinic.util;

import com.ds.medicalclinic.entity.Specialty;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Specialty> getSpecialties() {
        return new ArrayList<>(List.of(Specialty.values()));
    }

}

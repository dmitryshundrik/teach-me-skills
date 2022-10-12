package com.ds.medicalclinic.entity;

public enum Specialty {
    DERMATOLOGY("Дерматология"), DENTISTRY("Стоматология");

    private final String displayName;

    Specialty(String s) {
        displayName = s;
    }

    public String getDisplayName() {
        return displayName;
    }
}

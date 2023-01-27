package by.tms.model;

import lombok.Data;

@Data
public class SettingsUserModel {
    private String newName;
    private String newPhoneNumber1;
    private String newPhoneNumber2;
    private String newPassword;
    private String currentPassword;
}

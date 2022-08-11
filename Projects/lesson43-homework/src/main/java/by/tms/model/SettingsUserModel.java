package by.tms.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class SettingsUserModel {
    private String newName;
    private String newPassword;
    private String currentPassword;
}

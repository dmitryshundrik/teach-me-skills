package by.tms.lesson41homework.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
public class User {
    @NotBlank
    @NotEmpty
    private String name;
    @NotBlank
    @NotEmpty
    private String username;
    @NotBlank
    @NotEmpty
    private String password;
    private LocalDate registered;
}

package by.tms.lesson46homework.entity;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class User {
    private long id;

    @NotEmpty
    @NotBlank
    private String username;
    @NotEmpty
    @NotBlank
    private String password;
    @NotNull
    private Telephone telephone;
    @NotNull
    private Address address;
}

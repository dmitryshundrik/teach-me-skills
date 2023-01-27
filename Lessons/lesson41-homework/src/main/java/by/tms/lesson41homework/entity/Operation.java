package by.tms.lesson41homework.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class Operation {
    @NotBlank
    @NotEmpty
    private String firstNumber;
    @NotBlank
    @NotEmpty
    private String secondNumber;
    @NotBlank
    @NotEmpty
    private String operation;

}

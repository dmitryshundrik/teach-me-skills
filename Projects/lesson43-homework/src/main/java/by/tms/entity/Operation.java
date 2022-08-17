package by.tms.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NamedQuery(name = "Operation.findAll", query = "select o from Operation o")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    private String firstNumber;

    @NotNull
    @NotBlank
    @NotEmpty
    private String secondNumber;

    @NotNull
    @NotBlank
    @NotEmpty
    private String operation;
}

package by.tms.lesson48homework.entity;

import by.tms.lesson48homework.status.PetStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class Pet {
    private int id;

    @NotNull
    private Category category;
    @NotEmpty
    @NotBlank
    private String name;
    @NotNull
    private Tag tags;
    @NotEmpty
    @NotBlank
    private PetStatus status;
}

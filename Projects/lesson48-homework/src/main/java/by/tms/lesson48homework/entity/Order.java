package by.tms.lesson48homework.entity;

import by.tms.lesson48homework.status.OrderStatus;
import by.tms.lesson48homework.status.PetStatus;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class Order {
    private int id;

    @NotEmpty
    @NotBlank
    private int petId;
    @NotEmpty
    @NotBlank
    private int quantity;
    @NotEmpty
    @NotBlank
    private String shipDate;
    @NotEmpty
    @NotBlank
    private OrderStatus status;
    @NotEmpty
    @NotBlank
    private boolean complete;
}

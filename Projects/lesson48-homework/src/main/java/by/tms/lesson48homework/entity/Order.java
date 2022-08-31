package by.tms.lesson48homework.entity;

import by.tms.lesson48homework.status.OrderStatus;
import by.tms.lesson48homework.status.PetStatus;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
//@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @OneToOne
    private Pet pet;

    @NotNull
    private int quantity;

    @NotEmpty
    @NotBlank
    private String shipDate;

    private OrderStatus status;

    @NotNull
    private boolean complete;
}

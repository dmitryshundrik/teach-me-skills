package by.tms.lesson46homework.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private long id;

    private String username;
    private String password;
    private Telephone telephone;
    private Address address;
}

package by.tms.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NamedQuery(name = "User.findAll", query = "select u from User u")
@NamedQuery(name = "User.findByUsername", query = "select u from User u where u.username = :username")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotBlank
    @NotEmpty
    private String name;

    @NotNull
    @NotBlank
    @NotEmpty
    private String username;

    @NotNull
    @NotBlank
    @NotEmpty
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Telephone> telephones;

    @Enumerated(EnumType.STRING)
    private Role role;
}

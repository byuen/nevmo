package com.capitalized.model;

import com.capitalized.model.request.UserRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    String firstName;
    String lastName;
    String email;
    String password;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Account> accounts;

    public User(UserRequest userRequest) {
        this.firstName = userRequest.getFirstName();
        this.lastName = userRequest.getLastName();
        this.email = userRequest.getEmail();
        this.password = userRequest.getPassword();
        this.accounts = new ArrayList<>(List.of(new Account(Account.ACCOUNT_TYPE.NEVMO, "Nevmo Institute", 0.00)));
    }
}

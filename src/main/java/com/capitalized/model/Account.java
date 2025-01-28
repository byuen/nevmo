package com.capitalized.model;

import com.capitalized.model.request.AccountRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Accounts")
public class Account implements Serializable {

    public enum ACCOUNT_TYPE {
        NEVMO("nevmo"),
        EXTERNAL("external");

        public final String label;

        ACCOUNT_TYPE(String label) {
            this.label = label;
        }
    }


    public Account(ACCOUNT_TYPE accountType, String institute, Double balance) {
        this.type = accountType;
        this.balance = BigDecimal.valueOf(balance);
        this.institute = institute;
    }


    public Account(AccountRequest accountRequest) {
        this.type = ACCOUNT_TYPE.valueOf(accountRequest.getType());
        this.institute = accountRequest.getInstitute();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private ACCOUNT_TYPE type;
    private BigDecimal balance;
    private String institute;


}

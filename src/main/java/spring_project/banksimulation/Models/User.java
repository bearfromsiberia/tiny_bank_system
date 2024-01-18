package spring_project.banksimulation.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String first_name;

    @Column
    private String second_name;

    @Column
    private BigDecimal balance;
}

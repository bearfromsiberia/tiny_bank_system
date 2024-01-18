package spring_project.banksimulation.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data

public class TransferBalance {
    private Long from;
    private Long to;
    private BigDecimal amount;
}

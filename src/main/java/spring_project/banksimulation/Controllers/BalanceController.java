package spring_project.banksimulation.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import spring_project.banksimulation.Models.TransferBalance;
import spring_project.banksimulation.Services.BalanceService;

import java.math.BigDecimal;
@Slf4j
@RestController("/balance")
public class BalanceController {
    final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/{id}")
    public BigDecimal getBalance(@PathVariable long id){
            return balanceService.getBalance(id);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody TransferBalance transferBalance){
        balanceService.add(transferBalance);
        return true;
    }

    @PostMapping("/transfer")
    public boolean transfer(@RequestBody TransferBalance transferBalance){
        balanceService.transfer(transferBalance);
        return true;
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException ex){
        log.error(ex.getMessage());
        return ex.getMessage();
    }
}


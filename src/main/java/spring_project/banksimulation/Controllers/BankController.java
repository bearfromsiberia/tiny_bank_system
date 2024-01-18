package spring_project.banksimulation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring_project.banksimulation.Models.User;
import spring_project.banksimulation.Services.BankService;

import java.util.List;

@RestController("/bank")
public class BankController {
    final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PutMapping("/create")
    public void createUser(@RequestBody User user){
            bankService.createUser(user);
    }
    @GetMapping("/all")
    public String all(){
        return bankService.findAll();
    }
}

package spring_project.banksimulation.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import spring_project.banksimulation.Models.User;
import spring_project.banksimulation.Repositories.BankRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Service
public class BankService {
    final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }
    public void createUser(User user){
        bankRepository.save(user);
    }

    public String findAll(){
        StringBuilder info = new StringBuilder();
        Iterable<User> users = bankRepository.findAll();
        users.forEach(user ->  info.append(user.getId()+" ").append(user.getFirst_name()+ " ")
                .append(user.getSecond_name() +" ").append(user.getBalance() + "\n"));
        return info.toString();
    }
}

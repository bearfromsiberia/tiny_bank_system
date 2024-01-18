package spring_project.banksimulation.Services;

import org.springframework.stereotype.Service;
import spring_project.banksimulation.Models.TransferBalance;
import spring_project.banksimulation.Models.User;
import spring_project.banksimulation.Repositories.BankRepository;


import java.math.BigDecimal;

@Service
public class BalanceService {

    final BankRepository bankRepository;
    public BalanceService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public boolean transfer(TransferBalance transfer){
        if (bankRepository.findById(transfer.getFrom()).isEmpty() || bankRepository.findById(transfer.getTo()).isEmpty())
            throw new IllegalArgumentException("Wrong ID");
        User detect_to = bankRepository.findById(transfer.getTo()).get();
        User detect_from = bankRepository.findById(transfer.getFrom()).get();
        if(detect_from.getBalance().compareTo(transfer.getAmount()) < 0){
            throw  new IllegalArgumentException("Wrong amount");
        }
        detect_to.setBalance(detect_to.getBalance().add(transfer.getAmount()));
        detect_from.setBalance(detect_from.getBalance().subtract(transfer.getAmount()));
        bankRepository.save(detect_from);
        bankRepository.save(detect_to);
        return true;
    }
    public boolean add(TransferBalance transferBalance){
        if (bankRepository.findById(transferBalance.getTo()).isEmpty())
            throw new IllegalArgumentException("Wrong ID");
        if(transferBalance.getAmount().compareTo(BigDecimal.ZERO)<0)
            throw  new IllegalArgumentException("Wrong amount");
        User user = bankRepository.findById(transferBalance.getTo()).get();
        user.setBalance(user.getBalance().add(transferBalance.getAmount()));
        bankRepository.save(user);
        return true;
    }

    public BigDecimal getBalance(Long id){
        if (bankRepository.findById(id).isEmpty())
            throw new IllegalArgumentException("Wrong ID");
        User user = bankRepository.findById(id).get();
        return user.getBalance();
    }
}

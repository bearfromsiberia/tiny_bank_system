package spring_project.banksimulation.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring_project.banksimulation.Models.User;

import java.math.BigDecimal;
@Repository
public interface BankRepository extends CrudRepository<User, Long> {
}

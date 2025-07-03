package org.example.Repo;
import org.example.Model.CreateAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<CreateAccount, Long> {
}

package org.example.Service;

import org.example.Model.CreateAccount;
import org.example.Repo.BankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BankServices {
    @Autowired
    private BankRepo bankRepo;

    public List<CreateAccount> getAllAccounts(){
        return bankRepo.findAll(Sort.by("id"));
    }

    public CreateAccount getCreateAccountById(Long id){
        return bankRepo.findById(id).orElse(null);
    }
    public void addCreateAccount(CreateAccount createAccount){
        bankRepo.save(createAccount);
    }
    public void deleteCreateAccount(Long id){
        bankRepo.deleteById(id);
    }
}

package org.example.Controller;
import org.example.Service.BankServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import org.example.Model.CreateAccount;

@RestController
@RequestMapping("/account")

public class BankController {
    private static final Logger log = LoggerFactory.getLogger(BankController.class);

    @Autowired
    private BankServices bankServices;
    @GetMapping
    public List<CreateAccount> getAllAccounts(){
        List<CreateAccount> temp=bankServices.getAllAccounts();
        log.info(temp.toString());
        return temp;

    }
    @GetMapping("/{id}")
    public CreateAccount getbankByID(@PathVariable Long id){
        CreateAccount temp=bankServices.getCreateAccountById(id);
        log.info(temp.toString());
        return temp;
    }

    @PostMapping
    public String AddAccount(@RequestBody CreateAccount createAccount){
        bankServices.addCreateAccount(createAccount);
        return "Account Added Successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id){
        bankServices.deleteCreateAccount(id);
        return "Account Deleted Successfully";
    }
}

package org.example.Controller;

import org.example.Model.CreateAccount;
import org.example.Service.BankServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class BankController {

    @Autowired
    private BankServices bankServices;

    // Display all accounts
    @GetMapping
    public String getAllAccounts(Model model) {
        List<CreateAccount> accounts = bankServices.getAllAccounts();
        model.addAttribute("accounts", accounts);
        return "index";
    }

    @GetMapping("/search")
    public String showSearchForm() {
        return "account";  // This must match the name of the HTML file
    }


    @GetMapping("/{id}")
    public String getAccountById(@PathVariable Long id, Model model) {
        CreateAccount account = bankServices.getCreateAccountById(id);
        model.addAttribute("account", account);
        return "account";
    }

    // Display add an account form
    @GetMapping("/add")
    public String showAddAccountForm(Model model) {
        model.addAttribute("createAccount", new CreateAccount());
        return "addAccount";
    }

    // Handle account creation
    @PostMapping
    public String addAccount(@ModelAttribute CreateAccount createAccount, Model model) {
        bankServices.addCreateAccount(createAccount);
        model.addAttribute("message", "Account Added Successfully!");
        return "redirect:/account";
    }

    // Show delete form
    @GetMapping("/delete")
    public String showDeleteForm() {
        return "deleteAccount";
    }

    // Handle delete by ID
    @PostMapping("/{id}")
    public String deleteAccount(@PathVariable Long id, Model model) {
        bankServices.deleteCreateAccount(id);
        model.addAttribute("message", "Account Deleted Successfully!");
        return "redirect:/account";
    }
}

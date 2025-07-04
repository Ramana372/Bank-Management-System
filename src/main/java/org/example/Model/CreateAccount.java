package org.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CreateAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Name;
    private String Email;
    private int age;
    private String AccountType;
    private String Balance;

    public Long getId() {
        return id;
    }
public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    @Override
    public String toString() {
        return "CreateAccount{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", age=" + age +
                ", AccountType='" + AccountType + '\'' +
                ", Balance='" + Balance + '\'' +
                '}';
    }
}



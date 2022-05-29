package ru.chentsov.otushw.testingsystem.bank;

import java.math.BigDecimal;
import java.util.UUID;

 class Account {
    private String id;
    private BigDecimal amount;

    Account(BigDecimal amount) {
        this.amount = amount;
        this.id = UUID.randomUUID().toString();
    }

    String getId(){
        return this.id;
    }

     BigDecimal getAmount() {
         return this.amount;
     }

     @Override
     public String toString() {
         return "Account{" +
                 "id='" + id + '\'' +
                 ", amount=" + amount +
                 '}';
     }
 }

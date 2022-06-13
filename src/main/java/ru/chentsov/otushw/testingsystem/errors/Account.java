package ru.chentsov.otushw.testingsystem.errors;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

class Account {
   private String id;
   private int amount;

   Account(int amount) throws Exception {
       if (amount<0){
        throw new Exception("Баланс должен быть положительным");
       }
       this.amount = amount;
       this.id = UUID.randomUUID().toString();
   }

   void withdrawMoney(int count) throws Exception {
       if (this.amount < count){
           throw new Exception("Недостаточно средств");
       }
       this.amount -= count;
   }

   String getId(){
       return this.id;
   }

    int getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

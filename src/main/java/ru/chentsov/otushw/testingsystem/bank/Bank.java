package ru.chentsov.otushw.testingsystem.bank;

import java.math.BigDecimal;
import java.util.List;

public class Bank {

    public static void main(String[] args) {
        Storage.registrationClient("Jone", 21);
        Storage.registrationClient("Tom", 46);
        Storage.registrationClient("Mike", 12);
        Storage.registrationClient("Alisa", 31);
        System.out.println("У пользователя Jone открыт счет " + Storage.openAccount("Jone", BigDecimal.valueOf(500)));
        System.out.println("У пользователя Tom открыт счет " + Storage.openAccount("Tom", BigDecimal.valueOf(125)));
        System.out.println("У пользователя Tom открыт счет " + Storage.openAccount("Tom", BigDecimal.valueOf(230)));
        System.out.println("У пользователя Mike открыт счет " + Storage.openAccount("Mike", BigDecimal.valueOf(100000)));
        System.out.println("У пользователя Alisa открыт счет " + Storage.openAccount("Alisa", BigDecimal.valueOf(5425)));
        System.out.println("У пользователя Alisa открыт счет " + Storage.openAccount("Alisa", BigDecimal.valueOf(95)));
        List<Account> accounts = Storage.getAccounts("Tom");
        System.out.println("У пользователя Tom есть счета:");
        for (Account account : accounts) {
            System.out.println(account);
        }
        Client client = Storage.findClient(accounts.get(1).getId());
        System.out.println(client);
        System.out.println(Storage.getAccounts2(client));
        System.out.println(Storage.findClient2(accounts.get(1)));
    }
}

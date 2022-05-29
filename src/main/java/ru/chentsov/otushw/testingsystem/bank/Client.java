package ru.chentsov.otushw.testingsystem.bank;

import java.util.ArrayList;
import java.util.List;

class Client {
    private String name;
    private int old;
    private List<Account> accounts = new ArrayList<>();

    Client(String name, int old) {
        this.name = name;
        this.old = old;
    }

    String getName(){
        return this.name;
    }

    int getOld() {
        return this.old;
    }

    List<Account> getAccounts(){
        return this.accounts;
    }

    void addAccount(Account account){
        this.accounts.add(account);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", old=" + old + '}';
    }
}

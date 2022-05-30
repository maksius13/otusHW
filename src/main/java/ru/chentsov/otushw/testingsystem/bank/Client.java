package ru.chentsov.otushw.testingsystem.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return name.equals(client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

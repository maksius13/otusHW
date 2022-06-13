package ru.chentsov.otushw.testingsystem.errors;

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

    void createAccount(int amount) throws Exception {
        try{
            Account tempAccount = new Account(amount);
            this.accounts.add(tempAccount);
        }
        catch (Exception e){
            // Перенаправляем ошибку на уровень выше
            throw e;
        }
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

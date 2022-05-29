package ru.chentsov.otushw.testingsystem.bank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

class Storage {
    private static Map<String, Client> clientsMap = new HashMap<>();
    private static Map<String, Client> accountsRelationClientsMap = new HashMap<>();

    static void registrationClient(String name, int old){
        Client tempClient = new Client(name, old);
        clientsMap.put(tempClient.getName(), tempClient);
    }

    static String openAccount(String name, BigDecimal amount){
        Client tempClient = clientsMap.get(name);
        if (tempClient == null){
            throw new NoSuchElementException("Пользователя с данным именем нет");
        }
        Account tempAccount = new Account( amount);
        tempClient.addAccount(tempAccount);
        String accountId = tempAccount.getId();
        accountsRelationClientsMap.put(accountId, tempClient);
        return accountId;
    }

    static List<Account> getAccounts(String clientName){
        Client tempClient = clientsMap.get(clientName);
        if (tempClient == null){
            throw new NoSuchElementException("Пользователя с данным именем нет");
        }
        return tempClient.getAccounts();
    }

    static Client findClient(String accountName){
        Client tempClient = accountsRelationClientsMap.get(accountName);
        if (tempClient == null){
            throw new NoSuchElementException("Пользователя с данным именем нет");
        }
        return tempClient;
    }
}

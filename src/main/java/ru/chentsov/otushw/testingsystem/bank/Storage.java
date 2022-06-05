package ru.chentsov.otushw.testingsystem.bank;

import java.math.BigDecimal;
import java.util.*;

class Storage {
    private static Map<String, Client> clientsMap = new HashMap<>();
    private static Map<String, Client> accountsRelationClientsMap = new HashMap<>();
    private static Map<Client, Set<Account>> clientAccountMap = new HashMap<>();

    static void registrationClient(String name, int old){
        Client tempClient = new Client(name, old);
        clientsMap.put(tempClient.getName(), tempClient);
        if (!clientAccountMap.containsKey(tempClient)){
            clientAccountMap.put(tempClient, new HashSet<>());
        }
        else{
            throw new DuplicateFormatFlagsException("Такой бользователь уже есть");
        }
        System.out.println("Сейчас в Map хранится пользователей: " + clientAccountMap.size());
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
        clientAccountMap.put(tempClient, new HashSet<>(tempClient.getAccounts()));
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

    static List<Account> getAccounts2(Client client){
        if (!clientAccountMap.containsKey(client)){
            throw new NoSuchElementException("Пользователя с данным именем нет");
        }
        return new ArrayList<>(clientAccountMap.get(client));
    }

    static Client findClient2(Account account){
        for (Client tempClient : clientAccountMap.keySet()) {
            if (clientAccountMap.get(tempClient).contains(account)){
                return tempClient;
            }
        }
        throw new NoSuchElementException("Пользователя с данным счетом нет");
    }
}

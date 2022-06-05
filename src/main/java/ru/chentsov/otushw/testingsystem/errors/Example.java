package ru.chentsov.otushw.testingsystem.errors;

import java.io.Closeable;
import java.io.IOException;

public class Example {
    public static void main(String[] args) {
        Client client = new Client("Max", 25);
        try{
            client.createAccount(-100);
            System.out.println(client.getAccounts());
        }
        catch (Exception e){
            // Выыводит ошибку в консоль
            System.out.println(e.getMessage());
        }
        try{
            client.getAccounts().get(0).withdrawMoney(200);
        }
        catch (Exception e){
            // Игнорируем ошибку
        }
        try (Connect connect = new Connect()){
            connect.doSth();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

class Connect implements Closeable {

    Connect(){
        System.out.println("Я открылся");
    }

    void doSth() throws Exception{
        throw new Exception("Я упал");
    }

    @Override
    public void close() {
        System.out.println("Я закрылся");
    }
}

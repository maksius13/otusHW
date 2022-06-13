package ru.chentsov.otushw.testingsystem.errors;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        for (int i = 0; i < 1_000; i++) {
            OutOfMemory.start("Google Chrome", 100_000_000);
            OutOfMemory.drop();
        }

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
        Connect connect2 = new Connect();
        try {
            connect2.doSth();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            connect2.close();
        }
    }
}

class Connect implements Closeable {

    Connect(){
        System.out.println("Я открылся");
    }

    void doSth() throws Exception{
        throw new MyException("Я упал");
    }

    @Override
    public void close() {
        System.out.println("Я закрылся");
    }
}

class MyException extends Exception{
    MyException(){
        super();
    }

    MyException(String s){
        super(s);
    }
}

class OutOfMemory{
    static private List<String> list = new ArrayList<>();

    static void start(String s, int iteration){
        for (int i = 0; i < iteration; i++) {
            list.add(s + i);
        }
    }

    static void drop(){
        list = new ArrayList<>();
    }
}

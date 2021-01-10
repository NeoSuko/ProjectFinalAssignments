package com.example.binusezyfood.Balance;

public class Balance {
    private double balance;
    private static Balance instance;

    private Balance() {
        this.balance = 50000;
    }

    public static Balance getInstance(){
        if(instance == null){
            instance = new Balance();
        }
        return instance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

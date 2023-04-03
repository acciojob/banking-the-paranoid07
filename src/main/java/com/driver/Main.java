package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {

        BankAccount bankAccount=new BankAccount("manu",4500,0);

        SavingsAccount savingsAccount=new SavingsAccount("anish",10000,5000,7);

        CurrentAccount currentAccount=new CurrentAccount("ankit",7899,"AAB");

        StudentAccount studentAccount=new StudentAccount("aman",6467,"AccioJob");



    }
}

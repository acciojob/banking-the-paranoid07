package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {

        CurrentAccount currentAccount1=new CurrentAccount("manu",8900,"AAAABC");
        currentAccount1.validateLicenseId();
    }
}

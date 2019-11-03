package com.ab.buscardsystem;

import java.util.Scanner;

public class FactoryInput {

    Scanner scanner = new Scanner(System.in);

    public int inputIntegerId() {
        return scanner.nextInt();
    }

    public int inputIntegerId2(){
        return scanner.nextInt();
    }

    public int inputIntegerId3(){
        return scanner.nextInt();
    }

    public int inputDoubleAmount(){
        return scanner.nextInt();
    }

    public int inputDoublePayment(){
        return scanner.nextInt();
    }

    public String inputStringName(){
        return scanner.nextLine();
    }

    public String inputStringSurname(){
        return scanner.nextLine();
    }

    public String inputStringType(){
        return scanner.nextLine();
    }

    public String inputStringAddress(){
        return scanner.nextLine();
    }


}

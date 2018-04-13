package com.github.sebastianek12345.view;

import com.github.sebastianek12345.controller.PasswordSafeController;
import com.github.sebastianek12345.model.PasswordEntry;
import com.github.sebastianek12345.model.PasswordSafe;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

import java.util.Arrays;
import java.util.Scanner;

public class ViewController {

    TextIO textIO = TextIoFactory.getTextIO();

    public  int chooseFunctionality(){

         int functionality = textIO.newIntInputReader()
                 .withMinVal(1)
                 .withMinVal(3)
                 .read("Welcome to our awesome program\n" +
                 "1) add and save file \n" +
                 "2) show your result bro \n"+
                 "3) your file will be remove");

         if (functionality > 0 && functionality <= 3){
             return functionality;
         }else
             throw new IllegalArgumentException("this option isn't in your program");
    }

    public static void main(String[] args) {

        PasswordSafe passwordSafe = new PasswordSafe();
        PasswordSafeController passwordSafeController = new PasswordSafeController();
        Scanner sc = new Scanner(System.in);

        int menu;

        System.out.println("Welcome to password manager keeper");
        System.out.println("1) add  \n 2)show this result \n 3) remove entries");
        do {
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1:
                    System.out.println("Please enter your serviceName, login, passwordName");
                    PasswordEntry entry = new PasswordEntry(sc.next(),sc.next(),sc.next());
                    passwordSafe.addEntries(entry.getServiceName(),entry.getLogin(),entry.getPasswordName());
                    passwordSafeController.saveToFile(Arrays.asList(entry));
                    break;
                case 2:
                    System.out.println("Please enter serviceName");
                    System.out.println(passwordSafe.show(sc.nextLine()));
                    break;
                case 3:
                    System.out.println("Please enter id");
                    passwordSafe.removeEntries(sc.nextInt());
                    break;
                default:
                    System.out.println("Brak takiej funkcji w panelu ");
            }
        }

        while (menu != 0);
        System.out.println("END");
    }
}

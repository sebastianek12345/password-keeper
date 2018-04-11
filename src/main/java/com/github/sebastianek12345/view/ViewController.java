package com.github.sebastianek12345.view;

import com.github.sebastianek12345.controller.PasswordSafeController;
import com.github.sebastianek12345.model.PasswordSafe;

import java.util.Scanner;

public class ViewController {

    public static void main(String[] args) {

        PasswordSafe passwordSafe = new PasswordSafe();
        PasswordSafeController passwordSafeController = new PasswordSafeController();
        Scanner sc = new Scanner(System.in);
        final int EXIT = 0;
        int menu;

        System.out.println("1) add  \n 2)show this result \n 3) remove entries \n 4) save to file ");
        do {
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1:
                    System.out.println("Please enter your serviceName, login, passwordName");
                    passwordSafe.addEntries(sc.nextLine(), sc.nextLine(), sc.nextLine());
                    break;
                case 2:
                    System.out.println("Please enter serviceName");
                    System.out.println(passwordSafe.show(sc.nextLine()));
                    break;
                case 3:
                    System.out.println("Please enter id");
                    passwordSafe.removeEntries(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Please enter List");

                default:
                    System.out.println("Brak takiej funkcji w panelu ");
            }
        }

        while (menu != 0);
        System.out.println("Output");
    }
}

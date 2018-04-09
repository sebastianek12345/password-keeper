package com.github.sebastianek12345;

import com.github.sebastianek12345.model.PasswordSafe;

public class Aplication {

    public static void main(String[] args){

        PasswordSafe passwordSafe = new PasswordSafe();
        passwordSafe.addEntries("gmail","sebuś","sebastianek");
        passwordSafe.show("gmail");
        System.out.println(passwordSafe.show("gmail"));
    }
}

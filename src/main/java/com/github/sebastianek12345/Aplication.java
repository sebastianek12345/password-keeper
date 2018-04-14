package com.github.sebastianek12345;

import com.github.sebastianek12345.controller.PasswordSafeController;
import com.github.sebastianek12345.model.PasswordEntry;
import com.github.sebastianek12345.model.PasswordSafe;
import com.github.sebastianek12345.view.ViewController;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Aplication {

    public static void main(String[] args){

        ViewController viewController = new ViewController();
        viewController.options();

//        PasswordSafe passwordSafe = new PasswordSafe();
//        PasswordEntry passwordEntry = new PasswordEntry(1,"sebo","super","daniel");
//        PasswordEntry passwordEntry1 = new PasswordEntry(2,"tomek","grejt","trep");
//        PasswordEntry passwordEntry2 = new PasswordEntry(3,"smarkacz","dupcia1234","mati");
//        PasswordEntry passwordEntry3 = new PasswordEntry(4,"dupek","twoja stara","gmail");
//
//
//        PasswordSafeController passwordSafeController = new PasswordSafeController();
//        passwordSafeController.saveToFile(Arrays.asList(passwordEntry, passwordEntry1, passwordEntry2,passwordEntry3));
//
//        passwordSafeController.readFromFile("password-manager-file.pwm").forEach(System.out::println);
//
//




//        PasswordEntry passwordEntry = new PasswordEntry(1,"w","twoja","ds");
//        Gson gson = new Gson();
//        String passwordEntryJson = gson.toJson(passwordEntry);
//        System.out.println(passwordEntryJson);
//
//
//        File file = new File("password-manager-file.pwm");
//        try {
//            FileUtils.writeStringToFile(file,passwordEntryJson,"UTF-8");
//        }catch (IOException e){
//            e.printStackTrace();
//        }


    }
}

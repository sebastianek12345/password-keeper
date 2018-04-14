package com.github.sebastianek12345.view;

import com.github.sebastianek12345.controller.PasswordSafeController;
import com.github.sebastianek12345.controller.myclass;
import com.github.sebastianek12345.model.PasswordEntry;
import com.github.sebastianek12345.model.PasswordSafe;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class ViewController {

    TextIO textIO = TextIoFactory.getTextIO();

    PasswordSafe passwordSafe = new PasswordSafe();
    PasswordEntry passwordEntry = new PasswordEntry();
    PasswordSafeController passwordSafeController = new PasswordSafeController();

    public int chooseFunctionality() {

        int functionality = textIO.newIntInputReader()
                .withMinVal(1)
                .withMaxVal(3)
                .read("Welcome to our awesome program\n" +
                        "1) add and save file \n" +
                        "2) your file will be removed \n" +
                        "3) show me ");


        if (functionality > 0 && functionality <= 3) {
            return functionality;
        } else
            throw new IllegalArgumentException("this option isn't in your program");
    }

    public void options() {

        Integer functionality;

        do {
            functionality = chooseFunctionality();

            if (functionality == 1) {
                passwordEntry = passwordSafe.addEntries(textIO.newStringInputReader().withMinLength(3).read("Enter name of the service"),
                        textIO.newStringInputReader().withMinLength(3).read("Enter your login"),
                        textIO.newStringInputReader().withMinLength(6).withInputMasking(true).read("Enter your password"));
                passwordSafeController.saveToFile(Arrays.asList(passwordEntry), true);
                textIO.newIntInputReader().read("Dane zostałe dodane i zapisane w pliku \n" +"Wybierz kolejna opcję lub zamknij program");
            }

            if (functionality == 2)

            {
                passwordSafe.removeEntries(textIO.newIntInputReader().read("Podaj id do usunięcia"));
                passwordSafeController.saveToFile(new ArrayList<>(passwordSafe.all()), false);
                textIO.newIntInputReader().read("Wpis o podanym id został właśnie usunięty z pliku");
            }

            if (functionality == 3)

            {
                System.out.println(passwordSafe.show(textIO.newStringInputReader().read("Podaj nazwę serwisu")));
                textIO.newIntInputReader().read("Wszysytko jest poprostu świetne");
            }
        }

        while (functionality != 0);
    }
}






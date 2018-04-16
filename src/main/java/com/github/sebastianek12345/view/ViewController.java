package com.github.sebastianek12345.view;

import com.github.sebastianek12345.controller.PasswordSafeController;
import com.github.sebastianek12345.model.PasswordEntry;
import com.github.sebastianek12345.model.PasswordSafe;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ViewController {

    TextIO textIO = TextIoFactory.getTextIO();
    PasswordSafeController passwordSafeController = new PasswordSafeController();
    PasswordSafe passwordSafe = new PasswordSafe();
    //    PasswordSafe passwordSafe = passwordSafeController.init("src/main/java/com/github/sebastianek12345/text/password-manager-file.pwm");
    PasswordEntry passwordEntry = new PasswordEntry();
    File file = new File("C:/Users/DELL/Desktop/hasla/password-file-manager.txt");

    public int chooseFunctionality() {

        int option = textIO.newIntInputReader()
                .withMinVal(1)
                .withMaxVal(7)
                .read("Welcome to password manager program creating by Sebastian Małecki\n \n" +
                        "1) Add content to a file that will be automatically saved \n" +
                        "2) The contents of the file will be deleted \n" +
                        "3) Show the contents of the file \n " +
                        "4) Load the contents of the file \n" +
                        "5) Encrypt the contents of the file \n" +
                        "6) Decrypt the contents of the file \n" +
                        "Close the program press Alt + F4 \n\n" +
                        "Choose an option");


        if (option > 0 && option <= 6) {
            return option;
        } else
            throw new IllegalArgumentException("this option isn't in your program");
    }

    public void options() {

        Integer option;

        do {
            option = chooseFunctionality();

            if (option == 1) {
                passwordEntry = passwordSafe.addEntries(textIO.newStringInputReader().withMinLength(3).read("Enter name of the service"),
                        textIO.newStringInputReader().withMinLength(3).read("Enter your login"),
                        textIO.newStringInputReader().withMinLength(6).withInputMasking(true).read("Enter your password"));
                passwordSafeController.saveToFile(Arrays.asList(passwordEntry), true);
                textIO.newIntInputReader().read("The data has been added and saved in the file \n\n" + "Choose an option or close the program \n");

            }

            if (option == 2)

            {
                passwordSafe.removeEntries(textIO.newIntInputReader().read("Enter id"));
                passwordSafeController.saveToFile(new ArrayList<>(passwordSafe.all()), false);
                textIO.newIntInputReader().read("Entry with the given id has benn removed from the file \n\n" + "Choose an option or close the program \n");
            }

            if (option == 3)

            {
                System.out.println(passwordSafe.show(textIO.newStringInputReader().read("Enter the service name")));
                textIO.newIntInputReader().read("The contents of the file: \n\n");
                textIO.newIntInputReader().read("Choose an option or close the program \n" + "Choose an option or close the program \n");
            }

            if (option == 4)

            {
                passwordSafeController.readFromFile(textIO.newStringInputReader().read("Enter the file name"));
                textIO.newIntInputReader().read("The content of the file has benn read \n\n" + "Choose an option or close the program \n");

            }

            if (option == 5)

            {
                passwordSafeController.encryptTheFile(file);
                textIO.newIntInputReader().read("The content of the file has been encrypted \n\n" + "Choose an option or close the program \n");
            }

            if (option == 6)

            {
                passwordSafeController.decryptTheFile(file);
                textIO.newIntInputReader().read("The content of the file has been decrypted \n\n" + "Choose an option or close the program \n");
            }
        }

        while (option != 0);
    }
}






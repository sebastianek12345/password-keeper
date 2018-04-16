package com.github.sebastianek12345.controller;

import com.github.sebastianek12345.model.PasswordEntry;
import com.github.sebastianek12345.model.PasswordSafe;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

public class PasswordSafeController {


    public void saveToFile(List<PasswordEntry> passwordEntries, boolean append) {

        Gson gson = new Gson();
        List<String> jsons = passwordEntries.stream()
                .map(gson::toJson)
                .collect(Collectors.toList());


        File file = new File("C:/Users/DELL/Desktop/hasla/password-file-manager.txt");
        try {
            FileUtils.writeLines(file, jsons, append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void encryptTheFile(File f) {
        CipherFile ctf;
        try {
            ctf = new CipherFile(")(*#@#$!@Egg", 16, "AES");
            ctf.encryptFile(f);
        } catch (IOException | NoSuchPaddingException | BadPaddingException | InvalidKeyException | IllegalBlockSizeException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public PasswordSafe init(String readFile) {

        Collection<PasswordEntry> passwordEntries = readFromFile(readFile);
        return new PasswordSafe(passwordEntries);
    }

    public Collection<PasswordEntry> readFromFile(String readFile) {

        Gson gson = new Gson();

        File file = new File(readFile);
        try {
            return FileUtils.readLines(file, "UTF-8").stream()
                    .map(s -> gson.fromJson(s, PasswordEntry.class))
                    .collect(Collectors.toSet());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptySet();
    }

    public void decryptTheFile(File f) {
        try {
            List<String> checkList = FileUtils.readLines(f, "UTF-8");
            if (!(checkList.get(0).equals("decrypted"))) {
                CipherFile ctf;
                try {
                    ctf = new CipherFile(")(*#@#$!@Egg", 16, "AES");
                    ctf.decryptFile(f);
                } catch (IOException | NoSuchPaddingException | BadPaddingException | InvalidKeyException | IllegalBlockSizeException | NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




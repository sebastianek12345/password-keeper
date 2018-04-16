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

    }
}

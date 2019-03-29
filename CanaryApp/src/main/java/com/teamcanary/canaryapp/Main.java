package com.teamcanary.canaryapp;

import controller.JsonManager;
import controller.UserSystem;
import java.io.FileNotFoundException;
import java.io.IOException;
import model.Task;
import view.AppView;

/**
 *
 * Written by Gustavo and Kylan
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        AppView mainWindow = AppView.getInstance();
        UserSystem.loadEverybody();
        
    }
}

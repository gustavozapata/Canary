package com.teamcanary.canaryapp;

import controller.UserSystem;
import java.io.FileNotFoundException;
import view.AppView;

/**
 *
 * @author k1715308
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        
        AppView mainWindow = AppView.getInstance();
              UserSystem.loadEverybody();
    }
}
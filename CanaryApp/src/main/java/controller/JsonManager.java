
package controller;

import com.google.gson.Gson;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import model.Task;
import model.TaskContainer;
import view.AppView;

public class JsonManager {
    
    
    
    public static Task[] read(String path) throws IOException{

        Gson gson = new Gson();
        String text = usingFileReader(path);
        Task[] results = gson.fromJson(text, Task[].class);
        ArrayList<Task> list_tasks = new ArrayList<Task>(Arrays.asList(results));
        System.out.println("READ");
        TaskContainer.getInstance().clear();
        TaskContainer.getInstance().addItems(list_tasks);
        AppView.getInstance().reRender();
        
        return results;
    }
    
    public static void write(String path,ArrayList<Task> task) throws IOException{
        Gson gson = new Gson();
        gson.toJson(task);
        usingFileWriter(path,gson.toJson(task));
  
        
      
    }

  private static String usingFileReader(String fileName) throws IOException {
        File file = new File(fileName);
        String finalString = "";
        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            String line;          
            System.out.println("Reading text file using FileReader");
            while((line = br.readLine()) != null){
                finalString += line;
            }
            br.close();
        }
        return finalString;
        
    }
    
    
   
    
    public static void usingFileWriter(String path,String text) throws IOException
{
    FileWriter fileWriter = new FileWriter(path);
    fileWriter.write(text);
    fileWriter.close();
}
    
    
    
    
}

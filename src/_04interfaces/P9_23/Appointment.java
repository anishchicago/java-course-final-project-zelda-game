package _04interfaces.P9_23;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public abstract class Appointment {

    private String description;
    private Date date;

    public Appointment(String description, Date date) {
        this.description = description;
        this.date = date;
    }

    public abstract boolean occursOn(int year, int month, int day);

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String getType();

    public void save(String fileName) {
        try {
            FileWriter fileOut = new FileWriter(fileName, true);
            fileOut.append(this.getType() + ";" + this.getDescription()
                    + ";"
                    + this.getDate().getMonth() + "/"
                    + this.getDate().getDate()+"/"
                    + this.getDate().getYear()
                    + "\n");
            fileOut.close();
            System.out.println("Successfully saved to file " + fileName + "!");
        } catch (FileNotFoundException e){
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }




}

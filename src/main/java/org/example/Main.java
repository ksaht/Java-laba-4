package org.example;



import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\foreign_names.csv";
        ArrayList<Person> cont = new ArrayList<>();

        try {
            CSV_Parser reader = new CSV_Parser(path, ';', cont);
            reader.print();
            cont = new ArrayList<>(reader.getPersons());
        }
        catch (FileNotFoundException except){
            System.out.println("Таблицы нет");
        }
    }
}
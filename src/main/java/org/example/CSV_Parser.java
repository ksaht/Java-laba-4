package org.example;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.util.List;
public class CSV_Parser{
    private String path;
    private char separator;
    /*
    * Список людей
     */
    private List<Person> container;

    /*
    * Конструктор класса
    * @param path путь к CSV файлу в системе
    * @param separator символ-разделитель
    * @param persons ссылка на контейнер людей
    */
    public CSV_Parser(String path, char separator, List<Person> persons) throws FileNotFoundException{
        this.path = path;
        this.separator = separator;
        container = persons;
        read();
    }

    /*
    * Метод считывания данных CSV файла
     */
    public void read() throws FileNotFoundException {
        try (FileReader in = new FileReader(path)) {
            CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();
            CSVReader reader = new CSVReaderBuilder(in).withCSVParser(parser).withSkipLines(1).build();
            if (reader == null) {
                throw new FileNotFoundException(path);
            }
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Person person = new Person(Integer.valueOf(nextLine[0]),
                        nextLine[1],
                        nextLine[2],
                        new Department(nextLine[4]),
                        Integer.valueOf(nextLine[5]),
                        nextLine[3]);
                container.add(person);
            }
        } catch (IOException | CsvValidationException except) {
            throw new FileNotFoundException(path);
        }
    }

    /**
     * Метод печати информации
     */
    public void print() {
        for (int i = 0; i < container.size(); i++) {
            System.out.print("" + (i + 1) + " человек: ");
            System.out.print(container.get(i).getID() + "\t");
            System.out.print(container.get(i).getName() + "\t");
            System.out.print(container.get(i).getGender() + "\t");
            System.out.print(container.get(i).getDate() + "\t");
            System.out.print("Подразделение: ");
            System.out.print(container.get(i).getDepartment().getID() + "\t");
            System.out.print(container.get(i).getDepartment().getTitle() + "\t");
            System.out.println(container.get(i).getSalary() + "\t");
        }
    }

    public String getFilePath() {
        return path;
    }

    public void setFilePath(String filePath) throws FileNotFoundException {
        path = filePath;
        read();
    }

    public char getSeparator() {
        return separator;
    }

    public void setSeparator(char separator) {
        this.separator = separator;
    }

    public List<Person> getPersons() {
        return container.subList(0, container.size());
    }

    public void setPersons(List<Person> persons) {
        this.container = persons;
    }
}
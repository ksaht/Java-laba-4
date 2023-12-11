package org.example;
/*
* Класс человека.
*/
public class Person{
    private int ID;
    /*
    * Имя
    */
    private String name;
    /*
    * Пол
    */
    private String gender;
    /*
     * Подразделение
     */
    private Department department;
    /*
    * Зарплата
    */
    private int salary;
    /*
    * Дата рождения
    * */
    private String date;

    /*
     * Конструктор по умолчанию
     */
    public Person(){
        ID = 0;
        name = "";
        gender = "";
        department = null;
        salary = 0;
        date = "";
    }

    /**
     * Конструктор по атрибутам
     * @param ID  идентификатор
     * @param name имя
     * @param gender пол
     * @param department подразделение
     * @param salary зарплата
     * @param date день рождения
     */
    public Person(int ID,
                  String name,
                  String gender,
                  Department department,
                  int salary,
                  String date){
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDate() {
        return date;
    }

    public void setBirthday(String date) {
        this.date = date;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString(){
        return "ID: " + getID() + '\n' +
                "Имя: " + getName() + '\n' +
                "Пол: " + getGender() + '\n' +
                "Подразделение: " + getDepartment().toString() + '\n' +
                "Зарплата: " + getSalary() + '\n' +
                "Дата рождения: " + getDate();
    }
}
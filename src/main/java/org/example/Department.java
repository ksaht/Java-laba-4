package org.example;
public class Department {

    private static int idCounter = 0;
    /*
    * ID текущего подразделения.
     */
    private int ID;
    /*
    * Подразделение
    * */
    private String title;

    /*
    * Конструктор по умолчанию
    */
    public Department(){
        this.ID = ++idCounter;
        this.title = "noTitle";
    }

    /*
    * Конструктор по подразделению.
    * @param departmentName наименование подразделения.
    */
    public Department(String departmentName){
        this.ID = ++idCounter;
        this.title = departmentName;
    }

    @Override
    public String toString(){
        return "" + title + " (ID: " + ID + ")";
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
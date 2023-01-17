package com.example.demo;





public class Employ {
    private String name;
    private String surname;
    private String dos;
    public Employ(String name, String surname, String dos) {
        this.name = name;
        this.surname = surname;
        this.dos = dos;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Name: "+ name+ " Surname: "+surname+" Date "+ dos;
    }
}

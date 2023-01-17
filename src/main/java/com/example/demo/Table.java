package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private static Table instance=null;
    List<Employ> employList;
    private Table(){
        employList=new ArrayList<>();
    }
    public static Table getInstance(){
        if(instance==null){
            instance=new Table();
        }
        return instance;
    }
    public void add_employ(Employ employ){
        employList.add(employ);
    }
    public List<Employ> get_employ(){
        return employList;
    }
}

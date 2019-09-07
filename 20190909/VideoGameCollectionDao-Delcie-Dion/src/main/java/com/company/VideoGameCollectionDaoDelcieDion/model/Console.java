package com.company.VideoGameCollectionDaoDelcieDion.model;

import java.util.Objects;

public class Console {

    /*
    console_id int not null auto_increment primary key,
    name varchar(50) not null,
    year char(4) not null
     */

    private int id;
    private String name;
    private String year;

    public Console() {
    }

    public Console(int id, String name, String year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return id == console.id &&
                name.equals(console.name) &&
                year.equals(console.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year);
    }
}

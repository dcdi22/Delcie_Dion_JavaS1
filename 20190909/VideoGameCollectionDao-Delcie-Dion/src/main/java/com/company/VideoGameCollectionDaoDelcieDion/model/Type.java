package com.company.VideoGameCollectionDaoDelcieDion.model;

import java.util.Objects;

public class Type {

    /*
    type_id int not null auto_increment primary key,
    name varchar(50) not null,
    description varchar(255) not null
     */

    private int id;
    private String name;
    private String description;

    public Type() {
    }

    public Type(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return id == type.id &&
                name.equals(type.name) &&
                description.equals(type.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}

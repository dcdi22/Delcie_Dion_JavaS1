package com.company.VideoGameCollectionDaoDelcieDion.model;

import java.util.Objects;

public class Publisher {

    /*
    publisher_id int not null auto_increment primary key,
    name varchar(50) not null,
    website varchar(75)
     */

    private int id;
    private String name;
    private String website;

    public Publisher() {
    }

    public Publisher(int id, String name, String website) {
        this.id = id;
        this.name = name;
        this.website = website;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return id == publisher.id &&
                name.equals(publisher.name) &&
                Objects.equals(website, publisher.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, website);
    }
}

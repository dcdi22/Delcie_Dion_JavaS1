package com.company.CoffeeInventoryDaoDelcieDion.model;

import java.util.Objects;

public class Roaster {

    /*
    roaster_id int not null auto_increment primary key,
    name varchar(50) not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state char(2) not null,
    postal_code varchar(25) not null,
    phone varchar(15) not null,
    email varchar(60) not null,
    note varchar(255)
     */

    private int id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String postal_code;
    private String phone;
    private String email;
    private String note;

    public Roaster() {
    }

    public Roaster(int id, String name, String street, String city, String state, String postal_code, String phone, String email, String note) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.phone = phone;
        this.email = email;
        this.note = note;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roaster roaster = (Roaster) o;
        return id == roaster.id &&
                name.equals(roaster.name) &&
                street.equals(roaster.street) &&
                city.equals(roaster.city) &&
                state.equals(roaster.state) &&
                postal_code.equals(roaster.postal_code) &&
                phone.equals(roaster.phone) &&
                email.equals(roaster.email) &&
                Objects.equals(note, roaster.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, postal_code, phone, email, note);
    }
}

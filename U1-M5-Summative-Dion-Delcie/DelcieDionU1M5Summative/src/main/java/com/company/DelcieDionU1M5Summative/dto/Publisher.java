package com.company.DelcieDionU1M5Summative.dto;

/*
publisher_id int not null auto_increment primary key,
    name varchar(50)not null,
    street varchar(50) not null,
    city varchar(50) not null,
    state char(2) not null,
    postal_code varchar(25) not null,
    phone varchar(15) not null,
    email varchar(60) not null
 */

import javax.validation.constraints.Size;
import java.util.Objects;

public class Publisher {

    private int id;
    @Size(min=1, max = 50)
    private String name;
    @Size(min=1, max = 50)
    private String street;
    @Size(min=1, max = 50)
    private String city;
    @Size(min=1, max = 2)
    private String state;
    @Size(min=1, max = 25)
    private String postalCode;
    @Size(min=1, max = 15)
    private String phone;
    @Size(min=1, max = 60)
    private String email;

    public Publisher() {
    }

    public Publisher(int id, String name, String street, String city, String state, String postalCode, String phone, String email) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.phone = phone;
        this.email = email;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return id == publisher.id &&
                name.equals(publisher.name) &&
                street.equals(publisher.street) &&
                city.equals(publisher.city) &&
                state.equals(publisher.state) &&
                postalCode.equals(publisher.postalCode) &&
                phone.equals(publisher.phone) &&
                email.equals(publisher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, postalCode, phone, email);
    }
}

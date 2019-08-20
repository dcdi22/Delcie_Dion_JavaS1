package com.company;

import com.opencsv.bean.CsvBindByName;

public class Computers {

    @CsvBindByName(column = "Brand")
    private String brand;
    @CsvBindByName(column = "Model")
    private String model;
    @CsvBindByName(column = "CPU")
    private String cpu;
    @CsvBindByName(column = "RAM")
    private String ram;
    @CsvBindByName(column = "StorageSize")
    private String storageSize;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(String storageSize) {
        this.storageSize = storageSize;
    }

    public Computers() {
    }

    public Computers(String brand, String model, String cpu, String ram, String storageSize) {
        this.brand = brand;
        this.model = model;
        this.cpu = cpu;
        this.ram = ram;
        this.storageSize = storageSize;
    }
}

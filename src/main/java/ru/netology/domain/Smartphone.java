package ru.netology.domain;

public class Smartphone extends Product {

    protected String manufacturer;

    public Smartphone(int id, String title, int value, String manufacturer) {
        super(id, title, value);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {

        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {

        this.manufacturer = manufacturer;
    }
}
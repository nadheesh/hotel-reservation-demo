package org.choreo.demo.luxury.hotels.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RoomType")
public class RoomType {
    @Id
    private int id;
    private String name;
    private int guestCapacity;
    private double price;

    // Constructors, getters, and setters
    public RoomType() {}

    public RoomType(int id, String name, int guestCapacity, double price) {
        this.id = id;
        this.name = name;
        this.guestCapacity = guestCapacity;
        this.price = price;
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

    public int getGuestCapacity() {
        return guestCapacity;
    }

    public void setGuestCapacity(int guestCapacity) {
        this.guestCapacity = guestCapacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
// Getters and setters...
}

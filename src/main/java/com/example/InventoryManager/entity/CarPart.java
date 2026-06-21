package com.example.InventoryManager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CarPart
{
    // No business logic whatsoever implemented here, just a data container
    @Id
    private String partNumber;
    private int groupNumber;
    private String partDescription;
    private int stock;
    private int reserved;
    private double price;

    protected CarPart(){}// We do not use this directly, hence protected. For JPA only

    public CarPart(String partNumber, int groupNumber, String partDescription,
                   int stock, int reserved, double price)
    {
        this.partNumber = partNumber;
        this.groupNumber = groupNumber;
        this.partDescription = partDescription;
        this.stock = stock;
        this.reserved = reserved;
        this.price = price;
    }

    public String getPartNumber()
    {
        return partNumber;
    }

    public void setPartNumber(String partNumber)
    {
        this.partNumber = partNumber;
    }

    public int getStock()
    {
        return stock;
    }

    public void setStock(int stock)
    {
        this.stock = stock;
    }

    public int getGroupNumber()
    {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber)
    {
        this.groupNumber = groupNumber;
    }

    public String getPartDescription()
    {
        return partDescription;
    }

    public void setPartDescription(String partDescription)
    {
        this.partDescription = partDescription;
    }

    public int getReserved()
    {
        return reserved;
    }

    public void setReserved(int reserved)
    {
        this.reserved = reserved;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}

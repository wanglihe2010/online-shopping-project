package com.example.order.models;

import java.util.Date;
import java.util.List;

public class InputOrder {
    private Date date;
    private String email_id;
    private String description;
    private double price;
    private List<String> itemNames;


    public InputOrder() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InputOrder{");
        sb.append("date=").append(date);
        sb.append(", email_id='").append(email_id).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", price=").append(price);
        sb.append(", itemNames=").append(itemNames);
        sb.append('}');
        return sb.toString();
    }
}

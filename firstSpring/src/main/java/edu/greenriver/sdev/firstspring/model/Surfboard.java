package edu.greenriver.sdev.firstspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Surfboard {
    private String brand;
    private double price;
    private double length; // in feet
    private String color;
    private boolean onSale;
}

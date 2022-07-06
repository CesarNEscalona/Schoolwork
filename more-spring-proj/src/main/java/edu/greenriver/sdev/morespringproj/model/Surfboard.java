package edu.greenriver.sdev.morespringproj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Surfboard {
        private String brand;
        private double price;
        private double length; //in feet
        private String color;
        private boolean onSale;
}

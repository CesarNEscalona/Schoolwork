package edu.greenriver.sdev.springmvclab.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class NumberService {
    private int low;
    private int high;

    public int between(int low, int high){
        this.low = low;
        this.high = high;

        Random random = new Random();
        return random.nextInt(high + 1);
    }
}

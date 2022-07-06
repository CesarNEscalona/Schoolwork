package edu.greenriver.sdev.springmvclab.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Random;

@Service
public class ChallengeService {

    public ArrayList<Integer> nums() {
        Random rand = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numbers.add(rand.nextInt(50 + 1));
        }
        return numbers;
    }
}

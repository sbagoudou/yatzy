package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

@Service
public class YatzySixesPlugin implements YatzyPlugin {

    @Override
    public int calculateScore(int d1, int d2, int d3, int d4, int d5) {
        int[] dice;
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;

        int sum = 0;
        for (int at = 0; at < dice.length; at++)
            if (dice[at] == 6)
                sum = sum + 6;
        return sum;
    }

    @Override
    public boolean supports(Category category) {
        return Category.SIXES == category;
    }
}

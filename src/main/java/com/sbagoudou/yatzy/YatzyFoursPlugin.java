package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

@Service
public class YatzyFoursPlugin implements YatzyPlugin {

    @Override
    public int calculateScore(int d1, int d2, int d3, int d4, int d5) {
        int[] dice;
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;

        int sum;
        sum = 0;
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    @Override
    public boolean supports(Category category) {
        return Category.FOURS == category;
    }
}

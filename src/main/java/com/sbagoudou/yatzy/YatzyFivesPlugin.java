package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

@Service
public class YatzyFivesPlugin implements YatzyPlugin {

    @Override
    public int calculateScore(int d1, int d2, int d3, int d4, int d5) {
        int[] dice;
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;

        int s = 0;
        int i;
        for (i = 0; i < dice.length; i++)
            if (dice[i] == 5)
                s = s + 5;
        return s;
    }

    @Override
    public boolean supports(Category category) {
        return Category.FIVES == category;
    }
}

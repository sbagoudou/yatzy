package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

@Service
public class YatzySmallStraightPlugin implements YatzyPlugin {

    @Override
    public int calculateScore(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    @Override
    public boolean supports(Category category) {
        return Category.SMALL_STRAIGHT == category;
    }
}

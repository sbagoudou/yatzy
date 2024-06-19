package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

@Service
public class YatzyFourOfAKindPlugin implements YatzyPlugin {

    @Override
    public int calculateScore(int d1, int d2, int d3, int d4, int d5) {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1]++;
        tallies[d2-1]++;
        tallies[d3-1]++;
        tallies[d4-1]++;
        tallies[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    @Override
    public boolean supports(Category category) {
        return Category.FOUR_OF_A_KIND == category;
    }
}

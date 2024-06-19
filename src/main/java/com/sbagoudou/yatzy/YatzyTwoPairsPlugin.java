package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

@Service
public class YatzyTwoPairsPlugin implements YatzyPlugin {

    @Override
    public int calculateScore(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    @Override
    public boolean supports(Category category) {
        return Category.TWO_PAIRS == category;
    }
}

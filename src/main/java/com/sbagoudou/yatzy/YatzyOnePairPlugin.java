package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

@Service
public class YatzyOnePairPlugin implements YatzyPlugin {

    @Override
    public int calculateScore(int d1, int d2, int d3, int d4, int d5) {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }

    @Override
    public boolean supports(Category category) {
        return Category.PAIR == category;
    }
}

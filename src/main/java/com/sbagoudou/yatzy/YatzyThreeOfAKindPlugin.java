package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

@Service
public class YatzyThreeOfAKindPlugin implements YatzyPlugin {

    @Override
    public int calculateScore(int d1, int d2, int d3, int d4, int d5) {
        int[] t;
        t = new int[6];
        t[d1-1]++;
        t[d2-1]++;
        t[d3-1]++;
        t[d4-1]++;
        t[d5-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    @Override
    public boolean supports(Category category) {
        return Category.THREE_OF_A_KIND == category;
    }
}

package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

@Service
public class YatzyThreesPlugin implements YatzyPlugin {

    @Override
    public int calculateScore(int d1, int d2, int d3, int d4, int d5) {
        int s;
        s = 0;
        if (d1 == 3) s += 3;
        if (d2 == 3) s += 3;
        if (d3 == 3) s += 3;
        if (d4 == 3) s += 3;
        if (d5 == 3) s += 3;
        return s;
    }

    @Override
    public boolean supports(Category category) {
        return Category.THREES == category;
    }
}

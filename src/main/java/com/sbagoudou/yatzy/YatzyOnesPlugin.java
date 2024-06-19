package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

@Service
public class YatzyOnesPlugin implements YatzyPlugin {

    @Override
    public int calculateScore(int d1, int d2, int d3, int d4, int d5) {
        int sum = 0;
        if (d1 == 1) sum++;
        if (d2 == 1) sum++;
        if (d3 == 1) sum++;
        if (d4 == 1) sum++;
        if (d5 == 1)
            sum++;

        return sum;
    }

    @Override
    public boolean supports(Category category) {
        return Category.ONES == category;
    }
}

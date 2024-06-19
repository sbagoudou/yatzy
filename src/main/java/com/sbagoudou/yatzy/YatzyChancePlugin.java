package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

@Service
public class YatzyChancePlugin implements YatzyPlugin {

    @Override
    public int calculateScore(int d1, int d2, int d3, int d4, int d5) {
        int total = 0;
        total += d1;
        total += d2;
        total += d3;
        total += d4;
        total += d5;
        return total;
    }

    @Override
    public boolean supports(Category category) {
        return Category.CHANCE == category;
    }
}

package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.sbagoudou.yatzy.Category.CHANCE;

@Service
public class YatzyChancePlugin implements YatzyPlugin {

    /**
     * Calculates the score of the roll based on the {@link CHANCE} category rules:
     * The score is the sum of all dice.
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    @Override
    public int calculateScore(List<Integer> dice) {
        return sum(dice);
    }

    @Override
    public boolean supports(Category category) {
        return CHANCE == category;
    }
}

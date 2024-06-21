package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.sbagoudou.yatzy.Category.FIVES;

@Service
public class YatzyFivesPlugin implements YatzyPlugin {

    /**
     * Calculates the score of the roll based on the {@link FIVES} category rules:
     * The score is the sum of the dice that reads five.
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    @Override
    public int calculateScore(List<Integer> dice) {
        return getNumberScore(dice, 5);
    }

    @Override
    public boolean supports(Category category) {
        return FIVES == category;
    }
}

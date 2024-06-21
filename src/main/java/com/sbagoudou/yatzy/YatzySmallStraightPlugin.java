package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.sbagoudou.yatzy.Category.SMALL_STRAIGHT;

@Service
public class YatzySmallStraightPlugin implements YatzyPlugin {

    /**
     * Calculates the score of the roll based on the {@link SMALL_STRAIGHT} category rules:
     * If the dice reads all possible values but 6, the score is the sum of all the dice.
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    @Override
    public int calculateScore(List<Integer> dice) {
        return calculateStraight(dice, 6);
    }

    @Override
    public boolean supports(Category category) {
        return SMALL_STRAIGHT == category;
    }
}

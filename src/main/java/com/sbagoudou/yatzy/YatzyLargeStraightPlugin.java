package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.sbagoudou.yatzy.Category.LARGE_STRAIGHT;

@Service
public class YatzyLargeStraightPlugin implements YatzyPlugin {

    /**
     * Calculates the score of the roll based on the {@link LARGE_STRAIGHT} category rules:
     * If the dice reads all possible values but 1, the score is the sum of all the dice.
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    @Override
    public int doCalculateScore(List<Integer> dice) {
        return calculateStraight(dice, 1);
    }

    @Override
    public boolean supports(Category category) {
        return LARGE_STRAIGHT == category;
    }
}

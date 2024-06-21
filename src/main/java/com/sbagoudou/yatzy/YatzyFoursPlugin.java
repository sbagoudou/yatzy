package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.sbagoudou.yatzy.Category.FOURS;

@Service
public class YatzyFoursPlugin implements YatzyPlugin {

    /**
     * Calculates the score of the roll based on the {@link FOURS} category rules:
     * The score is the sum of the dice that reads four.
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    @Override
    public int calculateScore(List<Integer> dice) {
        return getNumberScore(dice, 4);
    }

    @Override
    public boolean supports(Category category) {
        return FOURS == category;
    }
}

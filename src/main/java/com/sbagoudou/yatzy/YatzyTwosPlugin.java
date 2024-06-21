package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.sbagoudou.yatzy.Category.TWOS;

@Service
public class YatzyTwosPlugin implements YatzyPlugin {

    /**
     * Calculates the score of the roll based on the {@link TWOS} category rules:
     * The score is the sum of the dice that reads two.
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    @Override
    public int doCalculateScore(List<Integer> dice) {
        return getNumberScore(dice, 2);
    }

    @Override
    public boolean supports(Category category) {
        return TWOS == category;
    }
}

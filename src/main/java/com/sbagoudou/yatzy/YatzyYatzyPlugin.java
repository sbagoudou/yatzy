package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.sbagoudou.yatzy.Category.YATZY;

@Service
public class YatzyYatzyPlugin implements YatzyPlugin {

    /**
     * Calculates the score of the roll based on the {@link YATZY} category rules:
     * If all dice have the same number, the score is 50.
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    @Override
    public int calculateScore(List<Integer> dice) {
        if (dice.stream().distinct().count() == 1) {
            return 50;
        }
        return 0;
    }

    @Override
    public boolean supports(Category category) {
        return YATZY == category;
    }
}

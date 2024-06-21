package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.sbagoudou.yatzy.Category.PAIR;

@Service
public class YatzyPairPlugin implements YatzyPlugin {

    /**
     * Calculates the score of the roll based on the {@link PAIR} category rules:
     * The score is the sum of the two highest matching dice.
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    @Override
    public int doCalculateScore(List<Integer> dice) {
       return calculateNOfAKind(dice, 2);
    }

    @Override
    public boolean supports(Category category) {
        return PAIR == category;
    }
}

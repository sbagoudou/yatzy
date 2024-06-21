package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.sbagoudou.yatzy.Category.FOUR_OF_A_KIND;

@Service
public class YatzyFourOfAKindPlugin implements YatzyPlugin {

    /**
     * Calculates the score of the roll based on the {@link FOUR_OF_A_KIND} category rules:
     * If there are four dice with the same number, the score is the sum of these dice.
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    @Override
    public int doCalculateScore(List<Integer> dice) {
        return calculateNOfAKind(dice, 4);
    }

    @Override
    public boolean supports(Category category) {
        return FOUR_OF_A_KIND == category;
    }
}

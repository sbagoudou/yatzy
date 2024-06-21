package com.sbagoudou.yatzy.service;

import com.sbagoudou.yatzy.Category;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sbagoudou.yatzy.Category.THREE_OF_A_KIND;

@Service
public class YatzyThreeOfAKindPlugin implements YatzyPlugin {

    /**
     * Calculates the score of the roll based on the {@link THREE_OF_A_KIND} category rules:
     * If there are three dice with the same number, the score is the sum of these dice.
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    @Override
    public int doCalculateScore(List<Integer> dice) {
        return calculateNOfAKind(dice, 3);
    }

    @Override
    public boolean supports(Category category) {
        return THREE_OF_A_KIND == category;
    }
}

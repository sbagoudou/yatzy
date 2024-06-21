package com.sbagoudou.yatzy.service;

import com.sbagoudou.yatzy.Category;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sbagoudou.yatzy.Category.SIXES;

@Service
public class YatzySixesPlugin implements YatzyPlugin {

    /**
     * Calculates the score of the roll based on the {@link SIXES} category rules:
     * The score is the sum of the dice that reads six.
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    @Override
    public int doCalculateScore(List<Integer> dice) {
        return getNumberScore(dice, 6);
    }

    @Override
    public boolean supports(Category category) {
        return SIXES == category;
    }
}

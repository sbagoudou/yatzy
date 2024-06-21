package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.sbagoudou.yatzy.Category.FULL_HOUSE;

@Service
public class YatzyFullHousePlugin implements YatzyPlugin {

    /**
     * Calculates the score of the roll based on the {@link FULL_HOUSE} category rules:
     * If the dice are two of a kind and three of a kind, the score is the sum of all the dice.
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    @Override
    public int calculateScore(List<Integer> dice) {
        var frequencyMap = getFrequencyMap(dice);
        if (frequencyMap.containsValue(2L) && frequencyMap.containsValue(3L)) {
            return sum(dice);
        }
        return 0;
    }

    @Override
    public boolean supports(Category category) {
        return FULL_HOUSE == category;
    }
}

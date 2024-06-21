package com.sbagoudou.yatzy;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.sbagoudou.yatzy.Category.TWO_PAIRS;

@Service
public class YatzyTwoPairsPlugin implements YatzyPlugin {

    /**
     * Calculates the score of the roll based on the {@link TWO_PAIRS} category rules:
     * If there are two pairs of dice with the same number, the score is the sum of these dice.
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    @Override
    public int calculateScore(List<Integer> dice) {
        var frequencyMap = getFrequencyMap(dice);
        var repeatedCountEntries = frequencyMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 2)
                .toList();

        if (repeatedCountEntries.size() != 2) {
            return 0;
        }

        return repeatedCountEntries.stream()
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .map(i -> i * 2)
                .sum();
    }

    @Override
    public boolean supports(Category category) {
        return TWO_PAIRS == category;
    }
}

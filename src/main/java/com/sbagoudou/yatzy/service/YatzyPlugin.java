package com.sbagoudou.yatzy.service;

import com.sbagoudou.yatzy.Category;
import com.sbagoudou.yatzy.exception.YatzyException;
import org.springframework.plugin.core.Plugin;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface YatzyPlugin extends Plugin<Category> {

    List<Integer> ALL_DICE_VALUES = List.of(1, 2, 3, 4, 5, 6);

    /**
     * Calculates the score of a roll of dice according to the rules of the YATZY game
     *
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    int doCalculateScore(List<Integer> dice);

    /**
     * Performs preconditions checks then calls the actual score algorithm
     * @param dice a list of dice representing a roll
     * @return the calculated score
     */
    default int calculateScore(List<Integer> dice){
        assertDiceAreComplete(dice);
        return doCalculateScore(dice);
    }

    /**
     * Checks if the dice list is compliant for the game:
     * - The size is exactly 5
     * - Values are between 1 & 6 limit included
     *
     * @param dice the list of elements representing a roll
     * @throws YatzyException if dice list is not compliant
     */
    default void assertDiceAreComplete(List<Integer> dice) throws YatzyException {
        if (CollectionUtils.isEmpty(dice) || dice.size() != 5) {
            throw new YatzyException("Dice have not the excepted size. Actual: {0}, Excepted: 5",
                    dice != null ? dice.size() : 0);
        }

        if (dice.stream().anyMatch(d -> d < 1 || d > 6)) {
            throw new YatzyException("All dice values are not in the range [1-6]");
        }
    }

    /**
     * Calculates the sum of elements in the list
     *
     * @param dice the list of elements to sum
     * @return the calculated sum
     */
    default int sum(List<Integer> dice) {
        return dice.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * Calculates the sum of the dice that reads {@code value}
     *
     * @param dice  the list of elements to sum
     * @param value the value to look up for the sum
     * @return the calculated sum
     */
    default int getNumberScore(List<Integer> dice, int value) {
        return sum(dice.stream()
                .filter(d -> d == value)
                .toList());
    }

    /**
     * Calculates the sum of dice that are repeated {@code numberOfKind} times.
     * If their are more than one value repeated the wanted amount of time, the highest value is kept.
     *
     * @param dice         the roll
     * @param numberOfKind the number of repetition to check
     * @return the calculated value
     */
    default int calculateNOfAKind(List<Integer> dice, int numberOfKind) {
        Map<Integer, Long> frequencyMap = getFrequencyMap(dice);

        return ALL_DICE_VALUES.stream()
                .sorted(Comparator.reverseOrder())
                .filter(i -> frequencyMap.get(i) != null && frequencyMap.get(i) >= numberOfKind)
                .findFirst()
                .map(i -> i * numberOfKind)
                .orElse(0);
    }

    /**
     * Creates a Map with the values of dice and the number of occurrence of each element
     *
     * @param dice the dice roll
     * @return the frequency Map
     */
    default Map<Integer, Long> getFrequencyMap(List<Integer> dice) {
        return dice.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Checks if the roll has only one occurrence of each element and in that case calculate the sum
     * of these elements based on an excluded value that should not be present in the straight.
     *
     * @param dice           the dice roll
     * @param excludedValued the value that should not be in the straight
     * @return the calculated score
     */
    default int calculateStraight(List<Integer> dice, int excludedValued) {
        boolean hasDistinctElements = getFrequencyMap(dice).values()
                .stream()
                .filter(v -> v == 1)
                .toList()
                .size() == 5;
        if (hasDistinctElements && getFrequencyMap(dice).get(excludedValued) == null) {
            return sum(dice);
        }
        return 0;
    }
}

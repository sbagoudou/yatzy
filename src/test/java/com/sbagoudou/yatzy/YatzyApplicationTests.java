package com.sbagoudou.yatzy;

import com.sbagoudou.yatzy.exception.YatzyException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class YatzyApplicationTests {

    @Autowired
    private Yatzy1 yatzy1;

    static Stream<Arguments> chance() {
        return Stream.of(
                Arguments.of(List.of(2, 3, 4, 5, 1), 15),
                Arguments.of(List.of(1, 1, 3, 3, 6), 14),
                Arguments.of(List.of(4, 5, 5, 6, 1), 21),
                Arguments.of(List.of(6, 6, 6, 6, 6), 30)
        );
    }

    @ParameterizedTest
    @MethodSource("chance")
    void test_chance_scores_sum_of_all_dice(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.CHANCE));
    }

    static Stream<Arguments> chance_error() {
        return Stream.of(
                Arguments.of(List.of(2, 3, 4, 5)),
                Arguments.of(List.of(1, 1)),
                Arguments.of(List.of(4, 5, 5, 6, 1, 1, 6)),
                Arguments.of(List.of(4, 5, 7, 6, 1)),
                Arguments.of(List.of(4, 0, 5, 6, 1)),
                Arguments.of((Object) null)
        );
    }

    @ParameterizedTest
    @MethodSource("chance_error")
    void test_chance_with_wrong_dice_size(List<Integer> dice) {
        assertThrows(YatzyException.class, () -> yatzy1.calculateScore(dice, Category.CHANCE));
    }

    static Stream<Arguments> yatzy() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 1, 1, 1), 50),
                Arguments.of(List.of(2, 2, 2, 2, 2), 50),
                Arguments.of(List.of(3, 3, 3, 3, 3), 50),
                Arguments.of(List.of(6, 6, 6, 6, 6), 50),
                Arguments.of(List.of(3, 6, 1, 1, 4), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("yatzy")
    void test_yatzy(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.YATZY));
    }

    static Stream<Arguments> ones() {
        return Stream.of(
                Arguments.of(List.of(3, 1, 1, 5, 1), 3),
                Arguments.of(List.of(3, 3, 3, 4, 2), 0),
                Arguments.of(List.of(1, 1, 2, 4, 4), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("ones")
    void test_ones(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.ONES));
    }

    static Stream<Arguments> twos() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 2, 6), 4),
                Arguments.of(List.of(2, 2, 2, 2, 2), 10),
                Arguments.of(List.of(1, 1, 6, 4, 4), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("twos")
    void test_twos(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.TWOS));
    }

    static Stream<Arguments> threes() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 2, 3), 6),
                Arguments.of(List.of(2, 3, 3, 3, 3), 12),
                Arguments.of(List.of(1, 1, 6, 4, 4), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("threes")
    void test_threes(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.THREES));
    }

    static Stream<Arguments> fours() {
        return Stream.of(
                Arguments.of(List.of(4, 4, 4, 5, 5), 12),
                Arguments.of(List.of(4, 4, 5, 5, 5), 8),
                Arguments.of(List.of(4, 5, 5, 5, 5), 4),
                Arguments.of(List.of(1, 1, 6, 5, 5), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("fours")
    void test_fours(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.FOURS));
    }

    static Stream<Arguments> fives() {
        return Stream.of(
                Arguments.of(List.of(4, 4, 4, 5, 5), 10),
                Arguments.of(List.of(4, 4, 5, 5, 5), 15),
                Arguments.of(List.of(4, 5, 5, 5, 5), 20),
                Arguments.of(List.of(1, 1, 6, 4, 4), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("fives")
    void test_fives(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.FIVES));
    }

    static Stream<Arguments> sixes() {
        return Stream.of(
                Arguments.of(List.of(4, 4, 6, 5, 5), 6),
                Arguments.of(List.of(6, 5, 6, 6, 5), 18),
                Arguments.of(List.of(4, 4, 4, 5, 5), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("sixes")
    void test_sixes(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.SIXES));
    }

    static Stream<Arguments> pair() {
        return Stream.of(
                Arguments.of(List.of(3, 4, 3, 5, 6), 6),
                Arguments.of(List.of(5, 3, 3, 3, 5), 10),
                Arguments.of(List.of(5, 3, 6, 6, 5), 12),
                Arguments.of(List.of(1, 2, 3, 4, 5), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("pair")
    void test_pair(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.PAIR));
    }

    static Stream<Arguments> twoPairs() {
        return Stream.of(
                Arguments.of(List.of(3, 3, 5, 4, 5), 16),
                Arguments.of(List.of(3, 3, 5, 5, 5), 16),
                Arguments.of(List.of(1, 1, 6, 2, 6), 14),
                Arguments.of(List.of(1, 1, 2, 3, 4), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("twoPairs")
    void test_two_pairs(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.TWO_PAIRS));
    }

    static Stream<Arguments> threeOfAKind() {
        return Stream.of(
                Arguments.of(List.of(3, 3, 3, 4, 5), 9),
                Arguments.of(List.of(5, 3, 5, 4, 5), 15),
                Arguments.of(List.of(3, 3, 3, 3, 5), 9),
                Arguments.of(List.of(1, 1, 2, 3, 4), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("threeOfAKind")
    void test_three_of_a_kind(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.THREE_OF_A_KIND));
    }

    static Stream<Arguments> fourOfAKind() {
        return Stream.of(
                Arguments.of(List.of(3, 3, 3, 3, 5), 12),
                Arguments.of(List.of(5, 5, 5, 4, 5), 20),
                Arguments.of(List.of(3, 3, 3, 3, 3), 12),
                Arguments.of(List.of(1, 1, 2, 3, 4), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("fourOfAKind")
    void test_four_of_a_kind(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.FOUR_OF_A_KIND));
    }

    static Stream<Arguments> smallStraight() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), 15),
                Arguments.of(List.of(2, 3, 4, 5, 1), 15),
                Arguments.of(List.of(2, 3, 4, 5, 6), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("smallStraight")
    void test_small_straight(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.SMALL_STRAIGHT));
    }

    static Stream<Arguments> largeStraight() {
        return Stream.of(
                Arguments.of(List.of(6, 2, 3, 4, 5), 20),
                Arguments.of(List.of(2, 3, 4, 5, 6), 20),
                Arguments.of(List.of(1, 2, 3, 4, 5), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("largeStraight")
    void test_large_straight(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.LARGE_STRAIGHT));
    }

    static Stream<Arguments> fullHouse() {
        return Stream.of(
                Arguments.of(List.of(6, 2, 2, 2, 6), 18),
                Arguments.of(List.of(1, 1, 2, 2, 2), 8),
                Arguments.of(List.of(2, 3, 4, 5, 6), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("fullHouse")
    void test_full_house(List<Integer> dice, int expected) {
        assertEquals(expected, yatzy1.calculateScore(dice, Category.FULL_HOUSE));
    }

}

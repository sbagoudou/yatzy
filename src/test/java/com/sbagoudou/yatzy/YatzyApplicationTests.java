package com.sbagoudou.yatzy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class YatzyApplicationTests {

    @Test
    void contextLoads() {
    }

    static Stream<Arguments> chance() {
        return Stream.of(
                Arguments.of(2, 3, 4, 5, 1, 15),
                Arguments.of(1, 1, 3, 3, 6, 14),
                Arguments.of(4, 5, 5, 6, 1, 21),
                Arguments.of(6, 6, 6, 6, 6, 30)
        );
    }

    @ParameterizedTest
    @MethodSource("chance")
    public void test_chance_scores_sum_of_all_dice(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.chance(d1, d2, d3, d4, d5));
    }

    static Stream<Arguments> yatzy() {
        return Stream.of(
                Arguments.of(1, 1, 1, 1, 1, 50),
                Arguments.of(2, 2, 2, 2, 2, 50),
                Arguments.of(3, 3, 3, 3, 3, 50),
                Arguments.of(6, 6, 6, 6, 6, 50),
                Arguments.of(3, 6, 1, 1, 4, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("yatzy")
    public void test_yatzy(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.yatzy(d1, d2, d3, d4, d5));
    }

    static Stream<Arguments> ones() {
        return Stream.of(
                Arguments.of(3, 1, 1, 5, 1, 3),
                Arguments.of(3, 3, 3, 4, 2, 0),
                Arguments.of(1, 1, 2, 4, 4, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("ones")
    public void test_ones(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.ones(d1, d2, d3, d4, d5));
    }

    static Stream<Arguments> twos() {
        return Stream.of(
                Arguments.of(1, 2, 3, 2, 6, 4),
                Arguments.of(2, 2, 2, 2, 2, 10),
                Arguments.of(1, 1, 6, 4, 4, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("twos")
    public void test_twos(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.twos(d1, d2, d3, d4, d5));
    }

    static Stream<Arguments> threes() {
        return Stream.of(
                Arguments.of(1, 2, 3, 2, 3, 6),
                Arguments.of(2, 3, 3, 3, 3, 12),
                Arguments.of(1, 1, 6, 4, 4, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("threes")
    public void test_threes(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.threes(d1, d2, d3, d4, d5));
    }

    static Stream<Arguments> fours() {
        return Stream.of(
                Arguments.of(4, 4, 4, 5, 5, 12),
                Arguments.of(4, 4, 5, 5, 5, 8),
                Arguments.of(4, 5, 5, 5, 5, 4),
                Arguments.of(1, 1, 6, 5, 5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("fours")
    public void test_fours(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy1(d1, d2, d3, d4, d5).fours());
    }

    static Stream<Arguments> fives() {
        return Stream.of(
                Arguments.of(4, 4, 4, 5, 5, 10),
                Arguments.of(4, 4, 5, 5, 5, 15),
                Arguments.of(4, 5, 5, 5, 5, 20),
                Arguments.of(1, 1, 6, 4, 4, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("fives")
    public void test_fives(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy1(d1, d2, d3, d4, d5).fives());
    }

    static Stream<Arguments> sixes() {
        return Stream.of(
                Arguments.of(4, 4, 6, 5, 5, 6),
                Arguments.of(6, 5, 6, 6, 5, 18),
                Arguments.of(4, 4, 4, 5, 5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("sixes")
    public void test_sixes(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy1(d1, d2, d3, d4, d5).sixes());
    }

    static Stream<Arguments> onePair() {
        return Stream.of(
                Arguments.of(3, 4, 3, 5, 6, 6),
                Arguments.of(5, 3, 3, 3, 5, 10),
                Arguments.of(5, 3, 6, 6, 5, 12),
                Arguments.of(1, 2, 3, 4, 5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("onePair")
    public void test_one_pair(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, new Yatzy1().score_pair(d1, d2, d3, d4, d5));
    }

    static Stream<Arguments> twoPairs() {
        return Stream.of(
                Arguments.of(3, 3, 5, 4, 5, 16),
                Arguments.of(3, 3, 5, 5, 5, 16),
                Arguments.of(1, 1, 6, 2, 6, 14),
                Arguments.of(1, 1, 2, 3, 4, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("twoPairs")
    public void test_two_pairs(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.two_pair(d1, d2, d3, d4, d5));
    }

    static Stream<Arguments> threeOfAKind() {
        return Stream.of(
                Arguments.of(3, 3, 3, 4, 5, 9),
                Arguments.of(5, 3, 5, 4, 5, 15),
                Arguments.of(3, 3, 3, 3, 5, 9),
                Arguments.of(1, 1, 2, 3, 4, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("threeOfAKind")
    public void test_three_of_a_kind(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.three_of_a_kind(d1, d2, d3, d4, d5));
    }

    static Stream<Arguments> fourOfAKind() {
        return Stream.of(
                Arguments.of(3, 3, 3, 3, 5, 12),
                Arguments.of(5, 5, 5, 4, 5, 20),
                Arguments.of(3, 3, 3, 3, 3, 12),
                Arguments.of(1, 1, 2, 3, 4, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("fourOfAKind")
    public void test_four_of_a_knd(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.four_of_a_kind(d1, d2, d3, d4, d5));
    }

    static Stream<Arguments> smallStraight() {
        return Stream.of(
                Arguments.of(1, 2, 3, 4, 5, 15),
                Arguments.of(2, 3, 4, 5, 1, 15),
                Arguments.of(1, 2, 2, 4, 5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("smallStraight")
    public void test_small_straight(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.smallStraight(d1, d2, d3, d4, d5));
    }

    static Stream<Arguments> largeStraight() {
        return Stream.of(
                Arguments.of(6, 2, 3, 4, 5, 20),
                Arguments.of(2, 3, 4, 5, 6, 20),
                Arguments.of(1, 2, 2, 4, 5, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("largeStraight")
    public void test_large_straight(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.largeStraight(d1, d2, d3, d4, d5));
    }

    static Stream<Arguments> fullHouse() {
        return Stream.of(
                Arguments.of(6, 2, 2, 2, 6, 18),
                Arguments.of(1, 1, 2, 2, 2, 8),
                Arguments.of(2, 3, 4, 5, 6, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("fullHouse")
    public void test_full_house(int d1, int d2, int d3, int d4, int d5, int expected) {
        assertEquals(expected, Yatzy1.fullHouse(d1, d2, d3, d4, d5));
    }

}

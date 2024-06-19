package com.sbagoudou.yatzy;

import org.springframework.plugin.core.Plugin;

public interface YatzyPlugin extends Plugin<Category> {

    int calculateScore(int d1, int d2, int d3, int d4, int d5);
}

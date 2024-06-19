package com.sbagoudou.yatzy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class Yatzy1 {

    private final PluginRegistry<YatzyPlugin, Category> yatzyPlugin;

    public int calculateScore(int d1, int d2, int d3, int d4, int d5, Category category) {
        try {
            return yatzyPlugin.getRequiredPluginFor(category).calculateScore(d1, d2, d3, d4, d5);
        } catch (IllegalArgumentException e) {
            log.error("Missing required plugin for Yatzy Category {}", category);
            throw e;
        }
    }

}





package com.sbagoudou.yatzy;

import com.sbagoudou.yatzy.service.YatzyPlugin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class Yatzy1 {

    private final PluginRegistry<YatzyPlugin, Category> yatzyPlugin;

    public int calculateScore(List<Integer> dice, Category category) {
        try {
            return yatzyPlugin.getRequiredPluginFor(category).calculateScore(dice);
        } catch (IllegalArgumentException e) {
            log.error("Missing required plugin for Yatzy Category {}", category);
            throw e;
        }
    }

}





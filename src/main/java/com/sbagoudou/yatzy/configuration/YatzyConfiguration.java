package com.sbagoudou.yatzy.configuration;

import com.sbagoudou.yatzy.ServiceBasePackage;
import com.sbagoudou.yatzy.service.YatzyPlugin;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.plugin.core.config.EnablePluginRegistries;

@Configuration
@ComponentScan(basePackageClasses = {ServiceBasePackage.class})
@EnablePluginRegistries(YatzyPlugin.class)
public class YatzyConfiguration {

}

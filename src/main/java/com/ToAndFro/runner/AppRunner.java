package com.ToAndFro.runner;

import com.ToAndFro.client.CLIMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final CLIMenu menu;

    public AppRunner(CLIMenu menu) {
        this.menu = menu;
    }

    @Override
    public void run(String... args) {
        menu.run();
    }
}

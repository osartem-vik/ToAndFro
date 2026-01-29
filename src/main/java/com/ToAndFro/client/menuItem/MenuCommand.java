package com.ToAndFro.client.menuItem;

import org.springframework.stereotype.Component;

@Component
public abstract class MenuCommand {
    private String name;

    public MenuCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void execute();
}

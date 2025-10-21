package com.ToAndFro.client.menuItem;

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

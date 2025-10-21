package com.ToAndFro.client.menuItem;

public class ExitCommand extends MenuCommand {
    public void execute() {
        System.out.println("Exiting...");
        System.exit(0);
    }
}

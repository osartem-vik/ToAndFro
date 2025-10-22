package com.ToAndFro.client;

import com.ToAndFro.client.menuItem.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CLIMenu {
    private static final Logger LOGGER = LoggerFactory.getLogger(CLIMenu.class);
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_PATTERN = "^[1-9]$";
    private static final String EXIT_KEY = "0";

    private Map<String, MenuCommand> menuItems = Map.of(
            "1", new LoginCommand(),
            "2", new ListItemsCommand(),
            "3", new ViewItemCommand(),
            "4", new BuyItemCommand(),
            "5", new ProfileCommand(),
            "6", new MyItemsCommand(),
            "7", new AddItemCommand(),
            "8", new RemoveItemCommand()
    );

    public void run() {
        boolean isRunnable = true;
        while (isRunnable) {
            showMenu();
            String key = readMenuChoice();
            Set<String> mapKeys = menuItems.keySet();
            if (mapKeys.contains(key)) {
                executeCommand(key);
            } else if (key.equals(EXIT_KEY)) {
                isRunnable = false;
                LOGGER.info("User exited");
            } else {
                System.out.println("Invalid input");
                LOGGER.warn("Invalid input: {} is not in {}", key, INPUT_PATTERN);
            }
        }
    }

    private String readMenuChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextLine().trim();
    }

    private void executeCommand(String key) {
        menuItems.get(key).execute();
        pressEnterToContinue();
    }

    private void pressEnterToContinue() {
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }

    private void showMenu() {
        System.out.println("=== Menu ===");
        menuItems.keySet().stream()
                .sorted()
                .forEach(key -> System.out.println(key + ". " + menuItems.get(key).getName()));
        System.out.println(EXIT_KEY + ". Exit");
    }
}

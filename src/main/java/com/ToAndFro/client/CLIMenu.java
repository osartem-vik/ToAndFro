package com.ToAndFro.client;

import com.ToAndFro.client.menuItem.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Scanner;

public class CLIMenu {
    private static final Logger LOGGER = LoggerFactory.getLogger(CLIMenu.class);
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_PATTERN = "^[1-9]$";
    private static final int EXIT_KEY = 9;
    private static final int WRONG_INPUT_KEY = -1;

    private Map<Integer, MenuCommand> menuItems = Map.of(
            1, new LoginCommand(),
            2, new ListItemsCommand(),
            3, new ViewItemCommand(),
            4, new BuyItemCommand(),
            5, new ProfileCommand(),
            6, new MyItemsCommand(),
            7, new AddItemCommand(),
            8, new RemoveItemCommand()
    );

    public void run() {
        boolean isRunnable = true;
        while (isRunnable) {
            showMenu();
            int key = readMenuChoice(scanner);
            if (key == EXIT_KEY) {
                isRunnable = false;
                LOGGER.info("User exited");
            } else if (key != WRONG_INPUT_KEY) {
                executeCommand(key, scanner);
            }
        }
    }

    private int readMenuChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        String input = scanner.nextLine();
        boolean isValid = input.matches(INPUT_PATTERN);
        if (isValid) {
            return Integer.parseInt(input);
        } else {
            System.out.println("Invalid input");
            LOGGER.warn("Invalid input: {} is not in {}", input, INPUT_PATTERN);
            return WRONG_INPUT_KEY;
        }
    }

    private void executeCommand(int key, Scanner scanner) {
        menuItems.get(key).execute();
        pressEnterToContinue(scanner);
    }

    private void pressEnterToContinue(Scanner scanner) {
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

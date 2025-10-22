package com.ToAndFro.client;

import com.ToAndFro.client.menuItem.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Scanner;

public class CLIMenu {
    private static final Logger logger = LoggerFactory.getLogger(CLIMenu.class);

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
        Scanner scanner = new Scanner(System.in);
        boolean isRunnable = true;
        while (isRunnable) {
            showMenu();
            int key = readMenuChoice(scanner);
            if (key == 9) {
                isRunnable = false;
            } else if (key == -1) {
                continue;
            } else {
                executeCommand(key, scanner);
            }
        }
    }

    public int readMenuChoice(Scanner scanner) {
        String inputPattern = "^[1-9]$";
        System.out.print("Enter your choice: ");
        String input = scanner.nextLine();
        boolean isValid = input.matches(inputPattern);
        if (isValid) {
            return Integer.parseInt(input);
        } else {
            System.out.println("Invalid input");
            logger.warn("Invalid input");
            return -1;
        }
    }

    public void executeCommand(int key, Scanner scanner) {
        MenuCommand command = menuItems.get(key);
        command.execute();
        pressEnterToContinue(scanner);
    }

    public void pressEnterToContinue(Scanner scanner) {
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }

    public void showMenu() {
        System.out.println("=== Menu ===");
        menuItems.keySet().stream()
                .sorted()
                .forEach(key -> System.out.println(key + ". " + menuItems.get(key).getName()));
        System.out.println("9. Exit");
    }
}

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

            if(key == 9) {
                isRunnable = false;
            } else {
                executeCommand(key, scanner);
            }
        }
    }

    public int readMenuChoice(Scanner scanner) {
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            try {
                int choice = Integer.parseInt(input);
                if (!menuItems.containsKey(choice)) {
                    System.out.println("Invalid key! Enter valid menu option.");
                    logger.warn("Invalid key: no such menu option.");
                    continue;
                }
                return choice;
            } catch (Exception e) {
                System.out.println("Invalid input! Enter a number.");
                logger.error("Invalid input: is not a number.");
            }
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

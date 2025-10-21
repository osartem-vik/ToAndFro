package com.ToAndFro.client;

import com.ToAndFro.client.menuItem.*;

import java.util.Map;
import java.util.Scanner;

public class CLIMenu {
    private Map<String, MenuCommand> menuItems = Map.of(
            "1", new LoginCommand(),
            "2", new ListItemsCommand(),
            "3", new ViewItemCommand(),
            "4", new BuyItemCommand(),
            "5", new ProfileCommand(),
            "6", new MyItemsCommand(),
            "7", new AddItemCommand(),
            "8", new RemoveItemCommand(),
            "9", new ExitCommand()
    );

    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            menuItems.get(value).execute();
        }
    }
}

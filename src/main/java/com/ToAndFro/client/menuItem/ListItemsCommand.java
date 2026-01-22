package com.ToAndFro.client.menuItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ListItemsCommand extends MenuCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListItemsCommand.class);

    public ListItemsCommand() {
        super("List all items");
    }

    @Override
    public void execute() {
        System.out.println("* List of all products *");
        LOGGER.debug("All items list");
    }
}

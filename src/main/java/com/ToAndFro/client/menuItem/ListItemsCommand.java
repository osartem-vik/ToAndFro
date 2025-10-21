package com.ToAndFro.client.menuItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListItemsCommand extends MenuCommand {
    private static final Logger logger = LoggerFactory.getLogger(ListItemsCommand.class);

    public ListItemsCommand() {
        super("List all items");
    }

    @Override
    public void execute() {
        System.out.println("* List of all products *");
        logger.debug("All items list");
    }
}

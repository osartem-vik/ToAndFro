package com.ToAndFro.client.menuItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoveItemCommand extends MenuCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(RemoveItemCommand.class);

    public RemoveItemCommand() {
        super("Remove item");
    }

    @Override
    public void execute() {
        System.out.println("Item removed");
        LOGGER.info("Item removed");
    }
}

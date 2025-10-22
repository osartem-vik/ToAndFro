package com.ToAndFro.client.menuItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyItemsCommand extends MenuCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyItemsCommand.class);

    public MyItemsCommand() {
        super("My items");
    }

    @Override
    public void execute() {
        System.out.println("* List of my items *");
        LOGGER.debug("My items list");
    }
}

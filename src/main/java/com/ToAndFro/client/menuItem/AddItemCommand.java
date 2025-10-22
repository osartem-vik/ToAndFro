package com.ToAndFro.client.menuItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddItemCommand extends MenuCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddItemCommand.class);

    public AddItemCommand() {
        super("Add item");
    }

    @Override
    public void execute() {
        //value = console.getValue();
        //value pass to service();
        System.out.println("Product created");
        LOGGER.info("Product created");
    }
}

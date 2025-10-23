package com.ToAndFro.client.menuItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewItemCommand extends MenuCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(ViewItemCommand.class);

    public ViewItemCommand() {
        super("View item details");
    }

    @Override
    public void execute() {
        System.out.println("* Item info *");
        LOGGER.debug("Item info");
    }
}

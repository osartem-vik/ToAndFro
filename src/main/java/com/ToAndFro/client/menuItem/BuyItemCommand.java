package com.ToAndFro.client.menuItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BuyItemCommand extends MenuCommand {
    private static final Logger logger = LoggerFactory.getLogger(BuyItemCommand.class);

    public BuyItemCommand() {
        super("Buy item");
    }

    @Override
    public void execute() {
        System.out.println("Congrats! You successfully purchased a product");
        logger.info("Product purchased");
    }
}

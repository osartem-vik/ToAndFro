package com.ToAndFro.client.menuItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExitCommand extends MenuCommand {
    private static final Logger logger = LoggerFactory.getLogger(ExitCommand.class);

    public ExitCommand() {
        super("Exit");
    }

    @Override
    public void execute() {
        System.out.println("Exiting...");
        logger.info("User exited");
        System.exit(0);
    }
}

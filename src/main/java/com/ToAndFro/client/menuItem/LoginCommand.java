package com.ToAndFro.client.menuItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginCommand extends MenuCommand {
    private static final Logger logger = LoggerFactory.getLogger(LoginCommand.class);

    public LoginCommand() {
        super("Login");
    }

    @Override
    public void execute() {
        System.out.println("Welcome! You successfully logged in");
        logger.info("User logged in");
    }
}

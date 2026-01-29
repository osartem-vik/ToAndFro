package com.ToAndFro.client.menuItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProfileCommand extends MenuCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileCommand.class);

    public ProfileCommand() {
        super("My profile");
    }

    @Override
    public void execute() {
        System.out.println("* Profile info *");
        LOGGER.debug("Profile opened");
    }
}

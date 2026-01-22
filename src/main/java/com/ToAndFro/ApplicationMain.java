package com.ToAndFro;

import com.ToAndFro.client.CLIMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ApplicationMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationMain.class, args);
        CLIMenu menu = context.getBean(CLIMenu.class);
        menu.run();
    }
}

package org.example;

import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter implements Writer {
    public void write(String string) {
        System.out.println(string);
    }
}

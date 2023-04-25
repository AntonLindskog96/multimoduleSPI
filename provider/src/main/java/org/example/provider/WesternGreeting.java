package org.example.provider;

import org.example.service.Greeting;
import org.example.service.annotation.Language;

@Language("west")
public class WesternGreeting implements Greeting {
    @Override
    public String nationalGreet() {
        return "Hallå eller";
    }

}

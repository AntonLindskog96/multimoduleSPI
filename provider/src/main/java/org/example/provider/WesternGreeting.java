package org.example.provider;

import org.example.service.Greeting;

public class WesternGreeting implements Greeting {
    @Override
    public String nationalGreet() {
        return "Hallå eller";
    }

}

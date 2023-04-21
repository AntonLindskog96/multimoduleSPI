package org.example.provider;

import org.example.service.Greeting;

public class WesternGreeting implements Greeting {
    @Override
    public String sayHello() {
        return "Hallå eller";
    }

}

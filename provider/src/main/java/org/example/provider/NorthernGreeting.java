package org.example.provider;

import org.example.service.Greeting;

public class NorthernGreeting implements Greeting {

    @Override
    public String nationalGreet(){
        return "God tjenare";
    }
}

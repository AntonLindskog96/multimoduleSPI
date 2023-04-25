package org.example.provider;

import org.example.service.Greeting;
import org.example.service.annotation.Language;

@Language("north")
public class NorthernGreeting implements Greeting {

    @Override
    public String nationalGreet(){
        return "God tjenare";
    }
}

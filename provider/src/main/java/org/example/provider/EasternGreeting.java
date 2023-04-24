package org.example.provider;

import org.example.service.Greeting;

public class EasternGreeting implements Greeting {

    @Override
    public String nationalGreet(){
        return "God dag";
    }

}

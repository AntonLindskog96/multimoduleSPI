package org.example.provider;

import org.example.service.Greeting;
import org.example.service.annotation.Language;

@Language("east")
public class EasternGreeting implements Greeting {

    @Override
    public String nationalGreet(){
        return "God dag";
    }

}

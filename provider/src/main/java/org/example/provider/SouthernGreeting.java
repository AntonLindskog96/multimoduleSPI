package org.example.provider;

import org.example.service.Greeting;
import org.example.service.annotation.Language;

@Language("south")
public class SouthernGreeting  implements Greeting {
    @Override
    public String nationalGreet(){
        return "Hallåja";
    }

}

package org.example.provider;

import org.example.service.Greeting;

public class SouthernGreeting  implements Greeting {
    @Override
    public String sayHello(){
        return "Hallåja";
    }
}

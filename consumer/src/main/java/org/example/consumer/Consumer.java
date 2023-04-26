package org.example.consumer;
import org.example.service.Greeting;
import org.example.service.annotation.Language;
import java.util.*;

public class Consumer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServiceLoader<Greeting> greetings = ServiceLoader.load(Greeting.class);

        Map<String, Greeting> loaderMap = new HashMap<>();
        greetingMapping(loaderMap, greetings);

        String inputs;
        while (true) {
            loaderMap.keySet().forEach(System.out::println);
            System.out.println("Enter a language code ('exit' to quit): ");
            inputs = scanner.nextLine();

            if (inputs.equalsIgnoreCase("exit")) {
                break;
            }

            Greeting greeting = loaderMap.get(inputs);
            if (greeting == null) {
                System.out.println("Unknown language code.");
                continue;
            }

            System.out.println(greeting.nationalGreet());
            System.out.println("-----------------------------------");
        }
    }

    private static void greetingMapping(Map<String, Greeting> loaderMap, ServiceLoader<Greeting> greetings) {
        for (Greeting service : greetings) {
            Language annotation = service.getClass().getAnnotation(Language.class);
            if (annotation != null) {
                loaderMap.put(annotation.value(), service);
            }
        }
    }

}




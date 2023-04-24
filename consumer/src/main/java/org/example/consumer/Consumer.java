package org.example.consumer;

import org.example.provider.EasternGreeting;
import org.example.provider.NorthernGreeting;
import org.example.provider.SouthernGreeting;
import org.example.provider.WesternGreeting;
import org.example.service.Greeting;

import java.util.Scanner;
import java.util.ServiceLoader;


public class Consumer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            switch (scanner.nextLine()) {
                case "1" -> NorthernPrint(scanner);
                case "2" -> SouthernGreeting(scanner);
                case "3" -> WesternGreeting(scanner);
                case "4" -> EasternGreeting(scanner);
                case "5" -> System.exit(0);
            }
        }
    }

    private static void NorthernPrint(Scanner scanner) {
        ServiceLoader<Greeting> greetings = ServiceLoader.load(Greeting.class);
        for (var greeting : greetings) {
            if ( greeting instanceof NorthernGreeting) {
                System.out.println(greeting.nationalGreet());
                break;
            }
        }
    }

    private static void SouthernGreeting(Scanner scanner) {
        ServiceLoader<Greeting> greetings = ServiceLoader.load(Greeting.class);
        for (var greeting : greetings) {
            if ( greeting instanceof SouthernGreeting) {
                System.out.println(greeting.nationalGreet());
                break;
            }
        }
    }

    private static void WesternGreeting(Scanner scanner) {
        ServiceLoader<Greeting> greetings = ServiceLoader.load(Greeting.class);
        for (var greeting : greetings) {
            if ( greeting instanceof WesternGreeting) {
                System.out.println(greeting.nationalGreet());
                break;
            }
        }
    }

    private static void EasternGreeting(Scanner scanner) {
        ServiceLoader<Greeting> greetings = ServiceLoader.load(Greeting.class);
        for (var greeting : greetings) {
            if ( greeting instanceof EasternGreeting) {
                System.out.println(greeting.nationalGreet());
                break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                --------------------------------------------------------------
                Choose a direction and u will recieve a phrase.
                1. North
                2. West
                3. East
                4. South
                5. Exit
                --------------------------------------------------------------
                """);
    }
}
package org.example.consumer;
import org.example.service.Greeting;
import org.example.service.annotation.Language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.stream.Collectors;


public class Consumer {
    private static final Scanner scanner = new Scanner(System.in);
    private static String input;

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, IOException, NoSuchMethodException, InstantiationException {

        ServiceLoader<Greeting> greetings = ServiceLoader.load(Greeting.class);

        for ( var greeting : greetings) {
            System.out.println(greeting.nationalGreet());
        }


        Set<Class> classes = findAllClasses("org.example.provider");

        for (var c : classes) {
            var annotation = (Language) c.getAnnotation(Language.class);
            if (annotation != null) {
                System.out.println(annotation.value());
                var o = c.getConstructor().newInstance();
                var methods = c.getMethods();
                for (var m : methods) {
                    if (m.getReturnType().equals(String.class) && m.getParameterCount() == 0) {
                        var s = m.invoke(o);
                        if (s instanceof String string)
                            System.out.println(string);
                    }
                }

            }
        }
    }

    private static Set<Class> findAllClasses(String packageName) throws IOException {
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }

    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
        }
        return null;
    }
}


/*        private static List<Greeting> get(String annotationType){
            return ServiceLoader.load(Greeting.class)
                    .stream()
                    .filter(c -> c.type().isAnnotationPresent(Language.class)
                            && c.type().getAnnotation(Language.class)
                            .value()
                            .equals(annotationType))
                    .map(ServiceLoader.Provider::get)
                    .toList();
        }*/




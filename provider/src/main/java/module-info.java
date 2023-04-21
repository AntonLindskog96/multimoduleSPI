import org.example.provider.SouthernGreeting;
import org.example.provider.WesternGreeting;
import org.example.service.Greeting;

module org.example.provider {
    requires org.example.service;

    provides Greeting with SouthernGreeting, WesternGreeting;
}

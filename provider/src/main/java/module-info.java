import org.example.provider.EasternGreeting;
import org.example.provider.NorthernGreeting;
import org.example.provider.SouthernGreeting;
import org.example.provider.WesternGreeting;
import org.example.service.Greeting;

module org.example.provider {
    exports org.example.provider;
    requires org.example.service;

    provides Greeting with SouthernGreeting, WesternGreeting, NorthernGreeting, EasternGreeting;
}

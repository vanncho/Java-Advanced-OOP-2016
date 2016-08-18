package dependencyInjectionDemo;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dependencyInjectionDemo.models.InjectionModule;
import dependencyInjectionDemo.models.TwitterWrapper;

public class Main {
    public static void main(String[] args) {

        // DI
        Injector injector = Guice.createInjector(new InjectionModule());
        TwitterWrapper twitter = injector.getInstance(TwitterWrapper.class);

        // SIMULATE DI
       // TwitterWrapper twitter = new TwitterWrapper();

        twitter.processNotification("SoftUni", "Hello!");
    }
}

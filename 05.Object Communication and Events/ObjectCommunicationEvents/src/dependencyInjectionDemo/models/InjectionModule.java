package dependencyInjectionDemo.models;

import com.google.inject.AbstractModule;
import dependencyInjectionDemo.interfaces.NotificationService;

public class InjectionModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(NotificationService.class).to(TwitterService.class);
    }
}

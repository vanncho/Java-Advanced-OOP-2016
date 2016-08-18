package dependencyInjectionDemo.models;

import com.google.inject.Inject;
import dependencyInjectionDemo.interfaces.NotificationService;

public class TwitterWrapper {
    NotificationService service;

    // SIMULATE DI
    //public TwitterWrapper() {
    //    //this(new TwitterService());
    //}

    @Inject
    public TwitterWrapper(NotificationService service) {
        this.service = service;
    }

    public void processNotification(String sentTo, String message) {
        this.service.sendMessage(sentTo, message);
    }
}

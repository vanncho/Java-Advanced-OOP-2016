package dependencyInjectionDemo.models;

import dependencyInjectionDemo.interfaces.NotificationService;

public class TwitterService implements NotificationService {

    @Override
    public void sendMessage(String sentTo, String message) {
        System.out.println(sentTo + " received:");
        System.out.println(message);
    }
}

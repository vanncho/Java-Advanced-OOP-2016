package observerPatternDemo;

import java.util.ArrayList;
import java.util.List;

public class Server implements Observable {

    private String message;
    private List<Observer> observers;

    public Server() {
        this.observers = new ArrayList<>();
    }

    @Override
    public String getScheduleMessage() {
        return this.message;
    }

    @Override
    public void addObserver(Observer observer) {

        if (!this.observers.contains(observer)) {
            this.observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {

        if (this.observers.contains(observer)) {
            this.observers.remove(observer);
        }
    }

    public void scheduleDownTime(String message) {
        this.message = message;

        // TODO notify all observers
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        List<Observer> clonedObservers = new ArrayList<>(this.observers);

        for (Observer clonedObserver : clonedObservers) {
            clonedObserver.update();
        }
    }
}

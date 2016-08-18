package observerPatternDemo;

public interface Observable {

    String getScheduleMessage();

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void scheduleDownTime(String message);

    void notifyObservers();
}

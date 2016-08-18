package observerEventPatternDemo2;

public interface Observable {

    void scheduleDownTime(String message);

    String getScheduleDownTime();

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

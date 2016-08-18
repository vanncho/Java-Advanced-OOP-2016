package observerPatternDemo;

public class User implements Observer {

    private String userName;
    private String emailAddress;
    private Observable observable;

    public User(String userName, String emailAddress, Observable o) {
        this.setUserName(userName);
        this.setEmailAddress(emailAddress);

        this.observable = o;
    }

    public String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    private void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        read();
        unsubscribe();
    }

    @Override
    public void unsubscribe() {
        this.observable.removeObserver(this);
    }

    private void read() {
        System.out.println(this.getUserName() + " received:");
        System.out.println(this.observable.getScheduleMessage());
    }
}

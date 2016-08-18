package observerEventPatternDemo2;

public class User implements Observer {

    private String userName;
    private String emailAddress;
    private Observable observable;

    public User(String userName, String emailAddress, Observable ob) {
        this.setUserName(userName);
        this.setEmailAddress(emailAddress);

        this.setObservable(ob);
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

    public Observable getObservable() {
        return this.observable;
    }
    private void setObservable(Observable obsarvable) {
        this.observable = obsarvable;
    }

    @Override
    public void update(){

        read();
        unsubscribe();
    }

    private void read() {
        System.out.println(this.getUserName() + " recieved:");
        System.out.println(this.observable.getScheduleDownTime());
    }

    private void unsubscribe() {
        this.observable.removeObserver(this);
    }
}
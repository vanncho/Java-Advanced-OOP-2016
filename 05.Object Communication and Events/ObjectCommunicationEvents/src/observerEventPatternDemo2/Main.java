package observerEventPatternDemo2;

public class Main {
    public static void main(String[] args) {

        Observable server = new Server();

        Observer gosho = new User("Gosho", "gosho@abv.bg", server);
        Observer tosho = new User("Tosho", "tosho@gmail.com", server);
        Observer ivan = new User("Ivan", "ivan@yahoo.com", server);

        server.addObserver(gosho);
        server.addObserver(ivan);

        server.scheduleDownTime("Our servers will be unavailable on friday");

        server.addObserver(tosho);

        server.scheduleDownTime("We are hosting a party!");
    }
}

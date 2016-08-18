package observerPatternDemo;

public class Main {
    public static void main(String[] args) {

        Observable server = new Server();
        Observer gosho_mosho = new User("gosho_mossho", "gosho_qkia@abv.bg", server);
        Observer mosho_tosho = new User("mosho_tosho", "tosho_sofiiskia@gmail.com", null);
        Observer ivan_ivanov = new User("ivan_ivanov", "ivan_svaliacha@alo.bg", server);

        server.addObserver(gosho_mosho);
        server.addObserver(ivan_ivanov);

        server.scheduleDownTime("Our servers will be unavailable on friday");

    }
}

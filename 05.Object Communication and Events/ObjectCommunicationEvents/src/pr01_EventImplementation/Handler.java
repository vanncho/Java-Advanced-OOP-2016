package pr01_EventImplementation;

public class Handler implements NameChangeListener {

    private NameChange nameChange;

    public Handler(NameChange nameChange) {
        this.nameChange = nameChange;
    }

    @Override
    public void handleChangedName(NameChange event) {
        System.out.printf("Dispatcher's name changed to %s.%n", event.getChangedName());
    }
}

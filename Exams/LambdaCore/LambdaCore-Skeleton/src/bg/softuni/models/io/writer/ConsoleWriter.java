package bg.softuni.models.io.writer;

public class ConsoleWriter implements Writer {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}

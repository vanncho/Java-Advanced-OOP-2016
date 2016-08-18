package pr01_CommandPatternWithDependencyInjection;

import pr01_CommandPatternWithDependencyInjection.interfaces.CommandInterpreter;
import pr01_CommandPatternWithDependencyInjection.interfaces.Executable;
import pr01_CommandPatternWithDependencyInjection.models.CommandInterpreterImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();
        Thread thread = new Thread();

        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(builder, thread);

        while (true) {
            String[] data = reader.readLine().split("[\\s]+");
            String commandName = data[0];

            Executable command = commandInterpreter.interpretCommand(commandName, data);
            String result = command.execute();

            if (data[0].equals("End")) {
                break;
            }

            System.out.println(result);
        }
    }
}

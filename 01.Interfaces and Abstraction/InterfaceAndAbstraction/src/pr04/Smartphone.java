package pr04;

import pr04.interfaces.Browsable;
import pr04.interfaces.Callable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable {

    public Smartphone() {
    }

    @Override
    public void bowsing(String address) {
        boolean isMatch = true;

        for (int i = 0; i < address.length(); i++) {
            char ch = address.charAt(i);

            if (Character.isDigit(ch)){
                isMatch = false;
            }
        }

        if (isMatch) {
            System.out.printf("Browsing: %s!%n", address);
        } else {
            System.out.println("Invalid URL!");
        }
    }

    @Override
    public void calling(String number) {
        String numberRegex = "^[\\d]+$";
        Pattern pattern = Pattern.compile(numberRegex);
        Matcher matcher = pattern.matcher(number);

        if (matcher.find()) {
            System.out.printf("Calling... %s%n", number);
        } else {
            System.out.println("Invalid number!");
        }
    }
}

package pro02.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Suit {

    String type() default "Enumeration";
    String category() default "Suit";
    String description() default "Provides suit constants for a Card class.";
}

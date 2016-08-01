package pro02.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Rank {

    String type() default  "Enumeration";
    String category() default  "Rank";
    String description() default "Provides rank constants for a Card class.";
}

package pr00_LiveDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {

        //Class testClass = TestClass.class;
        //TestClass tc = (TestClass) testClass.newInstance();

        //Field[] fields = testClass.getDeclaredFields();
        //for (Field field : fields) {
        //    String type = field.getType().getTypeName();
        //    String name = field.getName();
        //    field.setAccessible(true);
        //    Object value = field.get(tc);
        //    System.out.println(type + " " + name + " = " + value.toString());
        //}


        //Field field = testClass.getDeclaredField("myName");
        //field.setAccessible(true);
        //field.set(tc, "Pesho");
        //Object val = field.get(tc);
        //int mod = field.getModifiers();
        //System.out.println(val.toString());
        //System.out.println(Modifier.toString(mod));

        //Class sbClass = StringBuilder.class;
        //Constructor ctor = sbClass.getConstructor(int.class);
        //Class[] params = ctor.getParameterTypes();
//
        //for (Class param : params) {
        //    System.out.println(param.getName());
        //}
        ////StringBuilder sb = (StringBuilder) ctor.newInstance("Iv");
        ////sb.append("an");
        ////System.out.println(sb);


        Class sbClass = StringBuilder.class;
        Constructor ctor = sbClass.getConstructor();
        StringBuilder sb = (StringBuilder) ctor.newInstance();

        Method append = sbClass.getMethod("append", String.class);
        append.invoke(sb, "test mmm");
        System.out.println(sb);
    }
}

class TestClass {

    private int testClassValue = 5;
    private String myName = "Ivan";
}

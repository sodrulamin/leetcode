package staticTest;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 27/02/2024
 */
public class MySubClass extends MyClass {
    public static void nonFinalStaticMethod() {
        System.out.println("Overridden non-final static method in subclass");
    }
}

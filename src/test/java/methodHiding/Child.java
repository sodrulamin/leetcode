package methodHiding;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 27/02/2024
 */
public class Child extends Parent {

    //we can't hide display method by making it private or static or anything. We must keep it same as its parent.
    public void display() {
        System.out.println("Child's display() method");
    }
}

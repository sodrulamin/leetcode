package methodHiding;

/**
 * @author Sodrul Amin Shaon
 * {@code @created} 27/02/2024
 */
public class Main {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.display();
        ((Child) parent).display();
    }
}

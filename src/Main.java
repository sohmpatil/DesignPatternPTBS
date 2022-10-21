import java.io.FileNotFoundException;

/**
 * This is the starting point for running the project
 */
public class Main {
    /**
     * This function calls the FACADE functions to give an overall idea.
     * @param args: These are general arguments
     * @throws InterruptedException: Interrupted by time loop
     * @throws FileNotFoundException: Interrupted by file not found error
     */
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        Facade facade = new Facade();
        facade.login();
        facade.reminderVisitor();
        facade.productOperation();
    }
}
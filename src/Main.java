import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        Facade facade = new Facade();
        facade.login();
        facade.reminderVisitor();
        facade.productOperation();
    }
}
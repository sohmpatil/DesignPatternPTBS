import javax.swing.*;

/**
 * This class implemented in FACADE, FACTORY and BRIDGE design patterns
 */
public interface ProductMenu {
    JFrame getProductFrame();
    void showMenu();
    void showAddButton();
    void showViewButton();
    void showRadioButton();
    void showLabels();
    void showComboxes(ClassProductList productList);
}

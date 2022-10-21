import javax.swing.*;
public interface ProductMenu {
    JFrame getProductFrame();
    void showMenu();
    void showAddButton();
    void showViewButton();
    void showRadioButton();
    void showLabels();
    void showComboxes(ClassProductList productList);
}

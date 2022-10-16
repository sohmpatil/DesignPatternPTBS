import javax.swing.*;

public class Facade {
    public static final String loginFrameTitle = "Login Form";

    private int UserType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList;
    private Person thePerson;

    public boolean login() {
        Login loginFrame = new Login();
        loginFrame.setTitle(loginFrameTitle);
        loginFrame.setVisible(true);
        loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loginFrame.setResizable(false);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return true;
    }

    public void addTrading() {

    }

    public void viewTrading() {

    }

    public void decideBidding() {

    }

    public void discussBidding() {

    }

    public void submitBidding() {

    }

    public void remind() {

    }

    public void createUser(UserInfoItem userinfoitem) {

    }

    public void createProductList() {

    }

    public void AttachProductToUser() {

    }

    public Product SelectProduct() {
        return new Product();
    }

    public void productOperation() {

    }
}

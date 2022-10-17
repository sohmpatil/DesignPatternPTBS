import javax.swing.*;

public class Facade {
    public static final String loginFrameTitle = "Login Form";

    private int UserType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList;
    private Person thePerson;
    private UserInfoItem userInfoItem;

    public Facade() {
    }

    public boolean login() {
        Login loginFrame = new Login();
        loginFrame.setTitle(loginFrameTitle);
        loginFrame.setVisible(true);
        loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loginFrame.setResizable(false);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userInfoItem.setUserType(loginFrame.userInfo.getUserType());
        userInfoItem.setUserName(loginFrame.userInfo.getUserName());
        addTrading();
        return loginFrame.isLogin;
    }

    public void addTrading() {
        System.out.println(userInfoItem.getUserType());
        System.out.println(userInfoItem.getUserName());
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

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * FACADE: This is mainly used for the FACADE design Pattern
 * This class as the name suggests works for accumulation of methods from other classes.
 * This uses methods from Login class.
 */
public class Facade {
    public static final String LOGIN_FRAME_TITLE = "Login Form";
    public static final File PRODUCTS_INFO_FILE = new File("resources/ProductInfo.txt");
    public static final File USER_PRODUCT_FiLE = new File("resources/UserProduct.txt");
    public static final String MEAT_PRODUCTS = "MEAT";
    public static final String PRODUCE_PRODUCTS = "PRODUCE";

    private int UserType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList;
    private Person thePerson;
    private UserInfoItem userInfoItem;
    private boolean isLoggingOn = true;

    Facade() {
    }

    /**
     * This function handles login
     * @return : boolean
     * @throws InterruptedException: TimeUnit interruption
     */
    public boolean login() throws InterruptedException {
        isLoggingOn = true;
        Login loginFrame = new Login();
        loginFrame.setTitle(LOGIN_FRAME_TITLE);
        loginFrame.setVisible(true);
        loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        loginFrame.setResizable(false);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(loginFrame.isLogin) {
            TimeUnit.MILLISECONDS.sleep(100);
        }
        loginFrame.setVisible(false);
        userInfoItem = new UserInfoItem(loginFrame.userInfo.getUserType(), loginFrame.userInfo.getUserName());
        UserType = userInfoItem.getUserType();
        createUser(userInfoItem);
        return loginFrame.isLogin;
    }

    /**
     * This function will work to add trading value
     */
    public void addTrading() {
        System.out.println("Add Trading");
    }

    /**
     * This function will show all the values to be tread.
     */
    public void viewTrading() {
        System.out.println("View Trading");
    }

    /**
     * The bidding will be decided.
     */
    public void decideBidding() {
        System.out.println("Decide Bidding");
    }

    /**
     * Negotiation of bids will be done here
     */
    public void discussBidding() {
        System.out.println("Discuss Bidding");
    }

    /**
     * Bidding will be finalized
     */
    public void submitBidding() {
        System.out.println("Submit Bidding");
    }

    /**
     * The reminder will be called to check the bids.
     */
    public void remind() {
        System.out.println("Remind");
    }

    /**
     * Create the user
     * @param userInfoItem: This contains user's name and type(seller or buyer)
     */
    public void createUser(UserInfoItem userInfoItem) {
        if (userInfoItem.getUserType() == 0) {
            thePerson = new Buyer(userInfoItem.getUserName());
        }
        else {
            thePerson = new Seller(userInfoItem.getUserName());
        }
    }

    /**
     * This creates the product list by reading the files.
     * @throws FileNotFoundException: File not found exception
     */
    public void createProductList() throws FileNotFoundException {
        String[] splits;
        theProductList = new ClassProductList();

        Scanner reader = new Scanner(PRODUCTS_INFO_FILE);

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            splits = line.split(":");
            String meatOrProduce = splits[0];
            String product = splits[1];

            if (MEAT_PRODUCTS.equals(meatOrProduce)) {
                Product meat_product = new Product(product, 0);
                theProductList.add(meat_product);
            } else if (PRODUCE_PRODUCTS.equals(meatOrProduce)) {
                Product produce_product = new Product(product, 1);
                theProductList.add(produce_product);
            }
        }

        reader.close();
    }

    public void AttachProductToUser() throws FileNotFoundException {
        Scanner reader = new Scanner(USER_PRODUCT_FiLE);

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] splits = line.split(":");
            String user = splits[0];
            String product = splits[1];

            if (user.equals(thePerson.getUserName())) {
                thePerson.getProductList().add(theProductList.findProduct(product));
            }
        }
    }

    /**
     * Selecting a product for trade
     * @return : Returns the product
     */
    public Product SelectProduct() {
        theSelectedProduct = new Product("Check", 0);
        return theSelectedProduct;
    }

    /**
     * This runs to create the products for the operation
     * @throws FileNotFoundException: File not found exception
     */
    public void productOperation() throws FileNotFoundException {
        Buyer buyer = new Buyer(this.userInfoItem.getUserName());
        createProductList();
        buyer.CreateProductMenu(this.userInfoItem.getUserType());
    }

    /**
     * This function calls the Node visitor extended reminder visitor class
     */
    public void reminderVisitor() {
        ReminderVisitor reminder = new ReminderVisitor();
        Trading trade = new Trading();
        //theProductList.accept(reminder);
        trade.accept(reminder);
        accept(reminder);
    }

    /**
     * This is
     * @param visitor
     */
    public void accept(NodeVisitor visitor) {
        visitor.visitFacade(this);
    }
}

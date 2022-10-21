/**
 * This is implemented for the BRIDGE and FACTORY design pattern
 */
public class Buyer extends Person{
    /**
     * Constructor takes argument of name and creates the buyer.
     * @param userName:String
     */
    Buyer(String userName) {
        this.setUserName(userName);
        this.setUserType(0);
        this.setClassProductList(new ClassProductList());
    }

    /**
     * This function calls the show menu function from the product menu class and show other labels
     */
    @Override
    public void showMenu() {
        theProductMenu.showMenu();
        System.out.println(theProductMenu);
        showLabels();
        showAddButton();
        showRadioButton();
        showViewButton();
        showComboxes(getProductList());
    }

    /**
     * It creates the product menu to show in the
     * @param meatOrProduce: This function takes the parameter to decide to show the types of products.
     * @return : Returns the product menu
     */
    @Override
    public ProductMenu CreateProductMenu(int meatOrProduce) {
        System.out.println(meatOrProduce);

        if (meatOrProduce == 0) {
            this.isPersonShown = true;
            theProductMenu = new MeatProductMenu();
            theProductMenu.getProductFrame().setVisible(true);
            theProductMenu.showMenu();
            theProductMenu.showAddButton();
            theProductMenu.showViewButton();
            theProductMenu.showLabels();
            theProductMenu.showRadioButton();
            theProductMenu.showComboxes(getProductList());
            return theProductMenu;
        } else if (meatOrProduce == 1) {
            theProductMenu = new ProduceProductMenu();
            theProductMenu.getProductFrame().setVisible(true);
            theProductMenu.showMenu();
            theProductMenu.showAddButton();
            theProductMenu.showViewButton();
            theProductMenu.showRadioButton();
            theProductMenu.showLabels();
            theProductMenu.showComboxes(getProductList());
            return theProductMenu;
        }

        return null;
    }

}

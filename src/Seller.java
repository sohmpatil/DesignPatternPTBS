/**
 * This is used in the BRIDGE and FACTORY design pattern
 */
public class Seller extends Person{

    Seller(String userName) {
        this.setUserName(userName);
        this.setUserType(1);
        this.setClassProductList(new ClassProductList());
    }

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

    @Override
    public ProductMenu CreateProductMenu(int meatOrProduce) throws InterruptedException {
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

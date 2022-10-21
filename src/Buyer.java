import java.util.concurrent.TimeUnit;

public class Buyer extends Person{
    Buyer(String userName) {
        this.setUserName(userName);
        this.setUserType(0);
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
            while (this.isPersonShown) {
                TimeUnit.MILLISECONDS.sleep(100);
            }
            this.isPersonShown = false;
            theProductMenu.getProductFrame().setVisible(false);
            return theProductMenu;
        } else if (meatOrProduce == 1) {
            theProductMenu = new ProduceProductMenu();
            theProductMenu.getProductFrame().setVisible(true);
            theProductMenu.showMenu();
            theProductMenu.showAddButton();
            theProductMenu.showViewButton();
            theProductMenu.showRadioButton();
            theProductMenu.showLabels();
            return theProductMenu;
        }

        return null;
    }

}

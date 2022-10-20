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
    public ProductMenu CreateProductMenu(int meatOrProduce) {
        System.out.println(meatOrProduce);

        if (meatOrProduce == 0) {
            return theProductMenu = new MeatProductMenu();
        } else if (meatOrProduce == 1) {
            return theProductMenu = new ProduceProductMenu();
        }

        return null;
    }

}

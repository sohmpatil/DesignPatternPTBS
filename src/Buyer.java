public class Buyer extends Person{

    Buyer(String userName) {
        this.setUserName(userName);
        this.setUserType(0);
        this.setClassProductList(new ClassProductList());
    }
    @Override
    public void showMenu() {

    }

    @Override
    public ProductMenu CreateProductMenu(int meatOrProduce) {
        return null;
    }

    @Override
    public ProductMenu CreateProductMenu() {
        return null;
    }
}

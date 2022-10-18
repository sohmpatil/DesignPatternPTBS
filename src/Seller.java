public class Seller extends Person{

    public Seller(String userName) {
        this.setUserName(userName);
        this.setUserType(1);
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

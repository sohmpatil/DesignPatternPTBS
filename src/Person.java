public abstract class Person {

    ProductMenu theProductMenu;
    private String userName;
    private int userType;
    private ClassProductList classProductList;

    public abstract void showMenu();
    public void showAddButton() {
        theProductMenu.showAddButton();
    }

    public void showViewButton() {
        theProductMenu.showViewButton();
    }

    public void showRadioButton() {
        theProductMenu.showRadioButton();
    }

    public void showLabels() {
        theProductMenu.showLabels();
    }

    public void showComboxes(ClassProductList productList) {
        theProductMenu = new MeatProductMenu();
        theProductMenu.showComboxes(productList);
    }

    public abstract ProductMenu CreateProductMenu(int meatOrProduce);

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ClassProductList getProductList() {
        return classProductList;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserType() {
        return this.userType;
    }

    public ClassProductList getClassProductList() {
        return this.classProductList;
    }

    public void setClassProductList(ClassProductList classProductList) {
        this.classProductList = classProductList;
    }
}

public class Product {
    private String productName;
    private int productType;

    Product(String productName, int productType) {
        this.productName = productName;
        this.productType = productType;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getProductType() {
        return this.productType;
    }

}

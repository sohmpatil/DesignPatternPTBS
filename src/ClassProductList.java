import java.util.ArrayList;

public class ClassProductList extends ArrayList<Product> {

    private ProductIterator productIterator;

    ClassProductList() {

        productIterator = new ProductIterator(this);
    }

    public Product findProduct(String productName) {
        return productIterator.findProduct(productName);
    }

    public void accept(NodeVisitor visitor) {

    }
}

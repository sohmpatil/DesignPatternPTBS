import java.util.ArrayList;

public class ClassProductList extends ArrayList<Product> {

    private ProductIterator productIterator;

    ClassProductList() {
        productIterator = new ProductIterator(this);
    }

    public Product findProduct(String productName) {
        System.out.println(productName);
        return productIterator.findProduct(productName);
    }

    public void accept(NodeVisitor visitor) {
        for (Product product: productIterator.classProductList) {
            visitor.visitProduct(product);
        }
    }
}

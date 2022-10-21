import java.util.ArrayList;

/**
 * ArrayList is extended by this class. This is used in ITERATOR and VISITOR design Pattern
 */
public class ClassProductList extends ArrayList<Product> {

    private ProductIterator productIterator;

    /**
     * This is the constructor for class product list.
     */
    ClassProductList() {
        productIterator = new ProductIterator(this);
    }

    /**
     * This function finds the product using the name string.
     * @param productName: String
     * @return : Product
     */
    public Product findProduct(String productName) {
        System.out.println(productName);
        return productIterator.findProduct(productName);
    }

    /**
     * This function is used for visitor Pattern
     * @param visitor: NodeVisitor
     */
    public void accept(NodeVisitor visitor) {
        for (Product product: productIterator.classProductList) {
            visitor.visitProduct(product);
        }
    }
}

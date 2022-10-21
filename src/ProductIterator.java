import java.util.ListIterator;

/**
 * This is used in ITERATOR design Pattern
 */
public class ProductIterator implements ListIterator<Product> {

    ClassProductList classProductList;
    private int idx = -1;

    public ProductIterator(ClassProductList classProductList) {
        this.classProductList = classProductList;
    }
    @Override
    public boolean hasNext() {
        return (idx < (classProductList.size() - 1));
    }

    @Override
    public Product next() {
        if (hasNext()) {
            return classProductList.get(++idx);
        }
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return (idx >= 0);
    }

    @Override
    public Product previous() {
        if (hasPrevious()) {
            return classProductList.get(--idx);
        }
        return null;
    }

    @Override
    public int nextIndex() {
        if (hasNext()) {
            return (idx + 1);
        }
        return -1;
    }

    @Override
    public int previousIndex() {
        if (hasNext()) {
            return (idx - 1);
        }
        return -1;
    }

    @Override
    public void remove() {
        if (idx != -1) {
            classProductList.remove(idx);
        }
    }

    @Override
    public void set(Product product) {
        if (idx != -1) {
            classProductList.add(idx, product);
            classProductList.remove(idx + 1);
        }
    }

    @Override
    public void add(Product product) {
        classProductList.add(product);
    }

    public void moveToHead() {
        idx = -1;
    }

    public Product findProduct(String productName) {
        moveToHead();

        while (hasNext()) {
            next();
            if (classProductList.get(idx).getProductName().equals(productName)) {
                return classProductList.get(idx);
            }
        }

        return null;
    }

}

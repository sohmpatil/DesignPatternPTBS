import java.lang.annotation.Documented;
import java.util.ListIterator;

public class ProductIterator implements ListIterator<Product> {

    ClassProductList classProductList;
    private int currentIndex = -1;

    public ProductIterator(ClassProductList classProductList) {
        this.classProductList = classProductList;
    }
    @Override
    public boolean hasNext() {
        return (currentIndex < (classProductList.size() - 1));
    }

    @Override
    public Product next() {
        if (hasNext()) {
            return classProductList.get(++currentIndex);
        }
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return (currentIndex >= 0);
    }

    @Override
    public Product previous() {
        if (hasPrevious()) {
            return classProductList.get(--currentIndex);
        }
        return null;
    }

    @Override
    public int nextIndex() {
        if (hasNext()) {
            return (currentIndex + 1);
        }
        return -1;
    }

    @Override
    public int previousIndex() {
        if (hasNext()) {
            return (currentIndex - 1);
        }
        return -1;
    }

    @Override
    public void remove() {
        if (currentIndex != -1) {
            classProductList.remove(currentIndex);
        }
    }

    @Override
    public void set(Product product) {
        if (currentIndex != -1) {
            classProductList.add(currentIndex, product);
            classProductList.remove(currentIndex + 1);
        }
    }

    @Override
    public void add(Product product) {
        classProductList.add(product);
    }

    public void moveToHead() {
        currentIndex = -1;
    }

}

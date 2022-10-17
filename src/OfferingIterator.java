import java.util.ListIterator;

public class OfferingIterator implements ListIterator<Offering> {

    OfferingList offeringList;
    private int currentIndex = -1;

    public OfferingIterator(OfferingList offeringList) {
        this.offeringList = offeringList;
    }
    @Override
    public boolean hasNext() {
        return (currentIndex < (currentIndex + 1));
    }

    @Override
    public Offering next() {
        if (hasNext()) {
            return offeringList.get(++currentIndex);
        }
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return (currentIndex >= 0);
    }

    @Override
    public Offering previous() {
        if (hasPrevious()) {
            return offeringList.get(--currentIndex);
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
            offeringList.remove(currentIndex);
        }
    }

    @Override
    public void set(Offering offering) {
        if (currentIndex != -1) {
            offeringList.add(currentIndex, offering);
            offeringList.remove(currentIndex + 1);
        }
    }

    @Override
    public void add(Offering offering) {
        offeringList.add(offering);
    }

    public void moveToHead() {
        currentIndex = -1;
    }
}

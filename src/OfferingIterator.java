import java.util.ListIterator;

/**
 * This is used in ITERATOR design Pattern
 */
public class OfferingIterator implements ListIterator<Offering> {

    OfferingList offeringList;
    private int idx = -1;

    public OfferingIterator(OfferingList offeringList) {
        this.offeringList = offeringList;
    }
    @Override
    public boolean hasNext() {
        return (idx < (idx + 1));
    }

    @Override
    public Offering next() {
        if (hasNext()) {
            return offeringList.get(++idx);
        }
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return (idx >= 0);
    }

    @Override
    public Offering previous() {
        if (hasPrevious()) {
            return offeringList.get(--idx);
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
            offeringList.remove(idx);
        }
    }

    @Override
    public void set(Offering offering) {
        if (idx != -1) {
            offeringList.add(idx, offering);
            offeringList.remove(idx + 1);
        }
    }

    @Override
    public void add(Offering offering) {
        offeringList.add(offering);
    }

    public void moveToHead() {
        idx = -1;
    }


}

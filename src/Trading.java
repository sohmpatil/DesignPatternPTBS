/**
 * This is used in VISITOR design Pattern
 */
public class Trading {
    public void accept(NodeVisitor visitor) {
        visitor.visitTrading(this);
    }
}

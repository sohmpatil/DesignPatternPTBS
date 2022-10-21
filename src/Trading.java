import com.sun.jdi.connect.Connector;

public class Trading {
    public void accept(NodeVisitor visitor) {
        visitor.visitTrading(this);
    }
}

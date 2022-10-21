public class ReminderVisitor extends NodeVisitor {

    private Reminder m_Reminder;

    @Override
    public void visitProduct(Product product) {
        System.out.println("Product Trading Reminder");
    }

    @Override
    public void visitTrading(Trading trading) {
        System.out.println("Trading Reminder");
    }

    @Override
    public void visitFacade(Facade facade) {
        System.out.println("Facade Reminder");
    }
}

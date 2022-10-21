/**
 * This is used in VISITOR design Pattern
 */
public class ReminderVisitor extends NodeVisitor {

    private Reminder m_Reminder;

    @Override
    public void visitProduct(Product product) {
        System.out.println("Product Trading Reminder");
    }

    @Override
    public void visitTrading(Trading trading) {
        this.m_Reminder = new Reminder();
        this.m_Reminder.name = "Reminder";
        System.out.println("Trading Reminder " + this.m_Reminder.name);
    }

    @Override
    public void visitFacade(Facade facade) {
        System.out.println("Facade Reminder");
    }
}

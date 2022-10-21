import javax.swing.*;

public class MeatProductMenu implements ProductMenu {
    private JFrame meatProductFrame;
    JLabel productsSelect = new JLabel("Select from following products");

    JRadioButton meatButton = new JRadioButton("Meat");
    JRadioButton produceButton = new JRadioButton("Produce");
    ButtonGroup productsButtonGroup = new ButtonGroup();

    JButton addProductButton = new JButton("Add");
    JButton viewProductButton = new JButton("View");

    JComboBox<String> jComboBox = new JComboBox<>();

    @Override
    public JFrame getProductFrame() {
        return this.meatProductFrame;
    }
    MeatProductMenu() {
        this.meatProductFrame = new JFrame();
        this.meatProductFrame.setLayout(null);
    }
    @Override
    public void showMenu() {

        this.meatProductFrame.setVisible(true);
        this.meatProductFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.meatProductFrame.setResizable(false);
        this.meatProductFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void showAddButton() {
        addProductButton.setBounds(100, 100, 100, 20);
        this.meatProductFrame.add(addProductButton);
    }

    @Override
    public void showViewButton() {
        viewProductButton.setBounds(200, 100, 100, 20);
        this.meatProductFrame.add(viewProductButton);
    }

    @Override
    public void showRadioButton() {
        meatButton.setBounds(100, 200, 100, 20);
        productsButtonGroup.add(meatButton);
        produceButton.setBounds(200, 200, 100, 20);
        productsButtonGroup.add(produceButton);
        this.meatProductFrame.add(meatButton);
        this.meatProductFrame.add(produceButton);
    }

    @Override
    public void showLabels() {
        productsSelect.setBounds(100, 300, 200, 20);
        this.meatProductFrame.add(productsSelect);
    }

    @Override
    public void showComboxes(ClassProductList productList) {
        for (Product product : productList) {
            if (product.getProductType() == 0)
                jComboBox.addItem(product.getProductName());
        }
        jComboBox.setBounds(200, 300,100,20);
        this.meatProductFrame.add(jComboBox);
    }
    
}
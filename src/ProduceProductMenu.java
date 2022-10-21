import javax.swing.*;

public class ProduceProductMenu implements ProductMenu {
    JFrame produceProductFrame;
    JLabel productsSelect = new JLabel("Select from following products");

    JRadioButton meatButton = new JRadioButton("Meat");
    JRadioButton produceButton = new JRadioButton("Produce");
    ButtonGroup productsButtonGroup = new ButtonGroup();

    JButton addProductButton = new JButton("Add");
    JButton viewProductButton = new JButton("View");

    JComboBox<String> jComboBox = new JComboBox<>();


    @Override
    public JFrame getProductFrame() {
        return this.produceProductFrame;
    }
    ProduceProductMenu() {
        this.produceProductFrame = new JFrame();
        this.produceProductFrame.setLayout(null);
    }

    @Override
    public void showMenu() {
        produceProductFrame.setVisible(true);
        produceProductFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        produceProductFrame.setResizable(false);
        produceProductFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void showAddButton() {
        addProductButton.setBounds(100, 500, 100, 20);
        produceProductFrame.add(addProductButton);
    }

    @Override
    public void showViewButton() {
        viewProductButton.setBounds(200, 500, 100, 20);
        produceProductFrame.add(viewProductButton);
    }

    @Override
    public void showRadioButton() {
        meatButton.setBounds(100, 200, 100, 20);
        productsButtonGroup.add(meatButton);
        produceButton.setBounds(200, 200, 100, 20);
        productsButtonGroup.add(produceButton);
        produceProductFrame.add(meatButton);
        produceProductFrame.add(produceButton);
    }

    @Override
    public void showLabels() {
        productsSelect.setBounds(100, 300, 200, 20);
        produceProductFrame.add(productsSelect);
    }

    @Override
    public void showComboxes(ClassProductList productList) {
        String[] products = new String[] {"Tomato", "Onion", "Potato"};
        for (int i = 0; i < products.length; i++) {
            jComboBox.addItem(products[i]);
            //if (product.getProductType() == 0)
            //jComboBox.addItem(product.getProductName());
        }
        jComboBox.setBounds(100, 400,200,20);
        this.produceProductFrame.add(jComboBox);
    }
}
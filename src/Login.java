import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login extends JFrame implements ActionListener {

    private final static int START_X = 50;
    private final static int DIFF_X = 100;
    private final static int START_Y = 150;
    private final static int DIFF_Y = 50;
    private final static int LABEL_WIDTH = 100;
    private final static int TEXT_WIDTH = 150;
    private final static int CHECKBOX_WIDTH = 150;
    private final static int BUTTON_WIDTH = 150;
    private final static int HEIGHT = 30;
    private final static int BUYER = 0;
    private final static int SELLER = 1;

    private final static String BUYER_PATH = "resources/BuyerInfo.txt";
    private final static String SELLER_PATH = "resources/SellerInfo.txt";

    private final Container layoutContainer = getContentPane();

    private final JLabel usernameLabel = new JLabel("Username");
    private final JLabel passwordLabel = new JLabel("Password");

    private final JTextField usernameTextField = new JTextField();
    private final JPasswordField passwordTextField = new JPasswordField();

    private final JCheckBox revealPasswordCheckBox = new JCheckBox("Reveal Password");
    private final JButton loginButton = new JButton("Login");
    public UserInfoItem userInfo;
    public boolean isLogin = false;

    Login() {

        layoutContainer.setLayout(null);

        usernameLabel.setBounds(START_X, START_Y, LABEL_WIDTH, HEIGHT);
        passwordLabel.setBounds(START_X, (START_Y + DIFF_Y), LABEL_WIDTH, HEIGHT);

        usernameTextField.setBounds((START_X + DIFF_X),START_Y, TEXT_WIDTH, HEIGHT);
        passwordTextField.setBounds((START_X + DIFF_X), (START_Y + DIFF_Y), TEXT_WIDTH, HEIGHT);

        revealPasswordCheckBox.setBounds((START_X + DIFF_X), (START_Y + DIFF_Y * 2), CHECKBOX_WIDTH, HEIGHT);
        loginButton.setBounds(START_X, (START_Y + DIFF_Y * 3), BUTTON_WIDTH, HEIGHT);

        layoutContainer.add(usernameLabel);
        layoutContainer.add(passwordLabel);

        layoutContainer.add(usernameTextField);
        layoutContainer.add(passwordTextField);

        layoutContainer.add(revealPasswordCheckBox);
        layoutContainer.add(loginButton);

        revealPasswordCheckBox.addActionListener(this);
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == revealPasswordCheckBox) {
            if (revealPasswordCheckBox.isSelected()) {
                passwordTextField.setEchoChar((char) 0);
            }
            else {
                passwordTextField.setEchoChar('\u25CF');
            }
        }

        if (actionEvent.getSource() == loginButton) {

            String usernameText;
            String passwordText;
            usernameText = usernameTextField.getText();
            passwordText = String.valueOf(passwordTextField.getPassword());

            File buyerFile = new File(BUYER_PATH);
            File sellerFile = new File(SELLER_PATH);

            try {
                if (userExists(usernameText, passwordText, buyerFile, BUYER)) {
                    JOptionPane.showMessageDialog(this, "Buyer Exists");
                } else if (userExists(usernameText, passwordText, sellerFile, SELLER)) {
                    JOptionPane.showMessageDialog(this, "Seller Exists");
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Password or Username");
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean userExists(String userName, String password, File fileName, int userType) throws FileNotFoundException {
        String userPasswordLine = userName + ":"  + password;
        try {
            Scanner reader = new Scanner(fileName);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (userPasswordLine.equals(line)) {
                    this.userInfo = new UserInfoItem(userType, userName);
                    this.isLogin = true;
                    return true;
                }
            }
            reader.close();
            return false;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            isLogin = false;
            return false;
        }
    }
}

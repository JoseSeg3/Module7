package assisnments;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton submitButton;
    private JButton clearButton;

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 3, 12, 12));

        
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");

        
        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        
        submitButton = new JButton("Submit");
        clearButton = new JButton("Clear");

        
        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(submitButton);
        add(clearButton);

        
        submitButton.addActionListener(new SubmitButtonListener());
        clearButton.addActionListener(new ClearButtonListener());

        setVisible(true);
    }

    
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Registration Successful!\nName: " + name + "\nEmail: " + email);
            }
        }
    }

    
    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            nameField.setText("");
            emailField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
        }
    }

    public static void main(String[] args) {
    	new RegistrationForm();

    }
}


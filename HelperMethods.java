import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperMethods {

    public static void addLabelTextField(JPanel panel, GridBagConstraints gbc, String label, int x, int y) {
        gbc.gridx = x * 2;
        gbc.gridy = y;
        JLabel tempLabel = new JLabel(label + ":");
        tempLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(tempLabel, gbc);

        gbc.gridx = x * 2 + 1;
        panel.add(new JTextField(15), gbc);
    }

    public static void addRadioGroup(JPanel panel, GridBagConstraints gbc, String label, String[] options, int x, int y) {
        gbc.gridx = x * 2;
        gbc.gridy = y;
        JLabel tempLabel = new JLabel(label + ":");
        tempLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(tempLabel, gbc);

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ButtonGroup group = new ButtonGroup();
        for (String option : options) {
            JRadioButton radio = new JRadioButton(option);
            group.add(radio);
            radioPanel.add(radio);
        }
        radioPanel.setOpaque(false);

        gbc.gridx = x * 2 + 1;
        panel.add(radioPanel, gbc);
    }

    public static void addNextBtn(JPanel panel, GridBagConstraints gbc, int x, int y, CardLayout layout, JPanel container, String nextCard, String prevCard) {
        JButton nextButton = new JButton("Next");

        nextButton.addActionListener(e -> layout.show(container, nextCard));

        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(nextButton, gbc);
    }

    public static void addBackNextBtn(JPanel panel, GridBagConstraints gbc, int x, int y, CardLayout layout, JPanel container, String nextCard, String prevCard) {
        JButton nextButton = new JButton("Next");
        JButton backButton = new JButton("Back");

        nextButton.addActionListener(e -> layout.show(container, nextCard));
        backButton.addActionListener(e -> layout.show(container, prevCard));

        JPanel btnCont = new JPanel(new FlowLayout());
        btnCont.setOpaque(false);
        btnCont.add(backButton);
        btnCont.add(nextButton);

        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(btnCont, gbc);
    }
}

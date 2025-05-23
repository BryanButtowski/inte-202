import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperMethods {

    public static JFrame createBaseWindow(String title, JPanel contentPanel) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel bgPanel = new JPanel(new BorderLayout()) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon mainBG = new ImageIcon("bg.png");
                g.drawImage(mainBG.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };


        JPanel header = createWindowHeader(frame);
        bgPanel.add(header, BorderLayout.NORTH);


        contentPanel.setOpaque(false);
        bgPanel.add(contentPanel, BorderLayout.CENTER);


        frame.setContentPane(bgPanel);
        return frame;
    }


    public static JPanel createWindowHeader(JFrame frame) {
        JPanel hdPanel = new JPanel();
        hdPanel.setBackground(new Color(180, 227, 192));
        hdPanel.setLayout(new BoxLayout(hdPanel, BoxLayout.Y_AXIS));

        JPanel headerRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 3));
        headerRow.setOpaque(false);

        ImageIcon logo = new ImageIcon("logo.png");
        Image image = logo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(image));

        JLabel hdLabel = new JLabel("I-70 MEDICAL CLINIC REGISTRATION FORM");
        hdLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerRow.add(logoLabel);
        headerRow.add(hdLabel);

        JLabel shdLabel = new JLabel("Please print and fill-out completely");
        shdLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        shdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        JLabel dateLabel = new JLabel("Date: " + formatter.format(LocalDate.now()));
        dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
        dateLabel.setBorder(new EmptyBorder(5, 10, 5, 10));
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        hdPanel.add(headerRow);
        hdPanel.add(shdLabel);
        hdPanel.add(dateLabel);

        return hdPanel;
    }

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

    public static void addNextBtn(JPanel panel, GridBagConstraints gbc, int x, int y) {
        JButton nextButton = new JButton("Next");
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(nextButton, gbc);
    }

    public static void addBackNextBtn(JPanel panel, GridBagConstraints gbc, int x, int y) {
        JButton nextButton = new JButton("Next");
        JButton backButton = new JButton("Back");
        JPanel btnCont = new JPanel(new FlowLayout());
        btnCont.setOpaque(false);

        btnCont.add(backButton);
        btnCont.add(nextButton);

        gbc.gridx = x;
        gbc.gridy = y;

        panel.add(btnCont, gbc);
    }

}

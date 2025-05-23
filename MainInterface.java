import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainInterface {
    JFrame mainFrame;
    JPanel bgPanel, hdPanel, panelPatientInfo, panelResponsibleParty;
    JPanel formPanel;
    JLabel titleLabel;

    public MainInterface() {
        mainFrame = new JFrame("I-70 Medical Clinic");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1000, 700);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new BorderLayout());

        bgPanel = new JPanel(new BorderLayout()) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon mainBG = new ImageIcon("bg.png");
                g.drawImage(mainBG.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        hdPanel = new JPanel();
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

        formPanel = new JPanel(new CardLayout());
        formPanel.setOpaque(false);

        bgPanel.add(hdPanel, BorderLayout.NORTH);
        bgPanel.add(formPanel, BorderLayout.CENTER);
        mainFrame.setContentPane(bgPanel);

        PatientInfo();
        ResponsibleParty();
        ((CardLayout) formPanel.getLayout()).show(formPanel, "patientInfo");

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainInterface::new);
    }

    public void PatientInfo() {
        panelPatientInfo = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 10, 20, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        titleLabel = new JLabel("Patient Information");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        panelPatientInfo.add(titleLabel, gbc);
        gbc.gridwidth = 1;

        HelperMethods.addLabelTextField(panelPatientInfo, gbc, "Primary Care Physician", 0, 1);
        HelperMethods.addLabelTextField(panelPatientInfo, gbc, "Last Name", 1, 1);
        HelperMethods.addLabelTextField(panelPatientInfo, gbc, "First Name", 2, 1);
        HelperMethods.addLabelTextField(panelPatientInfo, gbc, "Middle Name", 3, 1);
        HelperMethods.addRadioGroup(panelPatientInfo, gbc, "Honorifics", new String[]{"Mr.", "Ms."}, 0, 2);
        HelperMethods.addRadioGroup(panelPatientInfo, gbc, "Gender", new String[]{"Male", "Female"}, 1, 2);

        HelperMethods.addNextBtn(panelPatientInfo, gbc, 7, 8, (CardLayout) formPanel.getLayout(), formPanel, "responsibleParty", "patientInfo");

        panelPatientInfo.setOpaque(false);
        formPanel.add(panelPatientInfo, "patientInfo");
    }

    public void ResponsibleParty() {
        panelResponsibleParty = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 10, 20, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        titleLabel = new JLabel("Responsible Party");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        panelResponsibleParty.add(titleLabel, gbc);
        gbc.gridwidth = 1;

        HelperMethods.addLabelTextField(panelResponsibleParty, gbc, "Person Responsible for Bill", 0, 1);
        HelperMethods.addLabelTextField(panelResponsibleParty, gbc, "Address (If Different)", 0, 2);
        HelperMethods.addLabelTextField(panelResponsibleParty, gbc, "Phone Number", 0, 3);
        HelperMethods.addLabelTextField(panelResponsibleParty, gbc, "Occupation", 0, 4);
        HelperMethods.addLabelTextField(panelResponsibleParty, gbc, "Employer", 1, 1);
        HelperMethods.addLabelTextField(panelResponsibleParty, gbc, "Employer Address", 1, 2);
        HelperMethods.addLabelTextField(panelResponsibleParty, gbc, "Employer Phone Number", 1, 3);

        panelResponsibleParty.setOpaque(false);
        formPanel.add(panelResponsibleParty, "responsibleParty");
        HelperMethods.addBackNextBtn(panelResponsibleParty, gbc, 7, 8, (CardLayout) formPanel.getLayout(), formPanel, "patientInfo", "patientInfo");
    }
}

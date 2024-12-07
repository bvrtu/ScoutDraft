package ScoutDraft;

import javax.swing.*;
import java.awt.*;

public class Gui {
    private JFrame mainFrame;
    private JButton authorsButton;
    private JButton playButton;

    public Gui() {
        initializeMainGUI();
    }

    private void initializeMainGUI() {
        mainFrame = new JFrame("Scout Draft");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setSize(screenSize);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);

        JLabel titleLabel = new JLabel("Scout Draft");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        authorsButton = new JButton("Authors");
        playButton = new JButton("Play");

        Dimension buttonSize = new Dimension(150, 50);
        authorsButton.setMaximumSize(buttonSize);
        playButton.setMaximumSize(buttonSize);

        authorsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(50));
        mainPanel.add(playButton);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(authorsButton);

        JPanel container = new JPanel(new GridBagLayout());
        container.add(mainPanel);

        mainFrame.add(container);

        authorsButton.addActionListener(e -> openAuthorsWindow());

        playButton.addActionListener(e -> openPlayWindow());
    }

    private void openAuthorsWindow() {
        JFrame authorsFrame = new JFrame("Authors");
        authorsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        authorsFrame.setSize(screenSize);

        JPanel authorsPanel = new JPanel();
        authorsPanel.setLayout(new BoxLayout(authorsPanel, BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel("Hasan Efe ÜNAL");
        JLabel label2 = new JLabel("Bartu ERDEM");

        label1.setFont(new Font("Arial", Font.PLAIN, 24));
        label2.setFont(new Font("Arial", Font.PLAIN, 24));
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);

        authorsPanel.add(Box.createVerticalStrut(10));
        authorsPanel.add(label1);
        authorsPanel.add(Box.createVerticalStrut(20));
        authorsPanel.add(label2);

        JPanel container = new JPanel(new GridBagLayout());
        container.add(authorsPanel);

        authorsFrame.add(container);

        authorsFrame.setVisible(true);
    }

    private void openPlayWindow() {
        JFrame playFrame = new JFrame("Play Options");
        playFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        playFrame.setSize(screenSize);

        JPanel playPanel = new JPanel();
        playPanel.setLayout(new GridLayout(1, 3, 20, 0));

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");

        button1.setPreferredSize(new Dimension(150, 50));
        button2.setPreferredSize(new Dimension(150, 50));
        button3.setPreferredSize(new Dimension(150, 50));

        playPanel.add(button1);
        playPanel.add(button2);
        playPanel.add(button3);

        JPanel container = new JPanel(new GridBagLayout());
        container.setBackground(Color.WHITE);
        container.add(playPanel);

        playFrame.add(container);
        playFrame.setVisible(true);
    }
    
    public void show() {
        mainFrame.setVisible(true);
    }
}
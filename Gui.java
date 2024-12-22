import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Gui {
    private JFrame mainFrame;
    private JButton authorsButton;
    private JButton playButton;

    private JFrame playFrame = new JFrame("Play Options");
    private JFrame formationFrame;

    private JLabel formationImageLabel; // Label to show formation pictures

    private JButton[] formationButtons; // Array to hold the buttons on the photo
    private int numOfBoxes = 11;

    private Point[] boxCoordinates; // Coordinates of the player buttons in GUI

    private String lastSelectedFormation = "";
    private Formation currentFormation = new Formation();

    // Boolean variables of game modes to make some window closing activities and OK button boolean variable for the same thing.
    private boolean isRandom = false;
    private boolean isBuildTeam = false;
    private boolean isOnlySearch = true;
    private boolean isOkClicked = false;

    // Global variable of selected box index.
    private int selectedBoxIndex = -1;

    // It keeps the player positions to connect GUI button indexes with the graph.
    private ArrayList<Integer> valuesList;

    // Boolean variable of the player can play in that position. It is for Build Your Team mode.
    private boolean isCanPlay;

    // Link presentation labels
    private Map<String, JLabel> linkLabels = new HashMap<>();

    public Gui() {
        initializeMainGUI();
    }

    // Initializes the first window of the GUI, with two options.
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

        mainPanel.add(Box.createVerticalStrut(10)); // Creates an invisible, fixed-height component.
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(50));
        mainPanel.add(playButton);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(authorsButton);

        JPanel container = new JPanel(new GridBagLayout());
        container.add(mainPanel);

        mainFrame.add(container);

        authorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                openAuthorsWindow();
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                openPlayWindow();
            }
        });
    }

    // Authors window. It shows the authors.
    private void openAuthorsWindow() {
        JFrame authorsFrame = new JFrame("Authors");

        JButton backButton = new JButton("Back to Main Screen");
        backButton.setBounds(50, 50, 200, 30);
        authorsFrame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorsFrame.dispose();
                mainFrame.setVisible(true);
            }
        });

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

    // Play Options window. It shows the 3 game modes selection window.
    private void openPlayWindow() {

        JButton backButton = new JButton("Back to Main Screen");
        backButton.setBounds(50, 50, 200, 30);
        playFrame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playFrame.dispose(); // Yeni pencereyi gizle
                mainFrame.setVisible(true); // İlk pencereyi göster
            }
        });

        playFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        playFrame.setSize(screenWidth / 2, screenHeight / 2);
        playFrame.setLocation(screenWidth / 4, screenHeight / 4);

        JPanel playPanel = new JPanel();
        playPanel.setLayout(new GridBagLayout());
        playPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margins
        gbc.gridx = 0; // First column
        gbc.gridy = GridBagConstraints.RELATIVE; // Auto-increments of rows

        JButton button1 = new JButton("Build Your Team");
        JLabel label1 = new JLabel("Create your own team by selecting players for each position with position restrictions.");
        button1.setPreferredSize(new Dimension(150, 50));

        JButton button2 = new JButton("Random Draft");
        JLabel label2 = new JLabel("Generate a random team and try your luck without position restrictions.");
        button2.setPreferredSize(new Dimension(150, 50));

        JButton button3 = new JButton("Search Player");
        JLabel label3 = new JLabel("Search players for just scouting.");
        button3.setPreferredSize(new Dimension(150, 50));

        playPanel.add(button1, gbc);
        playPanel.add(label1, gbc);
        playPanel.add(button2, gbc);
        playPanel.add(label2, gbc);
        playPanel.add(button3, gbc);
        playPanel.add(label3, gbc);

        // Build Your Team
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playFrame.dispose();
                openFormationSelectionWindow();
            }
        });

        // Random Draft
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playFrame.dispose();
                showRandomFormations();
            }
        });

        // Search Player
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playFrame.dispose();
                openSearchWindow();
            }
        });

        playFrame.add(playPanel);
        playFrame.setVisible(true);
    }

    // Opens Build Your Team Mode window. You can select the formation and build your team.
    private void openFormationSelectionWindow() {
        isBuildTeam = true;
        isRandom = false;
        isOnlySearch = false;


        formationFrame = new JFrame("Build Your Team");
        formationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton backButton = new JButton("Back to Play Options");
        backButton.setBounds(50, 50, 200, 30);
        formationFrame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formationFrame.dispose();
                playFrame.setVisible(true);
                mainFrame.dispose();
                resetState();  // Reset the formation and state
            }
        });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        formationFrame.setSize(screenSize);

        JPanel formationPanel = new JPanel();
        formationPanel.setLayout(new BoxLayout(formationPanel, BoxLayout.Y_AXIS));

        String[] formations = {"3-4-3","3-4-1-2","3-4-2-1","3-5-2","4-1-2-1-2","4-1-4-1","4-2-2-2","4-2-3-1",
                "4-3-1-2","4-3-2-1","4-3-3","4-4-1-1","4-4-2","4-5-1","5-2-2-1","5-2-1-2","5-3-2"};

        // Formation selection with combobox
        JComboBox<String> formationComboBox = new JComboBox<>(formations);
        formationComboBox.setFont(new Font("Arial", Font.PLAIN, 24));
        formationComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton selectButton = new JButton("Select Formation");
        selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        formationImageLabel = new JLabel();
        formationImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton okButton = new JButton("OK");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.setEnabled(false);

        // When you clicked on this button, the photo of the formation pops up.
        selectButton.addActionListener(e -> {
            String selectedFormation = (String) formationComboBox.getSelectedItem();
            updateFormationImage(selectedFormation);
            okButton.setEnabled(true);
        });

        // When you clicked on this button, it locks the "Select Formation", "OK" and "Back to Play Options" buttons.
        // And after that, the buttons of the players and link presentations (labels) pops up. And you can start the building your team.
        okButton.addActionListener(e -> {
            selectButton.setEnabled(false); // Select Formation butonunu devre dışı bırak
            formationComboBox.setEnabled(false); // ComboBox'ı devre dışı bırak
            okButton.setEnabled(false); // OK butonunu da devre dışı bırak
            JOptionPane.showMessageDialog(formationFrame, "Formation selection confirmed!");
            isOkClicked = true;
            if (isOkClicked) backButton.setEnabled(false);
            lastSelectedFormation = (String) formationComboBox.getSelectedItem();
            currentFormation.setFormation_name(lastSelectedFormation);
            currentFormation.create_graph();
            addClickableButtons();
            addFormationLabels(lastSelectedFormation, formationImageLabel);
        });

        // Add patterns and button to the panel
        formationPanel.add(Box.createVerticalStrut(100));
        formationPanel.add(formationComboBox);
        formationPanel.add(Box.createVerticalStrut(20));
        formationPanel.add(selectButton);
        formationPanel.add(Box.createVerticalStrut(10));
        formationPanel.add(okButton);
        formationPanel.add(Box.createVerticalStrut(20));
        formationPanel.add(formationImageLabel); // Adding formation photo

        JPanel container = new JPanel(new GridBagLayout());
        container.add(formationPanel);

        formationFrame.add(container);
        formationFrame.setVisible(true);
    }

    // Creating and adding the labels on the formation photo
    private void addFormationLabels(String selectedFormation, JLabel formationImageLabel) {
        Point[] coordinates = getFormationBoxCoordinates(selectedFormation);

        // For loops for links between the player. First for loops for players and the second one is the identify the links.
        for (int main = 0; main < 10; main++) {
            for (int j : currentFormation.the_graph.neighbours(main)) {
                int graphIndex1 = main;
                int graphIndex2 = j;

                int uiIndex1 = currentFormation.getGraphToUI().getOrDefault(graphIndex1, -1);
                int uiIndex2 = currentFormation.getGraphToUI().getOrDefault(graphIndex2, -1);

                if (uiIndex1 == -1 || uiIndex2 == -1) {
                    continue;
                }

                String key = generateKey(graphIndex1, graphIndex2);

                if (!linkLabels.containsKey(key)) {
                    int rank = checkLink(graphIndex1, graphIndex2);

                    JLabel label = new JLabel(String.valueOf(rank), SwingConstants.CENTER);
                    label.setOpaque(true);

                    int x = (coordinates[uiIndex1].x + coordinates[uiIndex2].x) / 2;
                    int y = (coordinates[uiIndex1].y + coordinates[uiIndex2].y) / 2;
                    label.setBounds(x + 20, y + 60, 20, 20);

                    switch (rank) {
                        case 0 -> label.setBackground(Color.RED);
                        case 1 -> label.setBackground(Color.YELLOW);
                        case 2 -> label.setBackground(Color.GREEN);
                    }

                    label.setForeground(Color.WHITE);
                    formationImageLabel.add(label);

                    linkLabels.put(key, label);

                    // For debugging
                    System.out.println("Added label for key: " + key);
                }
            }
        }

        formationImageLabel.repaint();
    }

    // Updates the links after every player addition on the formation.
    private void updateLinkRank(int index) {
        ArrayList<Formation.Link> links = currentFormation.checkLinks(index);

        for (Formation.Link link : links) {
            int graphIndex1 = link.vertex1;
            int graphIndex2 = link.vertex2;

            String key = generateKey(graphIndex1, graphIndex2);

            JLabel label = linkLabels.get(key);

            if (label != null) {
                switch (link.rank) {
                    case 0 -> label.setBackground(Color.RED);
                    case 1, 2 -> label.setBackground(Color.YELLOW);
                    case 3 -> label.setBackground(Color.GREEN);
                }
                label.setText(String.valueOf(link.rank));
                label.repaint();
                System.out.println("Updated label for key: " + key + " to rank: " + link.rank);
            } else {
                System.out.println("No label found for key: " + key);
            }
        }
    }

    // Generating the keys of links
    private String generateKey(int graphIndex1, int graphIndex2) {
        if (graphIndex1 > graphIndex2) {
            int temp = graphIndex1;
            graphIndex1 = graphIndex2;
            graphIndex2 = temp;
        }
        return graphIndex1 + "-" + graphIndex2;
    }

    // Method that adds the image of the selected pattern to the current window.
    private void updateFormationImage(String selectedFormation) {
        String imagePath = "images/" + selectedFormation + ".png"; // Picture name compatible with the name formation

        try {
            ImageIcon formationImage = new ImageIcon(ImageIO.read(new File(imagePath)));
            formationImageLabel.setIcon(formationImage);

            boxCoordinates = getFormationBoxCoordinates(selectedFormation);
            clearPreviousButtons();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Image not found for the selected formation.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Opens the window of Random Draft mode.
    private void showRandomFormations() {
        isRandom = true;
        isBuildTeam = false;
        isOnlySearch = false;


        formationFrame = new JFrame("Random Draft");
        formationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton backButton = new JButton("Back to Play Options");
        backButton.setBounds(50, 50, 200, 30);
        formationFrame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formationFrame.dispose();
                playFrame.setVisible(true);
                mainFrame.dispose();
                resetState();  // Reset the formation and state
            }
        });

        String[] formations = {"3-4-3", "3-4-1-2", "3-4-2-1", "3-5-2", "4-1-2-1-2", "4-1-4-1", "4-2-2-2", "4-2-3-1",
                "4-3-1-2", "4-3-2-1", "4-3-3", "4-4-1-1", "4-4-2", "4-5-1", "5-2-2-1", "5-2-1-2", "5-3-2"};

        ArrayList<String> formationList = new ArrayList<>();
        Collections.addAll(formationList, formations);

        // Shuffling all of the formations and creates a list of five of them to show the user.
        Collections.shuffle(formationList);
        String[] randomFormations = formationList.subList(0, 5).toArray(new String[0]);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        formationFrame.setSize(screenSize);

        JPanel formationPanel = new JPanel();
        formationPanel.setLayout(new BoxLayout(formationPanel, BoxLayout.Y_AXIS));

        JLabel instructionLabel = new JLabel("Please select one of the following formations:");
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JComboBox<String> formationComboBox = new JComboBox<>(randomFormations);
        formationComboBox.setFont(new Font("Arial", Font.PLAIN, 24));
        formationComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton selectButton = new JButton("Select Formation");
        selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton okButton = new JButton("OK");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.setEnabled(false); // Başlangıçta devre dışı

        formationImageLabel = new JLabel();
        formationImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        selectButton.addActionListener(e -> {
            String selectedFormation = (String) formationComboBox.getSelectedItem();
            updateFormationImage(selectedFormation);
            okButton.setEnabled(true);
        });

        okButton.addActionListener(e -> {
            selectButton.setEnabled(false);
            formationComboBox.setEnabled(false);
            okButton.setEnabled(false);
            JOptionPane.showMessageDialog(formationFrame, "Formation selection confirmed!");
            isOkClicked = true;
            if (isOkClicked) backButton.setEnabled(false);
            addClickableButtons();
            lastSelectedFormation = (String) formationComboBox.getSelectedItem();
            currentFormation.setFormation_name(lastSelectedFormation);
            currentFormation.create_graph();
            addFormationLabels(lastSelectedFormation, formationImageLabel);
        });

        formationPanel.add(Box.createVerticalStrut(100));
        formationPanel.add(instructionLabel);
        formationPanel.add(Box.createVerticalStrut(20));
        formationPanel.add(formationComboBox);
        formationPanel.add(Box.createVerticalStrut(20));
        formationPanel.add(selectButton);
        formationPanel.add(Box.createVerticalStrut(10));
        formationPanel.add(okButton);
        formationPanel.add(Box.createVerticalStrut(20));
        formationPanel.add(formationImageLabel);

        JPanel container = new JPanel(new GridBagLayout());
        container.add(formationPanel);

        formationFrame.add(container);
        formationFrame.setVisible(true);
    }

    // Player search window for Search Player mode but this function's some parts are used in Random Draft mode.
    private void openSearchWindow() {
        JFrame searchFrame = new JFrame("Search Player");
        searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        searchFrame.setSize(screenSize);
        searchFrame.setLayout(new BorderLayout());

        // Top panel for parameters of the search
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(6, 2, 10, 10));

        topPanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        topPanel.add(nameField);

        topPanel.add(new JLabel("Nation:"));
        JComboBox<String> nationDropdown = new JComboBox<>(new String[]{
                "", "AFG", "ALB", "ANG", "ANT", "ARG", "ARM", "ARO", "AUT", "AZE", "BEL", "BEN",
                "BIH", "BLR", "BLZ", "BOL", "BUL", "CAN", "CHA", "CHN", "CIV", "COL", "COM", "CPV",
                "CRO", "CUB", "CZE", "DEN", "DOM", "DZA", "ECU", "EGY", "ENG", "EQG", "EST", "ETH",
                "FIJ", "FIN", "FRO", "GAB", "GAM", "GEO", "GER", "GIB", "GNB", "GRE", "GUI", "GUM",
                "GUY", "HAI", "HKG", "HON", "HUN", "IDN", "IRL", "IRN", "IRQ", "ISL", "ISR", "ITA",
                "JAM", "JOR", "JPN", "KEN", "KOS", "KSA", "KRG", "KOR", "KOS", "KSA", "KIR", "KAZ",
                "LBR", "LBY", "LCA", "LVA", "MAC", "MAR", "MDA", "MDV", "MEX", "MLI", "MLT", "MNE",
                "MOZ", "NAM", "NED", "NGA", "NIR", "NLD", "NOR", "NZL", "OMA", "PAN", "PER", "PHI",
                "PNG", "POL", "POR", "PRK", "PUR", "QAT", "ROM", "ROU", "RWA", "SAM", "SEN", "SGP",
                "SLE", "SLV", "SMR", "SOM", "SRB", "SUR", "SVK", "SVN", "SWE", "SYN", "SYR", "TAN",
                "TCH", "THA", "TGO", "TUN", "TUR", "UKR", "URU", "USA", "VAN", "VIE", "VEN", "ZAM",
                "ZIM"
        });

        nationDropdown.setSelectedIndex(0);
        topPanel.add(nationDropdown);

        topPanel.add(new JLabel("Age:"));
        JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<Integer> age = new JComboBox<>(generateRange(15, 100));
        age.insertItemAt(null, 0);
        age.setSelectedIndex(0);
        agePanel.add(new JLabel());
        agePanel.add(age);
        topPanel.add(agePanel);

        topPanel.add(new JLabel("Current Ability:"));
        JComboBox<Integer> abilityDropdown = new JComboBox<>(generateRange(0, 200));
        abilityDropdown.insertItemAt(null, 0);
        abilityDropdown.setSelectedIndex(0);
        topPanel.add(abilityDropdown);

        topPanel.add(new JLabel("Division:"));
        JComboBox<String> divisionDropdown = new JComboBox<>(new String[]{
                "", "-", "3. Liga", "Austrian Premier Division", "Argentine Premier Division", "Brazilian National First Division",
                "Brazilian National Second Division", "Bundesliga", "Bundesliga 2", "Canadian Premier League", "Chinese Super League",
                "Cinch Premiership", "Colombian First Division", "Croatian First League", "Czech First Division", "Egyptian Premier League",
                "English Premier Division", "Eredivisie", "French Ligue 1", "Greek Super League 1", "Hana 1Q K LEAGUE 1", "Israeli Premier League", "Italian Serie A",
                "Italian Serie B", "Italian Serie C/A", "Italian Serie C/B", "Italian Serie C/C", "J1 League", "J2 League",
                "J3 League", "JD Cymru Premier", "Japanese J-League", "Kazakhstan Premier League", "K League 1", "Ligue 1 Uber Eats",
                "Ligue 2 BKT", "Mexican First Division", "Major League Soccer", "Norwegian Premier Division", "Persian Gulf Premier League",
                "PKO Bank Polski Ekstraklasa", "Portuguese Premier League", "Qatar League", "Qatar Stars League", "Russian Premier League",
                "Saudi Professional League", "Serbian SuperLeague", "Sky Bet Championship", "Sky Bet League One", "Sky Bet League Two",
                "Spanish First Division", "Spanish Second Division", "Swedish Premier Division", "Swiss Super League", "Turkish 1. League",
                "Turkish 2. League Red Group", "Turkish 2. League White Group", "Turkish 3. League Group 1", "Turkish 3. League Group 2",
                "Turkish 3. League Group 3", "Turkish 3. League Group 4", "Turkish Super League", "UAE Professional League", "Ukrainian Premier League",
                "Uruguayan First Division", "Vanarama National League", "Vanarama National League North", "Vanarama National League South",});

        divisionDropdown.setSelectedIndex(0);
        topPanel.add(divisionDropdown);

        topPanel.add(new JLabel("Position:"));
        JComboBox<String> positionsDropdown = new JComboBox<>(new String[]{"", "GK", "CB", "RB", "LB", "RWB", "LWB", "CDM", "CM", "CAM", "RM", "LM", "RW", "LW", "ST"});
        positionsDropdown.setSelectedIndex(0);
        topPanel.add(positionsDropdown);

        // Back buttons for Random Draft and Search Player modes.
        JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton;
        if (isOnlySearch && (isRandom && isBuildTeam)) {
            backButton = new JButton("Back to Formation Window");
        } else {
            backButton = new JButton("Back to Play Options");
        }
        topRightPanel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFrame.dispose();
                playFrame.setVisible(true);
                mainFrame.dispose();
                resetState();  // Reset the formation and state
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 1, 10, 10)); // 2 satır, 1 sütun, aralık 10px
        JButton searchButton = new JButton("Search");
        buttonPanel.add(searchButton);

        // Query Results panel for query results.
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Query Results"));

        final Player[] selectedPlayer = new Player[1];

        // It shows the players on query results panel after clicked on that.
        searchButton.addActionListener(e -> {
            String name = nameField.getText();
            String nation = (String) nationDropdown.getSelectedItem();
            Integer ageValue = (Integer) age.getSelectedItem();
            Integer ability = (Integer) abilityDropdown.getSelectedItem();
            String division = (String) divisionDropdown.getSelectedItem();
            String position = (String) positionsDropdown.getSelectedItem();

            // Get results from the Query function from DatabaseAction class
            ArrayList<Player> results = Client.asktoDatabase(name, nation, ageValue, ability, division, position);

            if (results.isEmpty()) {
                JOptionPane.showMessageDialog(searchFrame, "No players found!");
                return;
            }

            // Showing the results with JTable
            String[] columnNames = {"ID", "Name", "Age", "Nation", "Club", "Current Ability", "League", "Positions"};
            Object[][] data = new Object[results.size()][8];
            for (int i = 0; i < results.size(); i++) {
                Player player = results.get(i);
                data[i][0] = player.getId();
                data[i][1] = player.getName();
                data[i][2] = player.getAge();
                data[i][3] = player.getNation();
                data[i][4] = player.getTeam_name();
                data[i][5] = player.getOverall();
                data[i][6] = player.getLeague();
                data[i][7] = String.join(", ", player.getPositions());
            }

            JTable resultTable = new JTable(data, columnNames);
            resultTable.setDefaultEditor(Object.class, null);
            JScrollPane scrollPane = new JScrollPane(resultTable);
            bottomPanel.removeAll();
            bottomPanel.add(scrollPane, BorderLayout.CENTER);
            bottomPanel.revalidate();
            bottomPanel.repaint();

            // Add sort property by adding TableRowSorter
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(resultTable.getModel());

            // Numeric sorting for ID and Overall columns
            sorter.setComparator(0, Comparator.comparingInt(o -> Integer.parseInt(o.toString())));
            sorter.setComparator(5, Comparator.comparingInt(o -> Integer.parseInt(o.toString())));

            resultTable.setRowSorter(sorter);

            // Save the selected player by adding a click feature to the table
            resultTable.getSelectionModel().addListSelectionListener(e1 -> {
                int selectedRow = resultTable.getSelectedRow();
                if (selectedRow != -1) {
                    selectedPlayer[0] = results.get(selectedRow);
                }
            });
        });

        JPanel combinedTopPanel = new JPanel(new BorderLayout());
        combinedTopPanel.add(topPanel, BorderLayout.CENTER);
        combinedTopPanel.add(buttonPanel, BorderLayout.SOUTH);
        combinedTopPanel.add(topRightPanel, BorderLayout.NORTH);

        searchFrame.add(combinedTopPanel, BorderLayout.NORTH);
        searchFrame.add(bottomPanel, BorderLayout.CENTER);

        searchFrame.setVisible(true);
    }

    // Build Your Team mode window
    private void openSearchWindow2() {
        isOnlySearch = false;

        JFrame searchFrame = new JFrame("Search Player");
        searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // If the user clicks on "X"
        searchFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                formationFrame.setVisible(true);
                searchFrame.dispose();
            }
        });

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        searchFrame.setSize(screenSize);
        searchFrame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(6, 2, 10, 10));

        topPanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        topPanel.add(nameField);

        topPanel.add(new JLabel("Nation:"));
        JComboBox<String> nationDropdown = new JComboBox<>(new String[]{
                "", "AFG", "ALB", "ANG", "ANT", "ARG", "ARM", "ARO", "AUT", "AZE", "BEL", "BEN",
                "BIH", "BLR", "BLZ", "BOL", "BUL", "CAN", "CHA", "CHN", "CIV", "COL", "COM", "CPV",
                "CRO", "CUB", "CZE", "DEN", "DOM", "DZA", "ECU", "EGY", "ENG", "EQG", "EST", "ETH",
                "FIJ", "FIN", "FRO", "GAB", "GAM", "GEO", "GER", "GIB", "GNB", "GRE", "GUI", "GUM",
                "GUY", "HAI", "HKG", "HON", "HUN", "IDN", "IRL", "IRN", "IRQ", "ISL", "ISR", "ITA",
                "JAM", "JOR", "JPN", "KEN", "KOS", "KSA", "KRG", "KOR", "KOS", "KSA", "KIR", "KAZ",
                "LBR", "LBY", "LCA", "LVA", "MAC", "MAR", "MDA", "MDV", "MEX", "MLI", "MLT", "MNE",
                "MOZ", "NAM", "NED", "NGA", "NIR", "NLD", "NOR", "NZL", "OMA", "PAN", "PER", "PHI",
                "PNG", "POL", "POR", "PRK", "PUR", "QAT", "ROM", "ROU", "RWA", "SAM", "SEN", "SGP",
                "SLE", "SLV", "SMR", "SOM", "SRB", "SUR", "SVK", "SVN", "SWE", "SYN", "SYR", "TAN",
                "TCH", "THA", "TGO", "TUN", "TUR", "UKR", "URU", "USA", "VAN", "VIE", "VEN", "ZAM",
                "ZIM"
        });

        nationDropdown.setSelectedIndex(0);
        topPanel.add(nationDropdown);

        topPanel.add(new JLabel("Age:"));
        JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<Integer> age = new JComboBox<>(generateRange(15, 100));
        age.insertItemAt(null, 0);
        age.setSelectedIndex(0);
        agePanel.add(new JLabel());
        agePanel.add(age);
        topPanel.add(agePanel);

        topPanel.add(new JLabel("Current Ability:"));
        JComboBox<Integer> abilityDropdown = new JComboBox<>(generateRange(0, 200));
        abilityDropdown.insertItemAt(null, 0);
        abilityDropdown.setSelectedIndex(0);
        topPanel.add(abilityDropdown);

        topPanel.add(new JLabel("Division:"));
        JComboBox<String> divisionDropdown = new JComboBox<>(new String[]{
                "", "-", "3. Liga", "Austrian Premier Division", "Argentine Premier Division", "Brazilian National First Division",
                "Brazilian National Second Division", "Bundesliga", "Bundesliga 2", "Canadian Premier League", "Chinese Super League",
                "Cinch Premiership", "Colombian First Division", "Croatian First League", "Czech First Division", "Egyptian Premier League",
                "English Premier Division", "Eredivisie", "French Ligue 1", "Greek Super League 1", "Hana 1Q K LEAGUE 1", "Israeli Premier League", "Italian Serie A",
                "Italian Serie B", "Italian Serie C/A", "Italian Serie C/B", "Italian Serie C/C", "J1 League", "J2 League",
                "J3 League", "JD Cymru Premier", "Japanese J-League", "Kazakhstan Premier League", "K League 1", "Ligue 1 Uber Eats",
                "Ligue 2 BKT", "Mexican First Division", "Major League Soccer", "Norwegian Premier Division", "Persian Gulf Premier League",
                "PKO Bank Polski Ekstraklasa", "Portuguese Premier League", "Qatar League", "Qatar Stars League", "Russian Premier League",
                "Saudi Professional League", "Serbian SuperLeague", "Sky Bet Championship", "Sky Bet League One", "Sky Bet League Two",
                "Spanish First Division", "Spanish Second Division", "Swedish Premier Division", "Swiss Super League", "Turkish 1. League",
                "Turkish 2. League Red Group", "Turkish 2. League White Group", "Turkish 3. League Group 1", "Turkish 3. League Group 2",
                "Turkish 3. League Group 3", "Turkish 3. League Group 4", "Turkish Super League", "UAE Professional League", "Ukrainian Premier League",
                "Uruguayan First Division", "Vanarama National League", "Vanarama National League North", "Vanarama National League South",});

        divisionDropdown.setSelectedIndex(0);
        topPanel.add(divisionDropdown);

        topPanel.add(new JLabel("Position:"));
        JComboBox<String> positionsDropdown = new JComboBox<>(new String[]{"", "GK", "CB", "RB", "LB", "RWB", "LWB", "CDM", "CM", "CAM", "RM", "LM", "RW", "LW", "ST"});
        positionsDropdown.setSelectedIndex(0);
        topPanel.add(positionsDropdown);

        JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Back to Formation Window");
        topRightPanel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFrame.dispose();
                playFrame.dispose();
                mainFrame.dispose();
                formationFrame.setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        JButton searchButton = new JButton("Search");
        JButton addButton = new JButton("Add");
        buttonPanel.add(searchButton);
        buttonPanel.add(addButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Query Results"));

        final Player[] selectedPlayer = new Player[1];

        final String[] selectedPlayerPositions = new String[1];

        searchButton.addActionListener(e -> {
            String name = nameField.getText();
            String nation = (String) nationDropdown.getSelectedItem();
            Integer ageValue = (Integer) age.getSelectedItem();
            Integer ability = (Integer) abilityDropdown.getSelectedItem();
            String division = (String) divisionDropdown.getSelectedItem();
            String position = (String) positionsDropdown.getSelectedItem();

            ArrayList<Player> results = DatabaseAction.query(name, nation, ageValue, ability, division, position);

            if (results.isEmpty()) {
                JOptionPane.showMessageDialog(searchFrame, "No players found!");
                return;
            }

            String[] columnNames = {"ID", "Name", "Age", "Nation", "Club", "Current Ability", "League", "Positions"};
            Object[][] data = new Object[results.size()][8];
            for (int i = 0; i < results.size(); i++) {
                Player player = results.get(i);
                data[i][0] = player.getId();
                data[i][1] = player.getName();
                data[i][2] = player.getAge();
                data[i][3] = player.getNation();
                data[i][4] = player.getTeam_name();
                data[i][5] = player.getOverall();
                data[i][6] = player.getLeague();
                data[i][7] = String.join(", ", player.getPositions());
            }

            JTable resultTable = new JTable(data, columnNames);
            resultTable.setDefaultEditor(Object.class, null);
            JScrollPane scrollPane = new JScrollPane(resultTable);
            bottomPanel.removeAll();
            bottomPanel.add(scrollPane, BorderLayout.CENTER);
            bottomPanel.revalidate();
            bottomPanel.repaint();

            TableRowSorter<TableModel> sorter = new TableRowSorter<>(resultTable.getModel());

            sorter.setComparator(0, Comparator.comparingInt(o -> Integer.parseInt(o.toString())));
            sorter.setComparator(5, Comparator.comparingInt(o -> Integer.parseInt(o.toString())));

            resultTable.setRowSorter(sorter);

            resultTable.getSelectionModel().addListSelectionListener(e1 -> {
                int selectedRow = resultTable.getSelectedRow();
                if (selectedRow != -1) {
                    selectedPlayer[0] = results.get(selectedRow);

                    selectedPlayerPositions[0] = String.join(", ", selectedPlayer[0].getPositions());

                    selectedPlayer[0].setCanPlay(selectedPlayerPositions[0].toString(),lastSelectedFormation);
                    valuesList = new ArrayList<>();

                    Collection<String> stringValues = selectedPlayer[0].getCanPlay().values();

                    for (String value : stringValues) {
                        try {
                            // Split the string by commas
                            String[] parts = value.split(",");

                            // Convert each part to an integer and add it to valuesList
                            for (String part : parts) {
                                valuesList.add(Integer.parseInt(part.trim()));
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Invalid number format in: " + value);
                        }
                    }

                    isCanPlay = valuesList.contains(selectedBoxIndex);
                }
            });
        });

        // Unlike other modes in this mode you have to click to "Add" button to add players into the formation.
        addButton.addActionListener(e -> {
            if (selectedPlayer[0] != null && isCanPlay) {
                // The player added on GUI
                currentFormation.addPlayer(selectedPlayer[0], selectedBoxIndex);

                // Player informations prints on the button with HTML style. HTML style is for the multi-lines.
                String buttonText = String.format(
                        "<html><center><span style='font-size:5px;'>%s<br>%s<br>%s<br>%s</span></center></html>",
                        selectedPlayer[0].getName(),
                        selectedPlayer[0].getNation(),
                        selectedPlayer[0].getTeam_name(),
                        selectedPlayer[0].getLeague()
                );

                // Player infos on the button
                formationButtons[selectedBoxIndex].setText(buttonText);

                updateLinkRank(selectedBoxIndex);
                searchFrame.dispose();
                formationFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Selected player not valid for this position.");
            }
        });

        JPanel combinedTopPanel = new JPanel(new BorderLayout());
        combinedTopPanel.add(topPanel, BorderLayout.CENTER);
        combinedTopPanel.add(buttonPanel, BorderLayout.SOUTH);
        combinedTopPanel.add(topRightPanel, BorderLayout.NORTH);

        searchFrame.add(combinedTopPanel, BorderLayout.NORTH);
        searchFrame.add(bottomPanel, BorderLayout.CENTER);

        searchFrame.setVisible(true);
    }

    // Auxiliary method for the age range
    private static Integer[] generateRange(int start, int end) {
        Integer[] range = new Integer[end - start + 1];
        for (int i = 0; i < range.length; i++) {
            range[i] = start + i;
        }
        return range;
    }

    // Coordinates of the player's buttons on the formation photo.
    private Point[] getFormationBoxCoordinates(String selectedFormation) {

        if (selectedFormation.equals("3-4-3")) {
            return new Point[]{
                    new Point(565, 90), new Point(350, 120), new Point(780, 120), new Point(235, 230),
                    new Point(460, 240), new Point(675, 240), new Point(905, 230), new Point(330, 335),
                    new Point(565, 335), new Point(800, 335), new Point(565, 485)
            };
        } else if (selectedFormation.equals("3-4-1-2")) {
            return new Point[]{
                    new Point(565, 190), new Point(435, 90), new Point(695, 90), new Point(235, 205),
                    new Point(440, 250), new Point(695, 250), new Point(905, 205), new Point(330, 335),
                    new Point(565, 335), new Point(800, 335), new Point(565, 485)
            };
        } else if (selectedFormation.equals("3-4-2-1")) {
            return new Point[]{
                    new Point(565, 90), new Point(425, 105), new Point(705, 105), new Point(235, 205),
                    new Point(460, 250), new Point(675, 250), new Point(905, 205), new Point(330, 335),
                    new Point(565, 335), new Point(800, 335), new Point(565, 485)
            };
        } else if (selectedFormation.equals("3-5-2")) {
            return new Point[]{
                    new Point(565, 190), new Point(465, 90), new Point(665, 90), new Point(235, 205),
                    new Point(440, 270), new Point(695, 270), new Point(905, 205), new Point(330, 335),
                    new Point(565, 335), new Point(800, 335), new Point(565, 485)
            };
        } else if (selectedFormation.equals("4-1-2-1-2")) {
            return new Point[]{
                    new Point(565, 170), new Point(465, 90), new Point(665, 90), new Point(285, 205),
                    new Point(440, 390), new Point(695, 390), new Point(845, 205), new Point(240, 375),
                    new Point(565, 325), new Point(905, 375), new Point(565, 485)
            };
        } else if (selectedFormation.equals("4-1-4-1")) {
            return new Point[]{
                    new Point(565, 90), new Point(440, 210), new Point(695, 210), new Point(235, 205),
                    new Point(440, 390), new Point(695, 390), new Point(905, 205), new Point(240, 375),
                    new Point(565, 290), new Point(905, 375), new Point(565, 485)
            };
        } else if (selectedFormation.equals("4-2-2-2")) {
            return new Point[]{
                    new Point(465, 90), new Point(665, 90), new Point(635, 270), new Point(340, 190),
                    new Point(405, 395), new Point(730, 395), new Point(795, 190), new Point(240, 390),
                    new Point(500, 270), new Point(905, 390), new Point(565, 485)
            };
        } else if (selectedFormation.equals("4-2-3-1")) {
            return new Point[]{
                    new Point(565, 85), new Point(430, 160), new Point(705, 160), new Point(235, 380),
                    new Point(460, 390), new Point(675, 390), new Point(905, 380), new Point(355, 305),
                    new Point(565, 235), new Point(780, 305), new Point(565, 485)
            };
        } else if (selectedFormation.equals("4-3-1-2")) {
            return new Point[]{
                    new Point(565, 130), new Point(455, 85), new Point(680, 85), new Point(235, 380),
                    new Point(440, 390), new Point(695, 390), new Point(905, 380), new Point(380, 245),
                    new Point(565, 280), new Point(755, 245), new Point(565, 485)
            };
        } else if (selectedFormation.equals("4-3-2-1")) {
            return new Point[]{
                    new Point(565, 85), new Point(440, 95), new Point(695, 95), new Point(235, 390),
                    new Point(440, 400), new Point(695, 400), new Point(905, 390), new Point(390, 250),
                    new Point(565, 245), new Point(745, 250), new Point(565, 485)
            };
        } else if (selectedFormation.equals("4-3-3")) {
            return new Point[]{
                    new Point(565, 95), new Point(330, 110), new Point(805, 110), new Point(235, 385),
                    new Point(440, 395), new Point(695, 395), new Point(905, 385), new Point(395, 250),
                    new Point(565, 255), new Point(740, 250), new Point(565, 485)
            };
        } else if (selectedFormation.equals("4-4-1-1")) {
            return new Point[]{
                    new Point(565, 80), new Point(240, 240), new Point(905, 240), new Point(240, 385),
                    new Point(440, 405), new Point(695, 405), new Point(900, 385), new Point(430, 255),
                    new Point(565, 230), new Point(705, 255), new Point(565, 485)
            };
        } else if (selectedFormation.equals("4-4-2")) {
            return new Point[]{
                    new Point(655, 85), new Point(240, 215), new Point(905, 215), new Point(240, 385),
                    new Point(455, 405), new Point(680, 405), new Point(900, 385), new Point(460, 235),
                    new Point(480, 85), new Point(675, 235), new Point(565, 485)
            };
        } else if (selectedFormation.equals("4-5-1")) {
            return new Point[]{
                    new Point(565, 95), new Point(240, 205), new Point(905, 205), new Point(240, 380),
                    new Point(440, 390), new Point(695, 390), new Point(900, 380), new Point(410, 165),
                    new Point(565, 255), new Point(725, 165), new Point(565, 485)
            };
        } else if (selectedFormation.equals("5-2-2-1")) {
            return new Point[]{
                    new Point(565, 85), new Point(335, 100), new Point(800, 100), new Point(235, 290),
                    new Point(460, 180), new Point(675, 180), new Point(905, 290), new Point(390, 335),
                    new Point(565, 335), new Point(750, 335), new Point(565, 485)
            };
        } else if (selectedFormation.equals("5-2-1-2")) {
            return new Point[]{
                    new Point(565, 160), new Point(455, 85), new Point(675, 85), new Point(235, 290),
                    new Point(460, 230), new Point(675, 230), new Point(905, 295), new Point(350, 335),
                    new Point(565, 335), new Point(785, 335), new Point(565, 485)
            };
        } else if (selectedFormation.equals("5-3-2")) {
            return new Point[]{
                    new Point(565, 180), new Point(465, 85), new Point(670, 85), new Point(235, 290),
                    new Point(365, 180), new Point(770, 180), new Point(905, 290), new Point(390, 335),
                    new Point(565, 335), new Point(745, 335), new Point(565, 485)
            };
        }

        return new Point[0]; // If no pattern is found, return empty array
    }

    private void clearPreviousButtons() {
        // Remove all the buttons
        if (formationButtons != null) {
            for (JButton button : formationButtons) {
                formationImageLabel.remove(button);
            }
        }
        // Clear button text and reset any state associated with the buttons
        formationButtons = new JButton[numOfBoxes];
        for (int i = 0; i < numOfBoxes; i++) {
            formationButtons[i] = new JButton(""); // Clear text
            formationButtons[i].setBounds(boxCoordinates[i].x, boxCoordinates[i].y, 70, 70);
            // Reset event listeners, or add new ones as needed
            final int boxIndex = i;
            formationButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectPlayer(boxIndex);
                }
            });
        }
    }

    private void resetState() {
        // Reset player assignments in the formation
        Player[] players = currentFormation.getPlayers();
        for (int i = 0; i < players.length; i++) {
            players[i] = null;  // Clear each player's assignment
        }

        // Reset other state variables
        selectedBoxIndex = -1;
        isBuildTeam = false;
        isRandom = false;
        isOnlySearch = false;
    }

    // Player buttons
    private void addClickableButtons() {
        formationButtons = new JButton[numOfBoxes];

        for (int i = 0; i < numOfBoxes; i++) {
            final int boxIndex = i;
            formationButtons[i] = new JButton("" + i);
            Point boxPoint = boxCoordinates[i];

            formationButtons[i].setBounds(boxPoint.x, boxPoint.y, 70, 70);

            formationButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectPlayer(boxIndex);
                }
            });
        }

        // Add buttons on the photo
        for (JButton button : formationButtons) {
            formationImageLabel.add(button);
        }
    }

    // Player selection process when the button is clicked.
    // For Random Draft mode, random player buttons pops up.
    // For Build Your Team mode, search window pops up.
    // For Search Player mode, search window pops up without "Add" button.
    private void selectPlayer(int boxIndex) {
        selectedBoxIndex = boxIndex;

        // Check if a player is assigned to this box
        Integer playerIndex = currentFormation.getUiToGraph().get(boxIndex);
        if (playerIndex != null && currentFormation.getPlayers()[playerIndex] != null) {
            // Player is already assigned, handle accordingly
            System.out.println("Expecting an action from the user...");
        } else {
            // No player assigned to this box, handle accordingly
            System.out.println("Expecting an action from the user...");
        }

        // Handle the user actions for building team, random player, or search
        if (isBuildTeam) {
            formationFrame.setVisible(false);
            openSearchWindow2();
        } else if (isRandom) {
            isOnlySearch = false;
            formationFrame.setVisible(false);
            openRandomPlayerWindow();
        } else {
            formationFrame.setVisible(false);
            openSearchWindow();
        }

        // Additional message for team building mode
        if (isBuildTeam) {
            JOptionPane.showMessageDialog(null, "You selected box: " + boxIndex);
        }
    }

    // Random players selection window on Random Draft mode
    private void openRandomPlayerWindow() {
        isOnlySearch = false;

        JFrame randomPlayerFrame = new JFrame("Select Random Player");
        randomPlayerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        randomPlayerFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                formationFrame.setVisible(true);
                randomPlayerFrame.dispose();
            }
        });

        randomPlayerFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        randomPlayerFrame.setLayout(new GridLayout(2, 3));

        // Get the current player list
        ArrayList<Player> availablePlayers = getAvailablePlayers();

        // Shuffle the list and select 5 players
        Collections.shuffle(availablePlayers);
        ArrayList<Player> randomPlayers = new ArrayList<>(availablePlayers.subList(0, 5));

        for (Player player : randomPlayers) {
            JButton playerButton = new JButton();
            String buttonText = String.format(
                    "<html><center><span style='font-size:15px;'>%s<br>%s<br>%s<br>%s</span></center></html>",
                    player.getName(),
                    player.getNation(),
                    player.getTeam_name(),
                    player.getLeague()
            );
            playerButton.setText(buttonText);

            playerButton.addActionListener(e -> {
                // Add the selected player to the formation
                currentFormation.addPlayer(player, selectedBoxIndex);
                String selectedPlayerText = String.format(
                        "<html><center><span style='font-size:5px;'>%s<br>%s<br>%s<br>%s</span></center></html>",
                        player.getName(),
                        player.getNation(),
                        player.getTeam_name(),
                        player.getLeague()
                );
                formationButtons[selectedBoxIndex].setText(selectedPlayerText);

                randomPlayerFrame.dispose();
                formationFrame.setVisible(true);
                updateLinkRank(selectedBoxIndex);
            });

            randomPlayerFrame.add(playerButton);
        }

        randomPlayerFrame.setVisible(true);
    }

    // Checks the links between players and sets the rank.
    private int checkLink (int a, int b) {
        int rank = 0;

        if(a<b || currentFormation.getPlayers()[currentFormation.getUiToGraph().get(a)] == null
                || currentFormation.getPlayers()[currentFormation.getUiToGraph().get(b)] == null) return 0;

        if(Objects.equals(currentFormation.getPlayers()[currentFormation.getUiToGraph().get(a)].getNation(), currentFormation.getPlayers()[currentFormation.getUiToGraph().get(b)].getNation()))
            rank++;

        if(Objects.equals(currentFormation.getPlayers()[currentFormation.getUiToGraph().get(a)].getLeague(), currentFormation.getPlayers()[currentFormation.getUiToGraph().get(b)].getLeague()))
            rank++;

        if(Objects.equals(currentFormation.getPlayers()[currentFormation.getUiToGraph().get(a)].getTeam_name(), currentFormation.getPlayers()[currentFormation.getUiToGraph().get(b)].getTeam_name()))
            rank++;

        return rank;
    }

    // For Random Draft mode, throws an empty query for take all players. And eliminates the selected players.
    private ArrayList<Player> getAvailablePlayers() {
        ArrayList<Player> availablePlayers = new ArrayList<>();
        ArrayList<Player> allPlayers = DatabaseAction.query(null,null,null,null,null,null);

        for (Player player : allPlayers) {
            if (!isPlayerSelected(player)) { // Implement this check
                availablePlayers.add(player);
            }
        }

        return availablePlayers;
    }

    // For Random Draft mode, elimination of the selected players method.
    private boolean isPlayerSelected(Player player) {
        for (Player p : currentFormation.getPlayers()) {
            if (p != null && p.getId() == player.getId()) {
                return true;
            }
        }
        return false;
    }

    // Starting the GUI
    public void show() {
        mainFrame.setVisible(true);
    }
}
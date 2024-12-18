import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Gui {
    private JFrame mainFrame;
    private JButton authorsButton;
    private JButton playButton;

    private JFrame playFrame = new JFrame("Play Options");
    private JFrame formationFrame;

    private JLabel formationImageLabel; // Formasyon resmini gösterecek label

    private JButton[] formationButtons; // Fotoğraf üzerindeki butonları tutacak dizi
    private int numOfBoxes = 11;

    private Point[] boxCoordinates;

    private String lastSelectedFormation = "";
    private Formation currentFormation = new Formation();

    private boolean isRandom = false;
    private boolean isBuildTeam = false;
    private boolean isOnlySearch = true;

    private int selectedBoxIndex = -1;

    JLabel[] labels = new JLabel[11];

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
        mainFrame.setVisible(false);
        JFrame authorsFrame = new JFrame("Authors");

        JButton backButton = new JButton("Back to Main Screen");
        backButton.setBounds(50, 50, 200, 30);
        authorsFrame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorsFrame.dispose();// Yeni pencereyi gizle
                mainFrame.setVisible(true); // İlk pencereyi göster
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

    private void openPlayWindow() {
        mainFrame.setVisible(false);

        JButton backButton = new JButton("Back to Main Screen");
        backButton.setBounds(50, 50, 200, 30);
        playFrame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playFrame.dispose();// Yeni pencereyi gizle
                mainFrame.setVisible(true); // İlk pencereyi göster
            }
        });

        playFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        playFrame.setSize(screenWidth/2,screenHeight/2);
        playFrame.setLocation(screenWidth/4,screenHeight/4);

        JPanel playPanel = new JPanel();
        playPanel.setLayout(new GridLayout(1, 3, 20, 0));

        JButton button1 = new JButton("Build Your Team");
        JButton button2 = new JButton("Random Draft");
        JButton button3 = new JButton("Search Player");

        button1.setPreferredSize(new Dimension(150, 50));
        button2.setPreferredSize(new Dimension(150, 50));
        button3.setPreferredSize(new Dimension(150, 50));

        playPanel.add(button1);
        playPanel.add(button2);
        playPanel.add(button3);

        button1.addActionListener(e -> openFormationSelectionWindow());
        button2.addActionListener(e -> showRandomFormations());
        button3.addActionListener(e -> openSearchWindow());

        JPanel container = new JPanel(new GridBagLayout());
        container.setBackground(Color.WHITE);
        container.add(playPanel);

        playFrame.add(container);
        playFrame.setVisible(true);
    }

    private void openFormationSelectionWindow() {
        isBuildTeam = true;
        isRandom = false;
        isOnlySearch = false;

        playFrame.setVisible(false);

        formationFrame = new JFrame("Build Your Team");
        formationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton backButton = new JButton("Back to Play Options");
        backButton.setBounds(50, 50, 200, 30);
        formationFrame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formationFrame.dispose();// Yeni pencereyi gizle
                playFrame.setVisible(true); // İlk pencereyi göster
                mainFrame.dispose();
            }
        });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        formationFrame.setSize(screenSize);

        // Panel
        JPanel formationPanel = new JPanel();
        formationPanel.setLayout(new BoxLayout(formationPanel, BoxLayout.Y_AXIS));

        // Formasyonlar için örnekler
        String[] formations = {"3-4-3","3-4-1-2","3-4-2-1","3-5-2","4-1-2-1-2","4-1-4-1","4-2-2-2","4-2-3-1",
                "4-3-1-2","4-3-2-1","4-3-3","4-4-1-1","4-4-2","4-5-1","5-2-2-1","5-2-1-2","5-3-2"};

        // ComboBox ile formasyon seçimi
        JComboBox<String> formationComboBox = new JComboBox<>(formations);
        formationComboBox.setFont(new Font("Arial", Font.PLAIN, 24));
        formationComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Seçilen formasyonu gösterecek buton
        JButton selectButton = new JButton("Select Formation");
        selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Formasyon görseli için label
        formationImageLabel = new JLabel();
        formationImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton okButton = new JButton("OK");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.setEnabled(false);

        // Seçim işlemi
        selectButton.addActionListener(e -> {
            String selectedFormation = (String) formationComboBox.getSelectedItem();
            updateFormationImage(selectedFormation); // Formasyon görselini güncelle
            okButton.setEnabled(true); // OK butonunu etkinleştir
        });

        okButton.addActionListener(e -> {
            selectButton.setEnabled(false); // Select Formation butonunu devre dışı bırak
            formationComboBox.setEnabled(false); // ComboBox'ı devre dışı bırak
            okButton.setEnabled(false); // OK butonunu da devre dışı bırak
            JOptionPane.showMessageDialog(formationFrame, "Formation selection confirmed!");
            lastSelectedFormation = (String) formationComboBox.getSelectedItem();
            currentFormation.setFormation_name(lastSelectedFormation);
            currentFormation.create_graph();
            addClickableButtons();
            addFormationLabels(lastSelectedFormation, formationImageLabel);
        });

        // Panele formasyonları ve butonu ekle
        formationPanel.add(Box.createVerticalStrut(100)); // Boşluk
        formationPanel.add(formationComboBox);
        formationPanel.add(Box.createVerticalStrut(20));
        formationPanel.add(selectButton);
        formationPanel.add(Box.createVerticalStrut(10));
        formationPanel.add(okButton);
        formationPanel.add(Box.createVerticalStrut(20));
        formationPanel.add(formationImageLabel); // Formasyon resmini ekle

        // İçeriği ortalamak için kapsayıcı panel
        JPanel container = new JPanel(new GridBagLayout());
        container.add(formationPanel);

        formationFrame.add(container);
        formationFrame.setVisible(true);
    }

    private void addFormationLabels(String selectedFormation, JLabel formationImageLabel) {
        Point[] coordinates = getFormationBoxCoordinates(selectedFormation);

        for (int i = 0; i < coordinates.length; i++) {
            labels[i] = new JLabel("Link Rank: 0", SwingConstants.CENTER);
            labels[i].setBounds(coordinates[i].x - 90, coordinates[i].y + 20, 90, 20);
            labels[i].setOpaque(true);

            labels[i].setBackground(Color.RED);
            labels[i].setForeground(Color.WHITE);

            formationImageLabel.add(labels[i]);
        }

        formationImageLabel.repaint();
    }

    private void updateLinkRank(int index) {
        if (index >= 0 && index < labels.length) {
            JLabel label = labels[index];
            ArrayList<Formation.Link> links = currentFormation.checkLinks(index);
            for (Formation.Link link : links) {
                if (link.rank == 0) {
                    label.setBackground(Color.RED);
                } else if (link.rank == 1 || link.rank == 2) {
                    label.setBackground(Color.YELLOW);
                } else if (link.rank == 3) {
                    label.setBackground(Color.GREEN);
                }
                label.setText("Link Rank: " + link.rank);
            }
            label.repaint();
        }
    }

    // Seçilen formasyonun görselini mevcut pencereye ekleyen metot
    private void updateFormationImage(String selectedFormation) {
        String imagePath = "images/" + selectedFormation + ".png"; // Formasyon ismiyle uyumlu resim ismi

        try {
            ImageIcon formationImage = new ImageIcon(ImageIO.read(new File(imagePath)));
            formationImageLabel.setIcon(formationImage);

            boxCoordinates = getFormationBoxCoordinates(selectedFormation); // Koordinatları al
            clearPreviousButtons();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Image not found for the selected formation.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showRandomFormations() {
        isRandom = true;
        isBuildTeam = false;
        isOnlySearch = false;

        playFrame.setVisible(false);

        formationFrame = new JFrame("Random Draft");
        formationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton backButton = new JButton("Back to Play Options");
        backButton.setBounds(50, 50, 200, 30);
        formationFrame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formationFrame.dispose();// Yeni pencereyi gizle
                playFrame.setVisible(true); // İlk pencereyi göster
                mainFrame.dispose();
            }
        });

        // Formasyonlar dizisi
        String[] formations = {"3-4-3", "3-4-1-2", "3-4-2-1", "3-5-2", "4-1-2-1-2", "4-1-4-1", "4-2-2-2", "4-2-3-1",
                "4-3-1-2", "4-3-2-1", "4-3-3", "4-4-1-1", "4-4-2", "4-5-1", "5-2-2-1", "5-2-1-2", "5-3-2"};

        // Formasyon listesini oluştur
        ArrayList<String> formationList = new ArrayList<>();
        Collections.addAll(formationList, formations);

        // Karıştır ve ilk 5'i seç
        Collections.shuffle(formationList);
        String[] randomFormations = formationList.subList(0, 5).toArray(new String[0]);

        // Seçilen formasyonları yazdır (kontrol için)
        for (String formation : randomFormations) {
            System.out.println(formation);
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        formationFrame.setSize(screenSize);

        JPanel formationPanel = new JPanel();
        formationPanel.setLayout(new BoxLayout(formationPanel, BoxLayout.Y_AXIS));

        JLabel instructionLabel = new JLabel("Please select one of the following formations:");
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // ComboBox ile rastgele formasyonları göster
        JComboBox<String> formationComboBox = new JComboBox<>(randomFormations);
        formationComboBox.setFont(new Font("Arial", Font.PLAIN, 24));
        formationComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Seçim butonu
        JButton selectButton = new JButton("Select Formation");
        selectButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // "OK" butonu
        JButton okButton = new JButton("OK");
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.setEnabled(false); // Başlangıçta devre dışı

        // Formasyon görseli için label
        formationImageLabel = new JLabel();
        formationImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Seçim işlemi
        selectButton.addActionListener(e -> {
            String selectedFormation = (String) formationComboBox.getSelectedItem();
            updateFormationImage(selectedFormation); // Formasyon görselini güncelle
            okButton.setEnabled(true); // OK butonunu etkinleştir
        });

        // OK butonuna basıldığında seçim kilitlensin
        okButton.addActionListener(e -> {
            selectButton.setEnabled(false); // Select Formation butonunu devre dışı bırak
            formationComboBox.setEnabled(false); // ComboBox'ı devre dışı bırak
            okButton.setEnabled(false); // OK butonunu da devre dışı bırak
            JOptionPane.showMessageDialog(formationFrame, "Formation selection confirmed!");
            addClickableButtons();
            lastSelectedFormation = (String) formationComboBox.getSelectedItem();
            currentFormation.setFormation_name(lastSelectedFormation);
            currentFormation.create_graph();
            addFormationLabels(lastSelectedFormation, formationImageLabel);
        });

        // Panele formasyonları ve butonları ekle
        formationPanel.add(Box.createVerticalStrut(100)); // Boşluk
        formationPanel.add(instructionLabel);
        formationPanel.add(Box.createVerticalStrut(20));
        formationPanel.add(formationComboBox);
        formationPanel.add(Box.createVerticalStrut(20));
        formationPanel.add(selectButton);
        formationPanel.add(Box.createVerticalStrut(10));
        formationPanel.add(okButton);
        formationPanel.add(Box.createVerticalStrut(20));
        formationPanel.add(formationImageLabel); // Formasyon resmini ekle

        // İçeriği ortalamak için kapsayıcı panel
        JPanel container = new JPanel(new GridBagLayout());
        container.add(formationPanel);

        formationFrame.add(container);
        formationFrame.setVisible(true);
    }

    private void openSearchWindow() {
        playFrame.setVisible(false);

        // Yeni pencere
        JFrame searchFrame = new JFrame("Search Player");
        searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        searchFrame.setSize(screenSize);
        searchFrame.setLayout(new BorderLayout());

        // Üst panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(5, 2, 10, 10)); // 5 satır, 2 sütun, aralık 10px

        // Name için text area
        topPanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        topPanel.add(nameField);

        // Nation için dropdown list
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

        // Age için aralık combobox'ları
        topPanel.add(new JLabel("Age:"));
        JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<Integer> age = new JComboBox<>(generateRange(15, 100));
        age.insertItemAt(null, 0);
        age.setSelectedIndex(0);
        agePanel.add(new JLabel());
        agePanel.add(age);
        topPanel.add(agePanel);

        // Current Ability için combobox
        topPanel.add(new JLabel("Current Ability:"));
        JComboBox<Integer> abilityDropdown = new JComboBox<>(generateRange(0, 200));
        abilityDropdown.insertItemAt(null, 0);
        abilityDropdown.setSelectedIndex(0);
        topPanel.add(abilityDropdown);

        // Division için dropdown list
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

        // Sağ üst köşe için panel ve buton
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
                searchFrame.dispose(); // Yeni pencereyi kapat
                playFrame.setVisible(true);  // İlk pencereyi göster
                mainFrame.dispose();
                if (isOnlySearch) {
                    formationFrame.setVisible(true);
                }
            }
        });

        // Ortalanmış "Add" ve "Search" düğmeleri için panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10)); // 2 satır, 1 sütun, aralık 10px
        JButton searchButton = new JButton("Search");
        buttonPanel.add(searchButton);

        // Alt panel (Sonuçların gösterileceği yer)
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Query Results"));

        // Seçilen oyuncuyu tutacak bir değişken
        final Player[] selectedPlayer = new Player[1];

        // "Search" butonuna basıldığında yapılacak işlemler
        searchButton.addActionListener(e -> {
            String name = nameField.getText();
            String nation = (String) nationDropdown.getSelectedItem();
            Integer ageValue = (Integer) age.getSelectedItem();
            Integer ability = (Integer) abilityDropdown.getSelectedItem();
            String division = (String) divisionDropdown.getSelectedItem();

            ArrayList<Player> results = DatabaseAction.query(name, nation, ageValue, ability, division); // Query fonksiyonundan sonuçları al

            if (results.isEmpty()) {
                JOptionPane.showMessageDialog(searchFrame, "No players found!");
                return;
            }

            // Sonuçları JTable ile göster
            String[] columnNames = {"ID", "Name", "Age", "Nation", "Club", "Current Ability", "League"};
            Object[][] data = new Object[results.size()][7];
            for (int i = 0; i < results.size(); i++) {
                Player player = results.get(i);
                data[i][0] = player.getId();
                data[i][1] = player.getName();
                data[i][2] = player.getAge();
                data[i][3] = player.getNation();
                data[i][4] = player.getTeam_name();
                data[i][5] = player.getOverall();
                data[i][6] = player.getLeague();
            }

            JTable resultTable = new JTable(data, columnNames);
            resultTable.setDefaultEditor(Object.class, null);
            JScrollPane scrollPane = new JScrollPane(resultTable);
            bottomPanel.removeAll(); // Eski sonuçları kaldır
            bottomPanel.add(scrollPane, BorderLayout.CENTER); // Yeni tabloyu ekle
            bottomPanel.revalidate(); // Paneli yeniden çiz
            bottomPanel.repaint();

            // TableRowSorter ekleyerek sıralama özelliği ekle
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(resultTable.getModel());

            // ID ve Overall sütunları için sayısal sıralama
            sorter.setComparator(0, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // ID sütunu
            sorter.setComparator(5, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // Overall sütunu

            resultTable.setRowSorter(sorter);

            // Tabloya tıklama özelliği ekleyerek seçilen oyuncuyu kaydetme
            resultTable.getSelectionModel().addListSelectionListener(e1 -> {
                int selectedRow = resultTable.getSelectedRow();
                if (selectedRow != -1) {
                    selectedPlayer[0] = results.get(selectedRow); // Seçilen oyuncuyu kaydet
                }
            });
        });

        // Üst paneli kapsayan bir ana panel
        JPanel combinedTopPanel = new JPanel(new BorderLayout());
        combinedTopPanel.add(topPanel, BorderLayout.CENTER);
        combinedTopPanel.add(buttonPanel, BorderLayout.SOUTH);
        combinedTopPanel.add(topRightPanel, BorderLayout.NORTH);

        // Üst ve alt panelleri yeni pencereye ekleme
        searchFrame.add(combinedTopPanel, BorderLayout.NORTH);
        searchFrame.add(bottomPanel, BorderLayout.CENTER);

        searchFrame.setVisible(true);
    }

    private void openSearchWindow2() {
        isOnlySearch = false;
        // Yeni pencere
        JFrame searchFrame = new JFrame("Search Player");
        searchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        searchFrame.setSize(screenSize);
        searchFrame.setLayout(new BorderLayout());

        // Üst panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(5, 2, 10, 10)); // 5 satır, 2 sütun, aralık 10px

        // Name için text area
        topPanel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        topPanel.add(nameField);

        // Nation için dropdown list
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

        // Age için aralık combobox'ları
        topPanel.add(new JLabel("Age:"));
        JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<Integer> age = new JComboBox<>(generateRange(15, 100));
        age.insertItemAt(null, 0);
        age.setSelectedIndex(0);
        agePanel.add(new JLabel());
        agePanel.add(age);
        topPanel.add(agePanel);

        // Current Ability için combobox
        topPanel.add(new JLabel("Current Ability:"));
        JComboBox<Integer> abilityDropdown = new JComboBox<>(generateRange(0, 200));
        abilityDropdown.insertItemAt(null, 0);
        abilityDropdown.setSelectedIndex(0);
        topPanel.add(abilityDropdown);

        // Division için dropdown list
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

        // Sağ üst köşe için panel ve buton
        JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("Back to Formation Window");
        topRightPanel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFrame.dispose(); // Yeni pencereyi kapat
                playFrame.dispose();  // İlk pencereyi göster
                mainFrame.dispose();
                formationFrame.setVisible(true);
            }
        });

        // Ortalanmış "Add" ve "Search" düğmeleri için panel
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10)); // 2 satır, 1 sütun, aralık 10px
        JButton searchButton = new JButton("Search");
        JButton addButton = new JButton("Add");
        buttonPanel.add(searchButton);
        buttonPanel.add(addButton);

        // Alt panel (Sonuçların gösterileceği yer)
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Query Results"));

        // Seçilen oyuncuyu tutacak bir değişken
        final Player[] selectedPlayer = new Player[1];

        // "Search" butonuna basıldığında yapılacak işlemler
        searchButton.addActionListener(e -> {
            String name = nameField.getText();
            String nation = (String) nationDropdown.getSelectedItem();
            Integer ageValue = (Integer) age.getSelectedItem();
            Integer ability = (Integer) abilityDropdown.getSelectedItem();
            String division = (String) divisionDropdown.getSelectedItem();

            ArrayList<Player> results = DatabaseAction.query(name, nation, ageValue, ability, division); // Query fonksiyonundan sonuçları al

            if (results.isEmpty()) {
                JOptionPane.showMessageDialog(searchFrame, "No players found!");
                return;
            }

            // Sonuçları JTable ile göster
            String[] columnNames = {"ID", "Name", "Age", "Nation", "Club", "Current Ability", "League"};
            Object[][] data = new Object[results.size()][7];
            for (int i = 0; i < results.size(); i++) {
                Player player = results.get(i);
                data[i][0] = player.getId();
                data[i][1] = player.getName();
                data[i][2] = player.getAge();
                data[i][3] = player.getNation();
                data[i][4] = player.getTeam_name();
                data[i][5] = player.getOverall();
                data[i][6] = player.getLeague();
            }

            JTable resultTable = new JTable(data, columnNames);
            resultTable.setDefaultEditor(Object.class, null);
            JScrollPane scrollPane = new JScrollPane(resultTable);
            bottomPanel.removeAll(); // Eski sonuçları kaldır
            bottomPanel.add(scrollPane, BorderLayout.CENTER); // Yeni tabloyu ekle
            bottomPanel.revalidate(); // Paneli yeniden çiz
            bottomPanel.repaint();

            // TableRowSorter ekleyerek sıralama özelliği ekle
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(resultTable.getModel());

            // ID ve Overall sütunları için sayısal sıralama
            sorter.setComparator(0, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // ID sütunu
            sorter.setComparator(5, Comparator.comparingInt(o -> Integer.parseInt(o.toString()))); // Overall sütunu

            resultTable.setRowSorter(sorter);


            // Tabloya tıklama özelliği ekleyerek seçilen oyuncuyu kaydetme
            resultTable.getSelectionModel().addListSelectionListener(e1 -> {
                int selectedRow = resultTable.getSelectedRow();
                if (selectedRow != -1) {
                    selectedPlayer[0] = results.get(selectedRow); // Seçilen oyuncuyu kaydet
                }
            });
        });

        // "Add" butonuna basıldığında yapılacak işlemler
        addButton.addActionListener(e -> {
            if (selectedPlayer[0] != null) {
                // Seçilen oyuncuyu UI'deki butona ekle
                currentFormation.addPlayer(selectedPlayer[0], selectedBoxIndex);

                // Oyuncu bilgilerini birleştir ve HTML formatında, font boyutunu küçült
                String buttonText = String.format(
                        "<html><center><span style='font-size:5px;'>%s<br>%s<br>%s<br>%s</span></center></html>",
                        selectedPlayer[0].getName(),
                        selectedPlayer[0].getNation(),
                        selectedPlayer[0].getTeam_name(),
                        selectedPlayer[0].getLeague()
                );

                // Buton üzerinde oyuncu bilgilerini göster
                formationButtons[selectedBoxIndex].setText(buttonText);

                updateLinkRank(selectedBoxIndex);
                searchFrame.dispose(); // Arama penceresini kapat
                formationFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(searchFrame, "No player selected!");
            }
        });

        // Üst paneli kapsayan bir ana panel
        JPanel combinedTopPanel = new JPanel(new BorderLayout());
        combinedTopPanel.add(topPanel, BorderLayout.CENTER);
        combinedTopPanel.add(buttonPanel, BorderLayout.SOUTH);
        combinedTopPanel.add(topRightPanel, BorderLayout.NORTH);

        // Üst ve alt panelleri yeni pencereye ekleme
        searchFrame.add(combinedTopPanel, BorderLayout.NORTH);
        searchFrame.add(bottomPanel, BorderLayout.CENTER);

        searchFrame.setVisible(true);
    }

    // DEĞİŞEBİLİR
    // Yaş aralığı için yardımcı metod
    private static Integer[] generateRange(int start, int end) {
        Integer[] range = new Integer[end - start + 1];
        for (int i = 0; i < range.length; i++) {
            range[i] = start + i;
        }
        return range;
    }

    private Point[] getFormationBoxCoordinates(String selectedFormation) {
        // Burada, her formasyon için kutuların koordinatlarını döndürmelisiniz.
        // Örnek olarak basit bir koordinat dizisi verelim.

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
        // Diğer formasyonlar için benzer şekilde koordinatlar döndürülebilir.
        return new Point[0]; // Eğer formasyon bulunmazsa boş dizi döndür
    }

    private void clearPreviousButtons() {
        // Önceki butonları temizle
        if (formationButtons != null) {
            for (JButton button : formationButtons) {
                formationImageLabel.remove(button);
            }
        }
    }

    private void addClickableButtons() {
        formationButtons = new JButton[numOfBoxes];

        // Fotoğrafın üstüne görünmez butonlar yerleştirme
        for (int i = 0; i < numOfBoxes; i++) {
            final int boxIndex = i;
            formationButtons[i] = new JButton("" + i);
            Point boxPoint = boxCoordinates[i]; // Koordinatları al

            formationButtons[i].setBounds(boxPoint.x, boxPoint.y, 70, 70); // Koordinatlara göre buton yerleştir
            //formationButtons[i].setOpaque(false);
            //formationButtons[i].setContentAreaFilled(false);
            //formationButtons[i].setBorder(BorderFactory.createEmptyBorder());
            formationButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectPlayer(boxIndex);
                }
            });
        }

        // Fotoğrafın üstüne butonları ekle
        for (JButton button : formationButtons) {
            formationImageLabel.add(button);
        }
    }

    // Butona tıklandığında oyuncu seçme işlemi
    private void selectPlayer(int boxIndex) {
        selectedBoxIndex = boxIndex;
        if (currentFormation.getUiToGraph().get(boxIndex) != null)
            if(currentFormation.getPlayers()[currentFormation.getUiToGraph().get(boxIndex)] != null) {
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
                System.out.println("Expecting an action from the user...");
            } else {
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
                System.out.println("Expecting an action from the user...");
            }
        // Burada seçilen kutu ile ilişkili bir oyuncu seçebilirsiniz
        // Örneğin, kutuya tıklanmasıyla ilgili oyuncu bilgisi alınabilir.
        JOptionPane.showMessageDialog(null, "You selected box: " + (boxIndex));
    }

    private void openRandomPlayerWindow() {
        isOnlySearch = false;
        // Yeni pencereyi tam ekran olarak aç
        JFrame randomPlayerFrame = new JFrame("Select Random Player");
        randomPlayerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Ekran boyutuna göre pencereyi tam ekran yap
        randomPlayerFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //randomPlayerFrame.setUndecorated(true); // Pencere kenarlarını ve başlığını gizle
        randomPlayerFrame.setLayout(new GridLayout(2, 3)); // 2 satır, 3 sütun için 5 buton

        // Mevcut oyuncu listesini al
        ArrayList<Player> availablePlayers = getAvailablePlayers(); // Implement this method

        // Listeyi karıştır ve 5 oyuncu seç
        Collections.shuffle(availablePlayers);
        ArrayList<Player> randomPlayers = new ArrayList<>(availablePlayers.subList(0, 5));

        // Butonları oluştur ve her birine oyuncu bilgilerini ekle
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

            // Butona tıklama aksiyonunu ekle
            playerButton.addActionListener(e -> {
                // Seçilen oyuncuyu forma ekle
                currentFormation.addPlayer(player, selectedBoxIndex);
                String selectedPlayerText = String.format(
                        "<html><center><span style='font-size:5px;'>%s<br>%s<br>%s<br>%s</span></center></html>",
                        player.getName(),
                        player.getNation(),
                        player.getTeam_name(),
                        player.getLeague()
                );
                formationButtons[selectedBoxIndex].setText(selectedPlayerText); // UI butonunu güncelle

                randomPlayerFrame.dispose();  // Rastgele oyuncu penceresini kapat
                formationFrame.setVisible(true);  // Ana pencereyi tekrar görünür yap
                updateLinkRank(selectedBoxIndex); // Link sırasını güncelle
            });

            // Butonu pencereye ekle
            randomPlayerFrame.add(playerButton);
        }

        randomPlayerFrame.setVisible(true);  // Rastgele oyuncu seçme penceresini göster
    }

    private ArrayList<Player> getAvailablePlayers() {
        ArrayList<Player> availablePlayers = new ArrayList<>();
        ArrayList<Player> allPlayers = DatabaseAction.query(null,null,null,null,null);

        for (Player player : allPlayers) { // assuming allPlayers is the list of all players
            if (!isPlayerSelected(player)) { // Implement this check
                availablePlayers.add(player);
            }
        }

        return availablePlayers;
    }

    private boolean isPlayerSelected(Player player) {
        for (Player p : currentFormation.getPlayers()) {
            if (p != null && p.getId() == player.getId()) {
                return true;
            }
        }
        return false;
    }

    public void show() {
        mainFrame.setVisible(true);
    }
}
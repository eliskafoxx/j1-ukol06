package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;

    private JTextField husyField;
    private JTextField kraliciField;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;

    private JSpinner kraliciSpinner;

    private JSpinner husySpinner;

    private JButton vypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 2.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(350, 250));

        //husyField = new JTextField();
        //husyField.setHorizontalAlignment(JTextField.TRAILING);
        SpinnerNumberModel husyModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        husySpinner = new JSpinner(husyModel);
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husySpinner);
        add(husyLabel);
        add(husySpinner, "span");
        husySpinner.setPreferredSize(new Dimension(175, 25));
        husySpinner.setMinimumSize(new Dimension(175, 25));
        husySpinner.setMaximumSize(new Dimension(175, 25));

        //kraliciField = new JTextField();
        //kraliciField.setHorizontalAlignment(JTextField.TRAILING);
        SpinnerNumberModel kraliciModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        kraliciSpinner = new JSpinner(kraliciModel);
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciSpinner);
        add(kraliciLabel);
        add(kraliciSpinner, "span");
        kraliciSpinner.setPreferredSize(new Dimension(175, 25));
        kraliciSpinner.setMinimumSize(new Dimension(175, 25));
        kraliciSpinner.setMaximumSize(new Dimension(175, 25));
        add(createButtonBar(), "span");

        getRootPane().setDefaultButton(vypocitatButton);
        vypocitatButton.addActionListener(this::handleVypocitat);

        pocetHlavField = new JTextField();
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEditable(false);
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField, "span");

        pocetNohouField = new JTextField();
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEditable(false);
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setLabelFor(pocetNohouField);
        add(pocetNohouLabel);
        add(pocetNohouField, "span");

        pack();
    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');

        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));

        buttonBar.add(vypocitatButton);
        return buttonBar;
    }

    private void handleVypocitat(ActionEvent actionEvent) {
        /*int pocetKraliku;
        try {
            pocetKraliku = (kraliciField.getText() != null && !kraliciField.getText().isBlank())
                    ? Integer.parseInt(kraliciField.getText()) : 0;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Neplatná hodnota v poli počet králíků! Vložte celé číslo!", "Chyba", JOptionPane.ERROR_MESSAGE);
            pocetKraliku = 0;
        }

        int pocetHus;
        try {
            pocetHus = (husyField.getText() != null && !husyField.getText().isBlank())
                    ? Integer.parseInt(husyField.getText()) : 0;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,"Neplatná hodnota v poli počet hus! Vložte celé číslo!", "Chyba", JOptionPane.ERROR_MESSAGE);
            pocetHus = 0;
        }

        int pocetNoh = pocetKraliku * 4 + pocetHus * 2;
        pocetNohouField.setText(String.valueOf(pocetNoh));

        int pocetHlav = pocetKraliku + pocetHus;
        pocetHlavField.setText(String.valueOf(pocetHlav));
        }
         */
        int pocetKraliku = (int) kraliciSpinner.getValue();
        int pocetHus = (int) husySpinner.getValue();

        int pocetNoh = pocetKraliku * 4 + pocetHus * 2;
        pocetNohouField.setText(String.valueOf(pocetNoh));

        int pocetHlav = pocetKraliku + pocetHus;
        pocetHlavField.setText(String.valueOf(pocetHlav));
    }
    }


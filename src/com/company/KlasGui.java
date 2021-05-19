package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KlasGui extends JFrame implements ActionListener {
    private final Klas klas;
    private final String title;
    private Boolean errorOccurdLastAction = false;
//    Buttons
    private final JButton tijdVerstrijktJButt;
    private final JButton helpIemandJButt;
    private final JButton voegToeJButt;
//Text fields
    private final JTextField naamTextField;
    private final JTextField blijTextField;
    private final JTextField studentnummerTextField;
//    Labels
    private final JLabel naamLabel;
    private final JLabel blijLabel;
    private final JLabel studentnummerLabel;

    private HelpenDialog dialog;

    private final KlasGraphics graphics;

    public KlasGui(Klas klas) {
        setSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        this.klas = klas;
this.title = "Mark Heijnekamp (S1156618): " +klas.getNaam();
        setTitle(title +" - mededeling: "+ (errorOccurdLastAction ? "Exception" : "OK"));
//        Create the item that you add below
//        like: button = new JButton
        tijdVerstrijktJButt = new JButton("tijd versrijkt");
        helpIemandJButt = new JButton("help iemand");
        voegToeJButt = new JButton("voeg toe");

        tijdVerstrijktJButt.addActionListener(this);
        helpIemandJButt.addActionListener(this);
        voegToeJButt.addActionListener(this);

        naamTextField = new JTextField(3);
        blijTextField = new JTextField(3);
        studentnummerTextField = new JTextField(3);

        naamLabel = new JLabel("naam:");
        blijLabel = new JLabel("blij:");
        studentnummerLabel = new JLabel("s:");

        graphics = new KlasGraphics(klas);

//        Other stuff
        //        Add new items
//        Like add(button) that is declared above as private

        add(tijdVerstrijktJButt);
        add(helpIemandJButt);

        add(naamLabel);
        add(naamTextField);

        add(blijLabel);
        add(blijTextField);

        add(studentnummerLabel);
        add(studentnummerTextField);

        add(voegToeJButt);
        add(graphics);
        setVisible(true);
    }
    private void errorDialog(String text){
        JOptionPane.showMessageDialog(this,"Hier ging even wat mis " + text+" daarom is de actie mislukt","Exception",JOptionPane.ERROR_MESSAGE);
        errorOccurdLastAction = true;
        setTitle(title +" - mededeling: "+ (errorOccurdLastAction ? "Exception" : "OK"));

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == voegToeJButt){
            try {
                klas.voegToe(naamTextField.getText(), studentnummerTextField.getText(), Integer.parseInt(blijTextField.getText()));
            }
            catch (NumberFormatException err){
                errorDialog(err.getMessage());
            }
//            De opdracht vroeg om zo specifiek mogelijk die heb ik hierboven gespecifiseerd

//            De catch hieronder is voor onvoorzienbare foutmeldingen
            catch (Exception err){
                errorDialog(err.getMessage());
            }
        }
        else if(e.getSource() == tijdVerstrijktJButt){
            klas.maakBlij(-5);
        }
        else if(e.getSource() == helpIemandJButt){
            dialog = new HelpenDialog(this);
            if(dialog.getAns()){
                if(klas.maakBlij(dialog.getName(),dialog.getBlij())) {

                    klas.getDocent().maakBlij(10);
                }
            }
        }
        klas.print();
        repaint();

    }
}

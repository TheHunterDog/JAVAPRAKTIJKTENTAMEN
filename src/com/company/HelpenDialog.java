package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpenDialog extends JDialog implements ActionListener{

        private final JButton ButtonYes;
        private final JButton ButtonNo;

        private final JLabel naamJlabel;
        private final JLabel blijheidsWijzingJlabel;

        private final JTextField naamTextField;
        private final JTextField blijheidsWijzingTextField;
        private boolean Ans;
        public HelpenDialog(JFrame frame){
            super(frame, true);
            setSize(300, 150);
            setLayout(new GridLayout(0,2));
            setTitle("Help iemand");
            naamJlabel = new JLabel("Naam");
            blijheidsWijzingJlabel = new JLabel("blijheidswijziging");

            naamTextField = new JTextField(5);
            blijheidsWijzingTextField = new JTextField(5);

            ButtonYes = new JButton("Ok");
            ButtonNo = new JButton("cancel");


            ButtonYes.addActionListener(this);
            ButtonNo.addActionListener(this);
            add(naamJlabel);
            add(naamTextField);
            add(blijheidsWijzingJlabel);
            add(blijheidsWijzingTextField);
            add(ButtonYes);
            add(ButtonNo);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Ans = e.getSource() == ButtonYes;
            setVisible(false);
        }

        public boolean getAns(){
            return Ans;
        }
    public String getName() {
        return naamTextField.getText();
    }
    public int getBlij() {
            try {
                return Integer.parseInt(blijheidsWijzingTextField.getText());
            }
            catch (NumberFormatException err){
                return 0;
            }
    }
    }

package GUI;

import domain.Onderdeel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.util.ArrayList;

public class JFrameFactuurRegelToevoegen extends javax.swing.JFrame implements ActionListener {

    private JFrameToevoegen main;
    private JComboBox list;
    private ArrayList<Onderdeel> onderdelen;
    private JTextField tf;

    public JFrameFactuurRegelToevoegen(JFrameToevoegen main, ArrayList<Onderdeel> onderdelen) {
        initComponents();
        this.setLocation(400, 250);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setTitle("Regel Toevoegen");
        this.main = main;
        this.onderdelen = onderdelen;

        list = new JComboBox();
        list.setBounds(20, 20, 190, 20);
        add(list);
        for (Onderdeel ond : onderdelen) {
            list.addItem(ond.getCode() + ":  " + ond.getOmschrijving());

        }

        JLabel lbl = new JLabel("Aantal:");
        lbl.setBounds(20, 50, 80, 30);
        lbl.setFont(new Font("Times New Roman", 0, 15));
        add(lbl);

        tf = new JTextField();
        tf.setBounds(110, 50, 80, 20);
        tf.setFont(new Font("Times New Roman", 0, 15));
        add(tf);

        JButton btVoeg = new JButton("Voeg Toe");
        btVoeg.setBounds(10, 80, 100, 20);
        btVoeg.setFont(new Font("Times New Roman", 0, 15));
        btVoeg.addActionListener(this);
        btVoeg.setActionCommand("Voeg Toe");
        add(btVoeg);

        JButton btCancel = new JButton("Cancel");
        btCancel.setBounds(120, 80, 100, 20);
        btCancel.setFont(new Font("Times New Roman", 0, 15));
        btCancel.addActionListener(this);
        btCancel.setActionCommand("Cancel");
        add(btCancel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Cancel")) {
            this.setVisible(false);
            main.setVisible(true);
            this.dispose();
        } else if (e.getActionCommand().equals("Voeg Toe")) {
            try {
                int aantal = Integer.parseInt(tf.getText());
                if (aantal > 0) {
                    if (aantal <= onderdelen.get(list.getSelectedIndex()).getAantal()) {
                        String temp = Integer.toString(aantal) + "x: " + onderdelen.get(list.getSelectedIndex()).getOmschrijving() + "(" + Integer.toString(onderdelen.get(list.getSelectedIndex()).getCode()) + ")";
                        onderdelen.get(list.getSelectedIndex()).setAantal(aantal);
                        main.GiveString(temp, onderdelen.get(list.getSelectedIndex()));
                        this.setVisible(false);
                        main.setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane op = new JOptionPane();
                        op.showMessageDialog(null, "Het gewenste aantal is hoger dan het aanwezige aantal!", "Fout!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane op = new JOptionPane();
                    op.showMessageDialog(null, "Het getal moet hoger dan nul zijn!", "Fout", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
}//GEN-LAST:event_formWindowClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

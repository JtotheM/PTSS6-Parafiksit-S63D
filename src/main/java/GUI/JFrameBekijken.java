package GUI;

import domain.Onderdeel;
import domain.Factuur;
import domain.FactuurRegel;
import domain.Klant;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import java.util.ArrayList;

public class JFrameBekijken extends javax.swing.JFrame implements ActionListener {

    JComboBox jCbSelect;
    ArrayList<Component> componenten;
    ArrayList<Klant> klanten;
    ArrayList<Onderdeel> onderdelen;
    ArrayList<Factuur> facturen;
    String soort;
    JOptionPane op;
    Magazijn main;

    public JFrameBekijken(String soort, ArrayList<Onderdeel> onderdelen, ArrayList<Klant> klanten, ArrayList<Factuur> facturen, Magazijn main) {
        initComponents();
        op = new JOptionPane();
        this.main = main;
        this.setLocation(400, 250);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setTitle("Onderdeel:");
        jBtClose.setText("Sluit Venster");
        componenten = new ArrayList<Component>();
        jCbSelect = new JComboBox();
        jCbSelect.setBounds(20, 20, 200, 20);
        add(jCbSelect);
        jCbSelect.addActionListener(this);
        try {
            this.soort = soort;
            this.onderdelen = onderdelen;
            this.klanten = klanten;
            this.facturen = facturen;
            if (soort.equals("Klant")) {
                for (Klant kl : klanten) {
                    jCbSelect.addItem(Integer.toString(kl.getId()) + ":   " + kl.getNaam());
                }
            } else if (soort.equals("Onderdeel")) {
                for (Onderdeel ond : onderdelen) {
                    jCbSelect.addItem(Integer.toString(ond.getCode()) + ":   " + ond.getOmschrijving());
                }
            } else if (soort.equals("Factuur")) {
                for (Factuur fact : facturen) {
                    jCbSelect.addItem(Integer.toString(fact.getFactuurId()) + ":   " + fact.getDatum());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N
        setResizable(false);

        jBtClose.setName("jBtClose"); // NOI18N
        jBtClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtClose, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(jBtClose, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jBtCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCloseActionPerformed
        main.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jBtCloseActionPerformed

    public void actionPerformed(ActionEvent e) {
        Font font = new Font("Times New Roman", 1, 12);
        for (Component com : componenten) {
            this.remove(com);
        }
        componenten.clear();

        if (soort.equals("Onderdeel")) {
            JLabel lblID = new JLabel("ID:   " + onderdelen.get(jCbSelect.getSelectedIndex()).getCode());
            lblID.setBounds(70, 60, 150, 30);
            lblID.setFont(font);
            componenten.add(lblID);
            add(lblID);

            JLabel lblOmschr = new JLabel("Omschrijving:   " + onderdelen.get(jCbSelect.getSelectedIndex()).getOmschrijving());
            lblOmschr.setBounds(40, 90, 200, 30);
            lblOmschr.setFont(font);
            componenten.add(lblOmschr);
            add(lblOmschr);

            double pRijs = onderdelen.get(jCbSelect.getSelectedIndex()).getPrijs() / 100.00;
            String prijs = String.format("%.2f", pRijs);
            JLabel lbPrijs = new JLabel("Prijs:   €" + prijs);
            lbPrijs.setBounds(80, 150, 150, 30);
            lbPrijs.setFont(font);
            componenten.add(lbPrijs);
            add(lbPrijs);

            JLabel lblAantal = new JLabel("Aantal:   " + onderdelen.get(jCbSelect.getSelectedIndex()).getAantal());
            lblAantal.setBounds(80, 120, 150, 30);
            lblAantal.setFont(font);
            componenten.add(lblAantal);
            add(lblAantal);

            this.setTitle("Onderdeel: " + onderdelen.get(jCbSelect.getSelectedIndex()).getOmschrijving());
        } else if (soort.equals("Klant")) {
            JLabel lblID = new JLabel("ID:   " + klanten.get(jCbSelect.getSelectedIndex()).getId());
            lblID.setBounds(70, 60, 150, 30);
            lblID.setFont(font);
            componenten.add(lblID);
            add(lblID);

            JLabel lbNaam = new JLabel("Naam:   " + klanten.get(jCbSelect.getSelectedIndex()).getNaam());
            lbNaam.setBounds(60, 90, 200, 30);
            lbNaam.setFont(font);
            componenten.add(lbNaam);
            add(lbNaam);

            JLabel lbAdres = new JLabel("Adres:   " + klanten.get(jCbSelect.getSelectedIndex()).getAdres());
            lbAdres.setBounds(60, 120, 150, 30);
            lbAdres.setFont(font);
            componenten.add(lbAdres);
            add(lbAdres);

            this.setTitle("Klant: " + klanten.get(jCbSelect.getSelectedIndex()).getNaam());
        } else if (soort.equals("Factuur")) {
            JLabel lbID = new JLabel("FactuurID:   " + facturen.get(jCbSelect.getSelectedIndex()).getFactuurId());
            lbID.setBounds(40, 40, 150, 30);
            lbID.setFont(font);
            componenten.add(lbID);
            add(lbID);

            JLabel lbKlID = new JLabel("KlantID:   " + facturen.get(jCbSelect.getSelectedIndex()).getKlantId());
            lbKlID.setBounds(40, 60, 150, 30);
            lbKlID.setFont(font);
            componenten.add(lbKlID);
            add(lbKlID);

            JLabel lbDatum = new JLabel("Datum:  " + facturen.get(jCbSelect.getSelectedIndex()).getDatum());
            lbDatum.setBounds(40, 80, 150, 30);
            lbDatum.setFont(font);
            componenten.add(lbDatum);
            add(lbDatum);

            JLabel lbInfo = new JLabel("Onderdelen:");
            lbInfo.setBounds(20, 108, 150, 30);
            lbInfo.setFont(font);
            componenten.add(lbInfo);
            add(lbInfo);

            JList list = new JList();
            list.setBounds(20, 130, 200, 70);
            list.setFont(font);
            for (FactuurRegel rl : facturen.get(jCbSelect.getSelectedIndex()).getOnderdelen()) {
                AddListItem(list, "ID: " + rl.getOnderdeelCode() + "  Aantal: " + rl.getAantal());
            }
            componenten.add(list);
            add(list);

            this.setTitle("Factuur");
        }
        this.repaint();
    }

    private void AddListItem(JList jlist, String Text) {
        Object[] SET = new Object[jlist.getModel().getSize() + 1];
        for (int i = 0; i < jlist.getModel().getSize(); i++) {
            SET[i] = jlist.getModel().getElementAt(i);
        }

        SET[jlist.getModel().getSize()] = Text;
        jlist.setListData(SET);
        jlist.ensureIndexIsVisible(jlist.getModel().getSize() - 1);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtClose;
    // End of variables declaration//GEN-END:variables
}

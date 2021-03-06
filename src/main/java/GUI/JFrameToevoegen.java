package GUI;

import domain.Onderdeel;
import domain.Klant;
import domain.FactuurRegel;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class JFrameToevoegen extends javax.swing.JFrame implements ActionListener {

    private JComboBox jCbSelect;
    private JList list;
    private JOptionPane op;
    private Magazijn main;
    private String soort;
    private ArrayList<Onderdeel> onderdelen;
    private ArrayList<Klant> klanten;
    private Font fontB, fontN;
    private ArrayList<Component> componenten;

    public JFrameToevoegen(String soort, Magazijn main, ArrayList<Klant> klanten) {
        initComponents();
        componenten = new ArrayList<Component>();
        fontB = new Font("Times New Roman", 1, 12);
        fontN = new Font("Times New Roman", 0, 12);
        this.main = main;
        this.setLocation(400, 250);
        this.soort = soort;
        onderdelen = new ArrayList<Onderdeel>();
        this.klanten = klanten;
        jCbSelect = new JComboBox();
        jCbSelect.setBounds(20, 40, 190, 20);
        add(jCbSelect);
        for (Klant kl : klanten) {
            jCbSelect.addItem(kl.getId() + ":  " + kl.getNaam());
        }
        op = new JOptionPane();
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setTitle("Toevoegen:");
        CreateFactuurGUI();
    }

    public JFrameToevoegen(String soort, Magazijn main) {
        componenten = new ArrayList<Component>();
        initComponents();
        fontB = new Font("Times New Roman", 1, 12);
        fontN = new Font("Times New Roman", 0, 12);
        this.main = main;
        this.soort = soort;
        op = new JOptionPane();
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setTitle("Toevoegen:");

        if (soort.equals("Klant")) {
            CreateKlantGUI();
        } else if (soort.equals("Onderdeel")) {
            CreateOnderdeelGUI();
        }
    }

    public void GiveString(String msg, Onderdeel ond) {
        AddListItem(list, msg);
        onderdelen.add(ond);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtClose = new javax.swing.JButton();
        javax.swing.JButton jBtToevoegen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(GUI.MagazijnApplicatieApp.class).getContext().getResourceMap(JFrameToevoegen.class);
        jBtClose.setText(resourceMap.getString("jBtClose.text")); // NOI18N
        jBtClose.setName("jBtClose"); // NOI18N
        jBtClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtCloseActionPerformed(evt);
            }
        });

        jBtToevoegen.setText(resourceMap.getString("jBtToevoegen.text")); // NOI18N
        jBtToevoegen.setName("jBtToevoegen"); // NOI18N
        jBtToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtToevoegenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtToevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtClose, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addComponent(jBtToevoegen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jBtCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtCloseActionPerformed
        main.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jBtCloseActionPerformed


    private void jBtToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtToevoegenActionPerformed
        if (soort.equals("Klant")) {
            try {
                JTextField field = (JTextField) componenten.get(1);
                String naam = field.getText();
                field = (JTextField) componenten.get(2);
                String adres = field.getText();
                int id = main.getMagazijn().VoegKlantToe(naam, adres);
                op.showMessageDialog(null, "De klant is correct toegevoegd aan de database. \r\n Het klantID is: " + id, "Gelukt", JOptionPane.OK_OPTION);
                main.setVisible(true);
                this.setVisible(false);
                this.dispose();
            } catch (Exception e) {
                op.showMessageDialog(null, "De klant is niet correct toegevoegd aan de database. \n\r Controleer de invoerwaardes.", "Fout", JOptionPane.OK_OPTION);
            }
        } else if (soort.equals("Onderdeel")) {
            try {
                JTextField field = (JTextField) componenten.get(1);
                String omschr = field.getText();
                field = (JTextField) componenten.get(2);
                int aantal = Integer.parseInt(field.getText());
                field = (JTextField) componenten.get(3);
                int prijs = Integer.parseInt(field.getText());
                int id = main.getMagazijn().VoegOnderdeelToe(omschr, aantal, prijs);
                op.showMessageDialog(null, "Het onderdeel is correct toegevoegd aan de database. \r\n De onderdeelCode is: " + id, "Gelukt", JOptionPane.OK_OPTION);
                main.setVisible(true);
                this.setVisible(false);
                this.dispose();
            } catch (Exception e) {
                op.showMessageDialog(null, "Het onderdeel is niet correct toegevoegd aan de database. \n\r Controleer de invoerwaardes.", "Fout", JOptionPane.OK_OPTION);
            }
        } else if (soort.equals("Factuur")) {
            try {
                ArrayList<FactuurRegel> ondrd = new ArrayList<FactuurRegel>();
                for (int i = 0; i < list.getModel().getSize(); i++) {
                    ondrd.add(new FactuurRegel(-1, onderdelen.get(i).getCode(), onderdelen.get(i).getAantal()));
                }
                int id = main.getMagazijn().VoegFactuurToe(klanten.get(jCbSelect.getSelectedIndex()).getId(), ondrd);
                op.showMessageDialog(null, "Het onderdeel is correct toegevoegd aan de database. \r\n Het factuurID is: " + id, "Gelukt", JOptionPane.OK_OPTION);
                main.setVisible(true);
                this.setVisible(false);
                this.dispose();
            } catch (Exception e) {
                op.showMessageDialog(null, "De factuur is niet correct toegevoegd aan de database. \n\r Controleer de invoerwaardes.", "Fout", JOptionPane.OK_OPTION);
            }
        }
    }//GEN-LAST:event_jBtToevoegenActionPerformed

    private void CreateOnderdeelGUI() {
        componenten.clear();
        JLabel lbInfo = new JLabel("Nieuw onderdeel aanmaken:");
        lbInfo.setBounds(20, 40, 250, 30);
        lbInfo.setFont(new Font("Times New Roman", 1, 15));
        add(lbInfo);
        componenten.add(lbInfo);

        JLabel lbOmschr = new JLabel("Omschr:");
        lbOmschr.setBounds(49, 90, 80, 30);
        lbOmschr.setFont(fontB);
        add(lbOmschr);
        componenten.add(lbOmschr);

        JLabel lbAantal = new JLabel("Aantal:");
        lbAantal.setBounds(50, 120, 80, 30);
        lbAantal.setFont(fontB);
        add(lbAantal);
        componenten.add(lbAantal);

        JLabel lbPrijs = new JLabel("Prijs in centen:");
        lbPrijs.setBounds(15, 150, 80, 30);
        lbPrijs.setFont(fontB);
        add(lbPrijs);
        componenten.add(lbPrijs);

        JTextField tfOmschr = new JTextField();
        tfOmschr.setBounds(90, 92, 100, 20);
        tfOmschr.setFont(fontN);
        add(tfOmschr);
        componenten.add(1, tfOmschr);

        JTextField tfAantal = new JTextField();
        tfAantal.setBounds(90, 122, 100, 20);
        tfAantal.setFont(fontN);
        add(tfAantal);
        componenten.add(2, tfAantal);

        JTextField tfPrijs = new JTextField();
        tfPrijs.setBounds(90, 152, 100, 20);
        tfPrijs.setFont(fontN);
        add(tfPrijs);
        componenten.add(3, tfPrijs);
    }

    private void CreateKlantGUI() {
        componenten.clear();
        JLabel lbInfo = new JLabel("Nieuwe klant aanmaken:");
        lbInfo.setBounds(20, 40, 250, 30);
        lbInfo.setFont(new Font("Times New Roman", 1, 15));
        add(lbInfo);
        componenten.add(lbInfo);

        JLabel lbNaam = new JLabel("Naam:");
        lbNaam.setBounds(28, 90, 80, 30);
        lbNaam.setFont(fontB);
        add(lbNaam);
        componenten.add(lbNaam);

        JLabel lbAdres = new JLabel("Adres:");
        lbAdres.setBounds(27, 120, 80, 30);
        lbAdres.setFont(fontB);
        add(lbAdres);
        componenten.add(lbAdres);

        JTextField tfNaam = new JTextField();
        tfNaam.setBounds(70, 92, 150, 20);
        tfNaam.setFont(fontN);
        add(tfNaam);
        componenten.add(1, tfNaam);

        JTextField tfAdres = new JTextField();
        tfAdres.setBounds(70, 122, 150, 20);
        tfAdres.setFont(fontN);
        add(tfAdres);
        componenten.add(2, tfAdres);
    }

    private void CreateFactuurGUI() {
        componenten.clear();
        JLabel lbInfo = new JLabel("Selecteer de klant:");
        lbInfo.setBounds(40, 5, 250, 30);
        lbInfo.setFont(new Font("Times New Roman", 1, 15));
        add(lbInfo);
        componenten.add(lbInfo);

        list = new JList();
        list.setBounds(10, 70, 208, 100);
        list.setFont(fontN);
        add(list);
        componenten.add(list);

        JButton bt = new JButton();
        bt.setBounds(10, 175, 100, 20);
        bt.setFont(fontN);
        bt.setText("Regel +");
        bt.addActionListener(this);
        bt.setActionCommand("RegelToevoegen");
        add(bt);
        componenten.add(bt);

        JButton btr = new JButton();
        btr.setBounds(120, 175, 100, 20);
        btr.setFont(fontN);
        btr.setText("Reset List");
        btr.addActionListener(this);
        btr.setActionCommand("Reset");
        add(btr);
        componenten.add(btr);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtClose;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("RegelToevoegen")) {
            JFrameFactuurRegelToevoegen frt = new JFrameFactuurRegelToevoegen(this, main.getMagazijn().GetOnderdelen());
            frt.setVisible(true);
            this.setVisible(false);
        } else if (e.getActionCommand().equals("Reset")) {
            ClearList(list);
        }
    }

    private void ClearList(JList jlist) {
        Object[] SET = new Object[0];
        jlist.setListData(SET);
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
}

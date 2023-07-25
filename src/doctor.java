import com.sun.glass.events.KeyEvent;
import java.util.logging.Logger;
import com.sun.glass.events.*;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.*;
import static javax.swing.UIManager.getString;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;
public class doctor extends javax.swing.JFrame {
Connection conn;
    Statement stm;
    ResultSet Rs;
    PreparedStatement pst ;
    PreparedStatement pt ;
    static String test;
    String tlf, nom, prenom, d, deb,fin,com;
    DefaultTableModel model = new DefaultTableModel();
 DefaultTableModel m = new DefaultTableModel();
 DefaultTableModel mo = new DefaultTableModel();
 DefaultTableModel ma = new DefaultTableModel();
 DefaultTableModel modele = new DefaultTableModel();
 DefaultTableModel mode = new DefaultTableModel();
 
 public doctor() {
        initComponents();
        model.addColumn("Numéro_de_patient");
        model.addColumn("nom");
        model.addColumn("prenom");
        model.addColumn("date_naissance");
        model.addColumn("adresse");
        model.addColumn("telephone");
        model.addColumn("sexe");
       try{ //Rs.getInt("id"),
            Connect();
             stm = conn.createStatement();
         ResultSet Rs= stm.executeQuery("Select * from medecin2");
        while(Rs.next()){
            model.addRow(new Object[]{Rs.getInt("Numéro_de_patient"),Rs.getString("nom"),
            Rs.getString("prenom"),Rs.getDate("date_naissance"), Rs.getString("adresse")
            , Rs.getInt("telephone"), Rs.getString("sexe")});
        }
        }catch(Exception e){System.err.println(e);}
        pat_tab1.setModel(model); 
        consultation();
        rdv();
         setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\Cabinet_medical\\src\\img\\icons8-tête-avec-cerveau-64.png"));
         setTitle("MiroudMed");
        ordonnance();
        afficher_rdv();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\CLINIC PC\\Documents\\NetBeansProjects\\projet\\Cabinet_medical\\src\\img\\catt.jpg").getImage().getScaledInstance(1344, 643, Image.SCALE_DEFAULT));
      jLabel11.setIcon(imageIcon);
    }
 
    
 public void Connect(){
        try{
             Class.forName("com.mysql.jdbc.Driver");
             conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/univ","root","");
             System.out.println("Connection Etablie");
        }catch(Exception e){
            System.out.println("Erreur de connection");
            e.printStackTrace();
        }
    }
 
 
 public void consultation(){
       m.addColumn("Numero_consultation");
        m.addColumn("nom");
        m.addColumn("prenom");
        m.addColumn("date_naissance");
        m.addColumn("date");
        m.addColumn("consultation");
        m.addColumn("description");
       /* m.addColumn("image1");
        m.addColumn("image2");
        m.addColumn("image3");
        m.addColumn("image4");
        m.addColumn("image5");
        m.addColumn("image6");
        m.addColumn("image7");
        m.addColumn("image8");
        m.addColumn("image9");
        m.addColumn("image10");
        m.addColumn("image11");
        m.addColumn("image12");
        m.addColumn("image13");
        m.addColumn("image14");
        m.addColumn("image15");
        m.addColumn("image16");*/
        m.addColumn("ordonnance");
        
          try{
            Connect();
             stm = conn.createStatement();
         ResultSet Rs= stm.executeQuery("Select * from consultation");
        while(Rs.next()){
               m.addRow(new Object[]{Rs.getInt("Numero_consultation"),Rs.getString("nom"),Rs.getString("prenom"),
              Rs.getString("date_naissance"),Rs.getString("date"),Rs.getString("consultation"),Rs.getString("description")
                      /* ,Rs.getString("image1"),Rs.getString("image2"),Rs.getString("image3")
                       ,Rs.getString("image4"),Rs.getString("image5"),Rs.getString("image6")
                       ,Rs.getString("image7"),Rs.getString("image8"),Rs.getString("image9")
                       ,Rs.getString("image10"),Rs.getString("image11"),Rs.getString("image12")
                       ,Rs.getString("image13"),Rs.getString("image14"),Rs.getString("image15")
                       ,Rs.getString("image16")*/,Rs.getString("ordonnance")});
            }
        }catch(Exception e){System.err.println(e);}
       cons_tab.setModel(m);
 }
 public void afficher_cons(){
     try{
            Connect();
             m.setRowCount(0);
             stm = conn.createStatement();
             ResultSet Rs= stm.executeQuery("Select * from consultation ");
            while(Rs.next()){
               m.addRow(new Object[]{Rs.getInt("Numero_consultation"),Rs.getString("nom"),Rs.getString("prenom"),
              Rs.getString("date_naissance"),Rs.getString("date"),Rs.getString("consultation"),Rs.getString("description")
                       /*,Rs.getString("image1"),Rs.getString("image2"),Rs.getString("image3")
                       ,Rs.getString("image4"),Rs.getString("image5"),Rs.getString("image6")
                       ,Rs.getString("image7"),Rs.getString("image8"),Rs.getString("image9")
                       ,Rs.getString("image10"),Rs.getString("image11"),Rs.getString("image12")
                       ,Rs.getString("image13"),Rs.getString("image14"),Rs.getString("image15")
                       ,Rs.getString("image16")*/,Rs.getString("ordonnance")});
           }
       }catch(Exception e){
           System.err.println(e);
       }
       cons_tab.setModel(m);
 }
  private void deplace_cons(int i){
        try{
           
            Connect();
            String table_click = (cons_tab.getModel().getValueAt(i, 0).toString());
            String sql = "select * from consultation where Numero_consultation='"+table_click+"' ";
            stm = conn.createStatement();
              Rs = stm.executeQuery(sql);
              int selectioner = cons_tab.getSelectedRow();
             DefaultTableModel modele = (DefaultTableModel) cons_tab.getModel();
              
              if(Rs.next()){
                  /*String add1= Rs.getString("num_consultation");
                  txtnumcons.setText(add1);*/
                  String add2= Rs.getString("nom");
                  txtid_pat1.setText(add2);
                  txtnom2.setText(add2);
                  String add3= Rs.getString("prenom");
                  txtmotif1.setText(add3);
                  txtprenom4.setText(add3);
                 String add4= Rs.getString("date_naissance");
                  txtmotif2.setText(add4);
                  String add1= Rs.getString("age");
                  age1.setText(add1);
                  String add5= Rs.getString("date");
                  txtdate_cons.setText(add5);
                  Date1.setText(modele.getValueAt(selectioner, 3).toString());
                 String add6= Rs.getString("consultation");
                  txtarea1.setText(add6);
                 String add7= Rs.getString("description");
                  txtarea.setText(add7);
                 imagedata1 = Rs.getString("image1");
                  format = new ImageIcon(imagedata1);
                java.awt.Image in= format.getImage();
                java.awt.Image ff = in.getScaledInstance(l1.getWidth(),l1.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg = new ImageIcon(ff);
                l1.setIcon(imggg);
                   imagedata2 = Rs.getString("image2");
                  format1 = new ImageIcon(imagedata2);
                java.awt.Image in1= format1.getImage();
                java.awt.Image ff1 = in1.getScaledInstance(l2.getWidth(), l2.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg1 = new ImageIcon(ff1);
                l2.setIcon(imggg1);
                
                 imagedata3 = Rs.getString("image3");
                  format2 = new ImageIcon(imagedata3);
                java.awt.Image in2= format2.getImage();
                java.awt.Image ff2 = in2.getScaledInstance(l3.getWidth(), l3.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg2 = new ImageIcon(ff2);
                l3.setIcon(imggg2);
                imagedata4 = Rs.getString("image4");
                  format3 = new ImageIcon(imagedata4);
                java.awt.Image in3= format3.getImage();
                java.awt.Image ff3 = in3.getScaledInstance(l4.getWidth(), l4.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg3 = new ImageIcon(ff3);
                 l4.setIcon(imggg3);
                
                 imagedata5 = Rs.getString("image5");
                  format4 = new ImageIcon(imagedata5);
                java.awt.Image in4= format4.getImage();
                java.awt.Image ff4= in4.getScaledInstance(l5.getWidth(), l5.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg4 = new ImageIcon(ff4);
                l5.setIcon(imggg4);
                
                 imagedata6 = Rs.getString("image6");
                  format5 = new ImageIcon(imagedata6);
                java.awt.Image in5= format5.getImage();
                java.awt.Image ff5 = in5.getScaledInstance(l6.getWidth(), l6.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg5 = new ImageIcon(ff5);
                l6.setIcon(imggg5);
                
                imagedata7 = Rs.getString("image7");
                  format6= new ImageIcon(imagedata7);
                java.awt.Image in6= format6.getImage();
                java.awt.Image ff6 = in6.getScaledInstance(l7.getWidth(), l7.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg6 = new ImageIcon(ff6);
                l7.setIcon(imggg6);
                
               imagedata8 = Rs.getString("image8");
                  format7 = new ImageIcon(imagedata8);
                java.awt.Image in7= format7.getImage();
                java.awt.Image ff7 = in7.getScaledInstance(l8.getWidth(), l8.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg7 = new ImageIcon(ff7);
                l8.setIcon(imggg7);
                
                 imagedata9 = Rs.getString("image9");
                  format8 = new ImageIcon(imagedata9);
                java.awt.Image in8= format8.getImage();
                java.awt.Image ff8 = in8.getScaledInstance(l9.getWidth(), l9.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg8 = new ImageIcon(ff8);
                l9.setIcon(imggg8);
                
                imagedata10 = Rs.getString("image10");
                  format9 = new ImageIcon(imagedata10);
                java.awt.Image in9= format9.getImage();
                java.awt.Image ff9 = in9.getScaledInstance(l10.getWidth(), l10.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg9 = new ImageIcon(ff9);
                l10.setIcon(imggg9);
                
                 imagedata11 = Rs.getString("image11");
                  format10 = new ImageIcon(imagedata11);
                java.awt.Image in10= format10.getImage();
                java.awt.Image ff10 = in10.getScaledInstance(l11.getWidth(), l11.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg10 = new ImageIcon(ff10);
                l11.setIcon(imggg10);
                
                imagedata12 = Rs.getString("image12");
                  format11 = new ImageIcon(imagedata12);
                java.awt.Image in11= format11.getImage();
                java.awt.Image ff11 = in11.getScaledInstance(l12.getWidth(), l12.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg11= new ImageIcon(ff11);
                l12.setIcon(imggg11);
                
                 imagedata13 = Rs.getString("image13");
                  format12 = new ImageIcon(imagedata13);
                java.awt.Image in12= format12.getImage();
                java.awt.Image ff12 = in12.getScaledInstance(l13.getWidth(), l13.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg12 = new ImageIcon(ff12);
                l13.setIcon(imggg12);
                
                imagedata14 = Rs.getString("image14");
                  format13 = new ImageIcon(imagedata14);
                java.awt.Image in13= format13.getImage();
                java.awt.Image ff13 = in13.getScaledInstance(l14.getWidth(), l14.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg13 = new ImageIcon(ff13);
                l14.setIcon(imggg13);
                
                 imagedata15 = Rs.getString("image15");
                  format14 = new ImageIcon(imagedata15);
                java.awt.Image in14= format14.getImage();
                java.awt.Image ff14 = in14.getScaledInstance(l15.getWidth(), l15.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg14 = new ImageIcon(ff14);
                l15.setIcon(imggg14);
                
                imagedata16 = Rs.getString("image16");
                  format15 = new ImageIcon(imagedata16);
                java.awt.Image in15= format15.getImage();
                java.awt.Image ff15 = in15.getScaledInstance(l16.getWidth(), l16.getHeight(),java.awt.Image.SCALE_SMOOTH );
                 ImageIcon imggg15 = new ImageIcon(ff15);
                l16.setIcon(imggg15);
                
                String add8 = Rs.getString("ordonnance");
                ord1.setText(add8);
              }
       }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"erreur de deplacement"+e.getLocalizedMessage());
        }
    }
    
    public void ordonnance(){
       modele.addColumn("Numero_ordonnance");
        modele.addColumn("nom");
        modele.addColumn("prenom");
        modele.addColumn("telephone");
        modele.addColumn("date_naissance");
       // modele.addColumn("age");
        modele.addColumn("date");
        modele.addColumn("ordonnance");
      try{
            Connect();
             stm = conn.createStatement();
         ResultSet Rs= stm.executeQuery("Select * from ordonnance");
        while(Rs.next()){
            modele.addRow(new Object[]{Rs.getInt("Numero_ordonnance"),Rs.getString("nom"),Rs.getString("prenom"),Rs.getInt("telephone")
                       ,Rs.getDate("date_naissance") ,Rs.getDate("date"),Rs.getString("ordonnance")});
            }
        }catch(Exception e){System.err.println(e);}
        ord_table.setModel(modele); 
    }
     //pour afficher les donnees de table médicament
    
//--------------------------- AFFICHER LED DONNES DE TABLEAU ORDONNANCE :ID,NOM,PRENOM,SA ORDONNANCE MEDICAL  ---------------------------------
  public void afficher_ordonnance(){
       try{
            Connect();
             modele.setRowCount(0);
             stm = conn.createStatement();
             ResultSet Rs= stm.executeQuery("Select * from ordonnance");
        while(Rs.next()){
                modele.addRow(new Object[]{Rs.getInt("Numero_ordonnance"),Rs.getString("nom"),Rs.getString("prenom"),Rs.getInt("telephone")
                       ,Rs.getDate("date_naissance") ,Rs.getDate("date"),Rs.getString("ordonnance")});
            }
       }catch(Exception e){
          System.err.println(e);
       }
        ord_table.setModel(modele);
    }
 //----------------------------------------  POUR IMPORTER UN ORDENNANCE --------------------------------------------------
    public void readFile (String filePath){
 BufferedReader reader;
     FileReader in;
     String ligne;
     try {
           in= new FileReader(new File(filePath));
           reader= new BufferedReader(in);
         do{
             ligne=reader.readLine();
             if(ligne!=null)
             ord.setText(ord.getText()+ligne+"\n");
         }while(ligne!=null);
     } catch (Exception e) {
     }

 }
   public void rdv(){
        ma.addColumn("Numero_de_RDV");
        ma.addColumn("Nom");
        ma.addColumn("prenom");
        ma.addColumn("telephone");
        ma.addColumn("Date_RDV");
        ma.addColumn("Commentaire");
        
        try{
            Connect();
           stm = conn.createStatement();
           ResultSet Rs= stm.executeQuery("Select * from rdv");
           while(Rs.next()){
            ma.addRow(new Object[]{Rs.getInt("Numero_de_RDV"),Rs.getString("Nom"),Rs.getString("prenom"),
                       Rs.getInt("telephone"),Rs.getDate("Date_RDV")
                        ,Rs.getString("Commentaire")});
        }
        }catch(Exception e){
            System.err.println(e);
        }
        rdv_tab.setModel(ma);
   }
   public void afficher_rdv(){
       try{
            
             Connect();
             ma.setRowCount(0);
             stm = conn.createStatement();
             ResultSet Rs= stm.executeQuery("Select * from rdv ");
        while(Rs.next()){
          ma.addRow(new Object[]{Rs.getInt("Numero_de_RDV"),Rs.getString("Nom"),Rs.getString("prenom"),
                       Rs.getInt("telephone"),Rs.getDate("Date_RDV")
                        ,Rs.getString("Commentaire")});
        }
        }catch(Exception e){System.err.println(e);}
        rdv_tab.setModel(ma);
   }
   public void deplace_rdv(int i){
        try{
            Connect(); 
            String table_click = (rdv_tab.getModel().getValueAt(i, 0).toString());
            
            String sql = "select * from rdv where Numero_de_RDV='"+ table_click+"'  ";
            stm = conn.createStatement();
              Rs = stm.executeQuery(sql);
              
             int selectioner =rdv_tab.getSelectedRow();
             DefaultTableModel model = (DefaultTableModel) rdv_tab.getModel();
             num_rdv.setText(model.getValueAt(selectioner, 0).toString());
             txtprenom1.setText(model.getValueAt(selectioner, 1).toString());
             txtprenom3.setText(model.getValueAt(selectioner, 2).toString());
             txtprenom2.setText(model.getValueAt(selectioner, 3).toString());
             if(Rs.next()){
              Date add4= Rs.getDate("Date_RDV");
              txtdaterdv1.setDate(add4);
             }
            
             txtcom1.setText(model.getValueAt(selectioner, 5).toString());
        }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"erreur de deplacement"+e.getLocalizedMessage());
        }
   }
    public void deplace_ord(int i){
         try{
            Connect();
            /*int selectioner = ord_table.getSelectedRow();
             DefaultTableModel modele = (DefaultTableModel) ord_table.getModel();
             txtnom.setText(modele.getValueAt(selectioner, 1).toString());
             txtprenom.setText(modele.getValueAt(selectioner, 2).toString());
             age.setText(modele.getValueAt(selectioner, 5).toString());
             Date.setText(modele.getValueAt(selectioner, 6).toString());
             //ord.setText(modele.getValueAt(selectioner, 5).toString());
              ord.setText(modele.getValueAt(selectioner, 7).toString());
           */
              String table_click = (ord_table.getModel().getValueAt(i, 0).toString());
              String sql = "select * from ordonnance where Numero_ordonnance='"+table_click+"' ";
             stm = conn.createStatement();
              Rs = stm.executeQuery(sql);
              if(Rs.next()){
                  String add1= Rs.getString("nom");
                  txtnom.setText(add1);
                   String add2= Rs.getString("prenom");
                   txtprenom.setText(add2);
                   String add4= Rs.getString("date");
                   Date.setText(add4);
                   String add5= Rs.getString("age");
                   age.setText(add5);
                   String add6= Rs.getString("ordonnance");
                   ord.setText(add6);
              }
            }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"erreur de deplacement"+e.getLocalizedMessage());
        
        }
       
    }
   
    //pour deplacer les informations des patient dans le formulaire 
   public void deplace(int i){
       try{
             Connect();
            /* String table_click = (pat_tab1.getModel().getValueAt(i, 0).toString());
              String sql = "select * from medecin2 where id='"+table_click+"' ";
             stm = conn.createStatement();
              Rs = stm.executeQuery(sql);
              
             int selectioner = pat_tab1.getSelectedRow();
             DefaultTableModel modele = (DefaultTableModel)  pat_tab1.getModel();
             txtnom1.setText(modele.getValueAt(selectioner, 0).toString());
             txtpre1.setText(modele.getValueAt(selectioner, 1).toString());
             
             //txtdate1.setDate(modele.getValueAt(selectioner, 6).toString());
             if(Rs.next()){
                 Date add4= Rs.getDate("date_naiss");
                   txtdate1.setDate(add4);
             }
             txtadrss1.setText(modele.getValueAt(selectioner, 3).toString());
              txttlf1.setText(modele.getValueAt(selectioner, 4).toString());
             jComboBox1.setSelectedItem(modele.getValueAt(selectioner, 5).toString());
             */
           String table_click = (pat_tab1.getModel().getValueAt(i, 0).toString());
              String sql = "select * from medecin2 where Numéro_de_patient='"+table_click+"'";
             stm = conn.createStatement();
              Rs = stm.executeQuery(sql);
              if(Rs.next()){
                  String add1= Rs.getString("Numéro_de_patient");
                  num_pat.setText(add1);
                   String add2= Rs.getString("nom");
                   txtnom1.setText(add2);
                   String add3= Rs.getString("prenom");
                   txtpre1.setText(add3);
                   Date add4= Rs.getDate("date_naissance");
                   txtdaterdv1.setDate(add4);
                   String add5= Rs.getString("adresse");
                   txtadrss1.setText(add5);
                   String add6= Rs.getString("telephone");
                   txttlf1.setText(add6);
                   String add7= Rs.getString("sexe");
                   jComboBox1.setSelectedItem(add7);
                } 
            }catch(Exception e){
                   System.err.println(e);
                    JOptionPane.showMessageDialog(null,"erreur d deplacement"+e.getLocalizedMessage());
        }
    }
   
  public void afficher(){
         try{
             Connect();
          model.setRowCount(0);
        stm = conn.createStatement();
       ResultSet Rs= stm.executeQuery("Select * from medecin2");
        while(Rs.next()){
            model.addRow(new Object[]{Rs.getInt("Numéro_de_patient"),Rs.getString("nom"),
           Rs.getString("prenom"),Rs.getString("date_naissance"), Rs.getString("adresse")
            , Rs.getInt("telephone"), Rs.getString("sexe")});
        }
        }catch(Exception e){System.err.println(e);}
        pat_tab1.setModel(model); 
       }
private void actualiser(){
    num_pat.setText("Auto Généré");
    txtnom1.setText("");
    txtpre1.setText("");
    txtdaterdv1.setDate(null);
    txtadrss1.setText("");
    txttlf1.setText("");
    jRadioButton1.setActionCommand(null);
    if(jRadioButton2.isSelected()){
    jRadioButton2.setSelected(false);
}
    jRadioButton3.setSelected(false);
   
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        principale = new javax.swing.JPanel();
        id = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtnom1 = new javax.swing.JTextField();
        txtpre1 = new javax.swing.JTextField();
        txtadrss1 = new javax.swing.JTextField();
        txttlf1 = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        num_pat = new javax.swing.JTextField();
        txtdaterdv1 = new com.toedter.calendar.JDateChooser();
        jScrollPane11 = new javax.swing.JScrollPane();
        pat_tab1 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jButton33 = new javax.swing.JButton();
        reach_pat1 = new javax.swing.JComboBox();
        jPanel16 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        txtre1 = new javax.swing.JTextField();
        jButton24 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel17 = new javax.swing.JPanel();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        ordonnance = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ord_table = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        pSearchField1 = new javax.swing.JTextField();
        rechrcherUnOrdonnanceDePatient = new javax.swing.JButton();
        dellet1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Date = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ord = new javax.swing.JTextArea();
        txtprenom = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        consultation = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        cons = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        txtid_pat1 = new javax.swing.JTextField();
        txtmotif1 = new javax.swing.JTextField();
        txtdate_cons = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        txtarea1 = new javax.swing.JTextArea();
        txtmotif2 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        cons_tab = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        txtre = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        pic = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtarea = new javax.swing.JTextArea();
        jPanel13 = new javax.swing.JPanel();
        l6 = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();
        l8 = new javax.swing.JLabel();
        l9 = new javax.swing.JLabel();
        l10 = new javax.swing.JLabel();
        l11 = new javax.swing.JLabel();
        l12 = new javax.swing.JLabel();
        l13 = new javax.swing.JLabel();
        l14 = new javax.swing.JLabel();
        l15 = new javax.swing.JLabel();
        l16 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        l4 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel12 = new javax.swing.JLabel();
        v_ord = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        Date1 = new javax.swing.JTextField();
        age1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ord1 = new javax.swing.JTextArea();
        txtprenom4 = new javax.swing.JTextField();
        txtnom2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        rdv_tab = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        rdv = new javax.swing.JTextField();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jPanel22 = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtcom1 = new javax.swing.JTextArea();
        txtprenom1 = new javax.swing.JTextField();
        num_rdv = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtprenom2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtprenom3 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        addUser = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1339, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );

        jTabbedPane3.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane3.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jTabbedPane3.setPreferredSize(new java.awt.Dimension(1210, 2555));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Acceuil", new javax.swing.ImageIcon(getClass().getResource("/img/icons8-top-menu-80.png")), jPanel9); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        jButton9.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton9.setText("Identité");
        jButton9.setAutoscrolls(true);
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setPreferredSize(new java.awt.Dimension(200, 109));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        jButton10.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton10.setText("Consultation");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setPreferredSize(new java.awt.Dimension(200, 109));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton10);

        jButton12.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton12.setText("Ordonnance");
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setPreferredSize(new java.awt.Dimension(200, 109));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton12);

        principale.setLayout(new java.awt.CardLayout());

        id.setBackground(new java.awt.Color(255, 255, 255));
        id.setPreferredSize(new java.awt.Dimension(1576, 1576));
        id.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "info patient", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 3, 18), new java.awt.Color(0, 153, 255))); // NOI18N
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("        N°");
        jPanel24.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 60, 30));

        jLabel39.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel39.setText("Prénom");
        jPanel24.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("Adresse");
        jPanel24.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, 30));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("Télephone");
        jPanel24.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 20));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setText("Sexe");
        jPanel24.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, -1, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Date de naissance");
        jPanel24.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 30));

        txtnom1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnom1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnom1KeyReleased(evt);
            }
        });
        jPanel24.add(txtnom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 199, 28));

        txtpre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpre1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpre1KeyReleased(evt);
            }
        });
        jPanel24.add(txtpre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 199, 28));

        txtadrss1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadrss1ActionPerformed(evt);
            }
        });
        txtadrss1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtadrss1KeyReleased(evt);
            }
        });
        jPanel24.add(txtadrss1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 199, 28));

        txttlf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttlf1ActionPerformed(evt);
            }
        });
        txttlf1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txttlf1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttlf1KeyReleased(evt);
            }
        });
        jPanel24.add(txttlf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 199, 28));
        jPanel24.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 200, 30));
        jPanel24.add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 220, 30));

        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel2KeyReleased(evt);
            }
        });
        jPanel24.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 200, 30));

        jComboBox1.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Femme", "Male" }));
        jPanel24.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 199, 28));
        jPanel24.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 200, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("Nom");
        jPanel24.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, 40));

        num_pat.setEditable(false);
        num_pat.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        num_pat.setText("       Auto Générer");
        jPanel24.add(num_pat, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 200, 28));
        jPanel24.add(txtdaterdv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 200, -1));

        id.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 390, 450));

        pat_tab1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(0, 153, 255))); // NOI18N
        pat_tab1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "nom", "prenom", "Date_naissance", "adresse ", "telephone ", "sex"
            }
        ));
        pat_tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pat_tab1MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(pat_tab1);

        id.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 870, 170));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel11.setLayout(null);

        jButton33.setBackground(new java.awt.Color(255, 255, 255));
        jButton33.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/act.png"))); // NOI18N
        jButton33.setText("Actualiser");
        jButton33.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(51, 153, 255))); // NOI18N
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton33);
        jButton33.setBounds(227, 18, 138, 35);

        reach_pat1.setEditable(true);
        reach_pat1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                reach_pat1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        reach_pat1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reach_pat1KeyPressed(evt);
            }
        });
        jPanel11.add(reach_pat1);
        reach_pat1.setBounds(12, 22, 165, 26);

        id.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel16.setLayout(null);

        jButton5.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/act.png"))); // NOI18N
        jButton5.setText("Actualiser");
        jButton5.setPreferredSize(new java.awt.Dimension(136, 35));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton5);
        jButton5.setBounds(286, 15, 136, 35);

        txtre1.setToolTipText("le recherche est par le nom ,la date de naissance ou le numéro de téléphone"); // NOI18N
        txtre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtre1KeyPressed(evt);
            }
        });
        jPanel16.add(txtre1);
        txtre1.setBounds(10, 20, 180, 30);

        jButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_xmag_8826.png"))); // NOI18N
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton24);
        jButton24.setBounds(200, 20, 50, 30);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Nom");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jPanel16.add(jRadioButton1);
        jRadioButton1.setBounds(20, 60, 70, 29);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("date de naissance");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });
        jPanel16.add(jRadioButton2);
        jRadioButton2.setBounds(90, 60, 130, 29);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Numéro de Téléphone");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });
        jPanel16.add(jRadioButton3);
        jRadioButton3.setBounds(220, 60, 160, 29);

        id.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 440, 90));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(0, 102, 255))); // NOI18N

        jButton28.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        jButton28.setText("Suppprimer");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pen.png"))); // NOI18N
        jButton29.setText("Modifier");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        jButton4.setText("Ajouter");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        id.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 490, 60));

        jButton2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        jButton2.setText("Nouvelle consultation");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        id.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 100, 240, 40));

        jButton11.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        jButton11.setText("Nouveau Rendez-vous");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        id.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 50, 240, 40));

        principale.add(id, "card2");

        ordonnance.setBackground(new java.awt.Color(255, 255, 255));
        ordonnance.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Les Ordonnances", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 3, 18), new java.awt.Color(0, 153, 255))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ord_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nom", "Prenom", "ordonnance"
            }
        ));
        ord_table.setGridColor(new java.awt.Color(255, 255, 255));
        ord_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ord_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ord_table);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 660, 150));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel25.setLayout(null);

        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        jPanel25.add(jLabel15);
        jLabel15.setBounds(195, 22, 0, 26);

        pSearchField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pSearchField1.setToolTipText("le recherche est par le nom ,la date de naissance , la date ou le numéro de téléphone");
        pSearchField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pSearchField1ActionPerformed(evt);
            }
        });
        pSearchField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pSearchField1KeyPressed(evt);
            }
        });
        jPanel25.add(pSearchField1);
        pSearchField1.setBounds(10, 10, 276, 30);

        rechrcherUnOrdonnanceDePatient.setBackground(new java.awt.Color(255, 255, 255));
        rechrcherUnOrdonnanceDePatient.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rechrcherUnOrdonnanceDePatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/if_xmag_8826.png"))); // NOI18N
        rechrcherUnOrdonnanceDePatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rechrcherUnOrdonnanceDePatientMouseClicked(evt);
            }
        });
        rechrcherUnOrdonnanceDePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechrcherUnOrdonnanceDePatientActionPerformed(evt);
            }
        });
        jPanel25.add(rechrcherUnOrdonnanceDePatient);
        rechrcherUnOrdonnanceDePatient.setBounds(290, 10, 50, 30);

        dellet1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dellet1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/trash.png"))); // NOI18N
        dellet1.setText("Supprimer");
        dellet1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dellet1MouseClicked(evt);
            }
        });
        dellet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dellet1ActionPerformed(evt);
            }
        });
        jPanel25.add(dellet1);
        dellet1.setBounds(350, 10, 136, 35);

        jButton1.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/act.png"))); // NOI18N
        jButton1.setText("Actualiser");
        jButton1.setPreferredSize(new java.awt.Dimension(136, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel25.add(jButton1);
        jButton1.setBounds(500, 10, 136, 35);

        buttonGroup3.add(jRadioButton7);
        jRadioButton7.setText("Nom");
        jRadioButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton7MouseClicked(evt);
            }
        });
        jPanel25.add(jRadioButton7);
        jRadioButton7.setBounds(10, 50, 60, 29);

        buttonGroup3.add(jRadioButton8);
        jRadioButton8.setText("Date de naissance");
        jRadioButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton8MouseClicked(evt);
            }
        });
        jPanel25.add(jRadioButton8);
        jRadioButton8.setBounds(70, 50, 130, 29);

        buttonGroup3.add(jRadioButton9);
        jRadioButton9.setText("Date");
        jRadioButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton9MouseClicked(evt);
            }
        });
        jPanel25.add(jRadioButton9);
        jRadioButton9.setBounds(200, 50, 60, 29);

        buttonGroup3.add(jRadioButton10);
        jRadioButton10.setText("Numéro de téléphone");
        jRadioButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton10MouseClicked(evt);
            }
        });
        jPanel25.add(jRadioButton10);
        jRadioButton10.setBounds(260, 50, 170, 29);

        jPanel7.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 650, 80));

        ordonnance.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 680, 290));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Ordonnance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 3, 18), new java.awt.Color(0, 153, 255))); // NOI18N

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(null);

        jLabel31.setFont(new java.awt.Font("Georgia", 2, 25)); // NOI18N
        jLabel31.setText("Cabinet Médical - Neurochirurgie .");
        panel.add(jLabel31);
        jLabel31.setBounds(83, 5, 395, 39);

        jLabel3.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        jLabel3.setText("  Dr.Miroud M.N");
        panel.add(jLabel3);
        jLabel3.setBounds(10, 60, 134, 17);

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panel.add(jSeparator2);
        jSeparator2.setBounds(10, 50, 505, 15);

        jLabel16.setFont(new java.awt.Font("Georgia", 2, 13)); // NOI18N
        jLabel16.setText("Neurochirurgien.");
        panel.add(jLabel16);
        jLabel16.setBounds(20, 80, 109, 15);

        jLabel17.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        jLabel17.setText("Consultation sur RDV");
        panel.add(jLabel17);
        jLabel17.setBounds(0, 110, 147, 17);

        jLabel18.setFont(new java.awt.Font("Georgia", 2, 13)); // NOI18N
        jLabel18.setText("MOB : 0667-970-412");
        panel.add(jLabel18);
        jLabel18.setBounds(10, 130, 131, 15);

        jLabel22.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        jLabel22.setText(" Cité 05 juillet, Bt A 8 N11 Mostaganem");
        panel.add(jLabel22);
        jLabel22.setBounds(170, 470, 256, 17);

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel29.setText("Mostaganem, Le");
        panel.add(jLabel29);
        jLabel29.setBounds(200, 150, 95, 16);

        Date.setBorder(null);
        Date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateActionPerformed(evt);
            }
        });
        panel.add(Date);
        Date.setBounds(300, 140, 153, 40);

        age.setBorder(null);
        age.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ageMouseClicked(evt);
            }
        });
        panel.add(age);
        age.setBounds(450, 190, 30, 20);

        jLabel1.setText("ans");
        panel.add(jLabel1);
        jLabel1.setBounds(490, 190, 40, 20);

        ord.setEditable(false);
        ord.setColumns(20);
        ord.setRows(5);
        ord.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane2.setViewportView(ord);

        panel.add(jScrollPane2);
        jScrollPane2.setBounds(0, 220, 540, 246);

        txtprenom.setBorder(null);
        txtprenom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtprenomMouseClicked(evt);
            }
        });
        txtprenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprenomActionPerformed(evt);
            }
        });
        panel.add(txtprenom);
        txtprenom.setBounds(340, 180, 90, 30);

        txtnom.setBorder(null);
        txtnom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnomMouseClicked(evt);
            }
        });
        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });
        panel.add(txtnom);
        txtnom.setBounds(240, 180, 90, 30);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        ordonnance.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 560, 540));

        principale.add(ordonnance, "card5");

        consultation.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setRollover(true);

        jButton3.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton3.setText("Voir la consultation ");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMaximumSize(new java.awt.Dimension(900, 900));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton3);

        jButton13.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton13.setText("Voir l'image");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setMaximumSize(new java.awt.Dimension(900, 900));
        jButton13.setPreferredSize(new java.awt.Dimension(255, 35));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton13);

        jButton6.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton6.setText("Voir l'ordonnance");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setPreferredSize(new java.awt.Dimension(255, 35));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton6);

        jPanel12.setLayout(new java.awt.CardLayout());

        cons.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(0, 153, 255))); // NOI18N
        jPanel18.setLayout(null);

        txtid_pat1.setEditable(false);
        txtid_pat1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtid_pat1KeyReleased(evt);
            }
        });
        jPanel18.add(txtid_pat1);
        txtid_pat1.setBounds(180, 10, 240, 26);

        txtmotif1.setEditable(false);
        jPanel18.add(txtmotif1);
        txtmotif1.setBounds(180, 50, 240, 26);

        txtdate_cons.setEditable(false);
        jPanel18.add(txtdate_cons);
        txtdate_cons.setBounds(180, 130, 240, 26);

        jLabel30.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel30.setText("Nom");
        jPanel18.add(jLabel30);
        jLabel30.setBounds(100, 10, 30, 26);

        jLabel27.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel27.setText("Prénom");
        jPanel18.add(jLabel27);
        jLabel27.setBounds(80, 60, 51, 14);

        jLabel28.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel28.setText("Date de naissance");
        jPanel18.add(jLabel28);
        jLabel28.setBounds(10, 90, 120, 30);

        jLabel26.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel26.setText("                         Date");
        jPanel18.add(jLabel26);
        jLabel26.setBounds(20, 130, 110, 14);

        jScrollPane13.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 3, 18), new java.awt.Color(51, 204, 255))); // NOI18N

        txtarea1.setEditable(false);
        txtarea1.setColumns(20);
        txtarea1.setRows(5);
        jScrollPane13.setViewportView(txtarea1);

        jPanel18.add(jScrollPane13);
        jScrollPane13.setBounds(10, 180, 410, 280);

        txtmotif2.setEditable(false);
        jPanel18.add(txtmotif2);
        txtmotif2.setBounds(180, 90, 240, 26);

        cons_tab.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(102, 204, 255))); // NOI18N
        cons_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "Consultation"
            }
        ));
        cons_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cons_tabMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(cons_tab);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txtre.setToolTipText("le recherche est par le nom ,la date de naissance ou la date");
        txtre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtreKeyPressed(evt);
            }
        });

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_xmag_8826.png"))); // NOI18N
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/act.png"))); // NOI18N
        jButton23.setText("Actualiser");
        jButton23.setPreferredSize(new java.awt.Dimension(136, 35));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Nom");
        jRadioButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton4MouseClicked(evt);
            }
        });
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Date de naissance");
        jRadioButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton5MouseClicked(evt);
            }
        });
        jRadioButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButton5KeyPressed(evt);
            }
        });

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("Date");
        jRadioButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton6MouseClicked(evt);
            }
        });
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(txtre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtre)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton5)
                    .addComponent(jRadioButton6))
                .addContainerGap())
        );

        javax.swing.GroupLayout consLayout = new javax.swing.GroupLayout(cons);
        cons.setLayout(consLayout);
        consLayout.setHorizontalGroup(
            consLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(consLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 874, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        consLayout.setVerticalGroup(
            consLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consLayout.createSequentialGroup()
                .addGroup(consLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(consLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(717, Short.MAX_VALUE))
        );

        jPanel12.add(cons, "card2");

        pic.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(null);

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrption textuelle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 3, 18), new java.awt.Color(51, 204, 255))); // NOI18N

        txtarea.setColumns(20);
        txtarea.setRows(5);
        jScrollPane7.setViewportView(txtarea);

        jPanel10.add(jScrollPane7);
        jScrollPane7.setBounds(920, 0, 420, 390);

        jPanel13.setLayout(null);

        l6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l6MouseClicked(evt);
            }
        });
        jPanel13.add(l6);
        l6.setBounds(0, 0, 100, 100);

        l7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l7MouseClicked(evt);
            }
        });
        jPanel13.add(l7);
        l7.setBounds(100, 0, 100, 100);

        l8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l8MouseClicked(evt);
            }
        });
        jPanel13.add(l8);
        l8.setBounds(200, 0, 100, 100);

        l9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l9MouseClicked(evt);
            }
        });
        jPanel13.add(l9);
        l9.setBounds(300, 0, 100, 100);

        l10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l10MouseClicked(evt);
            }
        });
        jPanel13.add(l10);
        l10.setBounds(400, 0, 100, 100);

        l11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l11MouseClicked(evt);
            }
        });
        jPanel13.add(l11);
        l11.setBounds(500, 0, 100, 100);

        l12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l12MouseClicked(evt);
            }
        });
        jPanel13.add(l12);
        l12.setBounds(600, 0, 100, 100);

        l13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l13MouseClicked(evt);
            }
        });
        jPanel13.add(l13);
        l13.setBounds(700, 0, 100, 100);

        l14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l14MouseClicked(evt);
            }
        });
        jPanel13.add(l14);
        l14.setBounds(800, 0, 100, 100);

        l15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l15MouseClicked(evt);
            }
        });
        jPanel13.add(l15);
        l15.setBounds(900, 0, 100, 100);

        l16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l16MouseClicked(evt);
            }
        });
        jPanel13.add(l16);
        l16.setBounds(1000, 0, 100, 100);

        jPanel10.add(jPanel13);
        jPanel13.setBounds(100, 400, 1100, 100);

        jPanel14.setLayout(null);

        l4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l4MouseClicked(evt);
            }
        });
        jPanel14.add(l4);
        l4.setBounds(0, 300, 100, 100);

        l2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l2MouseClicked(evt);
            }
        });
        jPanel14.add(l2);
        l2.setBounds(0, 100, 100, 100);

        l1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l1MouseClicked(evt);
            }
        });
        jPanel14.add(l1);
        l1.setBounds(0, 0, 100, 100);

        l3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l3MouseClicked(evt);
            }
        });
        jPanel14.add(l3);
        l3.setBounds(0, 200, 100, 100);

        l5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        l5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l5MouseClicked(evt);
            }
        });
        jPanel14.add(l5);
        l5.setBounds(0, 400, 100, 100);

        jPanel10.add(jPanel14);
        jPanel14.setBounds(0, 0, 100, 500);

        jLabel12.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLabel12MouseWheelMoved(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
        );

        jPanel10.add(jDesktopPane1);
        jDesktopPane1.setBounds(100, 0, 820, 400);

        javax.swing.GroupLayout picLayout = new javax.swing.GroupLayout(pic);
        pic.setLayout(picLayout);
        picLayout.setHorizontalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 1352, Short.MAX_VALUE)
        );
        picLayout.setVerticalGroup(
            picLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 400, Short.MAX_VALUE))
        );

        jPanel12.add(pic, "card4");

        v_ord.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Ordonnance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 3, 18), new java.awt.Color(0, 153, 255))); // NOI18N

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setLayout(null);

        jLabel32.setFont(new java.awt.Font("Georgia", 2, 25)); // NOI18N
        jLabel32.setText("Cabinet Médical - Neurochirurgie .");
        panel1.add(jLabel32);
        jLabel32.setBounds(83, 5, 395, 39);

        jLabel4.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        jLabel4.setText("  Dr.Miroud M.N");
        panel1.add(jLabel4);
        jLabel4.setBounds(10, 60, 134, 17);

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        panel1.add(jSeparator3);
        jSeparator3.setBounds(10, 50, 505, 15);

        jLabel33.setFont(new java.awt.Font("Georgia", 2, 13)); // NOI18N
        jLabel33.setText("Neurochirurgien.");
        panel1.add(jLabel33);
        jLabel33.setBounds(20, 80, 109, 15);

        jLabel38.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        jLabel38.setText("Consultation sur RDV");
        panel1.add(jLabel38);
        jLabel38.setBounds(0, 110, 147, 17);

        jLabel44.setFont(new java.awt.Font("Georgia", 2, 13)); // NOI18N
        jLabel44.setText("MOB : 0667-970-412");
        panel1.add(jLabel44);
        jLabel44.setBounds(10, 130, 131, 15);

        jLabel45.setFont(new java.awt.Font("Georgia", 2, 14)); // NOI18N
        jLabel45.setText(" Cité 05 juillet, Bt A 8 N11 Mostaganem");
        panel1.add(jLabel45);
        jLabel45.setBounds(170, 440, 256, 17);

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel46.setText("Mostaganem, Le");
        panel1.add(jLabel46);
        jLabel46.setBounds(200, 140, 95, 16);

        Date1.setBorder(null);
        Date1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Date1ActionPerformed(evt);
            }
        });
        panel1.add(Date1);
        Date1.setBounds(300, 130, 153, 40);

        age1.setBorder(null);
        age1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                age1MouseClicked(evt);
            }
        });
        age1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                age1ActionPerformed(evt);
            }
        });
        panel1.add(age1);
        age1.setBounds(440, 180, 20, 20);

        jLabel5.setText("ans");
        panel1.add(jLabel5);
        jLabel5.setBounds(470, 180, 50, 10);

        ord1.setEditable(false);
        ord1.setColumns(20);
        ord1.setRows(5);
        ord1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jScrollPane3.setViewportView(ord1);

        panel1.add(jScrollPane3);
        jScrollPane3.setBounds(0, 200, 550, 240);

        txtprenom4.setBorder(null);
        txtprenom4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtprenom4MouseClicked(evt);
            }
        });
        txtprenom4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprenom4ActionPerformed(evt);
            }
        });
        panel1.add(txtprenom4);
        txtprenom4.setBounds(340, 170, 90, 30);

        txtnom2.setBorder(null);
        txtnom2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnom2MouseClicked(evt);
            }
        });
        txtnom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom2ActionPerformed(evt);
            }
        });
        panel1.add(txtnom2);
        txtnom2.setBounds(240, 170, 90, 30);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout v_ordLayout = new javax.swing.GroupLayout(v_ord);
        v_ord.setLayout(v_ordLayout);
        v_ordLayout.setHorizontalGroup(
            v_ordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(v_ordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(763, Short.MAX_VALUE))
        );
        v_ordLayout.setVerticalGroup(
            v_ordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(v_ordLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(716, Short.MAX_VALUE))
        );

        jPanel12.add(v_ord, "card4");

        javax.swing.GroupLayout consultationLayout = new javax.swing.GroupLayout(consultation);
        consultation.setLayout(consultationLayout);
        consultationLayout.setHorizontalGroup(
            consultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(consultationLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 1352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        consultationLayout.setVerticalGroup(
            consultationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 1224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1061, Short.MAX_VALUE))
        );

        principale.add(consultation, "card4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principale, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 1335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(principale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane3.addTab("Dossier Médical", new javax.swing.ImageIcon(getClass().getResource("/img/4406032.png")), jPanel2); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rdv_tab.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(51, 153, 255))); // NOI18N
        rdv_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        rdv_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdv_tabMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(rdv_tab);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 690, 138));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/if_xmag_8826.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 40, 32));

        jButton8.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/act.png"))); // NOI18N
        jButton8.setText("Actualiser");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 136, 35));

        rdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdvActionPerformed(evt);
            }
        });
        rdv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rdvKeyPressed(evt);
            }
        });
        jPanel6.add(rdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 210, 32));

        buttonGroup4.add(jRadioButton11);
        jRadioButton11.setText("Nom");
        jRadioButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton11MouseClicked(evt);
            }
        });
        jPanel6.add(jRadioButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 70, -1));

        buttonGroup4.add(jRadioButton12);
        jRadioButton12.setText("Date de naissance");
        jRadioButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton12MouseClicked(evt);
            }
        });
        jPanel6.add(jRadioButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 130, -1));

        buttonGroup4.add(jRadioButton13);
        jRadioButton13.setText("Numéro de télèphone");
        jRadioButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton13MouseClicked(evt);
            }
        });
        jPanel6.add(jRadioButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 150, -1));

        buttonGroup4.add(jRadioButton14);
        jRadioButton14.setText("Date de rendez-vous");
        jRadioButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton14MouseClicked(evt);
            }
        });
        jRadioButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton14ActionPerformed(evt);
            }
        });
        jRadioButton14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jRadioButton14KeyReleased(evt);
            }
        });
        jPanel6.add(jRadioButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 150, -1));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 520, 90));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel22.setLayout(null);

        jButton21.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        jButton21.setText("Ajouter");
        jButton21.setMaximumSize(new java.awt.Dimension(107, 29));
        jButton21.setMinimumSize(new java.awt.Dimension(107, 29));
        jButton21.setPreferredSize(new java.awt.Dimension(107, 29));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton21);
        jButton21.setBounds(10, 20, 136, 35);

        jButton26.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pen.png"))); // NOI18N
        jButton26.setText("Modifier");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton26);
        jButton26.setBounds(320, 20, 136, 35);

        jButton27.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        jButton27.setText("Annuler");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton27);
        jButton27.setBounds(160, 20, 136, 35);

        jPanel4.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 470, 76));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(51, 204, 255))); // NOI18N
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel34.setText("Date RDV");
        jPanel19.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        txtcom1.setColumns(20);
        txtcom1.setRows(5);
        jScrollPane9.setViewportView(txtcom1);

        jPanel19.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 180, 130));

        txtprenom1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprenom1KeyReleased(evt);
            }
        });
        jPanel19.add(txtprenom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 180, 28));

        num_rdv.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        num_rdv.setText("       Auto Générer");
        jPanel19.add(num_rdv, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 180, 28));

        jLabel21.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel21.setText("N° de RDV");
        jPanel19.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 20));

        jLabel20.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel20.setText("Téléphone");
        jPanel19.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel36.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel36.setText("Commentaire");
        jPanel19.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));
        jPanel19.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 180, 20));
        jPanel19.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 180, 20));

        txtprenom2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprenom2KeyReleased(evt);
            }
        });
        jPanel19.add(txtprenom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 180, 28));

        jLabel23.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel23.setText("                      Nom  ");
        jPanel19.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 110, -1));

        jLabel13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel13KeyReleased(evt);
            }
        });
        jPanel19.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 180, 20));

        jLabel24.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel24.setText(" Prenom ");
        jPanel19.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        txtprenom3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtprenom3KeyReleased(evt);
            }
        });
        jPanel19.add(txtprenom3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 180, 28));

        jPanel4.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 400, 440));

        jTabbedPane3.addTab("Gestion de Rendez-vous", new javax.swing.ImageIcon(getClass().getResource("/img/iconne.png")), jPanel4); // NOI18N

        jMenu1.setText("File");

        addUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nouveau.png"))); // NOI18N
        addUser.setText("Créer un utilisateur");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });
        jMenu1.add(addUser);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ico.png"))); // NOI18N
        jMenuItem4.setText("Changer le mot de passe ");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-log-out-32.png"))); // NOI18N
        jMenuItem3.setText("Déconnecter ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenu3.setText("Nouveau");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-join-48.png"))); // NOI18N
        jMenuItem2.setText("Nouveau patient");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus.png"))); // NOI18N
        jMenuItem1.setText("Nouvelle consultation ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-clock-30.png"))); // NOI18N
        jMenuItem5.setText("Nouveau Rendez-vous");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1357, 720));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        ajouter a= new ajouter();
        a.setVisible(true);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if(pat_tab1.getSelectedRowCount()==1){
        String name = txtnom1.getText();
        String prenom = txtpre1.getText();
        String date= ((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText();
        String telephone = txttlf1.getText();
        ajoutercons rgf = new ajoutercons(name,prenom,date,telephone);
        rgf.setVisible(true);
         }else{
            JOptionPane.showMessageDialog(null,"Séléctionner une ligne SVP!");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        if(pat_tab1.getSelectedRowCount()==1){
        String name = txtnom1.getText();
        String prenom = txtpre1.getText();
        String tlf= txttlf1.getText();
        ajouterRdv rd = new ajouterRdv(name,prenom,tlf);
        rd.setVisible(true);
        afficher_rdv();
         }else{
            JOptionPane.showMessageDialog(null,"Séléctionner une ligne SVP!");
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        super.dispose();
        login meconnecter = new login();
        meconnecter.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        principale.removeAll();
        principale.repaint();
        principale.revalidate();
        principale.add(id);
        principale.repaint();
        principale.revalidate();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        principale.removeAll();
        principale.repaint();
        principale.revalidate();
        principale.add(consultation);
        principale.repaint();
        principale.revalidate();
         afficher_cons();
         
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        principale.removeAll();
        principale.repaint();
        principale.revalidate();
        principale.add(ordonnance);
        principale.repaint();
        principale.revalidate();
        afficher_ordonnance();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void txtnom1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnom1KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtnom1KeyPressed

    private void txtnom1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnom1KeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
            label.setText(null);
        }else{
            label.setText("Entrer seleument des alphabet");
            label.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtnom1KeyReleased

    private void txtpre1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpre1KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtpre1KeyPressed

    private void txtpre1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpre1KeyReleased
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
            jLabel2.setText(null);
        }else{
            jLabel2.setText("Entrer seleument des alphabet");
            jLabel2.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtpre1KeyReleased

    private void txtadrss1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadrss1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtadrss1ActionPerformed

    private void txtadrss1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtadrss1KeyReleased
        // TODO add your handling code here:
        String PATTERN ="^[^@,.;*+&$=^]{0,30}$" ;
        Pattern patt= Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txtadrss1.getText());
        if(!match.matches()){
            jLabel8.setText("Entrer seleument des alphabet");
            jLabel8.setForeground(Color.RED);
        }
        else{
            jLabel8.setText(null);
        }
    }//GEN-LAST:event_txtadrss1KeyReleased

    private void txttlf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttlf1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txttlf1ActionPerformed

    private void txttlf1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttlf1KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txttlf1KeyPressed

    private void txttlf1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttlf1KeyReleased
        // TODO add your handling code here:
        String PATTERN ="^[0-9]{0,12}$" ;
        Pattern patt= Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txttlf1.getText());
        if(!match.matches()){
            label2.setText("entrer suelement des numéro!");
            label2.setForeground(Color.RED);
        }
        else{
            label2.setText(null);
        }
    }//GEN-LAST:event_txttlf1KeyReleased

    private void pat_tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pat_tab1MouseClicked
        // TODO add your handling code here:
        try{
            int i=pat_tab1.getSelectedRow();
            deplace(i);

        }catch(Exception e){
            System.err.println(e);
        }
    }//GEN-LAST:event_pat_tab1MouseClicked

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton33ActionPerformed

    private void reach_pat1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_reach_pat1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_reach_pat1PopupMenuWillBecomeInvisible

    private void reach_pat1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reach_pat1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_reach_pat1KeyPressed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        try{
            if(pat_tab1.getSelectedRowCount()==1){
            if(JOptionPane.showConfirmDialog(null,"Voulez vous supprimer réellement ce patient "
                ,"supprimer patient",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
                
        
            stm.executeUpdate("Delete From medecin2 where nom='"+txtnom1.getText()+"'and prenom='"+txtpre1.getText()+"' and date_naissance='"+((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText()+"'" );

            afficher();
            actualiser();
        }else{
            JOptionPane.showMessageDialog(null,"Vous Veuillez choisir le patient à supprimer");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"erreur de supprimer\n"+e.getMessage());
        }
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        try{                Connect();
              if(pat_tab1.getSelectedRowCount()==1){  
                    if(JOptionPane.showConfirmDialog(null,"êtes-vous sûr de modifier les informations de ce patient "
                ,"Modifier un patient",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
             
                             pst = conn.prepareStatement("UPDATE medecin2 SET nom= ?,prenom=?,date_naissance=?"
                                   + ",adresse=?,telephone=?,sexe=? WHERE Numéro_de_patient ='"+num_pat.getText()+"'");
                            pst.setString(1,txtnom1.getText());
                            pst.setString(2,txtpre1.getText());
                            pst.setString(3, ((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText());
                            pst.setString(4,txtadrss1.getText());
                            pst.setString(5,txttlf1.getText());
                            pst.setString(6,jComboBox1.getSelectedItem().toString());
                           /* pst.setString(7,txtnom1.getText());
                            pst.setString(8,txtpre1.getText());
                            pst.setString(9, ((JTextField)txtdate1.getDateEditor().getUiComponent()).getText());
                            */pst.execute();
                            conn.close();
                            JOptionPane.showMessageDialog(null,  "Patient est bien Modifier");
                             afficher();
                            actualiser();}else{
            JOptionPane.showMessageDialog(null,"Vous Veuillez choisir le patient à modifier ses information ");
        }
                    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erreur \n"+ e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try{  Connect();
            String nom= txtnom1.getText();
            String prenom= txtpre1.getText();
            String dl=  ((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText();
            String adresse =txtadrss1.getText();
            String tlf =txttlf1.getText();
            if(nom.length()!=0&& prenom.length()!=0&&dl.length()!=0&& adresse.length()!=0&& tlf.length()!=0 ){
                String phone = "SELECT nom, prenom, date_naissance FROM medecin2 WHERE nom ='"+txtnom1.getText()+"' and prenom='"+txtpre1.getText()+"' and date_naissance= '"+((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText()+"' ";
                pst = conn.prepareStatement(phone);
                Rs= pst.executeQuery();
                if(Rs.next()){
                    if(Rs.getString("nom").equals(txtnom1.getText())||Rs.getString("prenom").equals(txtpre1.getText())||Rs.getString("date_naissance").equals(((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText())){
                        JOptionPane.showMessageDialog(null,  "Patient est déjà  ajouter");
                        actualiser();
                    }
                }else{
                    pst = conn.prepareStatement("INSERT INTO medecin2 (nom,prenom,date_naissance,adresse,telephone,sexe) values(?,?,?,?,?,?)");
                    pst.setString(1,txtnom1.getText());
                    pst.setString(2,txtpre1.getText());
                    pst.setString(3, ((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText());
                    pst.setString(4,txtadrss1.getText());
                    pst.setString(5,txttlf1.getText());
                    pst.setString(6,jComboBox1.getSelectedItem().toString());
                    pst.executeUpdate();
                    conn.close();
                    JOptionPane.showMessageDialog(null,  "Patient est bien ajouter");
                    afficher();
                   actualiser();
                }
            }else {
                JOptionPane.showMessageDialog(null," Vous veuillez remplir tous les champs  ");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Veuillez Svp entrer des information correct \n"+ e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ord_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ord_tableMouseClicked
        try{
            int i=ord_table.getSelectedRow();
            deplace_ord(i);

        }catch(Exception e){
            System.err.println(e);
        }
    }//GEN-LAST:event_ord_tableMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MouseClicked

    private void pSearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pSearchField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pSearchField1ActionPerformed

    private void pSearchField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pSearchField1KeyPressed
        // TODO add your handling code here:
       /* if(evt.getKeyCode()==KeyEvent.VK_ENTER)//tu click sur entrer et il va commencer
        {try{modele.setRowCount(0);//pour vider la list des etudient
            {Rs = stm.executeQuery("Select * From ordonnance WHERE nom= '"+pSearchField1.getText()+ "' or date='"+pSearchField1.getText()+ "' or date_naissance='"+pSearchField1.getText()+ "'or telephone='"+pSearchField1.getText()+ "' ");
            }while(Rs.next()){
                 Object[] ord ={Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5),Rs.getInt(6),Rs.getDate(7),Rs.getString(8)};
                modele.addRow(ord);
            }if(modele.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun patient ");
            }}catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            } }*/
    }//GEN-LAST:event_pSearchField1KeyPressed

    private void rechrcherUnOrdonnanceDePatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rechrcherUnOrdonnanceDePatientMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rechrcherUnOrdonnanceDePatientMouseClicked

    private void rechrcherUnOrdonnanceDePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechrcherUnOrdonnanceDePatientActionPerformed
        try{modele.setRowCount(0);//pour vider la list des etudient
            {Rs = stm.executeQuery("Select * From ordonnance WHERE nom= '"+pSearchField1.getText()+ "' or date='"+pSearchField1.getText()+ "' or date_naissance='"+pSearchField1.getText()+ "'or telephone='"+pSearchField1.getText()+ "' ");
            }while(Rs.next()){
                 Object[] ord ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5),Rs.getDate(7),Rs.getString(8)};
                modele.addRow(ord);
            }if(modele.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun patient ");
            }}catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
    }//GEN-LAST:event_rechrcherUnOrdonnanceDePatientActionPerformed

    private void dellet1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dellet1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dellet1MouseClicked

    private void dellet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dellet1ActionPerformed
        Connect();
        try{
             if(ord_table.getSelectedRowCount()==1){
            if(JOptionPane.showConfirmDialog(null,"voulez vous supprimer réellement cette ordonnance"
                ,"supprimer ordonnance",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
       
            stm.executeUpdate("Delete From ordonnance WHERE Numero_ordonnance='"+modele.getValueAt(ord_table.getSelectedRow(),0)+"'");
            afficher_ordonnance();
            ord.setText("");
        }else{
            JOptionPane.showMessageDialog(null,"Choisir l'ordonnance à supprimer SVP");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"erreur de supprimer\n"+e.getMessage());
        }
        /*
        // DefaultTableModel model3 =(DefaultTableModel) table2.getModel();
        String id=(String) modele.getValueAt(ord_table.getSelectedRow(),3);
        try {

            PreparedStatement pst =conn.prepareStatement("delletSql");

            if(ord_table.getSelectedRowCount()==1){
                try {
                    pst.executeUpdate("Delete From ordonnance WHERE ordonnance ='"+id+"' ");
                    modele.removeRow(ord_table.getSelectedRow());
                    JOptionPane.showMessageDialog(this," supprimer");
                } catch (SQLException ex) {
                    Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(patient.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_dellet1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        afficher_ordonnance();
        ord.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rdv_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdv_tabMouseClicked
        // TODO add your handling code here:
        try{
            int i=rdv_tab.getSelectedRow();
            deplace_rdv(i);

        }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"erreur de deplacement"+e.getLocalizedMessage());
        }
    }//GEN-LAST:event_rdv_tabMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try{
            ma.setRowCount(0);//pour vider la list des etudient
            {

                Rs = stm.executeQuery("SELECT * FROM rdv WHERE Nom='"+rdv.getText()+"'or Date_RDV='"+rdv.getText()+ "' or telephone='"+rdv.getText()+"'");
            }while(Rs.next()){
                Object[] rdv ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5)
                    ,Rs.getTime(6),Rs.getTime(7),Rs.getString(8)};
                ma.addRow(rdv);
            }if(ma.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun rendez-vous ");

            }
            num_rdv.setText("Auto Générer");
            //id_pat_rdv.setText("");
            txtprenom1.setText("");
            txtdaterdv1.setDate(null);
           
            txtcom1.setText("");

        }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        afficher_rdv();
        num_rdv.setText("Auto Générer");
        //id_pat_rdv.setText("");
        txtprenom1.setText("");
        txtprenom2.setText("");
        txtprenom3.setText("");
        txtdaterdv1.setDate(null);
        txtcom1.setText("");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void rdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdvActionPerformed

    private void rdvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rdvKeyPressed
        // TODO add your handling code here:
       /* if(evt.getKeyCode()==KeyEvent.VK_ENTER)//tu click sur entrer et il va commencer
        {
            try{
                ma.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From rdv WHERE Nom='"+rdv.getText()+"'or Date_RDV='"+rdv.getText()+ "' or telephone='"+rdv.getText()+"'");
                }while(Rs.next()){
                    Object[] rdv ={Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5)
                    ,Rs.getTime(6),Rs.getTime(7),Rs.getString(8)};
                    ma.addRow(rdv);
                }if(ma.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun Rendez-vous ");
                }
            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }*/
    }//GEN-LAST:event_rdvKeyPressed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        try{

            Connect();
            String id= txtprenom2.getText();//tlf
            String nom= txtprenom1.getText();
            String prenom= txtprenom3.getText();
           String  d= ((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText();
           String com = txtcom1.getText();
            if(id.length()!=0&&nom.length()!=0&& prenom.length()!=0&&com.length()!=0 ){
               String sql = "SELECT Nom ,prenom,Date_RDV FROM rdv WHERE Nom ='"+txtprenom1.getText()+"' and prenom='"+txtprenom3.getText()+"' and Date_RDV='"+((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText()+"' ";
                pst = conn.prepareStatement(sql);
                Rs= pst.executeQuery();
                if(Rs.next()){
                    if(Rs.getDate("Date_RDV").equals(((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText())|| Rs.getString("Nom").equals(txtprenom1.getText())|| Rs.getString("prenom").equals(txtprenom3.getText())){
                        JOptionPane.showMessageDialog(null,  "Ce patient  déja un rendez-vous dans cette date"+((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText());
                    }
                }else{
                    pst = conn.prepareStatement("INSERT INTO rdv (Nom,prenom,telephone,Date_RDV,Commentaire) VALUES(?,?,?,?,?)");
                    // pst.setString(1,txtid.getText());
                    pst.setString(1,txtprenom1.getText());//nom
                    pst.setString(2,txtprenom3.getText());//prenom
                    pst.setString(3,txtprenom2.getText());//telephone
                    pst.setString(4, ((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText());
                    pst.setString(5,txtcom1.getText());
                    pst.executeUpdate();
                    conn.close();
                    JOptionPane.showMessageDialog(null,  "Le rendez-vous est bien ajouter");
                    afficher_rdv();
                    num_rdv.setText("Auto Générer");
                    txtprenom2.setText("");
                    txtprenom3.setText("");
                    txtprenom1.setText("");
                    txtdaterdv1.setDate(null);
                    txtcom1.setText("");
                }
            }else {
                JOptionPane.showMessageDialog(null,"Veuillez vous remplir votr champs ");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Veuillez Svp entrer des information correct \n"+ e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        try{

            Connect();
         if(rdv_tab.getSelectedRowCount()==1){  
             if(JOptionPane.showConfirmDialog(null,"êtes-vous sûr de modifier ce Rendez-vous "
                ,"Modifier un Rendez-vous",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
             
            pst = conn.prepareStatement("UPDATE rdv SET Nom= ?,prenom=?,telephone=?,Date_RDV=?,Commentaire=? WHERE Numero_de_RDV=?");
            pst.setString(1,txtprenom1.getText());
            pst.setString(2,txtprenom3.getText());
            pst.setString(3,txtprenom2.getText());
            pst.setString(4, ((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText());
            pst.setString(5,txtcom1.getText());
            pst.setString(6,num_rdv.getText());

            pst.executeUpdate();
            conn.close();
            JOptionPane.showMessageDialog(null,  "Le rendez-vous est bien modifier");
            afficher_rdv();
            num_rdv.setText("Auto Générer");
            //id_pat_rdv.setText("");
            txtprenom1.setText("");
            txtprenom2.setText("");
            txtprenom3.setText("");
            txtdaterdv1.setDate(null);
            txtcom1.setText("");
                    }else{
            JOptionPane.showMessageDialog(null,"Vous Veuillez choisir le rendez-vous à modifier");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erreur \n"+ e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        try{
            int i=0; 
           // String in = (rdv_tab.getModel().getValueAt(i, 0).toString());
            if(rdv_tab.getSelectedRowCount()==1){ 
            if(JOptionPane.showConfirmDialog(null,"voulez vous annuler réellement ce rendez-vous "
                ,"annuler un Rendez-vous",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
        
            stm.executeUpdate("Delete From rdv where Numero_de_RDV ='"+num_rdv.getText()+"'");
            afficher_rdv();
            num_rdv.setText("Auto Générer");
            //id_pat_rdv.setText("");
            txtprenom1.setText("");
            txtprenom2.setText("");
            txtprenom3.setText("");
            txtdaterdv1.setDate(null);
            txtcom1.setText("");
            } else{
            JOptionPane.showMessageDialog(null,"Vous Veuillez choisir le rendez-vous à annuler");
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"erreur de supprimer\n"+e.getMessage());
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void txtprenom1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprenom1KeyReleased
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
            jLabel13.setText(null);
        }else{
            jLabel13.setText("Entrer seleument des alphabet ");
            jLabel13.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtprenom1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(pat_tab1.getSelectedRowCount()==1){
        String name = txtnom1.getText();
        String prenom = txtpre1.getText();
        String date= ((JTextField)txtdaterdv1.getDateEditor().getUiComponent()).getText();
        String telephone = txttlf1.getText(); 
        ajoutercons rgf = new ajoutercons(name,prenom,date,telephone);
        rgf.setVisible(true);
         }else{
            JOptionPane.showMessageDialog(null,"Vous Veuillez sélèctionner une ligne ");
        }
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtre1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtre1KeyPressed
        // TODO add your handling code here:
        /*if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        try{
            model.setRowCount(0);//pour vider la list des etudient
            {

                Rs = stm.executeQuery("Select * From medecin2 WHERE nom= '"+txtre1.getText()+"'or date_naiss= '"+txtre1.getText()+"'or telephone= '"+txtre1.getText()+"'");
            }while(Rs.next()){
                 Object[] medecin2 ={Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getInt(6),Rs.getString(7)};
                    model.addRow(medecin2);
            }if(model.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun patient");

            }
            actualiser();

        }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        }*/
    }//GEN-LAST:event_txtre1KeyPressed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        try{
            model.setRowCount(0);//pour vider la list des etudient
            {

                Rs = stm.executeQuery("Select * From medecin2 WHERE nom= '"+txtre1.getText()+"'or date_naiss= '"+txtre1.getText()+"'or telephone= '"+txtre1.getText()+"'");
            }while(Rs.next()){
                 Object[] medecin2 ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getInt(6),Rs.getString(7)};
                    model.addRow(medecin2);
            }if(model.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun patient");

            }
            actualiser();

        }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void txtprenom2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprenom2KeyReleased
        // TODO add your handling code here:
        String PATTERN ="^[0-9]{0,12}$" ;
        Pattern patt= Pattern.compile(PATTERN);
        Matcher match = patt.matcher(txtprenom2.getText());
        if(!match.matches()){
            jLabel9.setText("entrer suelement des numéro!");
            jLabel9.setForeground(Color.RED);
        }
        else{
            jLabel9.setText(null);
        }
    }//GEN-LAST:event_txtprenom2KeyReleased

    private void txtprenom3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprenom3KeyReleased
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)||Character.isWhitespace(c)||Character.isISOControl(c)){
           jLabel10.setText(null);
        }else{
            jLabel10.setText("Entrer seleument des alphabet");
            jLabel10.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtprenom3KeyReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        if(pat_tab1.getSelectedRowCount()==1){
        String name = txtnom1.getText();
        String prenom = txtpre1.getText();
        String tlf= txttlf1.getText();
        ajouterRdv rd = new ajouterRdv(name,prenom,tlf);
        rd.setVisible(true);
         }else{
            JOptionPane.showMessageDialog(null,"Vous Veuillez sélèctionner une ligne ");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
          //if(cons_tab.getSelectedRowCount()==1){
              jPanel12.removeAll();
              jPanel12.repaint();
              jPanel12.revalidate();
              jPanel12.add(cons);
              jPanel12.repaint();
              jPanel12.revalidate();
                   /* int i=cons_tab.getSelectedRow();
                    deplace_cons(i);}else{
            JOptionPane.showMessageDialog(null, "Vous veuillez selectionner une ligne svp");
        }
        */
         
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if(cons_tab.getSelectedRowCount()==1){
                jPanel12.removeAll();
                jPanel12.repaint();
                jPanel12.revalidate();
                jPanel12.add(pic);
                jPanel12.repaint();
                jPanel12.revalidate();
        }else{
            JOptionPane.showMessageDialog(null, "Vous veuillez selectionner une ligne svp");
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void cons_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cons_tabMouseClicked
        // TODO add your handling code here:
       
        try{
            int i=cons_tab.getSelectedRow();
                    deplace_cons(i);

        }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"erreur de deplacement"+e.getLocalizedMessage());
        }
    }//GEN-LAST:event_cons_tabMouseClicked

    private void txtid_pat1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_pat1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtid_pat1KeyReleased

    private void txtreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtreKeyPressed
        // TODO add your handling code here:
       /* if(evt.getKeyCode()==KeyEvent.VK_ENTER)//tu click sur entrer et il va commencer
        {
            try{
                m.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From consultation WHERE nom= '"+txtre.getText()+ "'or date= '"+txtre.getText()+ "' or date_naissance= '"+txtre.getText()+ "' ");
                }while(Rs.next()){
                    Object[] consultation ={Rs.getString(2),Rs.getString(3),Rs.getDate(4),Rs.getDate(5)
                            ,Rs.getString(6),Rs.getString(7),Rs.getBlob(8)};
                    m.addRow(consultation);
                }if(m.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun consultation ");
                }

            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }*/
    }//GEN-LAST:event_txtreKeyPressed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        try{
            m.setRowCount(0);//pour vider la list des etudient
            {

                Rs = stm.executeQuery("Select * From consultation WHERE nom= '"+txtre.getText()+ "'or date= '"+txtre.getText()+ "' or date_naissance= '"+txtre.getText()+ "' ");
                }while(Rs.next()){
                    Object[] consultation ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getDate(4),Rs.getDate(5)
                            ,Rs.getString(6),Rs.getString(7),Rs.getBlob(8)};
                    m.addRow(consultation);
            }if(m.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun consultation ");

            }
            
            txtdate_cons.setText(null);

            txtdate_cons.setText("");
            txtarea.setText("");

        }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        afficher_cons();
        
        txtdate_cons.setText(null);

        txtdate_cons.setText("");
        txtarea.setText("");
    }//GEN-LAST:event_jButton23ActionPerformed

    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        inscrire b=new inscrire();
        b.setVisible(true);
    }//GEN-LAST:event_addUserActionPerformed

    private void DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_DateActionPerformed

    private void ageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ageMouseClicked
        // TODO add your handling code here:
        age.setText("");
    }//GEN-LAST:event_ageMouseClicked

    private void txtprenomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtprenomMouseClicked
        txtprenom.setText("");
    }//GEN-LAST:event_txtprenomMouseClicked

    private void txtprenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprenomActionPerformed

    private void txtnomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnomMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomMouseClicked

    private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        afficher_rdv();
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ChangePassword f= new  ChangePassword();
        f.setVisible(true);
        f.pack();
        f.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(cons_tab.getSelectedRowCount()==1){
                jPanel12.removeAll();
                jPanel12.repaint();
                jPanel12.revalidate();
                jPanel12.add(v_ord);
                jPanel12.repaint();
                jPanel12.revalidate();
        }else{
            JOptionPane.showMessageDialog(null, "Vous veuillez selectionner une ligne svp");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void Date1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Date1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Date1ActionPerformed

    private void age1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_age1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_age1MouseClicked

    private void txtprenom4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtprenom4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprenom4MouseClicked

    private void txtprenom4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprenom4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprenom4ActionPerformed

    private void txtnom2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnom2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom2MouseClicked

    private void txtnom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnom2ActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:
      if (txtre1.getText().length()!=0) {  
        try{
            model.setRowCount(0);//pour vider la list des etudient
            {

                Rs = stm.executeQuery("Select * From medecin2 WHERE nom= '"+txtre1.getText()+"'");
            }while(Rs.next()){
                 Object[] medecin2 ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getDate(4),Rs.getInt(5),Rs.getString(6),Rs.getString(7)};
                    model.addRow(medecin2);
            }if(model.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun patient");

            }
            actualiser();

        }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }}else{
          JOptionPane.showMessageDialog(null,"Pouvez vous entrer votre recherche SVP");

      }
      
        
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        // TODO add your handling code here:
          if(txtre1.getText().length()!=0){
        try{
            model.setRowCount(0);//pour vider la list des etudient
            {

                Rs = stm.executeQuery("Select * From medecin2 WHERE  date_naissance= '"+txtre1.getText()+"'");
            }while(Rs.next()){
                  Object[] medecin2 ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getDate(4),Rs.getInt(5),Rs.getString(6),Rs.getString(7)};
                    model.addRow(medecin2);
            }if(model.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun patient");

            }
            actualiser();
        
        }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }}else{
                JOptionPane.showMessageDialog(null,"Pouvez vous entrer votre recherche SVP");
            }
        
    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
        // TODO add your handling code here:
       if(txtre1.getText().length()!=0){
          
        try{
            model.setRowCount(0);//pour vider la list des etudient
            {

                Rs = stm.executeQuery("Select * From medecin2 WHERE telephone= '"+txtre1.getText()+"'");
            }while(Rs.next()){
                 Object[] medecin2 ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getDate(4),Rs.getInt(5),Rs.getString(6),Rs.getString(7)};
                    model.addRow(medecin2);
            }if(model.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun patient");

            }
            actualiser();

        }catch(Exception e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,e.getMessage());
        }}else{
                JOptionPane.showMessageDialog(null,"Pouvez vous entrer votre recherche SVP");
            }
        
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void l6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l6MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(imagedata6);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l6MouseClicked

    private void l7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l7MouseClicked
        ImageIcon myimage = new ImageIcon(imagedata7);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l7MouseClicked

    private void l8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l8MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(imagedata8);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l8MouseClicked

    private void l9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l9MouseClicked
        ImageIcon myimage = new ImageIcon(imagedata9);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l9MouseClicked

    private void l10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l10MouseClicked
        ImageIcon myimage = new ImageIcon(imagedata10);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l10MouseClicked

    private void l11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l11MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(imagedata11);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l11MouseClicked

    private void l12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l12MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(imagedata12);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l12MouseClicked

    private void l13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l13MouseClicked
        ImageIcon myimage = new ImageIcon(imagedata13);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l13MouseClicked

    private void l14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l14MouseClicked
        ImageIcon myimage = new ImageIcon(imagedata14);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l14MouseClicked

    private void l15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l15MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(imagedata15);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l15MouseClicked

    private void l16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l16MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(imagedata16);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l16MouseClicked

    private void l4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l4MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(imagedata4);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l4MouseClicked

    private void l2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l2MouseClicked
        ImageIcon myimage = new ImageIcon(imagedata2);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l2MouseClicked

    private void l1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(imagedata1);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l1MouseClicked

    private void l3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l3MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(imagedata3);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l3MouseClicked

    private void l5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l5MouseClicked
        // TODO add your handling code here:
        ImageIcon myimage = new ImageIcon(imagedata5);
        java.awt.Image img = myimage.getImage();
        java.awt.Image newimage = img.getScaledInstance(jLabel12.getWidth(),jLabel12.getHeight(), java.awt.Image.SCALE_SMOOTH);
        ImageIcon finalimg = new ImageIcon(newimage);
        jLabel12.setIcon(finalimg);
    }//GEN-LAST:event_l5MouseClicked

    private void jLabel12MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLabel12MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseWheelMoved

    private void age1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_age1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_age1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         afficher();
        actualiser();
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton4MouseClicked
        // TODO add your handling code here:
         if(txtre.getText().length()!=0){
         try{
                m.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From consultation WHERE nom= '"+txtre.getText()+ "'");
                }while(Rs.next()){
                    Object[] consultation ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(6)
                            ,Rs.getString(7),Rs.getString(8),Rs.getString(25)};
                    m.addRow(consultation);
                }if(m.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun consultation ");
                }

            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }}else{
                JOptionPane.showMessageDialog(null,"Pouvez vous entrer votre recherche SVP");
            }
    }//GEN-LAST:event_jRadioButton4MouseClicked

    private void jRadioButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5KeyPressed

    private void jRadioButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton5MouseClicked
        // TODO add your handling code here:
         if(txtre.getText().length()!=0){
         try{
                m.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From consultation WHERE  date_naissance= '"+txtre.getText()+ "' ");
                }while(Rs.next()){
                  Object[] consultation ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(6)
                            ,Rs.getString(7),Rs.getString(8),Rs.getString(25)};
                    m.addRow(consultation);
                }if(m.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun consultation ");
                }

            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }}else{
                JOptionPane.showMessageDialog(null,"Pouvez vous entrer votre recherche SVP");
            }
    }//GEN-LAST:event_jRadioButton5MouseClicked

    private void jRadioButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton6MouseClicked
        // TODO add your handling code here:
        if(txtre.getText().length()!=0){
         try{
                m.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From consultation WHERE  date= '"+txtre.getText()+ "'");
                }while(Rs.next()){
                   Object[] consultation ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(6)
                            ,Rs.getString(7),Rs.getString(8),Rs.getString(25)};
                    m.addRow(consultation);
                }if(m.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun consultation ");
                }

            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }}else{
                JOptionPane.showMessageDialog(null,"Pouvez vous entrer votre recherche SVP");
            }
    }//GEN-LAST:event_jRadioButton6MouseClicked

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jRadioButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton7MouseClicked
        // TODO add your handling code here:
       if(pSearchField1.getText().length()!=0){
       try{modele.setRowCount(0);//pour vider la list des etudient
            {Rs = stm.executeQuery("Select * From ordonnance WHERE nom= '"+pSearchField1.getText()+ "' ");
            }while(Rs.next()){
                 Object[] ord ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getDate(4),Rs.getInt(5),Rs.getDate(6),Rs.getString(8)};
                modele.addRow(ord);
            }if(modele.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun patient ");
            }}catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            } }else{
                JOptionPane.showMessageDialog(null,"Pouvez vous entrer votre recherche SVP");
            }
    }//GEN-LAST:event_jRadioButton7MouseClicked

    private void jRadioButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton8MouseClicked
        // TODO add your handling code here:
         if(pSearchField1.getText().length()!=0){
        try{modele.setRowCount(0);//pour vider la list des etudient
            {Rs = stm.executeQuery("Select * From ordonnance WHERE  date_naissance='"+pSearchField1.getText()+ "' ");
            }while(Rs.next()){
                 Object[] ord ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getDate(4),Rs.getInt(5),Rs.getDate(6),Rs.getString(8)};
                modele.addRow(ord);
            }if(modele.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun patient ");
            }}catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            } }else{
                JOptionPane.showMessageDialog(null,"Pouvez vous entrer votre recherche SVP");
            }
    }//GEN-LAST:event_jRadioButton8MouseClicked

    private void jRadioButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton9MouseClicked
        // TODO add your handling code here:
        if(pSearchField1.getText().length()!=0){
        try{modele.setRowCount(0);//pour vider la list des etudient
            {Rs = stm.executeQuery("Select * From ordonnance WHERE date='"+pSearchField1.getText()+ "'");
            }while(Rs.next()){
                  Object[] ord ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getDate(4),Rs.getInt(5),Rs.getDate(6),Rs.getString(8)};
                modele.addRow(ord);
            }if(modele.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun patient ");
            }}catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            } }else{
                JOptionPane.showMessageDialog(null,"Pouvez vous entrer votre recherche SVP");
            }
    }//GEN-LAST:event_jRadioButton9MouseClicked

    private void jRadioButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton10MouseClicked
        // TODO add your handling code here:
        if(pSearchField1.getText().length()!=0){
        try{modele.setRowCount(0);//pour vider la list des etudient
            {Rs = stm.executeQuery("Select * From ordonnance WHERE telephone='"+pSearchField1.getText()+ "' ");
            }while(Rs.next()){
                  Object[] ord ={Rs.getInt(1),Rs.getString(2),Rs.getString(3),Rs.getDate(4),Rs.getInt(5),Rs.getDate(6),Rs.getString(8)};
                modele.addRow(ord);
            }if(modele.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"il y'a aucun patient ");
            }}catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            } }else{
                JOptionPane.showMessageDialog(null,"Pouvez vous entrer votre recherche SVP");
            }
    }//GEN-LAST:event_jRadioButton10MouseClicked

    private void jLabel13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel13KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel13KeyReleased

    private void jLabel2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2KeyReleased

    private void jRadioButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton11MouseClicked
        // TODO add your handling code here:
        if(rdv.getText().length()!=0){
        try{
                ma.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From rdv WHERE Nom='"+rdv.getText()+"'");
                }while(Rs.next()){
                    Object[] rdv ={Rs.getString(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5)
                                      ,Rs.getString(6)};
                    ma.addRow(rdv);
                }if(ma.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun Rendez-vous ");
                }
            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }}else{
             JOptionPane.showMessageDialog(null,"Pouvez vous entrer Votre Recherche SVP");
        }
    }//GEN-LAST:event_jRadioButton11MouseClicked

    private void jRadioButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton12MouseClicked
        // TODO add your handling code here:
         if(rdv.getText().length()!=0){
        try{
                ma.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From rdv WHERE  Date_RDV='"+rdv.getText()+ "'");
                }while(Rs.next()){
                    Object[] rdv ={Rs.getString(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5)
                                      ,Rs.getString(6)};
                    ma.addRow(rdv);
                }if(ma.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun Rendez-vous ");
                }
            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }}else{
             JOptionPane.showMessageDialog(null,"Pouvez vous entrer Votre Recherche SVP");
        }
    }//GEN-LAST:event_jRadioButton12MouseClicked

    private void jRadioButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton13MouseClicked
        // TODO add your handling code here:
         if(rdv.getText().length()!=0){
        try{
                ma.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From rdv WHERE  telephone='"+rdv.getText()+"'");
                }while(Rs.next()){
                    Object[] rdv ={Rs.getString(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5)
                                      ,Rs.getString(6)};
                    ma.addRow(rdv);
                }if(ma.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun Rendez-vous ");
                }
            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }}else{
             JOptionPane.showMessageDialog(null,"Pouvez vous entrer Votre Recherche SVP");
        }
    }//GEN-LAST:event_jRadioButton13MouseClicked

    private void jRadioButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton14ActionPerformed

    private void jRadioButton14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton14KeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jRadioButton14KeyReleased

    private void jRadioButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton14MouseClicked
        // TODO add your handling code here:
         if(rdv.getText().length()!=0){
        try{
                ma.setRowCount(0);//pour vider la list des etudient
                {

                    Rs = stm.executeQuery("Select * From rdv WHERE  Date_RDV='"+rdv.getText()+"'");
                }while(Rs.next()){
                    Object[] rdv ={Rs.getString(1),Rs.getString(2),Rs.getString(3),Rs.getInt(4),Rs.getDate(5)
                                      ,Rs.getString(6)};
                    ma.addRow(rdv);
                }if(ma.getRowCount()==0){
                    JOptionPane.showMessageDialog(null,"il y'a aucun Rendez-vous ");
                }
            }catch(Exception e){
                System.err.println(e);
                JOptionPane.showMessageDialog(null,e.getMessage());
            }}else{
             JOptionPane.showMessageDialog(null,"Pouvez vous entrer Votre Recherche SVP");
        }
    }//GEN-LAST:event_jRadioButton14MouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new doctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Date;
    private javax.swing.JTextField Date1;
    private javax.swing.JMenuItem addUser;
    private javax.swing.JTextField age;
    private javax.swing.JTextField age1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JPanel cons;
    private javax.swing.JTable cons_tab;
    private javax.swing.JPanel consultation;
    private javax.swing.JButton dellet1;
    private javax.swing.JPanel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l10;
    private javax.swing.JLabel l11;
    private javax.swing.JLabel l12;
    private javax.swing.JLabel l13;
    private javax.swing.JLabel l14;
    private javax.swing.JLabel l15;
    private javax.swing.JLabel l16;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel l8;
    private javax.swing.JLabel l9;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label2;
    private javax.swing.JTextField num_pat;
    private javax.swing.JTextField num_rdv;
    private javax.swing.JTextArea ord;
    private javax.swing.JTextArea ord1;
    private javax.swing.JTable ord_table;
    private javax.swing.JPanel ordonnance;
    private javax.swing.JTextField pSearchField1;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel1;
    private javax.swing.JTable pat_tab1;
    private javax.swing.JPanel pic;
    private javax.swing.JPanel principale;
    private javax.swing.JTextField rdv;
    private javax.swing.JTable rdv_tab;
    private javax.swing.JComboBox reach_pat1;
    private javax.swing.JButton rechrcherUnOrdonnanceDePatient;
    private javax.swing.JTextField txtadrss1;
    private javax.swing.JTextArea txtarea;
    private javax.swing.JTextArea txtarea1;
    private javax.swing.JTextArea txtcom1;
    private javax.swing.JTextField txtdate_cons;
    private com.toedter.calendar.JDateChooser txtdaterdv1;
    private javax.swing.JTextField txtid_pat1;
    private javax.swing.JTextField txtmotif1;
    private javax.swing.JTextField txtmotif2;
    private javax.swing.JTextField txtnom;
    public javax.swing.JTextField txtnom1;
    private javax.swing.JTextField txtnom2;
    private javax.swing.JTextField txtpre1;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txtprenom1;
    private javax.swing.JTextField txtprenom2;
    private javax.swing.JTextField txtprenom3;
    private javax.swing.JTextField txtprenom4;
    private javax.swing.JTextField txtre;
    private javax.swing.JTextField txtre1;
    private javax.swing.JTextField txttlf1;
    private javax.swing.JPanel v_ord;
    // End of variables declaration//GEN-END:variables
private ImageIcon format,format1,format2,format3,format4,format5,format6,format7,format8,format9,format10,format11,format12,format13,format14,format15;
String imagedata1,imagedata2,imagedata3,imagedata4,imagedata5,imagedata6,imagedata7,imagedata8,imagedata9,imagedata10,imagedata11,imagedata12,imagedata13,imagedata14,imagedata15,imagedata16;
String filename=null;
 int s=0;
 byte[] pers_img =null;
 private String save;
  
}

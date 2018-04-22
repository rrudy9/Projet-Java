 //réda Panel+actionlistener+JButton avec JScroll pour scroller la page
package vue;

import controleur.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Fenetre extends JFrame implements ActionListener{

	private JPanel pan;
	private TestMain controle;
	private JToolBar toolbar ;
        
        
         
        
	private JTabbedPane  tab_onglet ;
	private panel_champs tab_onglet2 ;
	private panel_champs tab_onglet3 ;

        private JScrollPane scroll;
	
        private JScrollPane scroll1;
       
	private JButton bouton1;
	private JButton bouton2;
	private JButton ok_bouton;
	private JButton ajouter_bouton;
        private JButton supprimer_bouton;
        private JButton modifier_bouton;
        private JButton maj;
        
       
        private JTextField nom_login, nom_bdd;
        private JPasswordField pass_login, pass_bdd;
        
        
        private JPanel textfield_login1;
       

        private JPanel login1;
       
        private JPanel loginn1;

         private boolean yeaah;
	
	private JPanel pan1 ;
	private JPanel pan2 ;
	private JPanel pan3 ;
     
	private JPanel result ;
	private JPanel ok ;
	private JPanel ajouter ;
        private JPanel majj;
        public boolean connecte;
        //initialisation 
	public Fenetre(TestMain cntrl) {
		
            controle = cntrl;
            connecte = false;
            this.setSize(900, 600);
            pan = new JPanel(); // instancier le panneau
            toolbar = new JToolBar();
            tab_onglet = new JTabbedPane();
            tab_onglet2 = new panel_champs();
            tab_onglet3 = new panel_champs();
		
            result = new JPanel();
            ok = new JPanel();
            ajouter = new JPanel();
		
            nom_login = new JTextField(8);
            nom_bdd= new JTextField(8);
            pass_bdd=new JPasswordField(8);
            pass_login=new JPasswordField(8);
         
           
           
            
                
            pan1 = new JPanel(); // instancier le panneau
            pan2 = new JPanel(); // instancier le panneau
            pan3 = new JPanel(); // instancier le panneau
		

            ok_bouton= new JButton("OK");
            ajouter_bouton= new JButton("Ajouter");
            supprimer_bouton= new JButton("Supprimer");
            modifier_bouton= new JButton("Modifier");
            maj= new JButton("MaJ");
            majj=new JPanel();
            majj.add(maj);
            
            ok.add(ok_bouton);
            ajouter.add(ajouter_bouton);
            ajouter.add(supprimer_bouton);
            ajouter.add(modifier_bouton);
            
            ok_bouton.addActionListener(this);
            ajouter_bouton.addActionListener(this);
            modifier_bouton.addActionListener(this);
            supprimer_bouton.addActionListener(this);
            maj.addActionListener(this);
                
            result.setBackground(Color.WHITE);
            pan3.setBackground(Color.gray);
		
                

            scroll = new JScrollPane(result,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            scroll.setLayout(new ScrollPaneLayout());
            scroll.setSize(new Dimension(800, 200));
                
            
            pan1.setLayout(new BorderLayout());
            pan1.add(tab_onglet2,BorderLayout.NORTH);
            pan1.add(scroll,BorderLayout.CENTER);
            pan1.add(ok,BorderLayout.SOUTH);
		
            pan2.setLayout(new BorderLayout());
            pan2.add(tab_onglet3,BorderLayout.NORTH);
            pan2.add(ajouter,BorderLayout.SOUTH);
            
            pan3.setLayout(new BorderLayout());
            pan3.add(majj,BorderLayout.SOUTH);

		
            tab_onglet.add("Recherche", pan1);
            tab_onglet.add("Ajouter", pan2);
            tab_onglet.add("Monitoring", pan3);
		
		
		
		
            bouton1= new JButton("Connection locale");
            bouton2= new JButton("Connection ECE");
		
            bouton1.addActionListener(this);
            bouton2.addActionListener(this);
            toolbar.add(bouton1);
            toolbar.add(bouton2);

	
		
		
            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(toolbar,BorderLayout.NORTH);
            getContentPane().add(tab_onglet,BorderLayout.CENTER); //
            this.setVisible(true);
		
	}
        
   
     
        
        
	@Override
	public void actionPerformed(ActionEvent e) {
            
            // TODO Auto-generated method stu
            if(e.getSource() == bouton1) {
                
                controle.connexion();
                connecte = true;
                affiche_chart();

                }
            if (e.getSource()==bouton2){
                
           
                String passECE = new String(pass_login.getPassword());
                String passBDD = new String(pass_bdd.getPassword());
                   
                //JOptionPane.showConfirmDialog(null, login_ece(), "login", JOptionPane.OK_CANCEL_OPTION);
                
                 Object[] options = { "Confirm", "Cancel" };
               int n= JOptionPane.showOptionDialog(null, login_ece(), "login", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                
               if (n==JOptionPane.NO_OPTION && n==JOptionPane.CLOSED_OPTION){
                   connecte=false;
               }
               
               if (n==JOptionPane.OK_OPTION){
                  
                    String st1 = nom_login.getText().trim();
                    String st3= nom_bdd.getText().trim();

                if(st1.compareTo("") == 0 && passECE.compareTo("") == 0 && st3.compareTo("") == 0 && passBDD.compareTo("") == 0){
                    
              JOptionPane.showMessageDialog(null, "champs null", "try again", JOptionPane.WARNING_MESSAGE);

                }
                else {
                    
                   try{
                    controle.connexion_ece(st1, passECE, st3, passBDD);
                    
                    /*if (st1.equals(nom_login) && passECE.equals(passECE) && nom_bdd.getText().equals(nom_bdd)&& passBDD.equals(passBDD)){
                        
                        connecte=true;
                        affiche_chart();
                        JOptionPane.showMessageDialog(null, "Connecte", "Confirm", JOptionPane.WARNING_MESSAGE);
    
                    }
                    else {
                      JOptionPane.showMessageDialog(null, "false", "try again", JOptionPane.WARNING_MESSAGE);
  
                    }*/
                  
                   }catch (Exception f){
                       System.out.println("Ca marche pas");
                   }
               }
               }
            
            }
                
            if(connecte == true){
		if(e.getSource() == ok_bouton) {
                    
                        if(tab_onglet2.getSelectedIndex() ==0){
                            String requete = "";
                            int premier = 1;

                            String st1 = tab_onglet2.tab_jtf_service.get(0).getText().trim();
                            String st2= tab_onglet2.tab_jtf_service.get(1).getText().trim();
                            String st3= tab_onglet2.tab_jtf_service.get(2).getText().trim();
                            int integer =0;
                            if(tab_onglet2.tab_jtf_service.get(3).getText().length() != 0){
                                integer= Integer.parseInt(tab_onglet2.tab_jtf_service.get(3).getText().trim());
                            }
                            if(st1.compareTo("") == 0 && st2.compareTo("") == 0 && st3.compareTo("") == 0 && integer== 0){
                                result.setLayout(new GridLayout(0,4));
                                result.removeAll();
                                ArrayList list =controle.rechercheService(); 
                                ArrayList title = controle.parametre_table("service");
                                String str_temp = "";
                                
                                for(int i = 0;i<4;i++){
                                    result.add(new JLabel(titre_service()[i]));
                                }

                                for(int i = 0;i<list.size();i++){
                                    this.affiche_result(list.get(i).toString().toCharArray());
                                }
                            }
                            
                            else {
                                if (st1.compareTo("") != 0 ){
                                    requete +="`service`.`code`=\""+st1+"\"";
                                    premier = 0;
                                   
                                }
                                if (st2.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }
                                    requete +="`service`.`nom`=\""+st2+"\"";
                                    premier = 0;

                                }
                                if (st3.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }
                                    requete +="`service`.`batiment`=\""+st3+"\"";
                                    premier = 0;

                                }
                                if (integer != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }
                                    requete +="`service`.`directeur`=\""+integer+"\"";
                                    premier = 0;

                                }
                                
                                if (premier==0){
                                    requete+="AND";
                                    requete+="`service`.`directeur`"+"="+"`docteur`.`numero`" ;
                                }
                                
                                if (premier==0){
                                    requete+="AND";
                                    requete+="`docteur`.`numero`"+"="+"`employe`.`numero`";
                                }
                                

                                ArrayList list =controle.recherche_requete_service("`service`","`docteur`","`employe`",requete); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,5));

                                result.removeAll();
                                for(int i = 0;i<5;i++){
                                    result.add(new JLabel(titre_service_requete()[i]));
                                }
                                
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());
                                }



                            }
                            System.out.println(controle.rechercheService());
                            }
                    
                    
                        if(tab_onglet2.getSelectedIndex() ==1){
                            String requete = "";
                            int premier = 1;

                            String st1 = tab_onglet2.tab_jtf_chambre.get(0).getText().trim();

                            int integer1 =0;
                            if(tab_onglet2.tab_jtf_chambre.get(1).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet2.tab_jtf_chambre.get(1).getText().trim());
                            }
                            int integer2 =0;
                            if(tab_onglet2.tab_jtf_chambre.get(2).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet2.tab_jtf_chambre.get(2).getText().trim());
                            }                        
                            int integer3 =0;
                            if(tab_onglet2.tab_jtf_chambre.get(3).getText().length() != 0){
                                integer3= Integer.parseInt(tab_onglet2.tab_jtf_chambre.get(3).getText().trim());
                            }
                            if(st1.compareTo("") == 0 && integer1== 0 && integer2== 0 && integer3== 0){


                                ArrayList list =controle.rechercheChambre(); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,4));
                                result.removeAll();
                                for(int i = 0;i<4;i++){
                                    result.add(new JLabel(titre_chambre()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());}

                                System.out.println(controle.rechercheChambre());

                            }

                            else{
                                if (st1.compareTo("") != 0 ){
                                    requete +="`code_service`=\""+st1+"\"";
                                    premier = 0;
                                }
                                if (integer1 != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`no_chambre`=\""+integer1+"\"";
                                    premier = 0;

                                }
                                if (integer2 != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }
                                    requete +="`surveillant`=\""+integer2+"\"";
                                    premier = 0;

                                }
                                if (integer3 != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }
                                    requete +="`nb_lits`=\""+integer3+"\"";
                                    premier = 0;

                                }

                                ArrayList list =controle.recherche_requete("`chambre`",requete); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,4));
                                result.removeAll();
                                for(int i = 0;i<4;i++){
                                    result.add(new JLabel(titre_chambre()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());
                                }
                            }  
                        }
                          
                        
                        if(tab_onglet2.getSelectedIndex() ==2){
                            String requete = "";
                            int premier = 1;

                            int integer =0;
                            if(tab_onglet2.tab_jtf_employe.get(0).getText().length() != 0){
                                integer= Integer.parseInt(tab_onglet2.tab_jtf_employe.get(0).getText().trim());
                            }
                            String st1= tab_onglet2.tab_jtf_employe.get(1).getText().trim();
                            String st2= tab_onglet2.tab_jtf_employe.get(2).getText().trim();
                            String st3= tab_onglet2.tab_jtf_employe.get(3).getText().trim();
                            String st4= tab_onglet2.tab_jtf_employe.get(4).getText().trim();

                            if(integer == 0 && st1.compareTo("") == 0 && st2.compareTo("") == 0 && st3.compareTo("") == 0 && st4.compareTo("")==0 ){
                                result.setLayout(new GridLayout(0,6));
                                result.removeAll();
                                ArrayList list =controle.rechercheEmploye(); 
                                ArrayList title = controle.parametre_table("employe");
                                String str_temp = "";
                                for(int i = 0;i<6;i++){
                                    result.add(new JLabel(titre_employe()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    this.affiche_result(list.get(i).toString().toCharArray());
                                }
                            }
                            else {

                                if (integer != 0 ){
                                    requete +="`numero`=\""+integer+"\"";
                                    premier = 0;
                                }
                                if (st1.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }
                                    requete +="`nom`=\""+st1+"\"";
                                    premier = 0;

                                }
                                if (st2.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }
                                    requete +="`prenom`=\""+st2+"\"";
                                    premier = 0;

                                }
                                if (st3.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }
                                    requete +="`adresse`=\""+st3+"\"";
                                    premier = 0;

                                }
                                if (st4.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }
                                    requete +="`tel`=\""+st4+"\"";
                                    premier = 0;

                                }

                                ArrayList list =controle.recherche_requete("`employe`",requete); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,6));

                                result.removeAll();
                                 for(int i = 0;i<6;i++){
                                    result.add(new JLabel(titre_employe()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());
                                }

                            }
                           
                        }
       
                        if(tab_onglet2.getSelectedIndex() ==3){
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet2.tab_jtf_docteur.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet2.tab_jtf_docteur.get(0).getText().trim());
                            }
                            
                            String st1 = tab_onglet2.tab_jtf_docteur.get(1).getText().trim();
                          
                            if( integer1== 0 && st1.compareTo("") == 0 ){


                                ArrayList list =controle.rechercheDocteur(); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,2));
                                result.removeAll();
                                for(int i = 0;i<2;i++){
                                    result.add(new JLabel(titre_docteur()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());}

                                System.out.println(controle.rechercheDocteur());

                            }

                            else{
                                if (integer1 != 0 ){
                                    requete +="`docteur`.`numero`=\""+integer1+"\"";
                                    premier = 0;
                                }
                                if (st1.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`specialite`=\""+st1+"\"";
                                    premier = 0;
                                }
                                
                                if (premier==0){
                                    requete+="AND";
                                    requete+="`docteur`.`numero`"+"="+"`employe`.`numero`";
                                }
                  
                                ArrayList list =controle.recherche_requete_docteur("`docteur`", "`employe`", requete); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,3));
                                result.removeAll();
                                for(int i = 0;i<3;i++){
                                    result.add(new JLabel(titre_docteur_requete()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());
                                }
                            }  
                        }
                        
                        if(tab_onglet2.getSelectedIndex() ==4){
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet2.tab_jtf_infirmier.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet2.tab_jtf_infirmier.get(0).getText().trim());
                            }
                            
                            
                            String st1 = tab_onglet2.tab_jtf_infirmier.get(1).getText().trim();
                            String st2 = tab_onglet2.tab_jtf_infirmier.get(2).getText().trim();
                          
                            int integer2 =0;
                            if(tab_onglet2.tab_jtf_infirmier.get(3).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet2.tab_jtf_infirmier.get(3).getText().trim());
                            }
                            if( integer1== 0 && st1.compareTo("") == 0 && st2.compareTo("") == 0 && integer2 == 0 ){


                                ArrayList list =controle.rechercheInfirmier(); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,4));
                                result.removeAll();
                                for(int i = 0;i<4;i++){
                                    result.add(new JLabel(titre_infirmier()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());}

                                System.out.println(controle.rechercheInfirmier());

                            }

                            else{
                                if (integer1 != 0 ){
                                    requete +="`infirmier`.`numero`=\""+integer1+"\"";
                                    premier = 0;
                                }
                                if (st1.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`code_service`=\""+st1+"\"";
                                    premier = 0;

                                }       
                                
                                if (st2.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`rotation`=\""+st2+"\"";
                                    premier = 0;

                                }       
                                if (integer2 != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`salaire`=\""+integer2+"\"";
                                    premier = 0;

                                }
                             
                                if (premier==0){
                                    requete+="AND";
                                    requete+="`infirmier`.`numero`"+ "="+ "`employe`.`numero`";
                                }
                              // requete += "AND" + "`infirmier`.numero=" +integer1+"="+ "`employe`.numero="+tab_onglet2.tab_jtf_employe.get(0).getText();
                               
                                
                                
                                
                                ArrayList list =controle.recherche_requete_infirmier("`infirmier`","`employe`",requete); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,2));
                                result.removeAll();
                                 for(int i = 0;i<2;i++){
                                    result.add(new JLabel(titre_infirmier_requete()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());
                                }
                            }  
                        }
                        
                        if(tab_onglet2.getSelectedIndex() ==5){
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet2.tab_jtf_malade.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet2.tab_jtf_malade.get(0).getText().trim());
                            }
                            
                            String st1 = tab_onglet2.tab_jtf_malade.get(1).getText().trim();
                            String st2 = tab_onglet2.tab_jtf_malade.get(2).getText().trim();
                            String st3 = tab_onglet2.tab_jtf_malade.get(3).getText().trim();
                            String st4 = tab_onglet2.tab_jtf_malade.get(4).getText().trim();
                            String st5 = tab_onglet2.tab_jtf_malade.get(5).getText().trim();
                          
                          
                            if( integer1== 0 && st1.compareTo("") == 0 && st2.compareTo("") == 0 && st3.compareTo("") == 0 && st4.compareTo("") ==0 && st5.compareTo("") ==0  ){


                                ArrayList list =controle.rechercheMalade(); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,7));
                                result.removeAll();
                                
                               for(int i = 0;i<7;i++){
                                    result.add(new JLabel(titre_malade()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());}

                                System.out.println(controle.rechercheMalade());

                            }

                            else{
                                if (integer1 != 0 ){
                                    requete +="`numero`=\""+integer1+"\"";
                                    premier = 0;
                                }
                                if (st1.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`nom`=\""+st1+"\"";
                                    premier = 0;

                                }       
                                
                                if (st2.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`prenom`=\""+st2+"\"";
                                    premier = 0;

                                }       
                                if (st3.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`adresse`=\""+st3+"\"";
                                    premier = 0;

                                }  
                                
                                if (st4.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`tel`=\""+st4+"\"";
                                    premier = 0;

                                }
                                
                                if (st5.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`mutuelle`=\""+st5+"\"";
                                    premier = 0;

                                }
                         
                                ArrayList list =controle.recherche_requete_malade("`malade`",requete); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,2));
                                result.removeAll();
                                for(int i = 0;i<2;i++){
                                    result.add(new JLabel(titre_malade_requete()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());
                                }
                            }  
                        }
                        
                        if(tab_onglet2.getSelectedIndex() ==6){
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet2.tab_jtf_hospital.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet2.tab_jtf_hospital.get(0).getText().trim());
                            }
                            
                            String st1 = tab_onglet2.tab_jtf_hospital.get(1).getText().trim();
                           
                            int integer2 =0;
                            if(tab_onglet2.tab_jtf_hospital.get(2).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet2.tab_jtf_hospital.get(2).getText().trim());
                            } 
                            
                            int integer3 =0;
                            if(tab_onglet2.tab_jtf_hospital.get(3).getText().length() != 0){
                                integer3= Integer.parseInt(tab_onglet2.tab_jtf_hospital.get(3).getText().trim());
                            }
                          
                        
                            if( integer1== 0 && st1.compareTo("") == 0 && integer2 == 0 && integer3 == 0){


                                ArrayList list =controle.rechercheHospital(); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,4));
                                result.removeAll();
                                for(int i = 0;i<4;i++){
                                    result.add(new JLabel(titre_hopital()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());}

                                System.out.println(controle.rechercheHospital());

                            }

                            else{
                                if (integer1 != 0 ){
                                    requete +="`no_malade`=\""+integer1+"\"";
                                    premier = 0;
                                }
                                if (st1.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`code_service`=\""+st1+"\"";
                                    premier = 0;

                                }       
                                
                                if (integer2 != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`no_chambre`=\""+integer2+"\"";
                                    premier = 0;

                                }       
                                if (integer3 != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`lit`=\""+integer3+"\"";
                                    premier = 0;

                                } 
                                
                                
                                if (premier==0){
                                    requete+="AND";
                                    requete+="`hospitalisation`.`no_malade`"+ "="+ "`malade`.`numero`";
                                    
                                }
                                
                            
                                ArrayList list =controle.recherche_requete_hopital("`hospitalisation`","`malade`",requete); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,6));
                                result.removeAll();
                                for(int i = 0;i<6;i++){
                                    result.add(new JLabel(titre_hopital_requete()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());
                                }
                            }  
                        }
                        
                        if(tab_onglet2.getSelectedIndex() ==7){
                           
      
                            
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet2.tab_jtf_soin.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet2.tab_jtf_soin.get(0).getText().trim());
                            }
                            
                            int integer2 =0;
                            if(tab_onglet2.tab_jtf_soin.get(1).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet2.tab_jtf_soin.get(1).getText().trim());
                            } 
                            
                            if( integer1== 0 && integer2 == 0 ){


                                ArrayList list =controle.rechercheSoin(); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,2));
                                result.removeAll();
                                for(int i = 0;i<2;i++){
                                    result.add(new JLabel(titre_soin()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());}

                                System.out.println(controle.rechercheSoin());
                                    
                            }

                            else{
                                if (integer1 != 0 ){
                                    requete +="`no_docteur`=\""+integer1+"\"";
                                    premier = 0;
                                }
                    
                                if (integer2 != 0 ){
                                    if (premier ==0){
                                        requete += " AND ";
                                    }

                                    requete +="`no_malade`=\""+integer2+"\"";
                                    premier = 0;

                                }
                                
                                 if (premier==0){
                                    requete+="AND";
                                    requete+="`docteur`.`numero`"+ "="+ "`soigne`.`no_docteur` AND `employe`.`numero`"+ "="+ "`docteur`.`numero` AND `malade`.`numero`"+ "="+ "`soigne`.`no_malade`";
                                    
                                }
                                
               
                                ArrayList list =controle.recherche_requete_soin("`soigne`","`docteur`","`employe`","`malade`",requete); 
                                ArrayList title = controle.parametre_table("");
                                result.setLayout(new GridLayout(0,6));
                                result.removeAll();
                                for(int i = 0;i<6;i++){
                                    result.add(new JLabel(titre_soin_requete()[i]));
                                }
                                for(int i = 0;i<list.size();i++){
                                    affiche_result(list.get(i).toString().toCharArray());
                                }
                            }  
                        }
                        
                   
                }
                    
                        
                        
                        
                        
                        
                        


                    
                    
                      
                                                                                                
                        
                    
                if (e.getSource()== ajouter_bouton){
                    
                    if(tab_onglet3.getSelectedIndex() ==0){
                        
                        String requete = "";
                        String p1="";
                        String p2="";
                        String p3="";
                        int premier = 1;

                        String st1 = tab_onglet3.tab_jtf_service.get(0).getText().trim();
                        String st2= tab_onglet3.tab_jtf_service.get(1).getText().trim();
                        String st3= tab_onglet3.tab_jtf_service.get(2).getText().trim();
                        int integer =0;
                        if(tab_onglet3.tab_jtf_service.get(3).getText().length() != 0){
                            integer= Integer.parseInt(tab_onglet3.tab_jtf_service.get(3).getText().trim());
                        }
                        if(st1.compareTo("") == 0 && st2.compareTo("") == 0 && st3.compareTo("") == 0 && integer== 0){
                           
                            JOptionPane jop2 = new JOptionPane();
                            jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }
                            else {
                                
                                if (st1.compareTo("") != 0 ){
                                    requete +="\""+st1+"\"";
                                    premier = 0;
                                }
                                if (st2.compareTo("") != 0 ){
                                   
                                    p1="\""+st2+"\"";
                                    premier = 0;

                                }
                                if (st3.compareTo("") != 0 ){
                                    
                                    p2="\""+st3+"\"";
                                    premier = 0;

                                }
                                if (integer != 0 ){
                                    
                                    p3="\""+integer+"\"";
                                    premier = 0;

                                }
                  
                                controle.ajouter(controle.write_requete_ajout_service(requete, p1, p2, p3));

                                //controle.ajouter_requete_service("`service`",requete); 
                                JOptionPane jop2 = new JOptionPane();
                                 jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);
                              



                            }
                           
                            }
                    
                    
                    
                        if(tab_onglet3.getSelectedIndex() ==1){
                            String requete = "";
                            String p1="";
                            String p2="";
                            String p3="";
                            int premier = 1;

                            String st1 = tab_onglet3.tab_jtf_chambre.get(0).getText().trim();

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_chambre.get(1).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_chambre.get(1).getText().trim());
                            }
                            int integer2 =0;
                            if(tab_onglet3.tab_jtf_chambre.get(2).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet3.tab_jtf_chambre.get(2).getText().trim());
                            }                        
                            int integer3 =0;
                            if(tab_onglet3.tab_jtf_chambre.get(3).getText().length() != 0){
                                integer3= Integer.parseInt(tab_onglet3.tab_jtf_chambre.get(3).getText().trim());
                            }
                            if(st1.compareTo("") == 0 && integer1== 0 && integer2== 0 && integer3== 0){
                                
                                    JOptionPane jop2 = new JOptionPane();
                                    jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                                if (st1.compareTo("") != 0 ){
                                    requete +="\""+st1+"\"";
                                    premier = 0;
                                }
                                if (integer1 != 0 ){
                                    
                                    p1="\""+integer1+"\"";
                                    premier = 0;

                                }
                                if (integer2 != 0 ){
                                    
                                    p2="\""+integer2+"\"";
                                    premier = 0;

                                }
                                if (integer3 != 0 ){
                                    
                                    p3="\""+integer3+"\"";
                                    premier = 0;

                                }

                                controle.ajouter(controle.write_requete_ajout_chambre(p1, p3, requete, p2));

                               //controle.ajouter_requete_chambre("`chambre`",requete); 
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);
                            }  
                        }
            
                        if(tab_onglet3.getSelectedIndex() ==2){
                            String requete = "";
                            int premier = 1;

                            int integer =0;
                            if(tab_onglet3.tab_jtf_employe.get(0).getText().length() != 0){
                                integer= Integer.parseInt(tab_onglet3.tab_jtf_employe.get(0).getText().trim());
                            }
                            String st1= tab_onglet3.tab_jtf_employe.get(1).getText().trim();
                            String st2= tab_onglet3.tab_jtf_employe.get(2).getText().trim();
                            String st3= tab_onglet3.tab_jtf_employe.get(3).getText().trim();
                            String st4= tab_onglet3.tab_jtf_employe.get(4).getText().trim();

                            if(integer == 0 && st1.compareTo("") == 0 && st2.compareTo("") == 0 && st3.compareTo("") == 0 && st4.compareTo("")==0 ){
                              JOptionPane jop2 = new JOptionPane();
                              jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }
                            else {
                                if (integer != 0 ){
                                    requete +="\""+integer+"\"";
                                    premier = 0;
                                }
                                if (st1.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += ",";
                                    }
                                    requete +="\""+st1+"\"";
                                    premier = 0;

                                }
                                if (st2.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += ",";
                                    }
                                    requete +="\""+st2+"\"";
                                    premier = 0;

                                }
                                if (st3.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += ",";
                                    }
                                    requete +="\""+st3+"\"";
                                    premier = 0;

                                }
                                if (st4.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += ",";
                                    }
                                    requete +="\""+st4+"\"";
                                    premier = 0;

                                }
                               
                                    controle.ajouter_requete_employe("`employe`",requete); 
                             
                                    JOptionPane jop2 = new JOptionPane();
                                    jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);

                                }

                            }
                        
                        
                        if(tab_onglet3.getSelectedIndex() ==3){
                            String requete = "";
                            int premier = 1;
                            String p="";
                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_docteur.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_docteur.get(0).getText().trim());
                            }
                            
                            String st1 = tab_onglet3.tab_jtf_docteur.get(1).getText().trim();
                          
                            if( integer1== 0 && st1.compareTo("") == 0 ){
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                                if (integer1 != 0 ){
                                    requete +="\""+integer1+"\"";
                                    premier = 0;
                                }
                                if (st1.compareTo("") != 0 ){
                                    
                                    premier = 0;
                                    p="\""+st1+"\"";
                                }
                             
                                controle.ajouter_requete_docteur("`docteur`","`employe`",p,requete); 
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);
                            }  
                        }
                        
                        
                        if(tab_onglet3.getSelectedIndex() ==4){
                            String requete = "";
                            String p1=""; 
                            String p2=""; 
                           String p3="";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_infirmier.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_infirmier.get(0).getText().trim());
                            }
                            
                            
                            String st1 = tab_onglet3.tab_jtf_infirmier.get(1).getText().trim();
                            String st2 = tab_onglet3.tab_jtf_infirmier.get(2).getText().trim();
                          
                            int integer2 =0;
                            if(tab_onglet3.tab_jtf_infirmier.get(3).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet3.tab_jtf_infirmier.get(3).getText().trim());
                            }
                            if( integer1== 0 && st1.compareTo("") == 0 && st2.compareTo("") == 0 && integer2 == 0 ){
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                                if (integer1 != 0 ){
                                    requete +="\""+integer1+"\"";
                                    premier = 0;
                                }
                                if (st1.compareTo("") != 0 ){
                                    
                                    premier = 0;
                                    p1="\""+st1+"\"";


                                }       
                                
                                if (st2.compareTo("") != 0 ){
                                   
                                    p2="\""+st2+"\"";
                                    premier = 0;


                                }       
                                if (integer2 != 0 ){
                                   

                                    p3="\""+integer2+"\"";
                                    premier = 0;

                                }
                             
                                controle.ajouter(controle.write_requete_ajout_infirmier(p2, p3, requete, p1));
                                //controle.ajouter_requete_infirmier("`infirmier`","`employe`","`service`",p2,p3,requete,p1); 
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);
                               
                            }  
                        }
                        
                        
                        if(tab_onglet3.getSelectedIndex() ==5){
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_malade.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_malade.get(0).getText().trim());
                            }
                            
                            String st1 = tab_onglet3.tab_jtf_malade.get(1).getText().trim();
                            String st2 = tab_onglet3.tab_jtf_malade.get(2).getText().trim();
                            String st3 = tab_onglet3.tab_jtf_malade.get(3).getText().trim();
                            String st4 = tab_onglet3.tab_jtf_malade.get(4).getText().trim();
                            String st5 = tab_onglet3.tab_jtf_malade.get(5).getText().trim();
                          
                          
                            if( integer1== 0 && st1.compareTo("") == 0 && st2.compareTo("") == 0 && st3.compareTo("") == 0 && st4.compareTo("") ==0 && st5.compareTo("") ==0  ){
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                                if (integer1 != 0 ){
                                    requete +="\""+integer1+"\"";
                                    premier = 0;
                                }
                                if (st1.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += ",";
                                    }

                                    requete +="\""+st1+"\"";
                                    premier = 0;

                                }       
                                
                                if (st2.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += ",";
                                    }

                                    requete +="\""+st2+"\"";
                                    premier = 0;

                                }       
                                if (st3.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += ",";
                                    }

                                    requete +="\""+st3+"\"";
                                    premier = 0;

                                }  
                                
                                if (st4.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += ",";
                                    }

                                    requete +="\""+st4+"\"";
                                    premier = 0;

                                }
                                
                                if (st5.compareTo("") != 0 ){
                                    if (premier ==0){
                                        requete += ",";
                                    }

                                    requete +="\""+st5+"\"";
                                    premier = 0;

                                }
                         
                                controle.ajouter_requete_malade("`malade`",requete); 
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);
                            }  
                        }
                        
                        if(tab_onglet3.getSelectedIndex() ==6){
                            String requete = "";
                            String p1="";
                            String p2="";
                            String p3="";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_hospital.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_hospital.get(0).getText().trim());
                            }
                            
                            String st1 = tab_onglet3.tab_jtf_hospital.get(1).getText().trim();
                           
                            int integer2 =0;
                            if(tab_onglet3.tab_jtf_hospital.get(2).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet3.tab_jtf_hospital.get(2).getText().trim());
                            } 
                            
                            int integer3 =0;
                            if(tab_onglet3.tab_jtf_hospital.get(3).getText().length() != 0){
                                integer3= Integer.parseInt(tab_onglet3.tab_jtf_hospital.get(3).getText().trim());
                            }
                          
                        
                            if( integer1== 0 && st1.compareTo("") == 0 && integer2 == 0 && integer3 == 0){
                                
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                                if (integer1 != 0 ){
                                    requete +="\""+integer1+"\"";
                                    premier = 0;
                                }
                                if (st1.compareTo("") != 0 ){
                                    

                                    p1="\""+st1+"\"";
                                    premier = 0;

                                }       
                                
                                if (integer2 != 0 ){
                                   

                                    p2="\""+integer2+"\"";
                                    premier = 0;

                                }       
                                if (integer3 != 0 ){
                                  

                                    p3="\""+integer3+"\"";
                                    premier = 0;

                                }  
                                
                                controle.ajouter(controle.write_requete_ajout_hopital(p3,requete,p1,p2));

                                //controle.ajouter_requete_hopital("`hospitalisation`",requete); 
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);
                            }  
                        }
                         
                        if(tab_onglet3.getSelectedIndex() ==7){
                           
      
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_soin.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_soin.get(0).getText().trim());
                            }
                            
                            int integer2 =0;
                            if(tab_onglet3.tab_jtf_soin.get(1).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet3.tab_jtf_soin.get(1).getText().trim());
                            } 
                            
                            if( integer1== 0 && integer2 == 0 ){
                                 
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                                if (integer1 != 0 ){
                                    requete +="\""+integer1+"\"";
                                    premier = 0;
                                }
                    
                                if (integer2 != 0 ){
                                    if (premier ==0){
                                        requete += ",";
                                    }

                                    requete +="\""+integer2+"\"";
                                    premier = 0;

                                }       
               
                               controle.ajouter_requete_soigne("`soigne`",requete); 
                               JOptionPane jop2 = new JOptionPane();
                               jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);
                            }  
                        }  
                }
                
                if (e.getSource()==supprimer_bouton){
                    
                    if(tab_onglet3.getSelectedIndex() ==0){
                        
                        String requete = "";
                        int premier = 1;
                        
                        String st1 = tab_onglet3.tab_jtf_service.get(0).getText().trim();
                        String st2= tab_onglet3.tab_jtf_service.get(1).getText().trim();
                        String st3= tab_onglet3.tab_jtf_service.get(2).getText().trim();
                        int integer =0;
                        if(tab_onglet3.tab_jtf_service.get(3).getText().length() != 0){
                            integer= Integer.parseInt(tab_onglet3.tab_jtf_service.get(3).getText().trim());
                        }
                        if(st1.compareTo("") == 0 && st2.compareTo("") == 0 && st3.compareTo("") == 0 && integer== 0){
                           
                            JOptionPane jop2 = new JOptionPane();
                            jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }
                            else {
                                JOptionPane jop2 = new JOptionPane();
                                if (jop2.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                                    controle.supprimer(controle.write_requete_delete_service(st1));
                                }else {
                                    
                                }
                   
                                
                                
                            }
                           
                        }
                    
                        if(tab_onglet3.getSelectedIndex() ==1){
                            String requete = "";
                            int premier = 1;

                            String st1 = tab_onglet3.tab_jtf_chambre.get(0).getText().trim();

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_chambre.get(1).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_chambre.get(1).getText().trim());
                            }
                            int integer2 =0;
                            if(tab_onglet3.tab_jtf_chambre.get(2).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet3.tab_jtf_chambre.get(2).getText().trim());
                            }                        
                            int integer3 =0;
                            if(tab_onglet3.tab_jtf_chambre.get(3).getText().length() != 0){
                                integer3= Integer.parseInt(tab_onglet3.tab_jtf_chambre.get(3).getText().trim());
                            }
                            if(st1.compareTo("") == 0 && integer1== 0 && integer2== 0 && integer3== 0){
                                
                                    JOptionPane jop2 = new JOptionPane();
                                    jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                                JOptionPane jop2 = new JOptionPane();
                                if (jop2.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                                    controle.supprimer(controle.write_requete_delete_chambre(st1,integer1));
                                }else {
                                    
                                }
                   
                                
                                
                               
                            }
                            }
                        
                        if(tab_onglet3.getSelectedIndex() ==2){
                            String requete = "";
                            int premier = 1;

                            int integer =0;
                            if(tab_onglet3.tab_jtf_employe.get(0).getText().length() != 0){
                                integer= Integer.parseInt(tab_onglet3.tab_jtf_employe.get(0).getText().trim());
                            }
                            String st1= tab_onglet3.tab_jtf_employe.get(1).getText().trim();
                            String st2= tab_onglet3.tab_jtf_employe.get(2).getText().trim();
                            String st3= tab_onglet3.tab_jtf_employe.get(3).getText().trim();
                            String st4= tab_onglet3.tab_jtf_employe.get(4).getText().trim();

                            if(integer == 0 && st1.compareTo("") == 0 && st2.compareTo("") == 0 && st3.compareTo("") == 0 && st4.compareTo("")==0 ){
                              JOptionPane jop2 = new JOptionPane();
                              jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }
                            else{
                                
                                JOptionPane jop2 = new JOptionPane();
                                if (jop2.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                                    controle.supprimer(controle.write_requete_delete_employe(integer));
                                }else {
                                    
                                }
                        
                            }
                        
                }
                        
                         if(tab_onglet3.getSelectedIndex() ==3){
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_docteur.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_docteur.get(0).getText().trim());
                            }
                            
                            String st1 = tab_onglet3.tab_jtf_docteur.get(1).getText().trim();
                          
                            if( integer1== 0 && st1.compareTo("") == 0 ){
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                               
                                
                                JOptionPane jop2 = new JOptionPane();
                                if (jop2.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                                controle.supprimer(controle.write_requete_delete_docteur(integer1)); 
                                }else {
                                    
                                }
                        
                             
                            }  
                        }
                        
                        
                        if(tab_onglet3.getSelectedIndex() ==4){
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_infirmier.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_infirmier.get(0).getText().trim());
                            }
                            
                            
                            String st1 = tab_onglet3.tab_jtf_infirmier.get(1).getText().trim();
                            String st2 = tab_onglet3.tab_jtf_infirmier.get(2).getText().trim();
                          
                            int integer2 =0;
                            if(tab_onglet3.tab_jtf_infirmier.get(3).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet3.tab_jtf_infirmier.get(3).getText().trim());
                            }
                            if( integer1== 0 && st1.compareTo("") == 0 && st2.compareTo("") == 0 && integer2 == 0 ){
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                              
                                JOptionPane jop2 = new JOptionPane();
                                if (jop2.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                                controle.supprimer(controle.write_requete_delete_infirmier(integer1));
                                }else {
                                    
                                }
                                
                                
                            }  
                        }
                        
                        
                        if(tab_onglet3.getSelectedIndex() ==5){
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_malade.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_malade.get(0).getText().trim());
                            }
                            
                            String st1 = tab_onglet3.tab_jtf_malade.get(1).getText().trim();
                            String st2 = tab_onglet3.tab_jtf_malade.get(2).getText().trim();
                            String st3 = tab_onglet3.tab_jtf_malade.get(3).getText().trim();
                            String st4 = tab_onglet3.tab_jtf_malade.get(4).getText().trim();
                            String st5 = tab_onglet3.tab_jtf_malade.get(5).getText().trim();
                          
                          
                            if( integer1== 0 && st1.compareTo("") == 0 && st2.compareTo("") == 0 && st3.compareTo("") == 0 && st4.compareTo("") ==0 && st5.compareTo("") ==0  ){
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                                
                                JOptionPane jop2 = new JOptionPane();
                                if (jop2.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                                controle.supprimer(controle.write_requete_delete_malade(integer1));
                                }else {
                                    
                                }
                                
                            }  
                        }
                        
                        if(tab_onglet3.getSelectedIndex() ==6){
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_hospital.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_hospital.get(0).getText().trim());
                            }
                            
                            String st1 = tab_onglet3.tab_jtf_hospital.get(1).getText().trim();
                           
                            int integer2 =0;
                            if(tab_onglet3.tab_jtf_hospital.get(2).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet3.tab_jtf_hospital.get(2).getText().trim());
                            } 
                            
                            int integer3 =0;
                            if(tab_onglet3.tab_jtf_hospital.get(3).getText().length() != 0){
                                integer3= Integer.parseInt(tab_onglet3.tab_jtf_hospital.get(3).getText().trim());
                            }
                          
                        
                            if( integer1== 0 && st1.compareTo("") == 0 && integer2 == 0 && integer3 == 0){
                                
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                            
                                JOptionPane jop2 = new JOptionPane();
                                if (jop2.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                                controle.supprimer(controle.write_requete_delete_hopital(integer1));
                                }else {
                                    
                                }
                                
                                
                                
                            }  
                        }
                         
                        if(tab_onglet3.getSelectedIndex() ==7){
                           
      
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_soin.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_soin.get(0).getText().trim());
                            }
                            
                            int integer2 =0;
                            if(tab_onglet3.tab_jtf_soin.get(1).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet3.tab_jtf_soin.get(1).getText().trim());
                            } 
                            
                            if( integer1== 0 && integer2 == 0 ){
                                 
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                                
                                JOptionPane jop2 = new JOptionPane();
                                if (jop2.showConfirmDialog(null, "Are you sure?", "WARNING", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
                               controle.supprimer(controle.write_requete_delete_soin(integer1,integer2));
                                }else {
                                    
                                }
                                
                                
                                

                       
                            }  
                        }  
             
                    }
      
                if (e.getSource()== modifier_bouton){
                    if(tab_onglet3.getSelectedIndex() ==0){
                        
                        String requete = "";
                        int premier = 1;

                        String st1 = tab_onglet3.tab_jtf_service.get(0).getText().trim();
                        String st2= tab_onglet3.tab_jtf_service.get(1).getText().trim();
                        String st3= tab_onglet3.tab_jtf_service.get(2).getText().trim();
                        int integer =0;
                        if(tab_onglet3.tab_jtf_service.get(3).getText().length() != 0){
                            integer= Integer.parseInt(tab_onglet3.tab_jtf_service.get(3).getText().trim());
                        }
                        if(st1.compareTo("") == 0 && st2.compareTo("") == 0 && st3.compareTo("") == 0 && integer== 0){
                           
                            JOptionPane jop2 = new JOptionPane();
                            jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }
                            else {
                                
                                controle.modifier(controle.write_requete_update_service(st1,st2,st3,integer));
                                JOptionPane jop2 = new JOptionPane();
                                 jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);
                   
                            }
                           
                        }
                    
                        if(tab_onglet3.getSelectedIndex() ==1){
                            String requete = "";
                            int premier = 1;

                            String st1 = tab_onglet3.tab_jtf_chambre.get(0).getText().trim();

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_chambre.get(1).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_chambre.get(1).getText().trim());
                            }
                            int integer2 =0;
                            if(tab_onglet3.tab_jtf_chambre.get(2).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet3.tab_jtf_chambre.get(2).getText().trim());
                            }                        
                            int integer3 =0;
                            if(tab_onglet3.tab_jtf_chambre.get(3).getText().length() != 0){
                                integer3= Integer.parseInt(tab_onglet3.tab_jtf_chambre.get(3).getText().trim());
                            }
                            if(st1.compareTo("") == 0 && integer1== 0 && integer2== 0 && integer3== 0){
                                
                                    JOptionPane jop2 = new JOptionPane();
                                    jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                      
                               controle.modifier(controle.write_requete_update_chambre(st1, integer1, integer2, integer3));
                               
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);}
                            }
                        
                        if(tab_onglet3.getSelectedIndex() ==2){
                            String requete = "";
                            int premier = 1;

                            int integer =0;
                            if(tab_onglet3.tab_jtf_employe.get(0).getText().length() != 0){
                                integer= Integer.parseInt(tab_onglet3.tab_jtf_employe.get(0).getText().trim());
                            }
                            String st1= tab_onglet3.tab_jtf_employe.get(1).getText().trim();
                            String st2= tab_onglet3.tab_jtf_employe.get(2).getText().trim();
                            String st3= tab_onglet3.tab_jtf_employe.get(3).getText().trim();
                            String st4= tab_onglet3.tab_jtf_employe.get(4).getText().trim();

                            if(integer == 0 && st1.compareTo("") == 0 && st2.compareTo("") == 0 && st3.compareTo("") == 0 && st4.compareTo("")==0 ){
                              JOptionPane jop2 = new JOptionPane();
                              jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }
                            else{
                            controle.modifier(controle.write_requete_update_employe(integer, st1, st2, st3, st4));
                            
                            JOptionPane jop3 = new JOptionPane();
                            jop3.showMessageDialog(null, "okkk", "OK", JOptionPane.WARNING_MESSAGE);}
                        
                }
                        
                         if(tab_onglet3.getSelectedIndex() ==3){
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_docteur.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_docteur.get(0).getText().trim());
                            }
                            
                            String st1 = tab_onglet3.tab_jtf_docteur.get(1).getText().trim();
                          
                            if( integer1== 0 && st1.compareTo("") == 0 ){
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                               
                             
                                controle.modifier(controle.write_requete_update_docteur(integer1, st1));
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);
                            }  
                        }
                        
                        
                        if(tab_onglet3.getSelectedIndex() ==4){
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_infirmier.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_infirmier.get(0).getText().trim());
                            }
                            
                            
                            String st1 = tab_onglet3.tab_jtf_infirmier.get(1).getText().trim();
                            String st2 = tab_onglet3.tab_jtf_infirmier.get(2).getText().trim();
                          
                            int integer2 =0;
                            if(tab_onglet3.tab_jtf_infirmier.get(3).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet3.tab_jtf_infirmier.get(3).getText().trim());
                            }
                            if( integer1== 0 && st1.compareTo("") == 0 && st2.compareTo("") == 0 && integer2 == 0 ){
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                              
                                controle.modifier(controle.write_requete_update_infirmier(integer1, st1, st2, integer2));
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);
                               
                            }  
                        }
                        
                        
                        if(tab_onglet3.getSelectedIndex() ==5){
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_malade.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_malade.get(0).getText().trim());
                            }
                            
                            String st1 = tab_onglet3.tab_jtf_malade.get(1).getText().trim();
                            String st2 = tab_onglet3.tab_jtf_malade.get(2).getText().trim();
                            String st3 = tab_onglet3.tab_jtf_malade.get(3).getText().trim();
                            String st4 = tab_onglet3.tab_jtf_malade.get(4).getText().trim();
                            String st5 = tab_onglet3.tab_jtf_malade.get(5).getText().trim();
                          
                          
                            if( integer1== 0 && st1.compareTo("") == 0 && st2.compareTo("") == 0 && st3.compareTo("") == 0 && st4.compareTo("") ==0 && st5.compareTo("") ==0  ){
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                            
                                controle.modifier(controle.write_requete_update_malade(integer1, st1, st2, st3, st4, st5));
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);
                            }  
                        }
                        
                        if(tab_onglet3.getSelectedIndex() ==6){
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_hospital.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_hospital.get(0).getText().trim());
                            }
                            
                            String st1 = tab_onglet3.tab_jtf_hospital.get(1).getText().trim();
                           
                            int integer2 =0;
                            if(tab_onglet3.tab_jtf_hospital.get(2).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet3.tab_jtf_hospital.get(2).getText().trim());
                            } 
                            
                            int integer3 =0;
                            if(tab_onglet3.tab_jtf_hospital.get(3).getText().length() != 0){
                                integer3= Integer.parseInt(tab_onglet3.tab_jtf_hospital.get(3).getText().trim());
                            }
                          
                        
                            if( integer1== 0 && st1.compareTo("") == 0 && integer2 == 0 && integer3 == 0){
                                
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                            
                                controle.modifier(controle.write_requete_update_hopital(integer1, st1, integer2, integer3));
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);
                            }  
                        }
                         
                        if(tab_onglet3.getSelectedIndex() ==7){
                           
      
                            String requete = "";
                            int premier = 1;

                            int integer1 =0;
                            if(tab_onglet3.tab_jtf_soin.get(0).getText().length() != 0){
                                integer1= Integer.parseInt(tab_onglet3.tab_jtf_soin.get(0).getText().trim());
                            }
                            
                            int integer2 =0;
                            if(tab_onglet3.tab_jtf_soin.get(1).getText().length() != 0){
                                integer2= Integer.parseInt(tab_onglet3.tab_jtf_soin.get(1).getText().trim());
                            } 
                            
                            if( integer1== 0 && integer2 == 0 ){
                                 
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "Attention", "Veuillez remplir les champs", JOptionPane.WARNING_MESSAGE);
                            }

                            else{
                            
                                controle.modifier(controle.write_requete_update_soin(integer1, integer2));
                                JOptionPane jop2 = new JOptionPane();
                                jop2.showMessageDialog(null, "okay", "yoo", JOptionPane.WARNING_MESSAGE);
                            }  
                        }
              
                
                        }
                                if (e.getSource()== maj){
                                    affiche_chart();
                                }
                                
            this.repaint();
            } else {
                            JOptionPane jop2 = new JOptionPane();
                            jop2.showMessageDialog(null, "Message préventif", "Attention, non connecte", JOptionPane.WARNING_MESSAGE);
                        
                        }
        
        }
        
                        
            public String[] titre_service(){
              
              String titre[]={"Code","Nom","Batiment","directeur"};
              
              
              return titre;
              
              
            }          
          
            public String[] titre_service_requete(){
              
              String titre[]={"Nom", "Batiment", "Nom dir", "Prenom dir","Specialite"};
              
              return titre;
              
            }
                        
                    
                
           
            public String[] titre_chambre(){
              
              String titre[]={"Code service", "No chambre", "Surveillant", "Nb lits"};
              
              return titre;
              
            }
          
            public String[] titre_employe(){
              
              String titre[]={"Numero", "Nom", "Prenom", "Adresse","Code postal","Tel"};
              
              return titre;
              
            }
          
            public String[] titre_docteur(){
              
              String titre[]={"Numero", "Specialite"};
              
              return titre;
              
            }
          
            public String[] titre_docteur_requete(){
              
              String titre[]={ "Nom", "Prenom", "Specialite"};
              
              return titre;
              
            }
          
          
          
          public String[] titre_infirmier(){
              
              String titre[]={"Numero", "Code service", "Rotation","Salaire"};
              
              return titre;
              
            }
          
            public String[] titre_infirmier_requete(){
              
              String titre[]={"Nom", "Prenom"};
              
              return titre;
              
            }
                  
                              
            
            public String[] titre_malade(){
              
              String titre[]={"Numero", "Nom", "Prenom","Adresse","Code Postal","Tel","Mutuelle"};
              
              return titre;
              
            }
		
		
            public String[] titre_malade_requete(){
              
              String titre[]={ "Nom", "Prenom"};
              
              return titre;
              
            }	
		
	
            	
            public String[] titre_hopital(){
              
              String titre[]={ "No Malade", "Code Service","No Chambre","Lit"};
              
              return titre;
              
            }
            
            
            public String[] titre_hopital_requete(){
              
              String titre[]={ "No Malade", "Nom","Prenom","Code Service","No Chambre","Lit"};
              
              return titre;
              
            }	
            
            public String[] titre_soin(){
              
              String titre[]={ "No Docteur", "No Malade"};
              
              return titre;
              
            }	
            
            public String[] titre_soin_requete(){
              
              String titre[]={ "Nom Docteur", "Prenom Docteur","Specialite","No Malade","Nom Malade","Prenom Malade"};
              
              return titre;
              
            }	
		
		
		
            
		
	
        
        public void affiche_result(char ch[]){
            
            String str_temp = "";
            for(char c:ch){
            if(c != '\n'){
                if(c != ','){
                    str_temp += c;
                }
                else {
                   result.add(new JLabel(str_temp));
                   str_temp = "";
                }
            }
            else{
                result.add(new JLabel(str_temp));            
                str_temp = "";

            }
        }    
            
        
}
        
        public JPanel login_ece(){
            
                  //login
            
            textfield_login1=new JPanel(new GridLayout(0, 1, 2, 2));
            
            login1=new JPanel( new GridLayout(0,1,2,2));
            login1.add(new JLabel("Username", SwingConstants.LEFT));
            login1.add(new JLabel("password",SwingConstants.LEFT));
            login1.add(new JLabel("bdd_name",SwingConstants.LEFT));
            login1.add(new JLabel("password_bdd",SwingConstants.LEFT));
            
            textfield_login1.add(nom_login);
            textfield_login1.add(pass_login);
            textfield_login1.add(nom_bdd);
            textfield_login1.add(pass_bdd);
 
      
            loginn1=new JPanel(new BorderLayout(5,5));
            loginn1.add(login1,BorderLayout.WEST);
            loginn1.add(textfield_login1,BorderLayout.CENTER);

            
         
            return loginn1;
        }
        
     
        
        public void affiche_chart(){
            
            JPanel char1=new JPanel();
            JPanel container=new JPanel();
            char1.add(new ChartPanel(data(), 520, 340, 400, 260, 400, 260, false, false, false, false, false, false));
            
            JPanel char2=new JPanel();
            char2.add(new ChartPanel(data2(), 520, 340, 400, 260, 400, 260, false, false, false, false, false, false));
            
            JPanel char3=new JPanel();
            char3.add(new ChartPanel(data3(), 520, 340, 400, 260, 400, 260, false, false, false, false, false, false));

            
            JPanel char4=new JPanel();
            char4.add(new ChartPanel(data4(), 520, 340, 400, 260, 400, 260, false, false, false, false, false, false));
            
                
            JPanel char5=new JPanel();
            char5.add(new ChartPanel(data5(), 520, 340, 400, 260, 400, 260, false, false, false, false, false, false));

            JPanel char6=new JPanel();
            char6.add(new ChartPanel(data6(), 520, 340, 400, 260, 400, 260, false, false, false, false, false, false));

            container.setLayout(new GridLayout(0, 2, 10, 5));
            container.add(char1);
            container.add(char2);
            container.add(char3);
            container.add(char4);
            container.add(char5);
            container.add(char6);
            
           
          
            scroll1 = new JScrollPane(container,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            scroll1.setLayout(new ScrollPaneLayout());
            pan3.add(scroll1);
            pan3.repaint();
                  
        }
        
        public JFreeChart data(){
                  DefaultPieDataset dataset = new DefaultPieDataset( );
                  ArrayList<Integer> nombre = new ArrayList<>();
                  nombre =controle.histograme1();
                  System.out.println(nombre.get(0));
                  System.out.println(nombre.get(1));
                  System.out.println(nombre.get(2));
                  dataset.setValue("Infirmier",nombre.get(0));
                  dataset.setValue("Docteur",nombre.get(1));
                  dataset.setValue("Autre",nombre.get(2) - (nombre.get(1) +nombre.get(0)) );
                  JFreeChart chart = ChartFactory.createPieChart("Employe",dataset,true,true,false);
                  return chart;
        }
        
        
        
        public JFreeChart data2(){
            
            DefaultCategoryDataset dataset=new DefaultCategoryDataset() ;
            ArrayList<Integer> nombre = new ArrayList<>();
            nombre =controle.Histogrmme();
            final String car="CAR";
            final String rea="REA";
            final String chg="CHG";
            
            final String docteur="Docteur";
            final String infirmier="Infirmier";
            final String malade="Malade";
            final String chambre="Chambre";
            final String nb_lits="nb_lits";
            
            dataset.addValue(nombre.get(0), car, docteur);
            dataset.addValue(nombre.get(1), rea, docteur); 
            dataset.addValue(nombre.get(2), chg, docteur);
            
            dataset.addValue(nombre.get(3), car, infirmier);  
            dataset.addValue(nombre.get(4), rea, infirmier);
            dataset.addValue(nombre.get(5), chg, infirmier);
            
            dataset.addValue(nombre.get(6), car, malade);
            dataset.addValue(nombre.get(7), rea, malade);
            dataset.addValue(nombre.get(8), chg, malade);  
            
            dataset.addValue(nombre.get(9), car, chambre);
            dataset.addValue(nombre.get(10), rea, chambre);
            dataset.addValue(nombre.get(11), chg, chambre);
            
            dataset.addValue(nombre.get(12), car,nb_lits );
            dataset.addValue(nombre.get(13), rea,nb_lits );
            dataset.addValue(nombre.get(14), chg,nb_lits );

            JFreeChart chart2 = ChartFactory.createBarChart3D("Service", "Categorie", "nombre", dataset, PlotOrientation.VERTICAL, true, true, false);
            final CategoryPlot plot = (CategoryPlot) chart2.getCategoryPlot();
           
            
            
            
            return chart2;
        }
        
        public JFreeChart data3(){
            
            DefaultPieDataset dataset = new DefaultPieDataset( );
            ArrayList<Integer> nombre = new ArrayList<>();
            nombre =controle.histograme2();
            
            dataset.setValue("MNAM",nombre.get(0));
            dataset.setValue("LMDE",nombre.get(1));
            dataset.setValue("MNH",nombre.get(2));
            dataset.setValue("MAAF",nombre.get(3));
            dataset.setValue("MGEN",nombre.get(4));
            dataset.setValue("MMA",nombre.get(5));
            dataset.setValue("CNAMTS",nombre.get(6));
            dataset.setValue("CCVRP",nombre.get(7));
            dataset.setValue("MNFTC",nombre.get(8));
            dataset.setValue("MAS",nombre.get(9));
            dataset.setValue("AG2R",nombre.get(10));
            dataset.setValue("MGSP",nombre.get(11));
            
            
            JFreeChart chart = ChartFactory.createPieChart3D("Nb malade associe a chaque mutuelle",dataset,true,true,false);
            
            final PiePlot3D plot= (PiePlot3D) chart.getPlot();
            plot.setStartAngle(270);
            plot.setForegroundAlpha(0.60f);
            plot.setInteriorGap(0.02);
            return chart;
            
        }
        
        public JFreeChart data4(){
            
            DefaultPieDataset dataset=new DefaultPieDataset();
            ArrayList<Integer> nombre = new ArrayList<>();
            nombre =controle.histograme3();
            final String car="CAR";
            final String rea="REA";
            final String chg="CHG";

            
            dataset.setValue(car, nombre.get(0));
            dataset.setValue(rea, nombre.get(1));
            dataset.setValue(chg, nombre.get(2));
    
            JFreeChart chart = ChartFactory.createPieChart3D("Moyenne (salaire)", dataset,true, true, false);
            
            final PiePlot3D plot= (PiePlot3D) chart.getPlot();
            plot.setStartAngle(270);
            plot.setForegroundAlpha(0.60f);
            plot.setInteriorGap(0.02);
            
            return chart;
        }
        
        public JFreeChart data5(){
            
            DefaultCategoryDataset dataset=new DefaultCategoryDataset() ;
            ArrayList<Integer> nombre = new ArrayList<>();
            nombre =controle.histogramme4();
            
            final String nb_chambre_tot="Tot";
            final String nb_chambre_lit_dispo="dispo";
            final String nb_chambre_lit_nondispo="nondispo";

            final String car="CAR";
            final String rea="REA";
            final String chg="CHG";
            System.out.println(nombre.get(0));

            dataset.addValue(nombre.get(0), car, nb_chambre_tot);
            dataset.addValue(nombre.get(1), car, nb_chambre_lit_dispo); 
            dataset.addValue((nombre.get(0)-nombre.get(1)), car, nb_chambre_lit_nondispo);
            
            dataset.addValue(nombre.get(2), rea, nb_chambre_tot);
            dataset.addValue(nombre.get(3), rea, nb_chambre_lit_dispo); 
            dataset.addValue((nombre.get(2)-nombre.get(3)), rea, nb_chambre_lit_nondispo);
            
            dataset.addValue(nombre.get(4), chg, nb_chambre_tot);
            dataset.addValue(nombre.get(5), chg, nb_chambre_lit_dispo); 
            dataset.addValue((nombre.get(4)-nombre.get(5)), chg, nb_chambre_lit_nondispo);
            
            JFreeChart chart2 = ChartFactory.createBarChart3D("Nb LIT/Chambre ", "lit", "nombre", dataset, PlotOrientation.VERTICAL, true, true, false);
            final CategoryPlot plot = (CategoryPlot) chart2.getCategoryPlot();
           
            return chart2;
        }
        
        public JFreeChart data6(){
            
            DefaultCategoryDataset dataset=new DefaultCategoryDataset() ;
            ArrayList<Integer> nombre = new ArrayList<>();
            nombre =controle.histogramme5();
            
            final String car="Dir_CAR";
            final String rea="Dir_REA";
            final String chg="Dir_CHG";

            final String malade="Malade";
            System.out.println(nombre.get(0));
            System.out.println(nombre.get(1));
            System.out.println(nombre.get(2));

            dataset.addValue(nombre.get(0), car, "");
            dataset.addValue(nombre.get(1), rea, ""); 
            dataset.addValue(nombre.get(2), chg, "");
            
         
            JFreeChart chart2 = ChartFactory.createBarChart3D("Nb_malade soigne par le directeur de chaque service ", "Malade", "nombre", dataset, PlotOrientation.VERTICAL, true, true, false);
            final CategoryPlot plot = (CategoryPlot) chart2.getCategoryPlot();
           
            return chart2;
        }
        
        
        
        
        
        
        
}

	
	


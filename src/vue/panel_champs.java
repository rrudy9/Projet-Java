package vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class panel_champs extends JTabbedPane {
	
	 ArrayList<JTextField> tab_jtf_service = new ArrayList<JTextField>();
	 ArrayList<JTextField> tab_jtf_chambre = new ArrayList<JTextField>();
	 ArrayList<JTextField> tab_jtf_employe = new ArrayList<JTextField>();
	 ArrayList<JTextField> tab_jtf_docteur = new ArrayList<JTextField>();
	 ArrayList<JTextField> tab_jtf_infirmier = new ArrayList<JTextField>();
	 ArrayList<JTextField> tab_jtf_malade = new ArrayList<JTextField>();
	 ArrayList<JTextField> tab_jtf_hospital = new ArrayList<JTextField>();
	 ArrayList<JTextField> tab_jtf_soin = new ArrayList<JTextField>();
	
	private JPanel pan11 ;
	private JPanel pan12;
	private JPanel pan13 ;
	private JPanel pan14 ;
	private JPanel pan15 ;
	private JPanel pan16;
	private JPanel pan17 ;
	private JPanel pan18;
        
        
	
	public panel_champs() {
		
		pan11 = new JPanel(); // instancier le panneau
		pan12 = new JPanel(); // instancier le panneau
		pan13 = new JPanel(); // instancier le panneau
		pan14 = new JPanel(); // instancier le panneau
		pan15 = new JPanel(); // instancier le panneau
		pan16 = new JPanel(); // instancier le panneau
		pan17 = new JPanel(); // instancier le panneau
		pan18 = new JPanel(); // instancier le panneau
		
		this.add("Service", pan11);
		this.add("Chambre", pan12);
		this.add("Employé", pan13);
		this.add("Docteur", pan14);
		this.add("Infirmier", pan15);
		this.add("Malade", pan16);
		this.add("Hospitalisation", pan17);
		this.add("Soin", pan18);
		
		init_service();
		init_chambre();
		init_employe();
		init_docteur();
		init_infirmier();
		init_malade();
		init_hospital();
		init_soin();
	}
	
	private void init_service() {
		pan11.setLayout(new GridLayout(2,4));
		JLabel lab1 = new JLabel("Code");
		JLabel lab2 = new JLabel("Nom");
		JLabel lab3 = new JLabel("Batiment");
		JLabel lab4 = new JLabel("Directeur");

		JTextField jtf1 = new JTextField();
		JTextField jtf2 = new JTextField();
		JTextField jtf3 = new JTextField();
		JTextField jtf4 = new JTextField();
		
		tab_jtf_service.add(jtf1);
		tab_jtf_service.add(jtf2);
		tab_jtf_service.add(jtf3);
		tab_jtf_service.add(jtf4);

		
		JPanel pantp1 = new JPanel();
		JPanel pantp2 = new JPanel();
		JPanel pantp3 = new JPanel();
		JPanel pantp4 = new JPanel();
		
		jtf1.setPreferredSize(new Dimension(150,30));
		jtf2.setPreferredSize(new Dimension(150,30));
		jtf3.setPreferredSize(new Dimension(150,30));
		jtf4.setPreferredSize(new Dimension(150,30));
		
		pantp1.add(lab1);
		pantp1.add(jtf1);
		pantp2.add(lab2);
		pantp2.add(jtf2);
		pantp3.add(lab3);
		pantp3.add(jtf3);
		pantp4.add(lab4);
		pantp4.add(jtf4);
		
		pan11.add(pantp1);

		pan11.add(pantp2);

		pan11.add(pantp3);

		pan11.add(pantp4);
		

	}
	
	private void init_chambre() {
		pan12.setLayout(new GridLayout(2,4));
		JLabel lab1 = new JLabel("Code Service");
		JLabel lab2 = new JLabel("Numero Chambre");
		JLabel lab3 = new JLabel("Surveillant");
		JLabel lab4 = new JLabel("Nombre lit");

		JTextField jtf1 = new JTextField();
		JTextField jtf2 = new JTextField();
		JTextField jtf3 = new JTextField();
		JTextField jtf4 = new JTextField();
		
		tab_jtf_chambre.add(jtf1);
		tab_jtf_chambre.add(jtf2);
		tab_jtf_chambre.add(jtf3);
		tab_jtf_chambre.add(jtf4);
                
                
		
		JPanel pantp1 = new JPanel();
		JPanel pantp2 = new JPanel();
		JPanel pantp3 = new JPanel();
		JPanel pantp4 = new JPanel();
		
		jtf1.setPreferredSize(new Dimension(150,30));
		jtf2.setPreferredSize(new Dimension(150,30));
		jtf3.setPreferredSize(new Dimension(150,30));
		jtf4.setPreferredSize(new Dimension(150,30));
		
		pantp1.add(lab1);
		pantp1.add(jtf1);
		pantp2.add(lab2);
		pantp2.add(jtf2);
		pantp3.add(lab3);
		pantp3.add(jtf3);
		pantp4.add(lab4);
		pantp4.add(jtf4);
      
		
		pan12.add(pantp1);
		pan12.add(pantp2);

		pan12.add(pantp3);

		pan12.add(pantp4);
		

	}
	
	private void init_employe() {
		pan13.setLayout(new GridLayout(2,5));
		JLabel lab1 = new JLabel("Numero");
		JLabel lab2 = new JLabel("Nom");
		JLabel lab3 = new JLabel("Prenom");
		JLabel lab4 = new JLabel("Adresse");
		JLabel lab5 = new JLabel("Telephone");

		JTextField jtf1 = new JTextField();
		JTextField jtf2 = new JTextField();
		JTextField jtf3 = new JTextField();
		JTextField jtf4 = new JTextField();
		JTextField jtf5 = new JTextField();

		tab_jtf_employe.add(jtf1);
		tab_jtf_employe.add(jtf2);
		tab_jtf_employe.add(jtf3);
		tab_jtf_employe.add(jtf4);
		tab_jtf_employe.add(jtf5);

		
		JPanel pantp1 = new JPanel();
		JPanel pantp2 = new JPanel();
		JPanel pantp3 = new JPanel();
		JPanel pantp4 = new JPanel();
		JPanel pantp5 = new JPanel();
		
		jtf1.setPreferredSize(new Dimension(150,30));
		jtf2.setPreferredSize(new Dimension(150,30));
		jtf3.setPreferredSize(new Dimension(150,30));
		jtf4.setPreferredSize(new Dimension(150,30));
		jtf5.setPreferredSize(new Dimension(150,30));
		
		pantp1.add(lab1);
		pantp1.add(jtf1);
		pantp2.add(lab2);
		pantp2.add(jtf2);
		pantp3.add(lab3);
		pantp3.add(jtf3);
		pantp4.add(lab4);
		pantp4.add(jtf4);
		pantp5.add(lab5);
		pantp5.add(jtf5);
		
		pan13.add(pantp1);
		pan13.add(pantp2);

		pan13.add(pantp3);

		pan13.add(pantp4);
		pan13.add(pantp5);

		

	}private void init_docteur() {
		pan14.setLayout(new GridLayout(2,2));
		JLabel lab1 = new JLabel("Numero");
		JLabel lab2 = new JLabel("Specialité");
		

		JTextField jtf1 = new JTextField();
		JTextField jtf2 = new JTextField();
		
		tab_jtf_docteur.add(jtf1);
		tab_jtf_docteur.add(jtf2);
		
		JPanel pantp1 = new JPanel();
		JPanel pantp2 = new JPanel();
		
		
		jtf1.setPreferredSize(new Dimension(150,30));
		jtf2.setPreferredSize(new Dimension(150,30));
		
		
		pantp1.add(lab1);
		pantp1.add(jtf1);
		pantp2.add(lab2);
		pantp2.add(jtf2);
		
		
		pan14.add(pantp1);
		pan14.add(pantp2);

	

		

	}
	
	private void init_infirmier() {
		pan15.setLayout(new GridLayout(2,4));
		JLabel lab1 = new JLabel("Numero");
		JLabel lab2 = new JLabel("Code service");
		JLabel lab3 = new JLabel("Rotation");
		JLabel lab4 = new JLabel("Salaire");

		JTextField jtf1 = new JTextField();
		JTextField jtf2 = new JTextField();
		JTextField jtf3 = new JTextField();
		JTextField jtf4 = new JTextField();

		tab_jtf_infirmier.add(jtf1);
		tab_jtf_infirmier.add(jtf2);
		tab_jtf_infirmier.add(jtf3);
		tab_jtf_infirmier.add(jtf4);
		
		JPanel pantp1 = new JPanel();
		JPanel pantp2 = new JPanel();
		JPanel pantp3 = new JPanel();
		JPanel pantp4 = new JPanel();
		
		jtf1.setPreferredSize(new Dimension(150,30));
		jtf2.setPreferredSize(new Dimension(150,30));
		jtf3.setPreferredSize(new Dimension(150,30));
		jtf4.setPreferredSize(new Dimension(150,30));
		
		pantp1.add(lab1);
		pantp1.add(jtf1);
		pantp2.add(lab2);
		pantp2.add(jtf2);
		pantp3.add(lab3);
		pantp3.add(jtf3);
		pantp4.add(lab4);
		pantp4.add(jtf4);
		
		
		pan15.add(pantp1);
		pan15.add(pantp2);
		pan15.add(pantp3);
		pan15.add(pantp4);

		

	}
	private void init_malade() {
		pan16.setLayout(new GridLayout(2,6));
		JLabel lab1 = new JLabel("Numero");
		JLabel lab2 = new JLabel("Nom");
		JLabel lab3 = new JLabel("Prenom");
		JLabel lab4 = new JLabel("Adresse");
		JLabel lab5 = new JLabel("Telephone");
		JLabel lab6 = new JLabel("Mutuelle");


		JTextField jtf1 = new JTextField();
		JTextField jtf2 = new JTextField();
		JTextField jtf3 = new JTextField();
		JTextField jtf4 = new JTextField();
		JTextField jtf5 = new JTextField();
		JTextField jtf6 = new JTextField();

		tab_jtf_malade.add(jtf1);
		tab_jtf_malade.add(jtf2);
		tab_jtf_malade.add(jtf3);
		tab_jtf_malade.add(jtf4);
		tab_jtf_malade.add(jtf5);
		tab_jtf_malade.add(jtf6);
		
		
		JPanel pantp1 = new JPanel();
		JPanel pantp2 = new JPanel();
		JPanel pantp3 = new JPanel();
		JPanel pantp4 = new JPanel();
		JPanel pantp5 = new JPanel();
		JPanel pantp6 = new JPanel();

		jtf1.setPreferredSize(new Dimension(150,30));
		jtf2.setPreferredSize(new Dimension(150,30));
		jtf3.setPreferredSize(new Dimension(150,30));
		jtf4.setPreferredSize(new Dimension(150,30));
		jtf5.setPreferredSize(new Dimension(150,30));
		jtf6.setPreferredSize(new Dimension(150,30));
		
		pantp1.add(lab1);
		pantp1.add(jtf1);
		pantp2.add(lab2);
		pantp2.add(jtf2);
		pantp3.add(lab3);
		pantp3.add(jtf3);
		pantp4.add(lab4);
		pantp4.add(jtf4);
		pantp5.add(lab5);
		pantp5.add(jtf5);
		pantp6.add(lab6);
		pantp6.add(jtf6);
		
		pan16.add(pantp1);
		pan16.add(pantp2);

		pan16.add(pantp3);

		pan16.add(pantp4);
		pan16.add(pantp5);
		pan16.add(pantp6);

		

	}
	private void init_hospital() {
		pan17.setLayout(new GridLayout(2,4));
		JLabel lab1 = new JLabel("Numero Malade");
		JLabel lab2 = new JLabel("Code service");
		JLabel lab3 = new JLabel("Numero Chambre");
		JLabel lab4 = new JLabel("Lit");

		JTextField jtf1 = new JTextField();
		JTextField jtf2 = new JTextField();
		JTextField jtf3 = new JTextField();
		JTextField jtf4 = new JTextField();

		tab_jtf_hospital.add(jtf1);
		tab_jtf_hospital.add(jtf2);
		tab_jtf_hospital.add(jtf3);
		tab_jtf_hospital.add(jtf4);
	
		
		JPanel pantp1 = new JPanel();
		JPanel pantp2 = new JPanel();
		JPanel pantp3 = new JPanel();
		JPanel pantp4 = new JPanel();
		
		jtf1.setPreferredSize(new Dimension(150,30));
		jtf2.setPreferredSize(new Dimension(150,30));
		jtf3.setPreferredSize(new Dimension(150,30));
		jtf4.setPreferredSize(new Dimension(150,30));
		
		pantp1.add(lab1);
		pantp1.add(jtf1);
		pantp2.add(lab2);
		pantp2.add(jtf2);
		pantp3.add(lab3);
		pantp3.add(jtf3);
		pantp4.add(lab4);
		pantp4.add(jtf4);
		
		
		pan17.add(pantp1);
		pan17.add(pantp2);
		pan17.add(pantp3);
		pan17.add(pantp4);

		

	}
	
	private void init_soin() {
		pan18.setLayout(new GridLayout(2,4));
		JLabel lab1 = new JLabel("Numero Docteur");
		JLabel lab2 = new JLabel("Numero Malade");
	

		JTextField jtf1 = new JTextField();
		JTextField jtf2 = new JTextField();
		
		tab_jtf_soin.add(jtf1);
		tab_jtf_soin.add(jtf2);


		JPanel pantp1 = new JPanel();
		JPanel pantp2 = new JPanel();
	
		
		jtf1.setPreferredSize(new Dimension(150,30));
		jtf2.setPreferredSize(new Dimension(150,30));

		
		pantp1.add(lab1);
		pantp1.add(jtf1);
		pantp2.add(lab2);
		pantp2.add(jtf2);
	
		
		
		pan18.add(pantp1);
		pan18.add(pantp2);
	

		

	}
	
	


	
}

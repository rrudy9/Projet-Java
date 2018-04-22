// camille chollet : histogrammes avec JFreeChart
package controleur;

import java.util.ArrayList;
import java.util.Collections;
import vue.*;
import modele.*;

public class TestMain {
    	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
                TestMain controle = new TestMain();
                
	}
        
        Connexion con ;
        Fenetre win ;
        public TestMain(){
            win = new Fenetre(this);
            
        }
        
        public ArrayList parametre_table(String table){
            ArrayList list = new ArrayList();
            try {
                 list = con.remplirChampsTable(table);

            } catch (Exception e) {
            }
            return list;
        }
        
        public ArrayList rechercheService(){
           ArrayList list = new ArrayList();
            try {
                 list = con.remplirChampsRequete("SELECT * FROM `service`");

            } catch (Exception e) {
            }
            return list;
        }
        
        public ArrayList rechercheChambre(){
           ArrayList list = new ArrayList();
            try {
                 list = con.remplirChampsRequete("SELECT * FROM `chambre`");

            } catch (Exception e) {
            }
            return list;
    
        }
        
        public ArrayList rechercheDocteur(){
            ArrayList list = new ArrayList();
            try{
                list=con.remplirChampsRequete("SELECT * FROM `docteur`");
            }catch (Exception e){   
            }
            
            return list;
        }
        
        public ArrayList rechercheEmploye(){
            ArrayList list = new ArrayList();
            try{
                list=con.remplirChampsRequete("SELECT * FROM `employe`");
            }catch (Exception e){   
            }
            
            return list;
        }
        
        public ArrayList rechercheInfirmier(){
            ArrayList list = new ArrayList();
            try{
                list=con.remplirChampsRequete("SELECT * FROM `infirmier`");
            }catch (Exception e){   
            }
            
            return list;
        }   
        
        public ArrayList rechercheMalade(){
            ArrayList list = new ArrayList();
            try{
                list=con.remplirChampsRequete("SELECT * FROM `malade`");
            }catch (Exception e){   
            }
            
            return list;
        }  
        
        public ArrayList rechercheHospital(){
            ArrayList list = new ArrayList();
            try{
                list=con.remplirChampsRequete("SELECT * FROM `hospitalisation`");
            }catch (Exception e){   
            }
            
            return list;
        }   
        
        public ArrayList rechercheSoin(){
            ArrayList list = new ArrayList();
            try{
                list=con.remplirChampsRequete("SELECT * FROM `soigne`");
            }catch (Exception e){   
            }
            
            return list;
        }

        public ArrayList recherche_requete(String table, String requete){
        ArrayList list = new ArrayList();
            try {
                 list = con.remplirChampsRequete("SELECT * FROM " +table+" WHERE " + requete);

            } catch (Exception e) {
            }
            return list;
            
        }
        
        public ArrayList recherche_requete_infirmier(String table, String table1 ,String requete){
        ArrayList list = new ArrayList();
            try {
                 list = con.remplirChampsRequete("SELECT `nom` , `prenom`  FROM " +table+ "," +table1+ "WHERE " + requete);

            } catch (Exception e) {
            }
            return list;
            
        }
        
        public ArrayList recherche_requete_docteur(String table, String table1 ,String requete){
        ArrayList list = new ArrayList();
            try {
                 list = con.remplirChampsRequete("SELECT `nom` , `prenom` , `specialite`  FROM " +table+ "," +table1+ "WHERE " + requete);

            } catch (Exception e) {
            }
            return list;
            
        }
        
        public ArrayList recherche_requete_malade(String table,String requete){
        ArrayList list = new ArrayList();
            try {
                 list = con.remplirChampsRequete("SELECT `nom` , `prenom`  FROM " +table+ "WHERE " + requete);

            } catch (Exception e) {
            }
            return list;
            
        }
        
        public ArrayList recherche_requete_hopital(String table,String table1,String requete){
        ArrayList list = new ArrayList();
            try {
                 list = con.remplirChampsRequete("SELECT `hospitalisation`.`no_malade`, `malade`.`nom`, `malade`.`prenom`, `hospitalisation`.`code_service`, `hospitalisation`.`no_chambre`, `hospitalisation`.`lit` FROM " +table+","+table1+"WHERE " + requete);

            } catch (Exception e) {
            }
            return list;
            
        }
        
        public ArrayList recherche_requete_service(String table, String table1,String table2,String requete){
        ArrayList list = new ArrayList();
            try {
                 list = con.remplirChampsRequete("SELECT `service`.`nom` , `service`.`batiment`, `employe`.`nom`, `employe`.`prenom` , `docteur`.`specialite`  FROM " +table+ ","+table1+ ","+table2+ "WHERE " + requete);

            } catch (Exception e) {
            }
            return list;
            
        }
        
        
        public ArrayList recherche_requete_soin(String table, String table1,String table2, String table3, String requete){
        ArrayList list = new ArrayList();
            try {
                 list = con.remplirChampsRequete("SELECT `employe`.`nom` , `employe`.`prenom`, `docteur`.`specialite`, `malade`.`numero` , `malade`.`nom` , `malade`.`prenom`  FROM " +table+ ","+table1+ ","+table2+ "," +table3+ "WHERE " + requete);

            } catch (Exception e) {
            }
            return list;
            
        }
        
        public void ajouter_requete_employe(String table,String requete){
            try {
                con.executeUpdate("INSERT INTO " +table+ " (`numero`, `nom`, `prenom`, `adresse`, `tel`) VALUES "+"("+requete+")");

            } catch (Exception e) {
            }
            
        }
        
       
     
        
        public void ajouter_requete_docteur(String table,String table1,String str,  String requete){
            try {
                con.executeUpdate("INSERT INTO "+table+" (`numero`,`specialite`) SELECT "+table1+".`numero` , "+str+"FROM "+table1+" WHERE "+table1+".`numero`="+requete);
                
               
            } catch (Exception e) {
            }
            
        }
        
       
        
        
        
          
        public void ajouter_requete_malade(String table,String requete){
            try {
                con.executeUpdate("INSERT INTO " +table+ " (`numero`, `nom`,`prenom`,`adresse`,`tel`,`mutuelle`) VALUES "+"("+requete+")");
                
               
            } catch (Exception e) {
            }
            
        }
        
        
        
        
        
        
         public void ajouter_requete_soigne(String table,String requete){
            try {
                con.executeUpdate("INSERT INTO " +table+ " (`no_docteur`, `no_malade`) VALUES "+"("+requete+")");
                
               
            } catch (Exception e) {
            }
            
        }
         
         public void ajouter (String requete){
             try {
                con.executeUpdate(requete);
                
               
            } catch (Exception e) {
            }
            
             
         }
         
         
        public void supprimer(String requete){
            try {
                con.executeUpdate(requete);
                
               
            } catch (Exception e) {
            }
            
        }
        
    
        public String write_requete_ajout_infirmier(String str1, String str2, String str3, String str4){

            String str = "INSERT INTO `infirmier`(`numero`,`code_service`,`rotation`,`salaire`) SELECT `employe`.`numero`, `service`.`code` , "+str1+", "+str2+" FROM `employe`, `service` WHERE `employe`.`numero`="+str3+" AND `service`.`code`="+str4;
            
            return str;
        }
         
        public String write_requete_ajout_hopital(String str1, String str2, String str3, String str4){

            String str = "INSERT INTO `hospitalisation`(`no_malade`,`code_service`,`no_chambre`,`lit`) SELECT `malade`.`numero`, `service`.`code`, `chambre`.`no_chambre`, "+str1+" FROM `malade`, `service`, `chambre` WHERE `malade`.`numero`="+str2+" AND `service`.`code`="+str3+" AND `chambre`.`no_chambre`="+str4;
            
            return str;
        }
        
        public String write_requete_ajout_chambre(String str1, String str2, String str3, String str4){

            String str = "INSERT INTO `chambre`(`code_service`,`no_chambre`,`surveillant`,`nb_lits`) SELECT `service`.`code`, "+str1+", `infirmier`.`numero`, "+str2+" FROM `infirmier`, `service` WHERE `service`.`code`="+str3+" AND `infirmier`.`numero`="+str4;
            
            return str;
        }
        
        public String write_requete_ajout_service(String str1, String str2, String str3, String str4){

            String str = "INSERT INTO `service`(`code`,`nom`,`batiment`,`directeur`) SELECT "+str1+","+str2+","+str3+",`docteur`.`numero` FROM `docteur` WHERE `docteur`.`numero`="+str4;
            
            return str;
        }
        
         
         
         
         
         
         
         
        
        public String write_requete_delete_service(String str1){

            String str = "DELETE FROM `service` WHERE `code`=\""+str1+"\"";
            return str;
        }
         
        
        public String write_requete_delete_chambre(String st1, int integer2){

            String str = "DELETE FROM `chambre` WHERE `code_service`=\""+st1+"\" AND `no_chambre`=\""+integer2+"\"";
            return str;
        }
         
        
        public String write_requete_delete_employe(int integer1){

            String str = "DELETE FROM `employe` WHERE `numero`=\""+integer1+"\"";
            return str;
        }
         
        
        public String write_requete_delete_docteur(int integer1){

            String str = "DELETE FROM `docteur` WHERE `numero`=\""+integer1+"\"";
            return str;
        }
        
        
        public String write_requete_delete_infirmier(int integer1){

            String str = "DELETE FROM `infirmier` WHERE `numero`=\""+integer1+"\"";
            return str;
        }
        
        
        public String write_requete_delete_malade(int integer1){

            String str = "DELETE FROM `malade` WHERE `numero`=\""+integer1+"\"";
            return str;
        }
        
        
        public String write_requete_delete_hopital(int integer1){

            String str = "DELETE FROM `hospitalisation` WHERE `no_malade`=\""+integer1+"\"";
            return str;
        }
        
        
        public String write_requete_delete_soin(int integer1, int integer2){

            String str = "DELETE FROM `soigne` WHERE `no_docteur`=\""+integer1+"\" AND `no_malade`=\""+integer2+"\"";
            return str;
        }
        
        
        
        
        
        
        
        
        
        public void modifier(String requete){
            try {
                con.executeUpdate(requete);

            } catch (Exception e) {
            }
            
        }
        
        public String write_requete_update_employe(int integer, String str1, String str2, String str3, String str4){

            String str = "UPDATE `employe` SET `nom`=\"" +str1+"\",`prenom`=\"" +str2+"\",`adresse`=\"" +str3+"\",`tel`=\"" +str4+"\" WHERE `numero`="+integer;
            return str;
        }
    
        
        public String write_requete_update_service(String str1, String str2, String str3, int integer1){

            String str = "UPDATE `service` SET `nom`=\"" +str2+"\",`batiment`=\"" +str3+"\",`directeur`=\" (SELECT `docteur`.`numero` FROM `docteur` WHERE `docteur`.`numero`=\""+integer1+"\") WHERE `service`.`code`=\""+str1+"\"";
            return str;
        }
        
        public String write_requete_update_chambre(String str1, int integer1, int integer2, int integer3){

            String str = "UPDATE `chambre` SET `surveillant`= (SELECT `infirmier`.`numero` FROM `infirmier` WHERE `infirmier`.`numero`=\"" +integer2+"\") ,`nb_lits`=\"" +integer3+"\" WHERE `chambre`.`code_service`=\"" +str1+"\" AND `chambre`.`no_chambre`=\""+integer1+"\"";
            
            return str;
        }
    
        public String write_requete_update_docteur(int integer1, String str1){

            String str = "UPDATE `docteur` SET `specialite`=\""+str1+"\" WHERE `numero`="+integer1;
            return str;
        }
        
        
        
        public String write_requete_update_infirmier(int integer1, String str1, String str2 ,int integer2 ){

            String str = "UPDATE `infirmier` SET `code_service`= (SELECT `service`.`code` FROM `service` WHERE `service`.`code`=\""+str1+"\"), `rotation`=\""+str2+"\", `salaire`=\""+integer2+"\" WHERE `infirmier`.`numero`=\""+integer1+"\"";
            return str;
        }
        
        
        public String write_requete_update_malade(int integer1, String str1, String str2,String str3,String str4, String str5){

            String str = "UPDATE `malade` SET `nom`=\"" +str1+"\", `prenom`=\""+str2+"\", `adresse`=\""+str3+"\", `tel`=\""+str4+"\", `mutuelle`=\""+str5+"\" WHERE `numero`="+integer1;
            return str;
        }
        
        
      
        public String write_requete_update_hopital(int integer1, String str1,int integer2, int integer3){

            String str = "UPDATE `hospitalisation` SET `code_service`= (SELECT `service`.`code` FROM `service` WHERE `service`.`code`=\""+str1+"\"), `no_chambre`= ( SELECT `chambre`.`no_chambre` FROM `chambre` WHERE `chambre`.`no_chambre`=\""+integer2+"\"), `lit`=\""+integer3+"\" WHERE `hospitalisation`.`no_malade`=\""+integer1+"\"";
            return str;
        }
        
        
      
         public String write_requete_update_soin(int integer1,int integer2){

            String str = "UPDATE `soigne` SET `no_malade`= (SELECT `malade`.`numero` FROM `malade` WHERE `malade`.`numero`=\""+integer2+"\") WHERE `soigne`.`no_docteur`=\""+integer1+"\"";
            return str;
            
        }
        

        public void connexion(){
        try {
                con =new Connexion("hopital","root","");
            } catch (Exception e) {
            }
            
        }
        
        public void connexion_ece(String usernameECE, String passwordECE, String loginDatabase, String passwordDatabase){
            
            try{
            con= new Connexion(usernameECE, passwordECE, loginDatabase, passwordDatabase);
            
            }catch(Exception e){
                
                
            }
            
        }
        
     
     

        public ArrayList recherche_requete() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

      
        public ArrayList histograme1(){
            ArrayList list = new ArrayList();
            String requete1 = "SELECT COUNT(*) as count FROM `employe`,`infirmier` WHERE `employe`.`numero`=`infirmier`.`numero`";
            String requete2 = "SELECT COUNT(*) as count FROM `employe`,`docteur` WHERE `employe`.`numero`=`docteur`.`numero`";
            String requete3 = "SELECT COUNT(*) as count FROM `employe`";

            list.add(con.nombre(requete1));
            list.add(con.nombre(requete2));
            list.add(con.nombre(requete3));
            

            return list;
        }
        
        
        public ArrayList Histogrmme(){
            ArrayList list=new ArrayList();
            String requete1="SELECT COUNT(*) as count FROM `malade`, `hospitalisation`, `service` WHERE `malade`.`numero`=`hospitalisation`.`no_malade` AND`hospitalisation`.`code_service`=`service`.`code` AND `service`.`code`=\"CAR\"";
            String requete2="SELECT COUNT(*) as count FROM `malade`, `hospitalisation`, `service` WHERE `malade`.`numero`=`hospitalisation`.`no_malade` AND`hospitalisation`.`code_service`=`service`.`code` AND `service`.`code`=\"REA\"";
            String requete3="SELECT COUNT(*) as count FROM `malade`, `hospitalisation`, `service` WHERE `malade`.`numero`=`hospitalisation`.`no_malade` AND`hospitalisation`.`code_service`=`service`.`code` AND `service`.`code`=\"CHG\"";

            String requete4="SELECT COUNT(*) as count FROM `infirmier`, `service` WHERE `infirmier`.`code_service`=`service`.`code` AND `service`.`code`=\"CAR\"";
            String requete5="SELECT COUNT(*) as count FROM `infirmier`, `service` WHERE `infirmier`.`code_service`=`service`.`code` AND `service`.`code`=\"REA\"";
             String requete6="SELECT COUNT(*) as count FROM `infirmier`, `service` WHERE `infirmier`.`code_service`=`service`.`code` AND `service`.`code`=\"CHG\"";
            
            String requete7="SELECT COUNT(DISTINCT(`soigne`.`no_docteur`)) as count FROM `docteur`,`soigne`,`hospitalisation`, `service` WHERE`docteur`.`numero`=`soigne`.`no_docteur` AND `soigne`.`no_malade`=`hospitalisation`.`no_malade` AND `hospitalisation`.`code_service`=`service`.`code`AND `service`.`code`=\"CAR\"";
            String requete8="SELECT COUNT(DISTINCT(`soigne`.`no_docteur`)) as count FROM `docteur`,`soigne`,`hospitalisation`, `service` WHERE`docteur`.`numero`=`soigne`.`no_docteur` AND `soigne`.`no_malade`=`hospitalisation`.`no_malade` AND `hospitalisation`.`code_service`=`service`.`code`AND `service`.`code`=\"REA\"";
            String requete9="SELECT COUNT(DISTINCT(`soigne`.`no_docteur`)) as count FROM `docteur`,`soigne`,`hospitalisation`, `service` WHERE`docteur`.`numero`=`soigne`.`no_docteur` AND `soigne`.`no_malade`=`hospitalisation`.`no_malade` AND `hospitalisation`.`code_service`=`service`.`code`AND `service`.`code`=\"CHG\"";

            
            String requete10="SELECT COUNT(*) as count FROM `chambre`, `service` WHERE `chambre`.`code_service`=`service`.`code` AND `service`.`code`=\"CAR\"";
            String requete11="SELECT COUNT(*) as count FROM `chambre`, `service` WHERE `chambre`.`code_service`=`service`.`code` AND `service`.`code`=\"REA\"";
            String requete12="SELECT COUNT(*) as count FROM `chambre`, `service` WHERE `chambre`.`code_service`=`service`.`code` AND `service`.`code`=\"CHG\"";

            String requete13 = "SELECT cast(AVG(nb_lits) as decimal(3,1)) as count FROM `chambre` WHERE `chambre`.`code_service`=\"CAR\"";
            String requete14 = "SELECT cast(AVG(nb_lits) as decimal(3,1)) as count FROM `chambre` WHERE `chambre`.`code_service`=\"REA\"";
            String requete15 = "SELECT cast(AVG(nb_lits) as decimal(3,1)) as count FROM `chambre` WHERE `chambre`.`code_service`=\"CHG\"";
            
            
            list.add(con.nombre(requete7));
            list.add(con.nombre(requete8));
            list.add(con.nombre(requete9));
            
            list.add(con.nombre(requete4));
            list.add(con.nombre(requete5));
            list.add(con.nombre(requete6));
            
            list.add(con.nombre(requete1));
            list.add(con.nombre(requete2));
            list.add(con.nombre(requete3));
            
            list.add(con.nombre(requete10));
            list.add(con.nombre(requete11));
            list.add(con.nombre(requete12));
           
            list.add(con.nombre(requete13));
            list.add(con.nombre(requete14));
            list.add(con.nombre(requete15));

            
            return list;
            
        }
        
        
        public ArrayList histograme2(){
            ArrayList list = new ArrayList();
            String requete1 = "SELECT COUNT(*) as count FROM `malade` WHERE `malade`.`mutuelle`=\"MNAM\"";
            String requete2 = "SELECT COUNT(*) as count FROM `malade` WHERE `malade`.`mutuelle`=\"LMDE\"";
            String requete3 = "SELECT COUNT(*) as count FROM `malade` WHERE `malade`.`mutuelle`=\"MNH\"";
            String requete4 = "SELECT COUNT(*) as count FROM `malade` WHERE `malade`.`mutuelle`=\"MAAF\"";
            String requete5 = "SELECT COUNT(*) as count FROM `malade` WHERE `malade`.`mutuelle`=\"MGEN\"";
            String requete6 = "SELECT COUNT(*) as count FROM `malade` WHERE `malade`.`mutuelle`=\"MMA\"";

            String requete7 = "SELECT COUNT(*) as count FROM `malade` WHERE `malade`.`mutuelle`=\"CNAMTS\"";
            String requete8 = "SELECT COUNT(*) as count FROM `malade` WHERE `malade`.`mutuelle`=\"CCVRP\"";
            String requete9 = "SELECT COUNT(*) as count FROM `malade` WHERE `malade`.`mutuelle`=\"MNFTC\"";
            String requete10 = "SELECT COUNT(*) as count FROM `malade` WHERE `malade`.`mutuelle`=\"MAS\"";
            String requete11= "SELECT COUNT(*) as count FROM `malade` WHERE `malade`.`mutuelle`=\"AG2R\"";
            String requete12 = "SELECT COUNT(*) as count FROM `malade` WHERE `malade`.`mutuelle`=\"MGSP\"";




            list.add(con.nombre(requete1));
            list.add(con.nombre(requete2));
            list.add(con.nombre(requete3));
            list.add(con.nombre(requete4));
            list.add(con.nombre(requete5));
            list.add(con.nombre(requete6)); 
            list.add(con.nombre(requete7));
            list.add(con.nombre(requete8));
            list.add(con.nombre(requete9));
            list.add(con.nombre(requete10));
            list.add(con.nombre(requete11));
            list.add(con.nombre(requete12)); 

            return list;
        }
        
        
          public ArrayList histograme3(){
            ArrayList list = new ArrayList();
            String requete1 = "SELECT cast(AVG(salaire) as decimal(10,2)) as count FROM `infirmier`  WHERE `infirmier`.`code_service`=\"CAR\"";
            String requete2 = "SELECT cast(AVG(salaire) as decimal(10,2)) as count FROM `infirmier`  WHERE `infirmier`.`code_service`=\"REA\"";
            String requete3 = "SELECT cast(AVG(salaire) as decimal(10,2)) as count FROM `infirmier`  WHERE `infirmier`.`code_service`=\"CHG\"";
            //String requete4 = "SELECT cast(AVG(nb_lits) as decimal(3,1)) as count FROM `chambre` WHERE `chambre`.`code_service`=\"CAR\"";
            //String requete5 = "SELECT cast(AVG(nb_lits) as decimal(3,1)) as count FROM `chambre` WHERE `chambre`.`code_service`=\"REA\"";
            //String requete6 = "SELECT cast(AVG(nb_lits) as decimal(3,1)) as count FROM `chambre` WHERE `chambre`.`code_service`=\"CHG\"";
            //String requete7= "SELECT (SELECT COUNT(*)  FROM `infirmier` WHERE `infirmier`.`code_service`=`service`.`code`)/ (SELECT COUNT(*)  FROM `hospitalisation` WHERE `hospitalisation`.`code_service`=`service`.`code`) as count FROM `service`WHERE`service`.`code`=\"CAR\"";
            //String requete8= "SELECT (SELECT COUNT(*)  FROM`infirmier` WHERE `infirmier`.`code_service`=`service`.`code`)/ (SELECT COUNT(*)  FROM `hospitalisation` WHERE `hospitalisation`.`code_service`=`service`.`code`) as count FROM `service`WHERE`service`.`code`=\"REA\"";
            //String requete9= "SELECT (SELECT COUNT(*)  FROM `infirmier` WHERE `infirmier`.`code_service`=`service`.`code`)/ (SELECT COUNT(*)  FROM`hospitalisation` WHERE `hospitalisation`.`code_service`=`service`.`code`) as count FROM `service`WHERE`service`.`code`=\"CHG\"";

            list.add(con.nombre(requete1));
            list.add(con.nombre(requete2));
            list.add(con.nombre(requete3));
            //list.add(con.nombre(requete4));
            //list.add(con.nombre(requete5));
            //list.add(con.nombre(requete6));
            //list.add(con.nombre(requete7));
            //list.add(con.nombre(requete8));
            //list.add(con.nombre(requete9));
            


            return list;
        }
        
        public ArrayList histogramme4(){
            
            ArrayList list = new ArrayList();
            String requete1="SELECT COUNT(*) as count FROM `chambre`, `service` WHERE `chambre`.`code_service`=`service`.`code` AND `service`.`code`=\"CAR\"";
            String requete2="SELECT COUNT(`no_chambre`) as count FROM `chambre` WHERE `code_service` in (SELECT `code` FROM `service` WHERE `service`.`code`=\"CAR\" )AND `nb_lits`>( SELECT COUNT(*) FROM `hospitalisation`WHERE `hospitalisation`.`code_service`=`chambre`.`code_service` AND `hospitalisation`.`no_chambre`=`chambre`.`no_chambre`)";
            
            String requete3="SELECT COUNT(*) as count FROM `chambre`, `service` WHERE `chambre`.`code_service`=`service`.`code` AND `service`.`code`=\"REA\"";
            String requete4="SELECT COUNT(`no_chambre`) as count FROM `chambre` WHERE `code_service` in (SELECT `code` FROM `service` WHERE `service`.`code`=\"REA\" )AND `nb_lits`>( SELECT COUNT(*) FROM `hospitalisation`WHERE `hospitalisation`.`code_service`=`chambre`.`code_service` AND `hospitalisation`.`no_chambre`=`chambre`.`no_chambre`)";

            String requete5="SELECT COUNT(*) as count FROM `chambre`, `service` WHERE `chambre`.`code_service`=`service`.`code` AND `service`.`code`=\"CHG\"";
            String requete6="SELECT COUNT(`no_chambre`) as count FROM `chambre` WHERE `code_service` in (SELECT `code` FROM `service` WHERE `service`.`code`=\"CHG\" )AND `nb_lits`>( SELECT COUNT(*) FROM `hospitalisation`WHERE `hospitalisation`.`code_service`=`chambre`.`code_service` AND `hospitalisation`.`no_chambre`=`chambre`.`no_chambre`)";

            list.add(con.nombre(requete1));
            list.add(con.nombre(requete2));
            list.add(con.nombre(requete3));
            list.add(con.nombre(requete4));
            list.add(con.nombre(requete5));
            list.add(con.nombre(requete6));
            
                                    

         
            return list;
            
        }
        
        
        public ArrayList histogramme5(){
            
            ArrayList list=new ArrayList();
            String requete1="SELECT COUNT(*) as count  FROM `malade` WHERE `numero` in (SELECT `hospitalisation`.`no_malade` FROM `hospitalisation`, `service`, `soigne`WHERE `hospitalisation`.`code_service`=`service`.`code` AND `service`.`directeur`=`soigne`.`no_docteur` AND `soigne`.`no_malade`=`hospitalisation`.`no_malade` AND `hospitalisation`.`code_service`=\"CAR\")";
            String requete2="SELECT COUNT(*) as count  FROM `malade` WHERE `numero` in (SELECT `hospitalisation`.`no_malade` FROM `hospitalisation`, `service`, `soigne`WHERE `hospitalisation`.`code_service`=`service`.`code` AND `service`.`directeur`=`soigne`.`no_docteur` AND `soigne`.`no_malade`=`hospitalisation`.`no_malade` AND `hospitalisation`.`code_service`=\"REA\")";
            String requete3="SELECT COUNT(*) as count  FROM `malade` WHERE `numero` in (SELECT `hospitalisation`.`no_malade` FROM `hospitalisation`, `service`, `soigne`WHERE `hospitalisation`.`code_service`=`service`.`code` AND `service`.`directeur`=`soigne`.`no_docteur` AND `soigne`.`no_malade`=`hospitalisation`.`no_malade` AND `hospitalisation`.`code_service`=\"CHG\")";

            
            list.add(con.nombre(requete1));
            list.add(con.nombre(requete2));
            list.add(con.nombre(requete3));
            
            return list;
        }
        
        
        
    
}

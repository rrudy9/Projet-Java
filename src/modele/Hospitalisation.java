
package modele;

import modele.Chambre;

public class Hospitalisation extends Table{
    
    int No_Malade;
    String Code_Service;
    int No_Chambre;
    int Lit;
    
    public Hospitalisation(){
        No_Malade=0;
        Code_Service="";
        No_Chambre=0;
        Lit=0;
        
    }
    
    public Hospitalisation(int no_malade, String code_service, int no_chambre, int lit){
        this.No_Malade=no_malade;
        this.Code_Service=code_service;
        this.No_Chambre=no_chambre;
        this.Lit=lit;
        
    }public Hospitalisation(int no_malade, String code_service, int no_chambre){
        this.No_Malade=no_malade;
        this.Code_Service=code_service;
        this.No_Chambre=no_chambre;
        this.Lit=0;
    }
    
        // ****** ACCESSEURS ****** //
    public int getNo_Malade (){
        return No_Malade;
    }
    
    public String getCode_Service (){
        return Code_Service;
    }
    
    public int getNo_Chambre (){
        return No_Chambre;
    }
    
    public int getLit (){
        return Lit;
    }
    
    // ****** MUTATEURS ****** //
    public void setNo_Malade (int pNo_Malade){
        No_Malade = pNo_Malade;
    }
    
    public void setCode_service (String pCode_Service){
        Code_Service = pCode_Service;
    }
    
    public void setNo_Chambre (int pNo_Chambre){
        No_Chambre = pNo_Chambre;
    }
    
    public void setLit (int pLit){
        Lit = pLit;
    }
    
}

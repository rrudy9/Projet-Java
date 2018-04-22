
package modele;


public class Chambre extends Table {
    
    
    String Code_Service;
    int No_Chambre;
    int Surveillant;
    int Nb_Lits;
    
    
    public Chambre (){
        Code_Service = "";
        No_Chambre=0;
        Surveillant=0;
        Nb_Lits=0;    
    }
    
    public Chambre (String code_service, int no_chambre, int surveillant, int nb_lits  ){
        
      
        this.Code_Service=code_service;
        this.No_Chambre=no_chambre;
        this.Surveillant= surveillant;
        this.Nb_Lits=nb_lits;
 
    }
    
    public Chambre (String code_service, int no_chambre, int surveillant  ){
        
      
        this.Code_Service=code_service;
        this.No_Chambre=no_chambre;
        this.Surveillant= surveillant;
        this.Nb_Lits=0;
 
    }
    
    
    public Chambre (String code_service, int no_chambre  ){
        
      
        this.Code_Service=code_service;
        this.No_Chambre=no_chambre;
        this.Surveillant= 0;
        this.Nb_Lits=0;
 
    }
    
    
    // ****** ACCESSEURS ****** //
    public int getNo_Chambre (){
        return No_Chambre;
    }
    
    public String getCode_Service (){
        return Code_Service;
    }
    
    public int getSurveillant (){
        return Surveillant;
    }
    
    public int getNb_Lits (){
        return Nb_Lits;
    }
    
    // ****** MUTATEURS ****** //
    public void setNo_Chambre (int pNo_Chambre){
        No_Chambre = pNo_Chambre;
    }
    
    public void setCode_Service (String pCode_Service){
        Code_Service = pCode_Service;
    }
    
    public void setSurveillant (int pSurveillant){
        Surveillant = pSurveillant;
    }
    
    public void setNb_Lits (int pNb_Lits){
        Nb_Lits = pNb_Lits;
    }    
    
}

    
    
    
    
    


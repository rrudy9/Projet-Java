
package modele;



public class Soigne {
 
    int No_Docteur;
    int No_Malade;
    
    public Soigne(){
        
        No_Docteur=0;
        No_Malade=0;

    }
    
    public Soigne(int no_docteur, int no_malade){
        
        this.No_Docteur=no_docteur;
        this.No_Malade=no_malade;
        
    }
        // ****** ACCESSEURS ****** //
    public int getNo_Docteur (){
        return No_Docteur;
    }
    
    public int getNo_Malade (){
        return No_Malade;
    }
    
    // ****** MUTATEURS ****** //
    public void setNo_Docteur (int pNo_Docteur){
        No_Docteur = pNo_Docteur;
    }
    
    public void setNo_Malade (int pNo_Malade){
        No_Malade = pNo_Malade;
    }
}

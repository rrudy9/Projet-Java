
package modele;


public class Service extends Table {
    
    String Code;
    String Nom;
    String Batiment;
    int Directeur;
    
    public Service(){
        
        Code="";
        Nom="";
        Batiment="";
        Directeur=0;
        
        
    }
    
    public Service (String code, String nom, String batiment, int directeur){
        
        this.Code=code;
        this.Nom=nom;
        this.Batiment=batiment;
        this.Directeur=directeur;
    }
    
        // ****** ACCESSEURS ****** //
    public String getCode (){
        return Code;
    }
    
    public String getNom (){
        return Nom;
    }
    
    public String getBatiment (){
        return Batiment;
    }
    
    public int getDirecteur (){
        return Directeur;
    }

    
    // ****** MUTATEURS ****** //
    public void setCode (String pCode){
        Code = pCode;
    }
    
    public void setNom (String pNom){
        Nom = pNom;
    }
    
    public void setBatiment (String pBatiment){
        Batiment = pBatiment;
    }
    
    public void setDirecteur (int pDirecteur){
        Directeur = pDirecteur;
    }
}


package modele;


public class Malade extends Table{
    
    
    
    int Numero;
    String Nom;
    String Prenom;
    String Adresse;
    String Tel;
    String Mutuelle;
    
    
    public Malade(){
        
        Numero=0;
        Nom=null;
        Prenom=null;
        Adresse=null;
        Tel=null;
        Mutuelle=null;
    }
    
    public Malade(int numero, String nom, String prenom, String tel, String adresse, String mutuelle ){
        
        this.Numero=numero;
        this.Nom=nom;
        this.Prenom=prenom;
        this.Adresse=adresse;
        this.Tel=tel;
        this.Mutuelle=mutuelle;
        
    }
    public Malade(int numero, String nom, String prenom ){
        
        this.Numero=numero;
        this.Nom=nom;
        this.Prenom=prenom;
        this.Adresse="";
        this.Tel="";
        this.Mutuelle="";
        
    }
    public Malade(int numero, String nom, String prenom, String tel){
        
        this.Numero=numero;
        this.Nom=nom;
        this.Prenom=prenom;
        this.Adresse="";
        this.Tel=tel;
        this.Mutuelle="";
        
    }
    
    public Malade(int numero, String nom, String prenom, String tel, String adresse){
        
        this.Numero=numero;
        this.Nom=nom;
        this.Prenom=prenom;
        this.Adresse=adresse;
        this.Tel=tel;
        this.Mutuelle="";
        
    }
    
        // ****** ACCESSEURS ****** //
    public int getNumero (){
        return Numero;
    }
    
    public String getNom (){
        return Nom;
    }
    
    public String getPrenom (){
        return Prenom;
    }
    
    public String getTel (){
        return Tel;
    }
    
    public String getAdresse (){
        return Adresse;
    }
    
    // ****** MUTATEURS ****** //
    public void setNumero (int pNumero){
        Numero = pNumero;
    }
    
    public void setNom (String pNom){
        Nom = pNom;
    }
    
    public void setPrenom (String pPrenom){
        Prenom = pPrenom;
    }
    
    public void setTel (String pTel){
        Tel = pTel;
    }
   
    public void setAdresse (String pAdresse){
        Adresse = pAdresse;
    }
}

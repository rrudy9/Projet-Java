
package modele;


public class Infirmier extends Table {
 
    int Numero;
    String Code_Service;
    String Rotation;
    int Salaire;
    
    public Infirmier(){
        Numero=0;
        Code_Service="";
        Rotation="";
        Salaire=0;
    }
    
    public Infirmier(int numero, String code_service, String rotation, int salaire){
        
        this.Numero=numero;
        this.Code_Service=code_service;
        this.Rotation=rotation;
        this.Salaire=salaire;
    }
    
    public Infirmier(int numero, String code_service, String rotation){
        
        this.Numero=numero;
        this.Code_Service=code_service;
        this.Rotation=rotation;
        this.Salaire=0;
    }
        // ****** ACCESSEURS ****** //
    public int getNumero (){
        return Numero;
    }
    
    public String getCode_service (){
        return Code_Service;
    }
    
    public String getRotation (){
        return Rotation;
    }
    
    public int getSalaire (){
        return Salaire;
    }
    
    // ****** MUTATEURS ****** //
    public void setNumero (int pNumero){
        Numero = pNumero;
    }
    
    public void setCode_Service (String pCode_Service){
        Code_Service = pCode_Service;
    }
    
    public void setRotation (String pRotation){
        Rotation = pRotation;
    }
    
    public void setSalaire (int pSalaire){
        Salaire = pSalaire;
    }
}


package modele;


public class Docteur extends Table {
    
    int Numero;
    String Specialite;
    
    
    public Docteur (){
        
        Numero = 0;
        Specialite=null;
    }
    
    public Docteur (int numero, String specialite){
        this.Numero=numero;
        this.Specialite=specialite;
    }
    
    // ****** ACCESSEURS ****** //
    public int getNumero (){
        return Numero;
    }
    
    public String getSpecialite (){
        return Specialite;
    }
    
    // ****** MUTATEURS ****** //
    public void setNumero (int pNumero){
        Numero = pNumero;
    }
    
    public void setSpecialite (String pSpecialite){
        Specialite = pSpecialite;
    }

    
}

package Main;
import java.io.File;

public class InfoEx {
    private String nom, numero,location,nomDePhoto;
    private File   JPEG;

    void SetNom(String nom) {
      this.nom = nom;
    }

    void SetNumero(String numero) {
      this.numero=numero;
    }

    void SetLocation(String location) {
this.location= location;
    }

    void SetPhoto(String nomPhoto) {
        nomDePhoto = nomPhoto;
        this.JPEG = new File("Photo" + File.separator + nomPhoto);
        if (!JPEG.exists()) {
            System.out.println("pas de file");
        }
    }
    public String GetNom(){
        return this.nom;
    }
    public String GetNumero(){
        return this.numero;
    }
    public String GetLocation(){
        return this.location;
    }
    public File GetPhoto(){
        return this.JPEG;
    }
    public String ToString() {
        
    return this.nom+" | "+this.numero+" | "+this.location+" | "+this.nomDePhoto;
    }
    
    
 
}

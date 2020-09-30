import java.util.Random;
public class Die {


    private int dice_value;
    public static final int MAXVALUE=6;

    public Die() {
      dice_value = (int)(Math.random() * 6 + 1);
    }

    public int getValue() {
      return this.dice_value; //retourne la valeur du dé
   }

   public void roll(){
     this.dice_value = (int)(Math.random() * 6 + 1);
   }

   public String toString(){
     String message;
     message = "Die {value:"+this.dice_value+"}";
     return message;
   }


}

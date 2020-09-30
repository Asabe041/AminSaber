public class Card {
    
    private int suit;
    private int rank;
    public static final int  DIAMOND=0, CLUB=1, HEART=2, SPADE=3;
    
    public Card(int suit, int rank){
    this.suit=suit;
    this.rank=rank;
    }

    
public boolean equals(Object object){
if (! (object instanceof Card)) {
      return false;
}

Card other;
other =  (Card) object;
    
return this.suit == other.suit && this.rank==other.rank;
    
}
    public String toString(){
        return "{"+this.suit+","+this.rank+"}";
    }

    public int getSuit(){
        return this.suit;
    }
    public int getRank(){
        return this.rank;
    }
    
   
    
}

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    /**
    * A constructor for the class <code>Deck</code>. It creates the initial
    * <code>ArrayList</code> that will be used to store the cards of Otherwise
    * deck.
    */

    public Deck() {
        cards = new ArrayList<Card>();
    }

    /**
    * A constructor for the class <code>Deck</code>. It creates the initial
    * <code>ArrayList</code> that will be used to store the cards of Otherwise
    * deck. The parameter specifies the number of ranks for the cards. Finally,
    * it also initializes this deck to contain 4 x n cards, where n is the value
    * of the parameter.
    *
    * @param range the number of ranks for the cards
    */

    public Deck(int range) {
      cards = new ArrayList<Card>();
      for(int i=1; i<range+1; i++){
        cards.add(new Card(0,i));
        cards.add(new Card(1,i));
        cards.add(new Card(2,i));
        cards.add(new Card(3,i));
      }
        // Complete the implementation of this constructor
    }

    // Add all the necessary methods here
    public int size(){
      return cards.size();
    }

    public boolean hasCards(){
      int x = cards.size();
      if (x>0){
        return true;
      } else {
        return false;
      }
      }

    public Card get(int pos){
      return cards.get(pos);
    }

    public void add(Card card){
      cards.add(card);
    }

    public void addAll(Deck other){
      int length = other.cards.size();
      for (int i=0; i<length; i++){
        cards.add(other.cards.get(i));
      }
      for (int i=0; i<length; i++){
        other.cards.remove(0);
      }
    }

    public Card removeLast(){
      Card temp;
      temp = cards.get(cards.size()-1);
      cards.remove(cards.size()-1);
      return temp;
    }

    public Card removeFirst(){
      Card temp;
      temp = cards.get(0);
      cards.remove(0);
      return temp;
    }

    public boolean remove(Card card){
      for(int i=0; i<cards.size();i++){
        if (card.equals(cards.get(i))){
          cards.remove(i);
          return true;
        }
      }
      return false;
    }

    public void removeAll(Deck other){
      int j=0;
      boolean flag=true;
      for(int i=0; i<other.cards.size(); i++){
        while(j<cards.size() && flag==true){
          if(cards.get(j).equals(other.cards.get(i))){
            cards.remove(j);
            flag= false;
          }
          j++;
        }
        j=0;
        flag=true;
      }
    }

    public void shuffle(){
      Collections.shuffle(cards);
    }

    public Deck deal(int n){
        Deck tmp;
        tmp = new Deck();
        System.out.println("1) "+cards.size()+" "+n);
        if (cards.size()<n){
            System.out.println("2) got into IF ");
            for(int i=0; i<cards.size();i++){
                tmp.add(cards.get(cards.size()-1-i));
            }
            
            for(int i=0; i<cards.size();i++){
                cards.remove(0);
                  System.out.println("3) "+get(i));
            }
            
        } else {
            
            for(int i=0; i<n;i++){
                tmp.add(cards.get(cards.size()-1-i));
            }
            
            for(int i=0; i<n;i++){
                removeLast();
            }
        }
        return tmp;
    }
    public boolean contains(Card card){
      for(int i=0; i<cards.size();i++){
        if(card.equals(cards.get(i))){
          return true;
        }
      }
      return false;
    }

    public boolean containsAll(Deck other){
      for (int i=0; i<other.cards.size();i++){
        if (cards.contains(other.cards.get(i))==false){
          return false;
        }
      }
      return true;
    }

    public boolean isKind(){
      int value;
      if (cards.size()<2){
        return false;
      }
      value = cards.get(0).getRank();
      for (int i=1;i<cards.size();i++){
        if(cards.get(i).getRank()!=value){
          return false;
        }
      }
      return true;
    }

    public boolean isSeq(){
      int value;
        if(cards.size()<3){
            return false;
        }
      value = cards.get(0).getSuit();
      //check if theyre same suits
      for (int i=1;i<cards.size();i++){
        if(cards.get(i).getSuit()!=value){
          return false;
        }
      }


      selectionSortRank();

      for(int i=0; i<cards.size()-1;i++){
        if(cards.get(i).getRank()+1 != cards.get(i+1).getRank()){
          return false;
        }
      }
      return true;
    }


    private void selectionSortRank(){ //helper functions
		Card temporary;
		int minArg;
		for(int counter=0; counter<cards.size()-1;counter++){
			minArg = counter;
			for (int counter2=counter+1;counter2<cards.size();counter2++){
				if (cards.get(counter2).getRank()<cards.get(minArg).getRank()){
					minArg=counter2;
				}
			}
			temporary=cards.get(minArg);
      cards.set(minArg, cards.get(counter));
      cards.set(counter,temporary);
		}
	}



  public void sortBySuit(){
    selectionSortRank();
    Deck temp;
    temp=new Deck();
    for (int i=0; i<cards.size();i++){
      if (cards.get(i).getSuit()==0){
        temp.add(cards.get(i));
      }
    }
    for (int i=0; i<cards.size();i++){
      if (cards.get(i).getSuit()==1){
        temp.add(cards.get(i));
      }
    }
    for (int i=0; i<cards.size();i++){
      if (cards.get(i).getSuit()==2){
        temp.add(cards.get(i));
      }
    }
    for (int i=0; i<cards.size();i++){
      if (cards.get(i).getSuit()==3){
        temp.add(cards.get(i));
      }
    }
    this.cards=temp.cards;
  }

  public void sortByRank(){
    sortBySuit();
    Deck newDeck;
    newDeck= new Deck();
    for (int i=1; i<100; i++){
      for(int j=0;j<cards.size();j++){
        if (cards.get(j).getRank()==i){
          newDeck.add(cards.get(j));
        }
      }
    }
    cards=newDeck.cards;
  }

  public void print(){
    sortByRank();
    System.out.println("Deck "+cards);
    sortBySuit();
    System.out.println("Deck "+cards);
  }

  public String toString(){
    String message="",tmp="";
    for (int i=0; i<cards.size();i++){
      tmp = cards.get(i).toString();
      message = message+" "+tmp;
    }
    return message;
  }
    }

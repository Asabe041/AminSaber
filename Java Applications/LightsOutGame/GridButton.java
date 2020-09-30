// YOUR IMPORT HERE
import java.awt.*;
import javax.swing.*;

public class GridButton extends JButton {


    // YOUR VARIABLES HERE
	private int row, column;
    private static final ImageIcon[] icons = new ImageIcon[4];

    /**
     * Constructor used for initializing a GridButton at a specific
     * Board location.
     * 
     * @param column
     *            the column of this Cell
     * @param row
     *            the row of this Cell
     */

    public GridButton(int column, int row) {
		
	this.row=row;
	this.column=column;
	
    for(int i=0; i<4;i++){
        icons[i]= new ImageIcon("Icons/Light-"+i+".png");
    }
        setIcon(findIcon(1));

    }
   /**
    * sets the icon of the button to reflect the
    * state specified by the parameters
    * @param isOn true if that location is ON
    * @param isClicked true if that location is
    * tapped in the model's current solution
    */ 
    public void setState(boolean isOn, boolean isClicked){
        
        
        if (!isOn && !isClicked){
            this.setIcon(findIcon(1));
            }
        if(isOn&& !isClicked){
            this.setIcon(findIcon(0));
        }
        if(!isOn&& isClicked){
            this.setIcon(findIcon(3));
        }
        if(isOn&& isClicked){
            this.setIcon(findIcon(2));
        }
        

    }

  
    /**
     * Getter method for the attribute row.
     * 
     * @return the value of the attribute row
     */

    public int getRow() {
        // YOUR CODE HERE
		return row;
    }

    /**
     * Getter method for the attribute column.
     * 
     * @return the value of the attribute column
     */

    public int getColumn() {
        // YOUR CODE HERE
		return column;
    }
    // YOUR OTHER METHODS HERE
    private ImageIcon findIcon(int state){
        return icons[state];
    }

}

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.border.*;

// your other import here if needed

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out a matrix of <b>GridButton</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame {

    // your variables here
    private GridButton[][] board;
	private GameModel model;
	private GameController gameController;
	private JCheckBox sol;
    /**
     * Constructor used for initializing the Frame
     * 
     * @param gameModel
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */
	private JLabel steps;
    public GameView(GameModel model, GameController gameController) {

        // YOUR CODE HERE
        super("LightsOut - Amin & Assaad");
		this.model=model;
		this.gameController=gameController;
        
        setSize(400, 400);
		
        board=new GridButton[model.getHeight()][model.getWidth()];
        setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		JPanel grid = new JPanel(new GridLayout(model.getHeight(), model.getWidth()));
		grid.setBackground(Color.WHITE);
        JPanel Button1= new JPanel();
		Button1.setBackground(Color.WHITE);
		JPanel Button2= new JPanel();
		Button2.setBackground(Color.WHITE);
		JPanel Button3= new JPanel();
		Button3.setBackground(Color.WHITE);
		JPanel Button4= new JPanel();
		Button4.setBackground(Color.WHITE);
		JPanel stepsP = new JPanel(new FlowLayout());
		stepsP.setBackground(Color.WHITE);
		
		
        JButton reset = new JButton("Reset");;
        JButton random = new JButton("Random");
        sol = new JCheckBox("Solution");
        JLabel solution= new JLabel("Solution");
        JButton quit = new JButton("Quit");
        
        
        for(int i=0;i<model.getHeight();i++){
            for(int j =0; j<model.getWidth();j++){
                board[i][j] = new GridButton(j,i);
                board[i][j].addActionListener(gameController);
                board[i][j].setActionCommand("Clicked");
                grid.add(board[i][j]);
            }
        }
        
        
		steps = new JLabel("Number of steps =0");
		stepsP.add(steps);
		
        Button1.add(reset);
        reset.addActionListener(gameController);
		
        Button2.add(random);
        random.addActionListener(gameController);
		
        Button3.add(sol);
        sol.addItemListener(gameController);
		sol.setBackground(Color.WHITE);
		
        Button4.add(quit);
        quit.addActionListener(gameController);
		
		JPanel panel= new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		
		panel.add(Button1);
		panel.add(Button2);
		panel.add(Button3);
		panel.add(Button4);
				
				
		JPanel panelB= new JPanel(new BorderLayout());
        panelB.setBackground(Color.WHITE);
        add(grid, BorderLayout.CENTER);
		add(stepsP, BorderLayout.SOUTH);
        add(panel, BorderLayout.EAST);
        
        //setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        // YOUR CODE HERE
    }

    

    /**
     * updates the status of the board's GridButton instances based 
     * on the current game model, then redraws the view
     */

    public void update(){
        model.setSolution();
		if(solutionShown()){
		updateSolution();
		}else{
        normalSolution();
        }
        steps.setText("Number of steps: "+model.getNumberOfSteps());
        
        if(model.isFinished()){
			String[] options ={"Quit", "Reset"};
			int answer = JOptionPane.showOptionDialog(null,"You have beat the game in "+ model.getNumberOfSteps()+" steps, Congratulations do you want to play again","Winner!!!", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, options,options[0]);
			if(answer == 0){
				System.exit(0);
			}
				else{
					model.reset();
					model.setSolution();
					update();
				}
			
		}
    }
    
    public void normalSolution(){
        for(int i=0; i<model.getHeight();i++){
            for(int j=0;j<model.getWidth();j++){
                board[i][j].setState(model.isON(i,j),false);
            }
        }
    }
 
	public void updateSolution(){
		 for(int i=0; i<model.getHeight();i++){
				for(int j=0;j<model.getWidth();j++){
					board[i][j].setState(model.isON(i,j),model.getSolution().get(j,i));
			}
		}
	}

    /**
     * returns true if the ``solution'' checkbox
     * is checked
     *
     * @return the status of the ``solution'' checkbox
     */
	public boolean solutionShown(){
		return sol.isSelected();
	}
   
    
}

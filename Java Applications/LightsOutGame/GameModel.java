import java.util.Random;
import java.util.ArrayList;

public class GameModel {

  // YOUR CODE HERE
    private boolean[][] table;
    private int clicks;
    private Solution solved;
    private LightsOut solutions;
    
    
    public GameModel(int width, int height){
        table = new boolean[height][width];
        clicks=0;
        solved= new Solution(width,height);
    }
    
    public int getHeight(){
        return table.length;
    }
    public int getWidth(){
        return table[0].length;
    }
	public Solution getSolution(){
	return solved;
	}
 
    public boolean isON(int i, int j){
        if(j<0 || i<0 || i>table.length-1|| j>table[0].length-1){
            throw new ArrayIndexOutOfBoundsException("I or J is less than zero or bigger than the table length");
        }
        return table[i][j];
    }
    
    public void reset(){
        for (int i=0; i<table.length;i++){
            for(int j=0; j<table[0].length;j++){
                table[i][j] = false;
            }
        }
        clicks=0;
    }
    
    public void set(int i, int j, boolean value){
        
        
        if(j<0 || i<0 || j>table.length-1|| i>table[0].length-1){
            throw new ArrayIndexOutOfBoundsException("I or J is less than zero or bigger than the table length");
        }
    
        table[j][i] = value;
    }
    public String toString(){
        String message="";
        for (int i=0; i<table.length; i++){
            message+="[";
            for (int j=0; j<table[0].length;j++){
                message += table[i][j];
                if (j<table[0].length-1){
                    message+=", ";
                }
            }
            message +="]";
            if(i<table.length-1){
                message+=", ";
            }
        }
        return "["+message+"]";
    }
    
    public void click(int i, int j){
        
        checkIfOn(i,j);
        if(i>0){
        checkIfOn(i-1,j);//changes the one on top if row is bigger than one
        }
        if(j>0){
        checkIfOn(i,j-1);//changes the one to the left if column bigger than 0
        }
        if(i<table.length-1){
        checkIfOn(i+1,j);//changes the one under if it isnt last row
        }
        if(j<table[0].length-1){
        checkIfOn(i,j+1);//changes the one to the left if it isnt in last column
        }
        clicks++;
    }
    public void checkIfOn(int i,int j){
        if(isON(i,j)){
            table[i][j]=false;
        }else{
            table[i][j]=true;
        }
    }
    public int getNumberOfSteps(){
        return clicks;
    }
    
    public boolean isFinished(){
        boolean flag=true;
        for (int i=0;i<table.length;i++){
            for(int j=0; j<table[0].length;j++){
                if(table[i][j]==false){
                    flag= false;
                }
            }
        }
        return flag;
    }
    public void randomize(){
        Random generator= new Random();
        for(int a=0;a<10;a++){
            for (int i=0;i<table.length;i++){
                for(int j=0; j<table[0].length;j++){
                    table[i][j]=generator.nextBoolean();
        }
            }
        }
        setSolution();
        if(LightsOut.solve(this).size()==0){
            randomize();
        }
        clicks=0;
    }
    
    public void setSolution(){
        solved=LightsOut.solveShortest(this);
    }
    
    public boolean solutionSelects(int i, int j){
        
        if(j<0 || i<0 || i>table.length-1|| j>table[0].length-1){
            throw new ArrayIndexOutOfBoundsException("I or J is less than zero or bigger than the table length");
        }
        
        if (solved!=null && solved.get(j,i)){
            return true;
        }
        return false;
    }

}

import java.awt.Color;
import java.awt.Graphics;
/**
 * Write a description of class Chip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chip
{
    private int row;
    private int column;
    public String team;
    private Color color;
    
    public Chip(){
    }
    
    public void setPos(int x, int y) {row = x; column = y;}
    public void setTeam(String t) {
        team = t;
               if (team.equals("red")){
            color = Color.RED;
        } else if (team.equals("blue")){
            color = Color.BLUE;
        }
    }
    
    public void getPos() {
        System.out.println("ROW: " + row);
        System.out.println("COLS: " + column);
    }
    
    public void getTeam() {
        System.out.println("TEAM: " + team);
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        //System.out.println(team);
        g.fillOval((25 + (column * 125)), (25 + (row * 125)), 100, 100);
    }
}

import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board
{ 
    public static void draw(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,900,800);
        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 7; j++){
                g.setColor(Color.DARK_GRAY);
                g.fillOval((25 + (j * 125)), (25 + (i * 125)), 100, 100);
            }
        }
    }
}
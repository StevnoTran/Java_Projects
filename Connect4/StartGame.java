import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
/**
 * Write a description of class StartGamee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGame
{
    private static JFrame frame = new JFrame("Connect 4 - By Steven Tran");
    private static GamePanel game;
    public static void main(String[] args){
       game = new GamePanel();
       frame.setSize(906,806);
       frame.setResizable(false);
       frame.setContentPane(game);
       frame.setVisible(true);
        
       // game.repaint();
    }
}

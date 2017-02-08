import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * Write a description of class GamePanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GamePanel extends JPanel
{
    private Chip[] chips = new Chip[42];
    private int[][] slots = new int[6][7];
    private volatile int usedChips = 0;
    private Board board = new Board();
    private String turn = "red";
    private int boardOn = 0;

    public GamePanel(){
        for (int r = 0; r < 6; r++){
            for (int c = 0; c < 7; c++){
                slots[r][c] = 0;
            }
        }
        setFocusable(true);
        addMouseListener(new EventHandler());
        init_Chips();
        repaint();
        System.out.println("RUN GAME");

    }

    public void init_Chips() {
        for(int i = 0; i < 42; i++) {
            chips[i] = new Chip();
        }
    }

    public void checkOpen(int column){
        int c = column;
        for (int r = 5; r >= 0; r--){
            if (slots[r][c] == 0){
                if (turn.equals("red")){
                    slots[r][c] = 1;
                    chips[usedChips] = new Chip();
                    chips[usedChips].setTeam("red");
                    chips[usedChips].setPos(r,c);
                    usedChips++;
                    turn = "blue";
                    //System.out.println(1);
                } else {
                    slots[r][c] = 2;
                    chips[usedChips] = new Chip();
                    chips[usedChips].setTeam("blue");
                    chips[usedChips].setPos(r,c);
                    usedChips++;
                    turn = "red";
                    //System.out.println(2);
                }
                break;
            }
        }
        // System.out.println(usedChips);
        repaint();
    }
    
    //Debugging method to display each chips attributes
    /* 
    public void displayChips() {
        System.out.println(usedChips);
        for(int i = 0; i < usedChips; i++) {
            System.out.println("CURR CHIP: " + i);
            chips[i].getTeam();
            chips[i].getPos();
            System.out.println();
        }
        System.out.println("****************************************************************************************************");
    }
    */
    
    @Override
    public void paintComponent(Graphics g) {
        board.draw(g);
        int count = usedChips - 1;
        if(usedChips != 0){
            while (count >= 0){
                chips[count].draw(g);
                count--;
            }
        }
        //displayChips(); //Calls on debugging method
    }

    public class EventHandler implements MouseListener
    {
        public void mouseClicked(MouseEvent e){
            int columnCheck;
            int x = e.getX();
            if (x > 25 && x < 125){
                columnCheck = 0;
            } else if (x > 150 && x < 250){
                columnCheck = 1;
            } else if (x > 275 && x < 375){
                columnCheck = 2;
            } else if (x > 400 && x < 500){
                columnCheck = 3;
            } else if (x > 525 && x < 625){
                columnCheck = 4;
            } else if (x > 650 && x < 750){
                columnCheck = 5;
            } else if (x > 775 && x < 875){
                columnCheck = 6;
            } else {
                return;
            }
            checkOpen(columnCheck);
            // usedChips++;

            // System.out.println(columnCheck);
            //         
            //         for (int r = 0; r < 6; r++){
            //            for (int c = 0; c < 7; c++){
            //                System.out.print(slots[r][c]);
            //            }
            //            System.out.println();
            //        }

            //        System.out.println("\nUsed Chips: " + usedChips + "\n");
            //        for (int i = 0; i < usedChips; i++){
            //            System.out.println(chips[i]);
            //         }
        }

        public void mouseEntered(MouseEvent e){
        }

        public void mouseExited(MouseEvent e){
        }

        public void mousePressed(MouseEvent e){
        }

        public void mouseReleased(MouseEvent e){
        }
    }
}

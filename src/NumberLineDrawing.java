import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;
public class NumberLineDrawing extends JPanel {
    private int start;
    private int end;
    public int[] results;
    public int head;
    private ArrayList<Integer> sequence;
    final int true_width = 990;
   

    public NumberLineDrawing(int start, int end, ArrayList<Integer> sequence, int[] results, int head, Double timer_speed) {
        this.start = start;
        this.end = end;
        this.sequence = sequence;
        this.results = results;
        this.head = head;
        super.setBackground(new java.awt.Color(250, 236, 182));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        int width = true_width;
        int height = 100;

        // Set up drawing properties
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));

        // Calculate the length and tick interval
        int length = Math.abs(start) + Math.abs(end) + 1;
        int tickInterval = width / length;

        // Draw zero line
        g2d.setStroke(new BasicStroke(3));
        g2d.setFont(new java.awt.Font("Poppins ExtraBold", 0, 12)); 
        g2d.drawLine(0, height / 2, 910, height / 2);

        // Plot the sequence on the number line
        int sequenceSize = sequence.size();
        int sequenceMarkerSize = 12;

        for (int i = 0; i < sequenceSize; i++) {

            if(i == 0){

                int number = 0;

            int x = (number - start) * tickInterval;
            
            x = x + 50;
            g2d.drawLine(x, height / 2 - 10, x, height / 2 + 10); // ticks
            // Adjust y position to avoid overlapping with tick marks
            int y = height / 2 - 10 - sequenceMarkerSize;
           
            g2d.setColor(new Color(95, 179, 255));
            g2d.fillOval(x - sequenceMarkerSize / 2, y, sequenceMarkerSize, sequenceMarkerSize);
            g2d.setColor(Color.BLACK);
            g2d.drawString(String.valueOf(number), x - 5, y - 5);

            number = 199;

            x = (number - start) * tickInterval;
            
            x = x + 50;
            g2d.drawLine(x, height / 2 - 10, x, height / 2 + 10); // ticks
            // Adjust y position to avoid overlapping with tick marks
            y = height / 2 - 10 - sequenceMarkerSize;
           
            
            g2d.setColor(new Color(95, 179, 255));
            g2d.fillOval(x - sequenceMarkerSize / 2, y, sequenceMarkerSize, sequenceMarkerSize);
            g2d.setColor(Color.BLACK);
            g2d.drawString(String.valueOf(number), x - 5, y - 5);
            }
            int number = sequence.get(i);
            int x = (number - start) * tickInterval;
            
            x = x + 50;
            g2d.drawLine(x, height / 2 - 10, x, height / 2 + 10); // ticks
            // Adjust y position to avoid overlapping with tick marks
            int y = height / 2 - 10 - sequenceMarkerSize;
           

            g2d.setColor(new Color(95, 179, 255));
            g2d.fillOval(x - sequenceMarkerSize / 2, y, sequenceMarkerSize, sequenceMarkerSize);
            g2d.setColor(Color.BLACK);
            g2d.drawString(String.valueOf(number), x - 5, y - 5);
        }
        lineWriter(g2d, head);
      
   
    }
    public void lineWriter(Graphics g2d, int head) {
        int length = Math.abs(start) + Math.abs(end) + 1;
        int width = true_width;
        int ticks = width / length;
        int number = head;
        final int START_NUM = 0;
        final int OFFSET = 50;
        int startX = (number - START_NUM) * ticks;
        startX = startX + OFFSET;
        int startY = 50;
        int nextY = 0;
       
        //for loop
        for(int i = 0; i < results.length; i++){
            if(i == 0){
                number = head;
                }
            else{
                number = results[i];
            }

            int nextX = (results[i]) * ticks;
            
            nextY = nextY + 50;
            nextX = nextX + 50;
  
                g2d.drawLine(startX, startY, nextX, nextY);  // line between two dots
                g2d.fillOval(startX-6, startY-6, 12, 12); // dot
                g2d.drawString(String.valueOf(number), nextX + 10, nextY + 20); //label
                startX = nextX;
                startY = nextY;
        }
        g2d.fillOval(startX-6, startY-6, 12, 12);
    }
    public Timer timer;
}

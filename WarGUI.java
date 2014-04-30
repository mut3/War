import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

/**
javaDocs are still for nerds
this is the GUI
*/

public class WarGUI extends JFrame
{
	//game init
	private WarGame g;
	//inits for swing objects
	private JPanel panel1;
	private JPanel panel2;
	//labels
	private JLabel p1Deck;
	private JLabel p2Deck;
	private JLabel p1Pile;
	private JLabel p2Pile;
	private JLabel statusText;
	//lonely button
	private JButton playButton;
	//images
	private ImageIcon backImage;
	private ImageIcon p1Card;
	private ImageIcon p2Card;
	
	//constructor
	public WarGUI()
	{
		g = new WarGame();

		try
        {
            backImage = new ImageIcon(ImageIO.read(new File("cards/back.jpg")));
        }
        catch (IOException derp)
        {
            System.err.println("Card image: back.jpg not found.");
            System.exit(1);
        }
        

		setTitle("War");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        validate();
        //build panel
        buildPanels();
        //add panel to the frame content
        add(panel1);
        add(panel2);

        setVisible(true);
	}

	private void buildPanels()
	{
		//create a text field to print status messages in can use HTML :)
		statusText = new JLabel("This is War");
		//create play button
		playButton = new JButton("Play");
		//add listener on the play button
		playButton.addActionListener(new PlayButtonListener());
		//create the panels
		panel2.add(statusText);
		panel2.add(playButton);
	}

	//button listener
	private class PlayButtonListener implements ActionListener
    {
        // Called when the button is pushed.
        public void actionPerformed(ActionEvent e)
        {
        	playButton.setText("Continue Game");
            g.play();
            updateCardImages();
            updateStatusText();
            
            // If the game is over
            if (g.getGameState() != 0)
            {
            	// Figure out who won
	            if (g.getGameState() < 0)
	            {
	            	javax.swing.JOptionPane.showMessageDialog(null, "P1 Wins!");
	            }
	            else //g.getGameState() > 0
	            {
	            	javax.swing.JOptionPane.showMessageDialog(null, "P2 Wins!");
	            }
	            // And finish up.
	            updateStatusText(); // To get the "P1 wins!"/"P2 Wins." message
	            playButton.setEnabled(false); // Disable the continue button.
            }
            

        }
    }


	//call this everytime something happens
	private void updateCardImages()
    {
    	// Set the player's hand to the back of a card if it has cards in it, otherwise set it to nothing.
        if (g.hasDeckCards(1))
        {
            p1Deck.setIcon(backImage);
        }
        else
        {
            p1Deck.setIcon(null);
        }
        p1Deck.revalidate(); // Repaint
        
        // Set the player's top card on the pile to the correct image if there are cards on the pile, otherwise set it to nothing.
        if (g.getActiveCard(1) != null)
        {
            try
            {
                p1Pile.setIcon(new ImageIcon(ImageIO.read(new File(g.getCardImage(1)))));
            }
            catch(IOException derp)
            {
                System.err.println("Card image "+g.getCardImage(1)+" not found.");
                System.exit(1);    
            }
        }
        else
        {
            p1Pile.setIcon(null);
        }
        p1Pile.revalidate(); // Repaint
        
        // Repeat above code for computer's hand and pile
        // Set the player's hand to the back of a card if it has cards in it, otherwise set it to nothing.
        if (g.hasDeckCards(2))
        {
            p2Deck.setIcon(backImage);
        }
        else
        {
            p2Deck.setIcon(null);
        }
        p2Deck.revalidate(); // Repaint
        
        // Set the player's top card on the pile to the correct image if there are cards on the pile, otherwise set it to nothing.
        if (g.getActiveCard(2) != null)
        {
            try
            {
                p2Pile.setIcon(new ImageIcon(ImageIO.read(new File(g.getCardImage(2)))));
            }
            catch(IOException derp)
            {
                System.err.println("Card image "+g.getCardImage(2)+" not found.");
                System.exit(1);    
            }
        }
        else
        {
            p2Pile.setIcon(null);
        }
        p2Pile.revalidate(); // Repaint
    }
	//call this method whenever something happens in the game
	private void updateStatusText()
    {
    	String newText = "<html>"+g.getStatusText()
    			+ "<br>P1 hand size: " + g.getDeckSize(1)
    			+ "<br>P2 hand size: " + g.getDeckSize(2)
    			+ "</html>";
    	try
    	{
    		statusText.setText(newText);
    
    	}
    	catch (NullPointerException derp)
    	{
    		return; //Work around a Java bug...
    	}
    }

	public static void main(String[] args) 
	{
	    WarGUI wgui = new WarGUI();
	}
}
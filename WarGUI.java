import java.io.File;
import java.io.FileNotFoundException;
import jave.io.IOException;

import javax.image.imageIO;
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

	private JLabel p1Deck;
	private JLabel p2Deck;
	private JLabel p1Pile;
	private JLabel p2Pile;

	private JTextField textArea;
	private JButton playButton;

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
            throw new FileNotFoundException("Card image: back.jpg not found.");
        }
        

		setTitle("War");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        validate();
        //build panel
        buildPanel();
        //add panel to the frame content
        add(panel1);

        setVisible(true);

        





	}




	public static void main(String[] args) 
	{
	    WarGUI wgui = new WarGUI();
	}
}
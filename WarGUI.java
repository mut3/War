import javax.swing.*;

/**
javaDocs are still for nerds
this is the GUI
*/

public class WarGUI extends JFrame
{
	 
	public WarGUI() 
	{
		

	}




	public static void main(String[] args) 
	{
	    WarGUI wgui = new WarGUI();
        
        
        wgui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wgui.setSize(800,600);
        wgui.validate();
        wgui.setVisible(true);
	}
}
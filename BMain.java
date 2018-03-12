import javax.swing.JFrame;

public class BMain extends JFrame {
	public BMain()
	{
		add(new BFrame());
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	


	public static void main(String[] args)
	{
		new BMain();
		

	}

}

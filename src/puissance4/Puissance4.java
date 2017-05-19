package puissance4;						

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Puissance4 extends JFrame
{
	public static void main(String[] args)
	{
		//appel de la JFrame joueur
		JFrame jf=new joueur();
		
		//on calcule ses dimensions et on l'affiche
		jf.pack();
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
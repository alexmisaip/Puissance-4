package puissance4;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class gagne extends JFrame
{
	puissController puis;
	
	//constructeur
	public gagne(int i,puissController p)
	{
		super("Gagné !");
		this.puis=p;
		
		//Bouton nouvelle partie
		ActionListener al_new=new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				//on réinititalise le programme
				puis.reinit();
				setVisible(false);
			}
		};
		
		//Bouton quitter
		ActionListener al_quit=new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		};
		
		//création des boutons nouvelle partie et quitter
		JButton jb_new=new JButton("Nouvelle partie");
		JButton jb_quitter=new JButton("Quitter");
		
		jb_new.addActionListener(al_new);
		jb_quitter.addActionListener(al_quit);
		
		//Création du JPanel qui contiendra les boutons et ajout des boutons
		JPanel jp_bouton=new JPanel();
		jp_bouton.add(jb_new);
		jp_bouton.add(jb_quitter);
		
		String nom="";
		
		//Création des JLabel contenant le texte de victoire
		if (i==1)
			nom=puis.j.j1;
		else
			nom=puis.j.j2;
		
		JLabel jl=new JLabel("Félicitations "+nom+" !",(int) JLabel.CENTER_ALIGNMENT);
		JLabel jl2=new JLabel("Vous avez gagné !", (int) JLabel.CENTER_ALIGNMENT);
		
		
		//Création des JPanel
		JPanel jp=new JPanel(new BorderLayout());
		JPanel jp2=new JPanel(new BorderLayout());
		
		//ajout des textes et des boutons
		jp2.add(jl,BorderLayout.NORTH);
		jp2.add(jl2,BorderLayout.CENTER);
		jp2.add(jp_bouton,BorderLayout.SOUTH);
		
		jp.add(jp2,BorderLayout.CENTER);
		this.getContentPane().add(jp);
	}
}
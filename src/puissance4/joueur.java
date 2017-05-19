package puissance4;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class joueur extends JFrame
{
	String j1,j2;			//Chaine de caractère ou seront stockés les noms des joueurs
	JTextField jtf_j1;		//JTextField ou seront entr�s les noms des joueurs
	JTextField jtf_j2;
	joueur j;				//référence vers soi-même necessaire pour l'appel de puissController
	
	//Constructuer
	public joueur()		
	{
		super("Joueurs");
		j=this;
		
		//initialisation des JTextField
		jtf_j1= new JTextField(20);
		jtf_j2= new JTextField(20);
		
		//initialisation de JLAbel
		JLabel jl_j1=new JLabel("Joueur 1 : ");
		JLabel jl_j2=new JLabel("Joueur 2 : ");
		
		//Bouton OK
		ActionListener al_ok= new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				j1=jtf_j1.getText();
				j2=jtf_j2.getText();
				
				setVisible(false);
				
				//Création de la JFrame du puissance 4
				JFrame jf=new puissController("Puissance 4",j);
				
				//calcul de la dimension de la JFrame
				jf.pack();
				jf.setVisible(true);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		};
		
		//création du bouton
		JButton jb_ok=new JButton("OK");
		
		jb_ok.addActionListener(al_ok);
		
		//Création des JPanel
		JPanel jp1=new JPanel();
		JPanel jp2=new JPanel();
		JPanel jpb=new JPanel(); 
		
		
		//rajout des différents éléments dans les JPanel
		jp1.add(jl_j1);
		jp1.add(jtf_j1);
		jp2.add(jl_j2);
		jp2.add(jtf_j2);
		jpb.add(jb_ok);
		
		//Ajout des JPanel dans la JFrame
		this.getContentPane().add(jp1,BorderLayout.NORTH);
		this.getContentPane().add(jp2,BorderLayout.CENTER);
		this.getContentPane().add(jpb,BorderLayout.SOUTH);
	}
}
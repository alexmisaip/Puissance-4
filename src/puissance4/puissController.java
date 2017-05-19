package puissance4;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class puissController extends JFrame
{
	JPanel tout;		//JPanel contenant toutes les colonnes du puissance 4
	colonne[] col;		//tableau de 'colonne' contenant les références vers chaque objet 'colonne'
	int joueurCur;		//numéro du joueur courant (1 ou 2)
	verification v;
	joueur j;
	JLabel jl;

	String defaut="C'est le tour de ";
	
	//constructeur
	public puissController(String titre,joueur jo)
	{
		super(titre);
		this.j=jo;
		
		//Le joueur courant est le joueur 1
		this.joueurCur=1;
		
		//instanciation du JPanel général 
		this.tout=new JPanel(new GridLayout(1,7));

		//instanciation du tableau de 'colonne'
		this.col=new colonne[7];
		
		//pour toutes les colonnes du puissance 4
		for (int i=0; i<7; i++)
		{
			//on crée un nouvel objet colonne
			this.col[i]=new colonne(this);
			//et on récupère le JPanel correspondant qu'on ajoute dans 'tout'
			(this.tout).add((this.col[i]).renvoyer());
		}
		
		//Création d'une instance de vérification
		v=new verification(this.col);

		jl=new JLabel(defaut + this.j.j1);
		
		JPanel jpl=new JPanel();
		jpl.add(jl);
		
		//ajout de 'tout' dans la JFrame principale
		this.getContentPane().add(this.tout,BorderLayout.CENTER);
		this.getContentPane().add(jpl,BorderLayout.SOUTH);
	}
	
	// Réinitialisation du programme
	public void reinit()
	{
		//on réinititalise la vérification
		v.reinit();
		
		//on réinitialise les colonnes
		for (int i=0; i<7; i++) {
			this.col[i].reinit();
		}
		if (joueurCur==1) {
			jl.setText(defaut+j.j1);
		} else {
			jl.setText(defaut+j.j2);
		}
	}
}
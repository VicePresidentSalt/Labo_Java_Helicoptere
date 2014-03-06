import java.awt.*;
import javax.swing.*;

public class Anim extends JApplet implements Runnable
{
	private Thread animation;

	public void init()
	{
		int tabCoordX[] = new int[20];
		int tabCoordY[] = new int[20];
		int tabCoordVilleX = new int[5];
		int tabCoordVilleY = new int[5];
		String tabNomVille = new String[5];

		for(int i = 0 ; i<tabCoordX.length;++i) // boucle CoordX du polygone
		{
			String temp =" ";
			try
			{
				temp = getParameter("x"+[i]); // recupération du string HTML et mettre dans temp
				tabCoordX[i] = Integer.parseInt(temp); // conversion du string temp -> int et mettre dans tab position adéquate
			}
			catch(ParseException e)
			{
				e.printStackTrace();
			}

			for(int j = 0 ; j<tabCoordY.length;++j) // boucle CoordY du polygone
			{
				try
				{
					temp = getParameter("y"+[j]);
					tabCoordY[j] = Integer.parseInt(temp);	
				}
				catch(ParseException e)
				{
					e.printStackTrace();
				}		
			}	
		}

		for(int v = 0 ; v<tabNomVille.length;++v) // boucle nom de ville
		{
			tabNomVille[v] = getParameter("nomVille"+[v])
		}

		for(int b = 0 ; b<tabCoordVilleX.length;++b) // boucle CoordX des villes
		{
			String TempVille = " ";
			try
			{
				TempVille= getParameter("xVille"+[b]);
				tabCoordVilleX[b] = Integer.parseInt(TempVille);
			}
			catch(ParseException e)
			{
				e.printStackTrace();
			}	

			for(int n = 0 ; n<tabCoordVilleY.length;++n) // boucle CoordY des villes
			{
				try
				{
					TempVille= getParameter("yVille"+[n]);
					tabCoordVilleY[n] = Integer.parseInt(TempVille);
				}
				catch(ParseException e)
				{
					e.printStackTrace();
				}
			}	
		}

	}

	public void start()
	{
		if( animation == null )
		{
			animation = new Thread( this );
			animation.start();
		}
	}

	public void stop()
	{
		if( animation != null )
		{
			animation = null;
		}
	}

	public void paint( Graphics g )
	{
		boolean pasFini = true;
		while( pasFini )
		{
			// calcul de la nouvelle position des objets graphiques

			try
			{
				Thread.sleep( DELAI );
				repaint();
			}
			catch( InterruptedException ie )
			{
				// ne devrait jamais arriver
			}
		}
	}
}
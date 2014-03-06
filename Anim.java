import java.awt.*;
import javax.swing.*;

public class Anim extends JApplet implements Runnable
{
	private Thread animation;
	int tabCoordX[] = new int[20];
	int tabCoordY[] = new int[20];
	int tabCoordVilleX[] = new int[5];
	int tabCoordVilleY[] = new int[5];
	String tabNomVille[] = new String[5];

	public void init()
	{


		for(int i = 0 ; i<tabCoordX.length;++i) // boucle CoordX du polygone
		{
			String temp =" ";
			try
			{
				//tabCoordX[i] = getParameter("x"+i);
				temp = getParameter("x"+i); // recupération du string HTML et mettre dans temp
				tabCoordX[i] = Integer.parseInt(temp); // conversion du string temp -> int et mettre dans tab position adéquate
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			for(int j = 0 ; j<tabCoordY.length;++j) // boucle CoordY du polygone
			{
				try
				{
					//tabCoordY[j]=getParameter("y"+j);
					temp = getParameter("y"+j);
					tabCoordY[j] = Integer.parseInt(temp);	
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}		
			}	
		}

		for(int v = 0 ; v<tabNomVille.length;++v) // boucle nom de ville
		{
			tabNomVille[v] = getParameter("nomVille"+v);
		}

		for(int b = 0 ; b<tabCoordVilleX.length;++b) // boucle CoordX des villes
		{
			String TempVille = " ";
			try
			{
				//tabCoordVilleX[b]=getParameter("xVille"+b);
				TempVille= getParameter("xVille"+b);
				tabCoordVilleX[b] = Integer.parseInt(TempVille);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}	

			for(int n = 0 ; n<tabCoordVilleY.length;++n) // boucle CoordY des villes
			{
				try
				{
					//tabCoordVilleY[n]= getParameter("yVille"+n);
					TempVille= getParameter("yVille"+n);
					tabCoordVilleY[n] = Integer.parseInt(TempVille);
				}
				catch(Exception e)
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
      // affichage des objets graphiques
   	setBackground(Color.BLUE);
   	  //Dessiner Polygone
      Polygon p = new Polygon();
      for(int i = 0;i<tabCoordX.length;++i)
      {
      	p.addPoint(tabCoordX[i],tabCoordY[i]); // Ajouter tout les points par les tableaux	
      }
      
      
      //Affichage des noms de villes
      for(int j = 0;j<tabNomVille.length;++j)
      {
      	g.drawString(tabNomVille[j],tabCoordVilleX[j]+20,tabCoordVilleY[j]+20); //A tester .. decaler de quelques Y pour ne pas écrire directement sur le point
      }
        //Dessiner cercle sur coord des ville
      for (int k = 0 ; k<tabCoordVilleX.length;++k)
      {
      	g.drawOval(tabCoordVilleX[k],tabCoordVilleY[k],10,10); // Mesure pas exacte a essayer
      	g.fillOval(tabCoordVilleX[k],tabCoordVilleY[k],10,10);
      }
      g.drawPolygon(p); // Dessiner polygon
      g.setColor(Color.GREEN); // Remplir en quel couleur
      g.fillPolygon(p); // Remplir en vert
    
      
   }

   public void run()
   {
      boolean pasFini = true;
      while( pasFini )
      {
         // calcul de la nouvelle position des objets graphiques

         try
         {
            Thread.sleep( 3000 ); //delai 3 secondes...a checker
            repaint();
         }
         catch( InterruptedException ie )
         {
            // ne devrait jamais arriver
         }
      }
   }
}
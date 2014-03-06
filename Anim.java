import java.awt.*;
import javax.swing.*;
	
public class Anim extends JApplet implements Runnable
{
   private Thread animation;¸
   	
   public void init()
   {
      int tabCoordX[] = new int[20];
      int tabCoordY[] = new int[20];
      int tabCoordVilleX = new int[5];
      int tabCoordVilleY = new int[5];
      String tabNomVille = new String[5];
      
      for(int i = 0 ; i<tabCoordX.length;++i) // boucle CoordX du polygone
      {
      	tabCoordX[i] = getParameter("x"+[i]);
      	
      	for(int j = 0 ; j<tabCoordY.length;++j) // boucle CoordY du polygone
      	{
      		tabCoordY[j] = getParameter("y"+[j]);	
      	}	
      }
   
      for(int v = 0 ; v<tabNomVille.length;++v) // boucle nom de ville
      {
      	tabNomVille[v] = getParameter("nomVille"+[v])
      }
      
      for(int b = 0 ; b<tabCoordVilleX.length;++b) // boucle CoordX des villes
      {
      	tabCoordVilleX[b] = getParameter("xVille"+[b]);
      	
      	for(int n = 0 ; n<tabCoordVilleY.length;++n) // boucle CoordY des villes
      	{
      		tabCoordVilleX[n] = getParameter("yVille"+[n]);	
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
import java.awt.*;
import javax.swing.*;
	
public class Anim extends JApplet implements Runnable
{
   private Thread animation;
   int Coord0X;int Coord0Y;
   int Coord1X;int Coord1Y;
   int Coord2X;int Coord2Y;
   int Coord3X;int Coord3Y;
   int Coord4X;int Coord4Y;
   int Coord5X;int Coord5Y;
   int Coord6X;int Coord6Y;
   int Coord7X;int Coord7Y;
   int Coord8X;int Coord8Y;
   int Coord9X;int Coord9Y;
   int Coord10X;int Coord10Y;
   int Coord11X;int Coord11Y;
   int Coord12X;int Coord12Y;
   int Coord13X;int Coord13Y;
   int Coord14X;int Coord14Y;
   int Coord15X;int Coord15Y;
   int Coord16X;int Coord16Y;
   int Coord17X;int Coord17Y;
   int Coord18X;int Coord18Y;
   int Coord19X;int Coord19Y;
   int CoordVille0X;int CoordVille0Y;
   int CoordVille1X;int CoordVille1Y;
   int CoordVille2X;int CoordVille2Y;
   int CoordVille3X;int CoordVille3Y;
   int CoordVille4X;int CoordVille4Y;
   String nomDeVille0;
   String nomDeVille1;
   String nomDeVille2;
   String nomDeVille3;
   String nomDeVille4;
   
   public void init()
   {
      // récupération des paramètres et création des objets
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
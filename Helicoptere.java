import java.awt.*;
import javax.swing.*;
	
public class Anim extends JApplet implements Runnable
{
   private Thread animation;
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
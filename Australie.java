import java.awt.*;
import javax.swing.*;

public class Australie extends JApplet implements Runnable
{
   private Thread animation;
   private final int NBVILLE = 10;
   int tabCoordVilleX[] = new int[NBVILLE];
   int tabCoordVilleY[] = new int[NBVILLE];
   String tabNomVille[] = new String[NBVILLE];
   Polygon australie = new Polygon();
   private int maxX = 0;
   private int maxY = 0;
   private int posX = 0;
   private int posY = 0;
   private int direction = 0;
   private final int GROSSEURHELICOPTERE = 15;

   public void init()
   {
      maxX = this.size().width;
      maxY = this.size().height;
      posX = (int)(Math.random() * maxX);
      posY = (int)(Math.random() * maxY);

      try
      {
         Boolean pasFini = true;
         int i = 0;
         int j = 0;
         String x = " ";
         String y = " ";
         int CoordX = 0;
         int CoordY = 0;

         while (pasFini)
         {
            x = getParameter("x" + i);
            y = getParameter("y" + j);
            if (x != null && y != null)
            {
               try
               {
                  CoordX = Integer.parseInt(x);
                  CoordY = Integer.parseInt(y);
                  australie.addPoint(CoordX, CoordY);
                  ++i;
                  ++j;
               }
               catch (NumberFormatException e)
               {
                  pasFini = false;
               }
            }
            else
            {
               pasFini = false;
            }
         }
         for (int v = 0; v < tabNomVille.length; ++v) // boucle nom de ville
         {
            if (getParameter("nomville" + v) != null)
            {
               tabNomVille[v] = getParameter("nomVille" + v);
            }
         }
         for (int b = 0; b < tabCoordVilleX.length; ++b) // boucle CoordX des villes
         {
            String TempVille = " ";
            try
            {
               if (getParameter("xVille" + b) != (null))
               {
                  TempVille = getParameter("xVille" + b);
                  tabCoordVilleX[b] = Integer.parseInt(TempVille);
               }
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
         }
         for (int n = 0; n < tabCoordVilleY.length; ++n) // boucle CoordY des villes
         {
            String TempVille = " ";
            try
            {
               if (getParameter("yVille" + n) != (null))
               {
                  TempVille = getParameter("yVille" + n);
                  tabCoordVilleY[n] = Integer.parseInt(TempVille);
               }
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
         }
      }
      catch (Exception e) {}
   }

   public void start()
   {
      if (animation == null)
      {
         animation = new Thread(this);
         animation.start();
      }
   }

   public void stop()
   {
      if (animation != null)
      {
         animation = null;
      }
   }

   public void paint(Graphics g)
   {
      // affichage des objets graphiques

      //Dessiner Polygone
      g.setColor(Color.CYAN);
      g.fillRect(0, 0, maxX, maxY);
      g.setColor(Color.GREEN); // Remplir en quel couleur
      g.fillPolygon(australie); // Remplir en avec la dite couleur ^
      g.drawPolygon(australie); // Dessiner polygon


      //Dessiner cercle sur coord des ville
      for (int k = 0; k < NBVILLE; ++k)
      {
         if (tabCoordVilleX[k] != 0 || tabCoordVilleY[k] != 0 || tabNomVille[k] != null)
         {
            g.setColor(Color.BLACK);
            g.drawOval(tabCoordVilleX[k], tabCoordVilleY[k], 10, 10); // Mesure pas exacte a essayer
            g.fillOval(tabCoordVilleX[k], tabCoordVilleY[k], 10, 10);
         }
      }

      //Affichage du String Australie
      g.setColor(Color.BLACK);
      Font f = new Font("SansSerif", Font.BOLD, 25);
      g.setFont(f);
      g.drawString("AUSTRALIE", 0, 420);

      //Affichage du point qui va bouger
      g.setColor(Color.BLACK);
      g.drawOval(posX, posY, GROSSEURHELICOPTERE, GROSSEURHELICOPTERE);
      g.fillOval(posX, posY, GROSSEURHELICOPTERE, GROSSEURHELICOPTERE);

      //Affichage des noms de villes
      for (int j = 0; j < tabNomVille.length; ++j)
      {
         if (tabCoordVilleX[j] != 0 || tabCoordVilleY[j] != 0 || tabNomVille[j] != null)
         {
            Font t = new Font("SansSerif", Font.PLAIN, 12);
            g.setFont(t);
            g.setColor(Color.BLACK);
            g.drawString(tabNomVille[j], tabCoordVilleX[j] + 20, tabCoordVilleY[j] + 20); //A tester .. decaler de quelques Y pour ne pas écrire directement sur le point
         }
      }
   }

   public void bougerPoint()
   {
      final int DEPLACEMENT = 5;
      switch (direction)
      {
         case 0:
         {
               if (posX + DEPLACEMENT < maxX - GROSSEURHELICOPTERE && posY - DEPLACEMENT > GROSSEURHELICOPTERE)
               {
                  posX += DEPLACEMENT;
                  posY -= DEPLACEMENT;
               }
               else
               {
                  direction = (int)(Math.random() * 4);
               }
               break;
         }
         case 1:
         {
               if (posX - DEPLACEMENT > GROSSEURHELICOPTERE && posY + DEPLACEMENT < maxY - GROSSEURHELICOPTERE)
               {
                  posX = posX - DEPLACEMENT;
                  posY = posY + DEPLACEMENT;
               }
               else
               {
                  direction = (int)(Math.random() * 4);
               }
               break;
         }
         case 2:
         {
               if (posX - DEPLACEMENT > GROSSEURHELICOPTERE && posY - DEPLACEMENT > GROSSEURHELICOPTERE)
               {
                  posX = posX - DEPLACEMENT;
                  posY = posY - DEPLACEMENT;
               }
               else
               {
                  direction = (int)(Math.random() * 4);
               }
               break;
         }
         case 3:
         {
               if (posX + DEPLACEMENT < maxX - GROSSEURHELICOPTERE && posY + DEPLACEMENT < maxY - GROSSEURHELICOPTERE)
               {
                  posX = posX + DEPLACEMENT;
                  posY = posY + DEPLACEMENT;
               }
               else
               {
                  direction = (int)(Math.random() * 4);
               }
               break;
         }
      }
   }

   public void run()
   {
      boolean pasFini = true;
      while (pasFini)//boucle infinie
      {
         try
         {
            bougerPoint();
            Thread.sleep(500); //delai 3 secondes...a checker
            repaint();
         }
         catch (InterruptedException ie)
         {
            // ne devrait jamais arriver
         }
      }
   }
}
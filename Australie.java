import java.awt.*;
import javax.swing.*;

public class Australie extends JApplet implements Runnable
{
	private Thread animation;
	int tabCoordVilleX[] = new int[10];
	int tabCoordVilleY[] = new int[10];
	String tabNomVille[] = new String[10];
   Polygon australie = new Polygon();
   final int MAXX = this.size().width;
   final int MAXY = this.size().height;
   private int posX = (int)(Math.random()*MAXX);
   private int posY = (int)(Math.random()*MAXY);
   private int direction = 0;

	public void init()
	{
	  Boolean pasFini = true;
	  int i= 0;
	  int j= 0;
	  String x = " ";
	  String y = " ";
	  int CoordX = 0;
	  int CoordY = 0;

	  while(pasFini)
	  {
        x=getParameter("x"+i);
        y=getParameter("y"+j);
        if(x!=null && y!=null)
        {
         try
         {
           CoordX = Integer.parseInt(x);
           CoordY = Integer.parseInt(y);
           australie.addPoint(CoordX,CoordY);
           ++i;
           ++j;
         }
         catch(NumberFormatException e)
         {
            pasFini = false;
         }

        }
        else
        {
         pasFini = false;
        }

	  }


		for(int v = 0 ; v<tabNomVille.length;++v) // boucle nom de ville
		{
			if (getParameter("nomville" + v)!=null)
			{
				tabNomVille[v] = getParameter("nomVille"+v);
			}
		}

		for(int b = 0 ; b<tabCoordVilleX.length;++b) // boucle CoordX des villes
		{
			String TempVille = " ";
			try
			{
				if (getParameter("xVille" + b)!=(null))
				{
					TempVille= getParameter("xVille"+b);
					tabCoordVilleX[b] = Integer.parseInt(TempVille);
				}


			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}


		for(int n = 0 ; n<tabCoordVilleY.length;++n) // boucle CoordY des villes
		{
			String TempVille= " ";
			try
			{
				if (getParameter("yVille" + n)!=(null))
				{
					TempVille= getParameter("yVille"+n);
					tabCoordVilleY[n] = Integer.parseInt(TempVille);
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
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

		//Dessiner Polygone
		g.setColor(Color.CYAN);
		g.fillRect(0,0,this.getSize().width,this.getSize().height);
      g.setColor(Color.GREEN); // Remplir en quel couleur
		g.drawPolygon(australie); // Dessiner polygon
		g.fillPolygon(australie); // Remplir en vert

      //Dessiner cercle sur coord des ville
      for (int k = 0 ; k<5;++k) // ******Hardcodé a 5 mais a régler********* cuz toute les autre ville font un point a 0,0
      {
         g.setColor(Color.BLACK);
         g.drawOval(tabCoordVilleX[k],tabCoordVilleY[k],10,10); // Mesure pas exacte a essayer
         g.fillOval(tabCoordVilleX[k],tabCoordVilleY[k],10,10);
      }

      //Affichage du String Australie
      Font f = new Font("SansSerif",Font.BOLD,25);
      g.setFont(f);
      g.setColor(Color.BLACK);
      g.drawString("AUSTRALIE",0,420);

      //Affichage du point qui va bouger
      g.setColor(Color.BLACK);
      g.drawOval(posX,posY,15,15);
      g.fillOval(posX,posY,15,15);

		//Affichage des noms de villes
		for(int j = 0;j<tabNomVille.length;++j)
		{
         Font t = new Font("SansSerif",Font.PLAIN,12);
         g.setFont(t);
			g.setColor(Color.BLACK);
			g.drawString(tabNomVille[j],tabCoordVilleX[j]+20,tabCoordVilleY[j]+20); //A tester .. decaler de quelques Y pour ne pas écrire directement sur le point
		}

	}

   public void bougerPoint()
   {
       boolean horsLimite = false;
       final int DEPLACEMENT =5;
       switch(direction)
       {
         case 0:
         {
            if(posX+DEPLACEMENT < MAXX || posY-DEPLACEMENT < 0 )
            {
               posX +=DEPLACEMENT;
               posY -=DEPLACEMENT;
            }
            else
            {
               horsLimite = true;
            }

            if(horsLimite)
            {
               direction = (int)Math.random()*4;
            }
            break;
         }
         case 1:
         {
            if(posX-DEPLACEMENT > 0 || posY+DEPLACEMENT < MAXY)
            {
               posX = posX-DEPLACEMENT;
               posY = posY+DEPLACEMENT;
            }
            else
            {
               horsLimite = true;
            }

            if(horsLimite)
            {
               direction = (int)Math.random()*4;
            }
            break;
         }
         case 2:
         {
            if(posX-DEPLACEMENT > 0 || posY-DEPLACEMENT < 0)
            {
                posX = posX-DEPLACEMENT;
                posY = posY-DEPLACEMENT;
            }
            else
            {
               horsLimite = true;
            }
            if(horsLimite)
            {
               direction = (int)Math.random()*4;
            }
            break;
         }
         case 3:
         {
            if(posX+DEPLACEMENT < MAXX || posY+DEPLACEMENT < MAXY)
            {
               posX = posX+DEPLACEMENT;
               posY = posY+DEPLACEMENT;
            }
            else
            {
               horsLimite = true;
            }
            if(horsLimite)
            {
               direction = (int)Math.random()*4;
            }
            break;
         }
       }
   }

	public void run()
	{
		boolean pasFini = true;
		while( pasFini )//boucle infinie
		{
			try
			{
            bougerPoint();
				Thread.sleep( 500 ); //delai 3 secondes...a checker
				repaint();
			}
			catch( InterruptedException ie )
			{
				// ne devrait jamais arriver
			}
		}
	}
}
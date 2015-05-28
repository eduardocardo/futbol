import java.util.Random;
/**
 * Write a description of class JugadorDeCampo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JugadorDeCampo extends Jugador
{
    //indica la puntuacion en pases del jugador
    private int pases;
    //indica la puntuacion en regate del jugador
    private int regate;
    //indica la puntuacion en remate
    private int remate;
    //indica la valoracion en conjunto del jugador
    /**
     * Constructor for objects of class JugadorDeCampo
     */
    public JugadorDeCampo(String nombre,int dorsal)
    {

        super(nombre,dorsal);
        Random rnd = new Random();
        pases = rnd.nextInt(11);
        regate = rnd.nextInt(11);
        remate = rnd.nextInt(11);
    }

    /**
     * metodo que devuelve la puntuacion del jugador en pases
     * @return la puntuacion en pases
     */
    public int getPases()
    {
        return pases;
    }

    /**
     * metodo que devuelve la puntuacion del jugador en regates
     * @return la puntuacion en regates
     */
    public int getRegate()
    {
        return regate;
    }

    /**
     * metodo que devuelve la puntuacion del jugador en remates
     * @return la puntuacion en reamtes
     */
    public int getRemate()
    {
        return remate;
    }

   /**
     * Metodo que calcula la valoracion del jugador
     * @return la valoracion del jugador
     */
    public int valoracion()
    {
        return (int)(getForma() + pases + regate + remate)/4;
    }

    /**
     * metodo que muestra la informacion sobre el jugador
     * @return la informacion del jugador en forma de cadena
     */
    public String toString()
    {
        
        return super.toString() + String.format("  Pases : %2d  Regates : %2d  Remates : %2d"
            + "  Valoracion : %2d",pases,regate,remate,valoracion());
    }
}

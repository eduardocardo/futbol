import java.util.Random;
/**
 * Write a description of class Portero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portero extends Jugador
{
    //indica la puntuacion en agilidad
    private int agilidad;
    //indica la puntuacion en fortaleza mental
    private int fortM;
    /**
     * Constructor for objects of class Portero
     */
    public Portero(String nombre,int dorsal)
    {
        super(nombre,dorsal);
        Random rnd = new Random();
        agilidad = rnd.nextInt(11);
        fortM = rnd.nextInt(11);
    }

    /**
     * Metodo que devuelve la puntuacion en agilidad
     * @return la puntuacion en agilidad
     */
    public int getAgilidad()
    {
        return agilidad;
    }

    /**
     * metodo que devuelve la puntuacion en fortaleza mental
     * @return un valor entero que representa la fortaleza mental
     */
    public int getFortM()
    {
        return fortM;
    }

     /**
     * metodo que calcula la valoracion del portero
     * @return un valor entero que representa la valoracion
     */
    public int valoracion()
    {
        return (int)(getForma() + agilidad + fortM)/3;
    }

    /**
     * metodo que devuelve la informacion del portero
     * @return la informacion del portero en forma de cadena
     */
    public String toString()
    {
        String espacio = " ";
        return super.toString() + String.format("  Agil  : %2d  FortM   : %2d %12s   Valoracion : %2d",agilidad,
            fortM,espacio,valoracion());
    }
}

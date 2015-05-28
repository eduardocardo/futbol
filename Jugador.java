import java.util.Random;
/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Jugador
{
    //indica el nombre del jugador
    private String nombre;
    //indica el dorsal del jugador
    private int dorsal;
    //indica la edad del jugador
    private int edad;
    //indica la puntuacion del jugador
    private int forma;


    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nombre,int dorsal)
    {
        this.nombre = nombre;
        this.dorsal = dorsal;
        Random rnd = new Random();
        //edad comprendida entre 18 y 40
        edad = rnd.nextInt(22) + 18;
        //forma comprendida en 0 y 10
        forma = rnd.nextInt(11);

    }
    /**
     * Metodo que devuelve el nombre del jugador
     * @return el nombre del jugador
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * Metodo que devuelve la edad del jugador
     * @return la edad
     */
    public int getEdad()
    {
        return edad;
    }

    /**
     * Metodo que devuelve la forma del jugador
     * @return la puntuacion en forma del jugador
     */
    public int getForma()
    {
        return forma;
    }

    /**
     * Metodo que devuelve el dorsal del jugador
     * @return el dorsal del jugador
     */
    public int getDorsal()
    {
        return dorsal;
    }

    /**
     * metodo que calcula la valoracion media del jugador
     * @return la valoracion media del jugador
     */
    public abstract int valoracion();

    /**
     * Metodo que muestra la informacion sobre el jugador
     * @return la informacion en forma de cadena sobre el jugador
     */
    public String toString()
    {

        return String.format("Dorsal : %3d.  %-12s  (%2d  anios )  Forma : %2d",dorsal,nombre,edad,forma);
    }
}

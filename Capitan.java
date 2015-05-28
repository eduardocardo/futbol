import java.util.Random;
/**
 * Write a description of class Capitan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Capitan extends JugadorDeCampo
{
    //indica la puntuacion en liderazgo
    private int liderazgo;
    /**
     * Constructor for objects of class Capitan
     */
    public Capitan(String nombre,int dorsal)
    {
        super(nombre,dorsal);
        Random rnd = new Random();
        liderazgo = rnd.nextInt(6);
    }

    /**
     * Metodo que devuelve la puntuacion del capitan en liderazgo
     * @return un valor entero que representa la puntuacion en liderazgo
     */
    public int getLiderazgo()
    {
        return liderazgo;
    }

    /**
     * Metodo que calcula la valoracion del capitan
     * @return la valoracion
     */
    public int valoracion()
    {
        int valoracion = super.valoracion() + liderazgo;
        if(valoracion > 10)
        {
            valoracion = 10;
        }
        return valoracion;
    }

    /**
     * Metodo que muestra informacion sobre el capitan
     * @return la informacion sobre el capitan en forma de cadena
     */
    public String toString()
    {
        return super.toString() + " " + "Liderazgo : " + liderazgo;
    }
}


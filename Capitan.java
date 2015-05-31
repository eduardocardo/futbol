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
     * modificador de la capacidad de liderazgo
     * @param int liderazgo
     */
    public void setLiderazgo(int l)
    {
        liderazgo=l;
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
    
     /**
     * entrenamiento de los jugadores
     * se mejora las habilidades en un porcentaje aleatorio
     * si la habilidad es 0 reconpensando el entrenamiento se convierte en 1 
     * 
     */
    public void entrenar()
    {
        super. entrenar();
        Random rnd=new Random();
        int porcent=rnd.nextInt(101);
        int mejorl = (int)Math.ceil(liderazgo * porcent) /100;
       
        
        if(mejorl + liderazgo <= 5)
        {
           liderazgo+=mejorl;
        }
        else
        {
            liderazgo = 5;
        }

    }
}


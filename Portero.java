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
     * modificador de la habilidad fortaleza mental
     * @param int fortaleza mental
     */
    public void setFortM(int f)
    {
        
        fortM=f;
    }
    
    
    /**
     * modificador de la habilidad agilidad
     * @param int fortaleza agilidad
     */
    public void setAgilidad(int a)
    {
        agilidad=a;
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
        int mejorag = (int)Math.ceil(agilidad * porcent) /100;
        int mejorafm =(int)Math.ceil(fortM * porcent) /100;
        
        
        if(mejorag + agilidad <= 10)
        {
           agilidad+=mejorag;
        }
        else
        {
            agilidad = 10;
        }

        
         if( mejorafm + fortM <= 10)
        {
            fortM+=mejorafm;
        }
        else
        {
           fortM = 10;
        }
        
        if(fortM==0)
        {
            fortM=1;
        }
        else if(agilidad==0)
        {
             agilidad=1;
        }
       
    }
}

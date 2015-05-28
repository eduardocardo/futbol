import java.util.Random;

import java.util.ArrayList;
/**
 * Write a description of class Equipo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equipo
{
    //indica el nombre del equipo
    private String nombre;
    //array que almacena el conjunto de jugadores que forma un equipo
    private ArrayList<Jugador> jugadores;

    /**
     * Constructor de la clase Equipo
     * @param nombre es el nombre del equipo
     * @param numJugadores es el numero de jugadores que tiene el equipo
     */
    public Equipo(String nombre,int numJugadores)
    {
        this.nombre = nombre;
        int numDorsal = 1;
        jugadores = new ArrayList<>();
        //se añade primero el portero que tiene el dorsal 1
        jugadores.add(new Portero(nombreAleatorio(),numDorsal));
        numDorsal++;
        Random rnd = new Random();
        int dorsalCapitan =rnd.nextInt(numJugadores -1) + 2;
        //se añaden el resto de jugadores
        for(int i = 0; i < numJugadores -1;i++)
        {
            if(numDorsal != dorsalCapitan)
            {
                jugadores.add(new JugadorDeCampo(nombreAleatorio(),numDorsal));
            }
            else
            {
                //si coincide el dorsal se añade el capitan al array
                jugadores.add(new Capitan(nombreAleatorio(),dorsalCapitan));
            }
            numDorsal++;
        }
        
    }

    /**
     * Metodo que genera un nombre aleatorio a partir de una coleccion de nombres
     * return un nombre
     */
    private String nombreAleatorio()
    {
        String nombres[] = {"Ramon", "Pedro", "Juan", "Mario", "Marcos", "Miguel", "Luis", "Carlos",
                "Jose Ramon", "Federico", "Alberto", "Roberto", "Ruben", "Guillermo", "Hector",
                "Mario", "Felipe", "Manuel", "Tomas", "Agustin", "Jose Manuel", "Juan Jesus",
                "Pepe", "Ricardo", "Fernando", "Antonio", "Jose Alberto", "Jose Luis", "David",
                "Emilio", "Cesar", "German", "Raul", "Pablo"};
        //se crea un objeto random
        Random rnd = new Random();
        return nombres[rnd.nextInt(nombres.length)];
    }

    /**
     * Metodo que devuelve el nombre del equipo
     * @return el nombre del equipo en forma de cadena
     */
    public String getNombre()
    {
        return nombre;

    }
   
    /**
     * Metodo que muestra la alineacion titular y de reservas del equipo
     */
    public void hacerAlineacion()
    {
        
        //se hace una copia del arrayList
        ArrayList<Jugador> copia = new ArrayList<>(); 
        copia = (ArrayList)jugadores.clone();
        //almacena la suma de las valoraciones del equipo titular
        float sumaValoraciones = 0;
        //primero se muestran los titulares
        System.out.println("Titulares :");
         //primero el portero y luego se elimina del del array
        System.out.println(copia.get(0));
        sumaValoraciones += copia.get(0).valoracion();
        copia.remove(0);
        int i = 0;
        boolean encontrado = false;
        //despues se busca al capitan
        while( i < copia.size() && !encontrado)
        {
            if(copia.get(i) instanceof Capitan)
            {
                System.out.println(copia.get(i));
                sumaValoraciones += copia.get(i).valoracion();
                copia.remove(i);
            }
            i++;
        }
        //a continuacion se añaden 9 jugadores de campo de forma aleatoria
        int j = 0;
        int num = 0;
        Random rnd = new Random();
        while(j < 9)
        {
             //se obtiene el indice del jugador titular de forma aleatoria
            num = rnd.nextInt(copia.size());
            System.out.println(copia.get(num));
            sumaValoraciones += copia.get(num).valoracion();
            copia.remove(num);
            j++;
        }
         System.out.printf("*************Valoracion media del equipo titular :  %.2f  **************\n",sumaValoraciones/11);
         
        System.out.println("Reservas : ");
        for(Jugador jugador:copia)
        {
            System.out.println(jugador);
        }
    }
}

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
    //almacena los 11 jugadores que forman el equipo titular
    private ArrayList<Jugador> equipoTitular;
    //almacena los jugadores que forman el equipo suplente
    private ArrayList<Jugador> equipoSuplente;
    
    private int victorias;
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
        //se obtiene el dorsal del capitan
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
        equipoTitular = new ArrayList<>();
        equipoSuplente = new ArrayList<>();
        
        victorias=0;
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
     * Metodo que hace la alineacion titular y el equipo de suplentes
     */
    public void hacerAlineacion()
    {

        //se hace una copia del arrayList
        ArrayList<Jugador> copia = new ArrayList<>(); 
        copia = (ArrayList)jugadores.clone();

        //primero se obtiene el equipo titular

        //el portero se selecciona el primero y se añade al array
        equipoTitular.add(copia.get(0));   
        copia.remove(0);

        int i = 0;
        boolean encontrado = false;
        //despues se busca al capitan y se añade al array
        while( i < copia.size() && !encontrado)
        {
            if(copia.get(i) instanceof Capitan)
            {
                equipoTitular.add(copia.get(i));
                copia.remove(i);
                encontrado = true;
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
            equipoTitular.add(copia.get(num));
            //se elimina el jugador
            copia.remove(num);
            j++;
        }
         
        //ahora se obtiene el equipo de suplentes
        for(Jugador jugador:copia)
        {
            equipoSuplente.add(jugador);
        }
        
        //crack calculado de manera aleatoria
        //de los doce titulares yn jugador pasa a ser el crack del equipo con todos los paramentros a tope
        //contamos solo los jugadores de campo por eso solo 
        int crack =rnd.nextInt(10)+1;
        
        //mejoramos las habilidades teniendo en cuenta si es jugador de campo o el capitan del equipo
           if(equipoTitular.get(crack) instanceof Capitan)
           {
                equipoTitular.get(crack).setForma(10);
                ((Capitan)equipoTitular.get(crack)).setPases(10);
                ((Capitan)equipoTitular.get(crack)).setRemate(10);
                ((Capitan)equipoTitular.get(crack)).setRemate(10);
                ((Capitan)equipoTitular.get(crack)).setLiderazgo(10);
           }
           else if (equipoTitular.get(crack) instanceof JugadorDeCampo)
           {
                ((JugadorDeCampo)equipoTitular.get(crack)).setForma(10);
               ((JugadorDeCampo)equipoTitular.get(crack)).setPases(10);
                ((JugadorDeCampo)equipoTitular.get(crack)).setRemate(10);
                ((JugadorDeCampo)equipoTitular.get(crack)).setRemate(10);
           }
        
        
        
       
    }

    
    /**
     * entrenamos al equipo al completo aumentado en un porcentaje aleatorio sus habilidades
     */
    public void entrenamineto()
    {
        
        for(Jugador jugador: equipoTitular)
        {
           
            
            if(jugador instanceof Capitan)
           { 
                ((Capitan)jugador).entrenar();
               
           }
          
           else if (jugador instanceof JugadorDeCampo)
           {
               ((JugadorDeCampo)jugador).entrenar();
               
           }
           
           else if (jugador instanceof Portero)
           {
                 ((Portero)jugador).entrenar();
                
           }
        }
        
        for(Jugador jugador: equipoSuplente)
        {
            
            if(jugador instanceof Capitan)
           { 
                ((Capitan)jugador).entrenar();
               
           }
          
           else if (jugador instanceof JugadorDeCampo)
           {
               ((JugadorDeCampo)jugador).entrenar();
               
           }
           
           else if (jugador instanceof Portero)
           {
                 ((Portero)jugador).entrenar();
                
           }
        }
    }
    
    
    /**
     * Metodo que muestra los datos de los jugadores que forman el equipo titular
     */
    public void mostrarEquipoTitular()
    {
       float sumaValoraciones = 0;
       for(Jugador jugador : equipoTitular)
       {
           System.out.println(jugador);
           sumaValoraciones += jugador.valoracion();
       }
       System.out.printf("*********************Valoracion media del equipo titular :  %.2f  ************************\n",sumaValoraciones/11);
    }
    
    /**
     * Metodo que muestra los datos de los jugadores que forma el equipo suplente
     */
    public void mostrarEquipoSuplente()
    {
        for(Jugador jugador : equipoSuplente)
        {
            System.out.println(jugador);
        }
    }
    
    /**
     * obtenemos la valoracion del equipo de titulares 
     * @return float valoracion de los titulares
     */
    public float getValoracionTitulares()
    {
        float sumaValoraciones = 0;
        for(Jugador jugador : equipoSuplente)
        {
            sumaValoraciones += jugador.valoracion();
        }
        return sumaValoraciones;
    }
    
    /**
     * devuelve el liderazgo del capitan del equipo
     * @return int liderazgo del capitan
     */
    public int getLiderazgo()
    {
        int liderazgo = 0;
        for(Jugador jugador : equipoSuplente)
        {
            if(jugador instanceof Capitan)
            {
                liderazgo=((Capitan)jugador).getLiderazgo();
            }
        }
        return liderazgo;
    }
    
    /**
     * devuelve las victorias del equipo
     * @return int victorias
     */
    public int getVictorias()
    {
        return victorias;
    }
    
    /**
     * modifica las victorias del equipo incrementando el numero de las mismas en 1
     *
     */
    public void incrementoVicotorias()
    {
        victorias++;
    }
}

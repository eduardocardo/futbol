import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Liga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Liga
{
    private int equiposLiga;
    private ArrayList<Partido> partidos;
    private ArrayList<Equipo> equipos;
    
    private static String[] nombres={"EQUIPO1","EQUIPO2","EQUIPO3","EQUIPO4","EQUIPO5","EQUIPO6",
                                       "EQUIPO7","EQUIPO8","EQUIPO9","EQUIPO10","EQUIPO11","EQUIPO12",
                                       "EQUIPO13","EQUIPO14","EQUIPO15","EQUIPO16","EQUIPO17","EQUIPO18"};

    /**
     * Constructor for objects of class Liga
     */
    public Liga(int participantes)
    {
        Random r = new Random();
        //coprobamos si el numero de participantes es correcto
       if(participantes < nombres.length &&  ( participantes%2==0))
       {
           equiposLiga=participantes;
       }
       else
       {
            equiposLiga=12;
       }
       
       //inicializamos los array
       partidos = new ArrayList<>();
       equipos = new ArrayList<>();
       
       //creamos los equipos
       for(int a =0; a<equiposLiga;a++)
       {
           int componentes=r.nextInt(15)+11;
           equipos.add(new Equipo(nombres[a],componentes));
        
       }
       
       
      
    }

    /**
     * simulador de partidos
     * @param int numero de jornadas 
     */
    public void simularJornadas(int jornadas)
    {
        //comprobamos que el numero de jornadas no es mayor que el numero de equipos menos 1
        if(jornadas > equipos.size()-1)
        {
            jornadas=equipos.size()-1;
        }
        
        //cremos un bucle para crear las jornadas
        for(int i =0;i < jornadas;i++)
        {
            System.out.println("Jornada " + (i+1));
            
            //para cada jornada se juega tantos partidos com numero equipos/2, de manera aleatoria 
            for(int a = 0;a < equipos.size()-1;)
            {
                Random r=new Random();
                int e1=r.nextInt(equipos.size());
                int e2=r.nextInt(equipos.size());
                
                //comprobamos que los dos equipos no sean el mismo
                do
                {
                     e1=r.nextInt(equipos.size());
                }
                while(e1==e2);
                
                //jugamos un partido entre los equipos y guardamoos los resultados y quien gana el partido
                Partido partido=(new Partido(equipos.get(e1),equipos.get(e2)) );
                partidos.add(partido );
                partido.simularPartido();
                partido.getGanador().incrementoVicotorias();
                //si es la primera simulacion se incrementa en 1 el valor de a equipor en pos 0  y 1 juegan
                //a partir de la segunda simulacion se incrementa de 2 en dos simulando los equipos emparejados
                if(a<1)
                {  
                   a+=1;
                
                }
                else
                {
                    a=a+2;
                }
                //al terminar el encuentro los equipos que han jugado entrenan para mejora su habilidad
                equipos.get(e1).entrenamineto();
                equipos.get(e2).entrenamineto();
                
                
            }
            System.out.println("   ");
            System.out.println("  Clasificacion de la jornada ");
            System.out.println("   ");
            mostrarClasificaciones();
    
            System.out.println("   ");
            System.out.println("   ");
            //si llegmos a la ultima jornada mostramos los datos del equipo ganador y que es la ultima jornada
            if(i==(jornadas-1))
            {
                System.out.println("  Clasificacion de la jornada -- final de la liga ");
                System.out.println(" GANADOR =  " + equipos.get(0).getNombre() + "------ENHORABUENA");
                System.out.println("   ");
                
            }
        }            
        
        
        
    }
    
    /**
     * mostramos la clasificacion usando el metodo de ordenacion de la burbuja
     * cada vez que simulamos un partido cambia el liderazgo de la liga 
     */
    public void mostrarClasificaciones()
    {
            boolean mov = true;
             int cont=0;
             
             while(mov)
             {
                 mov=false;
                 for(int i =1;i<equipos.size()-cont;i++)
                 {
                     if(equipos.get(i).getVictorias() > equipos.get(i-1).getVictorias())
                     {
                        
                         mov=true;
                         Equipo aux=equipos.get(i);
                         equipos.set(i,equipos.get(i-1));
                         equipos.set(i-1,aux);
                    }
                 }
                
             }
            //datos de los equipos en relacion a sus partidos ganados y sus puntos 3 por victoria.
             for(Equipo equip:equipos)
             {
           
                System.out.println(" " + equip.getNombre() + "\tpartidos ganados: "+
                                   equip.getVictorias()+ " \tpuntos: " + (equip.getVictorias()*3));
            }
    }
}

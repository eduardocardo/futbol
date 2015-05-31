import java.util.Random;
/**
 * Write a description of class Partido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Partido
{
    private Equipo equipo1;
    private Equipo equipo2;
    private Equipo ganador;
    /**
     * Constructor for objects of class Partido
     */
    public Partido(Equipo equipo1,Equipo equipo2)
    {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        ganador=null;
    }

    /**
     * Metodo que muestra las alineaciones de los equipos que participan en el partido
     */
    public void mostrarAlineaciones()
    {
        System.out.println(equipo1.getNombre());
        mostrarEquipoLocal();
        System.out.println(" ");
        System.out.println(equipo2.getNombre());
        mostrarEquipoVisitante();
    }
    
    /**
     * Metodo que muestra la alineacion titular y suplente del equipo local
     */
    public void mostrarEquipoLocal()
    {
        System.out.println("Titulares : ");
        equipo1.hacerAlineacion();
        equipo1.mostrarEquipoTitular();
        System.out.println("Reservas : ");
        equipo1.mostrarEquipoSuplente();
    }
    
    /**
     * Metodo que muestra la alineacion titular y suplente del equipo visitante
     */
    public void mostrarEquipoVisitante()
    {
        System.out.println("Titulares : ");
        equipo2.hacerAlineacion();
        equipo2.mostrarEquipoTitular();
        System.out.println("Reservas : ");
        equipo2.mostrarEquipoSuplente();
    }
    
    /**
     * la simulacion tiene varias facetas que definen los goles que marcara cada equipo.
     * 1- el liderazgo del capitan juega un papel fundamnetal, el equipo con mayor liderazgo
     *      tiene mayor probabiliadad de victoria
     * 2- la valoracion de cada equipo contando con los titulares del partido
     * 3- dos numeros aleatorios que son la suerte , papel determinante en muchos encuentros.
     * 4-cada simulacion se divide en 2 partes. 1º y 2º
     * 5- en caso de empate en la ronda de penaltis ganara el equipo con mas suerte
     * 
     * 
     *(suerte*(mejorval*lid))/100
     * 
     */
    public void simularPartido()
    {
        
        
        int golesEquipo1=0;
        int golesEquipo2=0;
        
        Random r=new Random();
        
        //suerte primera parte
        int suerteEquipo1=r.nextInt(51);
        int suerteEquipo2=r.nextInt(51);
        
        //suerte segunda parte
        int suerteEquipo3=r.nextInt(51);
        int suerteEquipo4=r.nextInt(51);
        
        int pluse1=0;
        int pluse2=0;
      //goles primera parte
      if(equipo1.getValoracionTitulares() > equipo2.getValoracionTitulares()) 
      {
        pluse1+=10;
        pluse2+=5;
      }
      else
      {
         pluse1+=5;
         pluse2+=10;
      }
       
      if(equipo1.getLiderazgo() > equipo2.getLiderazgo()) 
      {
         golesEquipo1+=1;
        
      }
      else
      {
          golesEquipo2+=1;
      }
      
        
       System.out.println(equipo1.getNombre() + "  vs " + equipo2.getNombre()); 
       //primera parte
       System.out.println("******Primera parte******");
              
       golesEquipo1 = ((suerteEquipo1*(pluse1+equipo1.getLiderazgo()))/100);
       golesEquipo2=((suerteEquipo2*(pluse2+equipo2.getLiderazgo()))/100);
       
     
      
       System.out.println(equipo1.getNombre() + " goles : " + golesEquipo1);
       System.out.println(equipo2.getNombre() + " goles : " + golesEquipo2);
       
       
       System.out.println("******Segunda parte******"); 
       
       golesEquipo1 += ((suerteEquipo3*(pluse1+equipo1.getLiderazgo()))/100);
       golesEquipo2+=((suerteEquipo4*(pluse2+equipo2.getLiderazgo()))/100);
       
       System.out.println(equipo1.getNombre() + " goles : " + golesEquipo1);
       System.out.println(equipo2.getNombre() + " goles : " + golesEquipo2);
       
       
       if(golesEquipo1 > golesEquipo2)
       {
           ganador=equipo1;
       }
       else if (golesEquipo1 < golesEquipo2)
       {
           ganador=equipo2;
       }
       else if(golesEquipo1 == golesEquipo2)
       {
           if((suerteEquipo1 + suerteEquipo3) < (suerteEquipo2+suerteEquipo4))
           {
               ganador=equipo1;
           }
           else
           {
                ganador=equipo2;
            
           }
       }
       
       
       System.out.println("Equipo ganador = " + ganador.getNombre());
       System.out.println("********************************");
    }
    
    /**
     * devuelve el ganador de un partido
     * @return Equipo ganador del partido
     */
    public Equipo getGanador()
    {
    
        return ganador;
    }
    
}
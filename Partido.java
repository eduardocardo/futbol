
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

    /**
     * Constructor for objects of class Partido
     */
    public Partido(Equipo equipo1,Equipo equipo2)
    {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
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
}
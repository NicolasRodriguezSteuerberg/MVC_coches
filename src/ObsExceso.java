import java.util.Observable;
import java.util.Observer;

public class ObsExceso implements Observer {
    View miVista = new View();

    /**
     * Método que hace el cambio cuando se llama al notifyObservers(...)
     * @param o     the observable object.
     * @param arg  recibe un objeto, en este caso de tipo Coche
     * Si la velocidad es superior a 120km/h llama a la view para mostrar un aviso
     * En cambio si la velocidad es menor o igual llama a la view para mostrar la velocidad
     */
    @Override
    public void update(Observable o, Object arg) {
        Coche obxC = (Coche) arg;
        if(obxC.velocidad>120) {
            miVista.muestraExceso(obxC.matricula, obxC.velocidad);
        }else{
            miVista.muestraVelocidad(obxC.matricula, obxC.velocidad);
        }
    }
}

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public Coche crearCoche(String modelo, String matricula){
        //Crea un coche y lo guarda en un auxiliar
        Coche aux = new Coche(modelo, matricula);
        //Añade el coche en la colección llamada parking
        parking.add(aux);
        return aux;
    }

    /**
     * @param matricula
     * @param v nueva velocidad
     * @return velocidad modificada
     */
    public Integer cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Sube la velocidad del coche y notifica al observer ç
     * @param matricula -> matricula del coche a subir velocidad
     */
    public void subirVelocidad(String matricula) {
        // busca el coche y sube la velocidad
        getCoche(matricula).velocidad = getCoche(matricula).velocidad + 10;
        // se da cuenta del cambio
        setChanged();
        // notifica el cambio al observer
        notifyObservers(getCoche(matricula));
    }

    /**
     * Baja la velocidad del coche y notifica al observer ç
     * @param matricula -> matricula del coche a subir velocidad
     */
    public void bajarVelocidad(String matricula) {
        // busca el coche y sube la velocidad
        getCoche(matricula).velocidad = getCoche(matricula).velocidad - 10;
        // se da cuenta del cambio
        setChanged();
        // notifica el cambio al observer
        notifyObservers(getCoche(matricula));

    }

    /**
     * Ddevuelve la velocidad segun la matricula
     * @param matricula
     * @return
     */
    public Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}

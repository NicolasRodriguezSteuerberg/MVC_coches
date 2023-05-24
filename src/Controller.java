public class Controller {
    static Model miModelo = new Model();
    static View miVista = new View();
    public static void main(String[] args) {
        IU.crearVentana();
    }

    /**
     * Método para crear un nuevo coche
     * @param modelo -> modelo del coche
     * @param matricula -> matricula que tiene el coche
     */
    public static void crearCoche(String modelo, String matricula){
        //Recoge el coche del model y lo guarda en una auxiliar
        Coche aux = miModelo.crearCoche(modelo,matricula);
        //si el auxiliar no es nulo llama a la vista para que muestre la velocidad
        if(aux!=null){
            miVista.muestraVelocidad(aux.matricula, aux.velocidad);
        }
    }

    /**
     * Método bajar velocidad de un coche
     * @param matricula -> matricula del coche a disminuir su velocidad
     */
    public static void bajarVelocidad(String matricula){
        //Recoge la velocidad del metodo bajar velocidad del model y lo guarda en una auxiliar
        int aux = miModelo.bajarVelocidad(matricula);
        //llama a la vista para que muestre su velocidad
        miVista.muestraVelocidad(matricula, aux);
    }

    /**
     * Método aumentar velocidad de un coche
     * @param matricula -> matricula del coche a aumentar su velocidad
     */
    public static void aumentarVelocidad(String matricula){
        //Recoge la velocidad del metodo subir velocidad del model y lo guarda en una auxiliar
        int aux = miModelo.subirVelocidad(matricula);
        //llama a la vista para que muestre su velocidad
        miVista.muestraVelocidad(matricula,aux);
    }

    /**
     * Método buscar coche que muestre el coche (si existe)
     * o que muestre que no haya coche
     * @param matricula -> matricula del coche
     * Llama al metodo getCoche del model y al muestraCoche de la vista
     */
    public static void buscarCoche(String matricula){
        //recoge el coche del modelo
        Coche aux = miModelo.getCoche(matricula);
        //llama a la vista para que muestre el coche
        miVista.muestraCoche(aux, matricula);
    }
}
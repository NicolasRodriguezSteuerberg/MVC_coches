public class Controller {
    static Model miModelo = new Model();
    static View miVista = new View();

    public static void main(String[] args) {
        //creas un objeto del observer creado para, seguidamente poder añadirlo al model y que funcione
        ObsExceso miObserver = new ObsExceso();
        miModelo.addObserver(miObserver);
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
        //Llama al método bajar velocidad del model
        miModelo.bajarVelocidad(matricula);
    }

    /**
     * Método aumentar velocidad de un coche
     * @param matricula -> matricula del coche a aumentar su velocidad
     */
    public static void aumentarVelocidad(String matricula){
        //Llama al método subir velocidad del model
        miModelo.subirVelocidad(matricula);
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
public class View {
    /**
     * Método ver velocidad actual del coche
     * @param matricula -> matricula que tiene el coche
     * @param v -> velocidad que tiene el coche
     */
    void muestraVelocidad(String matricula, Integer v){
        Dialog.vDialogo("El coche " + matricula + " tiene una velocidad de: " + v + "km/h");
    }

    /**
     * Metodo ver coche que muestra el coche
     * o que diga que no existe el coche
     * @param aux -> auxiliar de coche
     * @param matricula -> matricula de coche (por si no existe)
     */
    void muestraCoche(Coche aux, String matricula){
        if(aux==null){
            Dialog.vDialogo("No existe el coche con la matrícula: " + matricula);
        }
        else{
            Dialog.vDialogo("El " + aux.modelo + " con la matrícula: " + aux.matricula + " tiene una velocidad de: " + aux.velocidad +"km/h");
        }
    }
}

public class OperacionesMatematicas {
    
    //Atributos
    private int n1;
    private int n2;

    //Método Constructor de la clase: permite inicializar la clase
    //Tiene el mismo nombre de la clase.
    /*
     * Firma del método constructor
     * visibilidad: público
     * nombre: OperacionesMatematicas
     * Cuántos parámetros: 2
     * De que tipo son los parametros: 
     *       parametro 1 tipo entero
     *       parámetro 2 tipo entero
     */
    public OperacionesMatematicas(int n1, int n2){
        this.n1 = n1; //this significa una autoreferencia al atributo de la clase
        this.n2 = n2;
    }

    //Métodos
    public int sumar(){
        return n1 + n2;
    }
    
    public int restar(){
        return n1 = n2;
    }
   
    public int multiplicar()
        {return n1 = n2;
 }
    public double dividir(){
        double resultado;
        if (n2 == 0){
            resultado = 0.0; 
        }else {
            resultado = (double) n1 / (double) n2;  //Convertir un entero a real 
        }
        return resultado;
    }

}
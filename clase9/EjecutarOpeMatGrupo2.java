import java.util.Scanner;

public class EjecutarOpeMatGrupo2 {
    public static void main(String[] args) {
        //Clase Scanner para leer datos por teclado
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el primer número...");
        //Con el objeto sc llamamos los metodos de la clase Scanner, por ejemplo: sc.nextInt()
        int a = sc.nextInt();
        System.out.print("Digite el segundo número...");
        int b = sc.nextInt();
        /*
         * Para leer enteros: nextInt() ó nextLong()
         * Para leer reales: nextDouble() ó nextFloat()
         * para leer cadenas: next() ó nextLine()
         * para leer booleanos: nextBoolean()
         */
        OperacionesMatematicas objOp = new OperacionesMatematicas(a,b);

        System.out.println("El resultado de la suma es: " + objOp.sumar());
        System.out.println("El resultado de la resta es: " + objOp.restar());
        System.out.println("El resultado de la multiplicación es: " + objOp.multiplicar());
        System.out.println("El resultado de la división es: " + objOp.dividir());
        
        sc.close();

        //Tarea: implementar los métodos:
        //    - elevar al cuadrado
        //    - elevar al cubo
        //    - elevar a la n
        //    - sacar la raíz cuadrada
        //    - sacar la raíz cúbica
        //    - sacar la raíz n
        // Todo lo anterior con un menú de opciones
    }
}
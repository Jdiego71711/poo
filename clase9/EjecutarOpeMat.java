import java.util.Scanner;

public class EjecutarOpeMat {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

                int opcion;
        
        do {
        System.out.print("digite el primer numero...");
        int a = sc.nextInt();
        System.out.print("digite el segundo numero...");
        int b = sc.nextInt();
        OperacionesMatematicas objOp = new OperacionesMatematicas(a,b);
         
            System.out.println(" CALCULADORA ");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Elevar a la potencia de 2");
            System.out.println("6. Elevar al cubo");
            System.out.println("7. Elevar a la n");
            System.out.println("8. Sacar raíz cuadrada");
            System.out.println("9. Sacar raíz cúbica");
            System.out.println("10. Sacar raíz n");
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();
            
            
    
            switch (opcion) {
                case 1:
                    System.out.println("Sumar");
                    System.out.println("El resultado de la suma es: " + objOp.sumar());
                 
                    break;
                    
                case 2:
                    System.out.println("opcion:  Restar");
                    System.out.println("El resultado de la resta es: " + objOp.restar());
                 
                    break;
                    
                case 3:
                    System.out.println("opcion:  Multiplicar");
                    System.out.println("El resultado de la multiplicacion es: " + objOp.multiplicar());
              
                    break;
                    
                case 4:
                    System.out.println("opcion:  Dividir");
                     System.out.println("el resultado de la division es: " + objOp.dividir());
                 
                    break;
                    
                case 5:
                    System.out.println("opcion:  Elevar a la potencia de 2");
                     System.out.println("el resultado de elevar el primer numero al cuadrado es: " + objOp.potencia());
                  
                    break;

                                case 6:
                    System.out.println("opcion:  Elevar al cubo");
                    System.out.println("el resultado de elevar al cubo es " + objOp.cubo());
                   
                    break;
                    
                case 7:
                    System.out.println("opcion:  Elevar a la n");
                    System.out.println("el resultado de esta potencia entre los 2 numeros es " + objOp.n());
              
                    break;
                    
                case 8:
                    System.out.println("Ha seleccionado: Sacar raíz cuadrada");
                    System.out.println("el resultado de sacarle raiz cuadrada al primer numero es " + objOp.raiz());
      
                    break;
                    
                case 9:
                    System.out.println("opcion:  Sacar raíz cúbica");
                    System.out.println("el resultado de la raiz cubica al primer numero es " + objOp.cubic());
                  
                    break;
                    
                case 10:
                    System.out.println("opcion:  Sacar raíz n");
                    System.out.println("el resultado de la raiz entre los 2 numero es " + objOp.raizn());
                 
                    break;
                    
                case 11:
                    System.out.println("Hasta luego");
                    break;
                    
                default:
                    System.out.println("Opción inválida Intente nuevamente.");

            
                    
            }
            
        } while (opcion != 11);



        
        
        
       
       


        sc.close();


    }
}
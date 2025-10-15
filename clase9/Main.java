import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //Creación del Objeto
        Libro objLibro1 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 2000);
        Libro objLibro2 = new Libro("Ser Digital", "Nicolás Negroponte", 2005);
        
        //Mostrar el objeto1 completo
        System.out.println(objLibro1); //Libro [ Título: Cien Años de Soledad Autor: Gabriel García Márquez Año publicación: 2000 ]

        //Mostrar el objeto2 completo
        System.out.println(objLibro2); //Libro [ Título: Ser Digital Autor: Nicolás Negroponte Año publicación: 2005 ]
        
        //Mostrar solo el autor del objeto1
        System.out.println("Autor: " + objLibro1.getAutor()); //Autor: Gabriel García Márquez

        //Mostrar solo el año de publicación del objeto2
        System.out.println("Año publicación: " + objLibro2.getAnioPublicacion()); //Año publicación: 2005
        
        //Se cambia el nombre del titulo con el método setTitulo()
        objLibro1.setTitulo("El Coronel No Tiene Quién Le Escriba");
        
        //Mostrar el objeto1 completo
        System.out.println(objLibro1); //Libro [ Título: El Coronel No Tiene Quién Le Escriba Autor: Gabriel García Márquez Año publicación: 2000 ]

        //Mostrar solo el título del objeto1
        System.out.println("Título: " + objLibro1.getTitulo()); //Título: El Coronel No Tiene Quién Le Escriba
        
    }
}

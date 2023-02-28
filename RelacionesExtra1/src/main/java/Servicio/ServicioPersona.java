/*
Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro programa va a
tener que contar con muchas personas y muchos perros. El programa deberá preguntarle a
cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden adoptar
al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la
persona.
Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las
personas con sus respectivos perros.
 */
package Servicio;

import Entidad.Perro;
import Entidad.Persona;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Mile
 */
public class ServicioPersona {
    ArrayList<Persona> personas = new ArrayList<>();
    ArrayList<Perro> perros = new ArrayList<>();
    Scanner leer = new Scanner(System.in);
    Scanner leer2 = new Scanner(System.in);
    public Persona crearPersona(){
        String opcion = "";
        
        System.out.println("Ingrese el nombre: ");
        String n = leer.next();
        System.out.println("Ingrese el apellido: ");
        String a = leer.next();
        System.out.println("Ingrese la edad: ");
        int e = leer.nextInt();
        System.out.println("Ingrese el DNI: ");
        long dni = leer.nextLong();        

        return new Persona(n, a, e, dni, null);
    }
    
    public Perro crearPerro(){
        System.out.println("Ingrese el nombre del perro: ");
        String n = leer2.next();
        System.out.println("Ingrese la raza: ");
        String r = leer2.next();
        System.out.println("Ingrese la edad: ");
        int e = leer2.nextInt();
        System.out.println("Ingrese el tamaño: ");
        String t = leer2.next();
        
        return new Perro(n, r, e, t);
    }
    
    public ArrayList<Persona> crearListaPersonas(){
        int opcion = 0;
        do {            
            personas.add(crearPersona());
            System.out.println("¿Desea ingresar otro adoptante al registro?");
            System.out.println("1 - Si");
            System.out.println("2 - No");
            opcion = leer.nextInt(); 
        } while (opcion == 1);        
        
        return personas;
    }
    
    public ArrayList<Perro> crearListaPerros(){
        int opcion = 0;
        do {            
            perros.add(crearPerro());
            System.out.println("¿Desea ingresar otro perro al registro?");
            System.out.println("1 - Si");
            System.out.println("2 - No");
            opcion = leer.nextInt(); 
        } while (opcion == 1);        
        
        return perros;
    }
    
    public void adopcion(){       
        Iterator itP = personas.iterator();
        while (itP.hasNext()) {
            System.out.println("Ingresee el nombre del adoptante");
            String adoptante = leer.next();
            int cont = 0;
            for (Persona persona : personas) {
                if (persona.getNombre().equalsIgnoreCase(adoptante)) {
                    cont++;
                }
            }
            if (cont == 0) {
                System.out.println("El adoptante no se encuentra registrado");
            } else {
                System.out.println("Perros en adopción: ");
                for (Perro perro : perros) {
                    System.out.println(perro);
                }
                System.out.println("Ingrese el nombre del perro que desea adoptar");
                String adopta = leer.next();
                Iterator it = perros.iterator();
                cont = 0;
                while (it.hasNext()) {
                    Perro p = (Perro) it.next();
                    if (p.toString().contains(adopta)) {
                        cont++;
                        for (Persona persona : personas) {
                            if (persona.getNombre().equalsIgnoreCase(adoptante)) {
                                persona.setPerro(p);
                                it.remove();
                            }
                        }
                    }
                    if (cont == 0) {
                        System.out.println("El perro no se encuentra registrado o ya ha sido adoptado");
                    }
                }
            }
        }
    }
}


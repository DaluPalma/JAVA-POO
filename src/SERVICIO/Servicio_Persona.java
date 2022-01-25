package SERVICIO;

import ENTIDADES.Persona;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Servicio_Persona {
    
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Persona CrearPersona() {
        
        Persona p = new Persona();
        
        System.out.println("Ingrese su nombre completo");
        String nombre = leer.next();
        
        System.out.println("Ingrese su fecha de nacimiento");
        System.out.println("día(2 digitos):");
        byte dia = leer.nextByte();
        System.out.println("mes(dos dígitos):");
        byte mes = leer.nextByte();
        System.out.println("año(Cuatro dígitos):");
        int anio = leer.nextInt();

        //Cargar la fecha
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        System.out.println("Su fecha ingresada es: " + fecha);
        
        p.setNombre(nombre);
        p.setFecha(fecha);
        
        return p;        
        
    }
    
    public int CalcularEdad(Persona p) {
        LocalDate fechaHoy = LocalDate.now();
        Period Edad = Period.between(p.getFecha(), fechaHoy);
        int Edad1=Edad.getYears();
        return Edad1;
        
    }
    
    public boolean MenorQue(Persona p) {
        System.out.println("Ingrese la edad de otra persona");
        int Edad2=leer.nextInt();
        
        return CalcularEdad(p)<Edad2;
       
    }
    
    public void MostrarPersona(Persona p){
        System.out.println("Nombre: "+ p.getNombre());
        System.out.println("Fecha de nacimiento: "+ p.getFecha());
        System.out.println("Edad: "+ CalcularEdad(p));
    }
    
    public void Ejecutar(){
        Persona p = CrearPersona();
        CalcularEdad(p);
        boolean MenorQue = MenorQue(p);
       
        MostrarPersona(p);
    }
}

package ejercicioobligatorio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author danie
 */
public class Socio {

    /**
     * @param id Número socio
     * @param nombre Nombre Socio
     * @param fechaNacimiento
     */
    private Integer id;
    private String nombre;
    private LocalDate fechaNacimiento;

    public Socio(int id, String nombre, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        //Establecemos formato español
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, f);
    }

    public Integer edad() {
        return (int) fechaNacimiento.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }



    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "id:" + id + ", Nombre:" + nombre + ", Fecha de Nacimiento:" + fechaNacimiento.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+", Edad:" +this.edad() + "\n";
    }
    

}

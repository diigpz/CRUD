package modelo;

public class Persona {
    // colocamos las variables 
    private int id;
    private String nombres;
    private String dependencia;
    private String  fecha;
    private String archivo;

    // Constructor
    public Persona() {
    }
 
    public Persona(int id, String nombres, String dependencia, String fecha, String archivo) {
        this.id = id;
        this.nombres = nombres;
        this.dependencia = dependencia;
        this.fecha = fecha;
        this.archivo = archivo;
    }
    
    //son los getter y los setter del constructor 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    
}

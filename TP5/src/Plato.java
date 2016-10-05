import java.util.ArrayList;
import java.util.List;

/**
 * @author Pablo Germone
 */
public class Plato {
    private String nombre;
    private int cantidadIngredientes;
    private double precioBase;
    private List<Integer> opiniones = new ArrayList<Integer>();
    private Cocinero cocinero;


    public Plato(){}

    public Plato(String nombre, int cantIngredientes){
        setNombre(nombre);
        setCantidadIngredientes(cantIngredientes);
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadIngredientes() {
        return cantidadIngredientes;
    }

    public void setCantidadIngredientes(int cantidadIngredientes) {
        this.cantidadIngredientes = cantidadIngredientes;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public List<Integer> getOpiniones() {
        return opiniones;
    }

    public Cocinero getCocinero() {
        return cocinero;
    }

    public void setCocinero(Cocinero cocinero) {
        this.cocinero = cocinero;
    }



    public Double getPrecio(){
        double precio;

        if(getCantidadIngredientes() >= 3){
            precio = getCantidadIngredientes() * 2;
        }else{
            precio = getCantidadIngredientes() * 3;
        }

        return precio;
    }



    public Double getOpinionPromedio(){
        int total = 0;
        double resultado;

        for(int opinion : getOpiniones()){
            total += opinion;
        }

        resultado = total / getOpiniones().size();

        return resultado;
    }

    public void agregarOpinion(int puntaje){
        getOpiniones().add(puntaje);
    }



    public String getMailCocinero(){
        return getCocinero().getMail();
    }

    public String imprimir(){
        return getNombre() + "(" + getOpinionPromedio().intValue() + " puntos) - " + getMailCocinero();
    }
}
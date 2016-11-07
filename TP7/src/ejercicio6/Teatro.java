package ejercicio6;

/**
 * @author Pablo Germone
 */
public class Teatro {
    enum tipoLocalidad{
        adelante, medio, atras
    }

    private static int monto;

    public static int getMonto(tipoLocalidad localidad) {
        if(localidad == tipoLocalidad.adelante){
            monto = 5;
        }else if(localidad == tipoLocalidad.medio){
            monto = 15;
        }else if(localidad == tipoLocalidad.atras){
            monto = 30;
        }else{
            monto = -1;
        }

        return monto;
    }

    public static int precioEnDolares(){
        return monto / 15;
    }

    public static int precioEnEuros(){
        return monto / 18;
    }
}

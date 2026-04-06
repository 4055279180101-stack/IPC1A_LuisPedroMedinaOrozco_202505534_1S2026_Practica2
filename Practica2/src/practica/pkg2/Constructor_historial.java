package practica.pkg2;


public class Constructor_historial {
    private int Numero;
    private String Algoritmo;
    private String Orden;
    private int Tamaño;
    private String Comparaciones;
    private String Intercambios;
    private String Iteraciones;
    private String Tiempo;

    public Constructor_historial() {
    }
    
    public Constructor_historial(int Numero, String Algoritmo, String Orden, int Tamaño, String Comparaciones, String Intercambios, String Iteraciones, String Tiempo) {
        this.Numero = Numero;
        this.Algoritmo = Algoritmo;
        this.Orden = Orden;
        this.Tamaño = Tamaño;
        this.Comparaciones = Comparaciones;
        this.Intercambios = Intercambios;
        this.Iteraciones = Iteraciones;
        this.Tiempo = Tiempo;
    }

    public int getNumero() {
        return Numero;
    }

    public String getAlgoritmo() {
        return Algoritmo;
    }

    public String getOrden() {
        return Orden;
    }

    public int getTamaño() {
        return Tamaño;
    }

    public String getComparaciones() {
        return Comparaciones;
    }

    public String getIntercambios() {
        return Intercambios;
    }

    public String getIteraciones() {
        return Iteraciones;
    }

    public String getTiempo() {
        return Tiempo;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public void setAlgoritmo(String Algoritmo) {
        this.Algoritmo = Algoritmo;
    }

    public void setOrden(String Orden) {
        this.Orden = Orden;
    }

    public void setTamaño(int Tamaño) {
        this.Tamaño = Tamaño;
    }

    public void setComparaciones(String Comparaciones) {
        this.Comparaciones = Comparaciones;
    }

    public void setIntercambios(String Intercambios) {
        this.Intercambios = Intercambios;
    }

    public void setIteraciones(String Iteraciones) {
        this.Iteraciones = Iteraciones;
    }

    public void setTiempo(String Tiempo) {
        this.Tiempo = Tiempo;
    }
    
    
    
    
}

package practica.pkg2;

import java.awt.Color;

public class Practica2 {

    public static int[] datos;
    public static int[] datos_antiguo;
    public static int velocidad;
    public static Color[] colores;
    public static int Comparaciones;
    public static int Intercambios;
    public static int Iteraciones;
    public static int Particiones;
    
    public static double ms;
    
    public static void main(String[] args) {
        
        MenuPrincipal pantalla = new MenuPrincipal();
        pantalla.setVisible(true);
    }
    
    //Metodo para actualizar las comparaciones
    public static void ActualizarComparaciones(){
      String texto = Integer.toString(Comparaciones);
      MenuPrincipal.comparando.setText(texto);
    }
    
    public static void ActualizarIntercambios(){
      String texto = Integer.toString(Intercambios);
      MenuPrincipal.intercambios.setText(texto);
    }
    
    public static void ActualizarIteraciones(){
      String texto = Integer.toString(Iteraciones);
      MenuPrincipal.iteraciones.setText(texto);
    }
    
   //Metodo para cargar el area
    public static void CargarArea(String tipo,int numero, String pos1, String pos2, int valor1, int valor2){
      String accion="";
      
      if(tipo.equals("Comparando")){
         accion="Comparacion";
      }
      
      if(tipo.equals("Intercambio")){
         accion="Intercambio";
      }
     
      MenuPrincipal.area.setText(MenuPrincipal.area.getText()+"--- "+accion+" "+numero+"---"+"\n");
      MenuPrincipal.area.setText(MenuPrincipal.area.getText()+tipo+ " array["+pos1+"]="+valor1+" con array["+pos2+"]="+valor2+"\n");
      MenuPrincipal.area.setText(MenuPrincipal.area.getText()+accion+" realizado con exito"+"\n"+"\n");
    }
    
    public static void CargarTiempo(long inicio, long fin){
       long nano_segundos=fin-inicio;
       ms= nano_segundos/1000000;
       double segundos= ms/1000;
       
       MenuPrincipal.area.setText(MenuPrincipal.area.getText()+"\n Tiempo de ejecucion en "+segundos+" segundos");
    }
    
    public static void CargarParticion(String tipo,int numero, String pos1, String pos2, int valor1, int valor2){
        
         MenuPrincipal.area.setText(MenuPrincipal.area.getText()+"\n --- "+tipo+""+numero+" --- \n");
         MenuPrincipal.area.setText(MenuPrincipal.area.getText()+"Partiendo array["+pos1+"]="+valor1+" y array["+pos2+"]="+valor2+"\n");
         MenuPrincipal.area.setText(MenuPrincipal.area.getText()+"Particion realizado con exito"+"\n"+"\n");
    }
}

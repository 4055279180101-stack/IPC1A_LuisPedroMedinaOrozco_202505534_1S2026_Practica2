package practica.pkg2.Algoritmos;

import java.awt.Color;
import static practica.pkg2.Archivos.ResumenEjecucion;
import static practica.pkg2.MenuPrincipal.PonerGrafica;
import practica.pkg2.Practica2;
import static practica.pkg2.Practica2.ActualizarComparaciones;
import static practica.pkg2.Practica2.ActualizarIntercambios;
import static practica.pkg2.Practica2.ActualizarIteraciones;




public class Bubble_sort {
    
    //Algoritmo
    
    public static void Bublle_sort_Ascendente() throws InterruptedException{
    boolean paso=true;
       long inicio = System.nanoTime();
       while(paso){
          paso=false;
          Practica2.Iteraciones++;
           ActualizarIteraciones();
          for(int i=0; i<Practica2.datos.length-1; i++){
              
             //Comparando
             Practica2.colores[i] = Color.ORANGE;
             Practica2.colores[i+1] = Color.ORANGE;
             PonerGrafica();
             Practica2.Comparaciones++;
             ActualizarComparaciones();
             Practica2.CargarArea("Comparando", Practica2.Comparaciones, ""+i, ""+(i+1),Practica2.datos[i],Practica2.datos[i+1]);
             Thread.sleep(Practica2.velocidad);
             
             
             if(Practica2.datos[i]>Practica2.datos[i+1]){ 

               Practica2.colores[i] = Color.RED;
               Practica2.colores[i+1] = Color.RED;
               PonerGrafica();
               Thread.sleep(Practica2.velocidad);
                 
               //Intercambiando
               int aux=Practica2.datos[i+1];
               Practica2.datos[i+1]=Practica2.datos[i];
               Practica2.datos[i]=aux;
               
               //Permutando
               Practica2.colores[i] = Color.RED;
               Practica2.colores[i+1] = Color.RED;
               PonerGrafica();
               Thread.sleep(Practica2.velocidad);
               
               Practica2.colores[i] = Color.BLUE;
               Practica2.colores[i+1] = Color.BLUE;
               PonerGrafica();
               Practica2.Intercambios++;
               ActualizarIntercambios();
               Practica2.CargarArea("Intercambio", Practica2.Intercambios, ""+i, ""+(i+1),Practica2.datos[i],Practica2.datos[i+1]);
               Thread.sleep(Practica2.velocidad);
               
               paso=true;
               
              }else{
               
               Practica2.colores[i] = Color.BLUE;
               Practica2.colores[i+1] = Color.BLUE;
               PonerGrafica();
               Thread.sleep(Practica2.velocidad);
             }
            
          
          }
           
       }
       for(int i=0; i<Practica2.datos.length; i++){
         Practica2.colores[i] = Color.GREEN;
       }
       PonerGrafica();
       long fin = System.nanoTime();
       Practica2.CargarTiempo(inicio, fin);
       ResumenEjecucion();
    }
    
    public static void Bublle_sort_Descendente() throws InterruptedException{
    boolean paso=true;
       long inicio = System.nanoTime();
       while(paso){
          paso=false;
          Practica2.Iteraciones++;
           ActualizarIteraciones();
          
          for(int i=0; i<Practica2.datos.length-1; i++){
              
             //Comparando
             Practica2.colores[i] = Color.ORANGE;
             Practica2.colores[i+1] = Color.ORANGE;
             Practica2.Comparaciones++;
             ActualizarComparaciones();
             PonerGrafica();
             Practica2.CargarArea("Comparando", Practica2.Comparaciones, ""+i, ""+(i+1),Practica2.datos[i],Practica2.datos[i+1]);
             Thread.sleep(Practica2.velocidad);
             
             if(Practica2.datos[i]<Practica2.datos[i+1]){ 

               Practica2.colores[i] = Color.RED;
               Practica2.colores[i+1] = Color.RED;
               PonerGrafica();
               Thread.sleep(Practica2.velocidad);
                 
               //Intercambiando
               int aux=Practica2.datos[i+1];
               Practica2.datos[i+1]=Practica2.datos[i];
               Practica2.datos[i]=aux;
               
               //Permutando
               Practica2.colores[i] = Color.RED;
               Practica2.colores[i+1] = Color.RED;
               PonerGrafica();
               Thread.sleep(Practica2.velocidad);
               
               Practica2.colores[i] = Color.BLUE;
               Practica2.colores[i+1] = Color.BLUE;
               PonerGrafica();
               Practica2.Intercambios++;
               ActualizarIntercambios();
               Practica2.CargarArea("Intercambio", Practica2.Intercambios, ""+i, ""+(i+1),Practica2.datos[i],Practica2.datos[i+1]);
               Thread.sleep(Practica2.velocidad);
               
               paso=true;
              }else{
               
               Practica2.colores[i] = Color.BLUE;
               Practica2.colores[i+1] = Color.BLUE;
               PonerGrafica();
               Thread.sleep(Practica2.velocidad);
             }
            
          
          }
           
       }
       for(int i=0; i<Practica2.datos.length; i++){
         Practica2.colores[i] = Color.GREEN;
       }
       PonerGrafica();
       long fin = System.nanoTime();
       Practica2.CargarTiempo(inicio, fin);
       ResumenEjecucion();
    }
}

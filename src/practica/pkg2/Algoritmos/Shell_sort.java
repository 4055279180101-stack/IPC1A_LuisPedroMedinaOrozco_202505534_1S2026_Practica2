
package practica.pkg2.Algoritmos;

import java.awt.Color;
import static practica.pkg2.Archivos.ResumenEjecucion;
import static practica.pkg2.MenuPrincipal.PonerGrafica;
import practica.pkg2.Practica2;
import static practica.pkg2.Practica2.ActualizarComparaciones;
import static practica.pkg2.Practica2.ActualizarIntercambios;
import static practica.pkg2.Practica2.ActualizarIteraciones;


public class Shell_sort {
    
    public static void Shell_sort_Ascendente() throws InterruptedException{
       boolean paso=true; int gaps=Practica2.datos.length/2;
       
       long inicio = System.nanoTime();
       while(gaps>0){
           paso=true;
           Practica2.Iteraciones++;
           ActualizarIteraciones();
         while(paso){
             paso=false;
          for(int i=0; i<Practica2.datos.length-gaps; i++){
              
              //Comparando
             Practica2.colores[i] = Color.ORANGE;
             Practica2.colores[i+gaps] = Color.ORANGE;
             PonerGrafica();
             Practica2.Comparaciones++;
             ActualizarComparaciones();
             Practica2.CargarArea("Comparando", Practica2.Comparaciones, ""+i, ""+(i+gaps),Practica2.datos[i],Practica2.datos[i+gaps]);
             Thread.sleep(Practica2.velocidad);
             
            if(Practica2.datos[i]>Practica2.datos[i+gaps]){
                
                //Intercambiando
                Practica2.colores[i] = Color.RED;
                Practica2.colores[i+gaps] = Color.RED;
                PonerGrafica();
                Thread.sleep(Practica2.velocidad);
                
              int aux=Practica2.datos[i+gaps];
              Practica2.datos[i+gaps]=Practica2.datos[i];
              Practica2.datos[i]=aux;
              
                Practica2.colores[i] = Color.RED;
                Practica2.colores[i+gaps] = Color.RED;
                PonerGrafica();
                Thread.sleep(Practica2.velocidad);
                
              paso=true;
              
              //Reposo
                Practica2.colores[i] = Color.BLUE;
                Practica2.colores[i+gaps] = Color.BLUE;
                PonerGrafica();
                Practica2.Intercambios++;
                ActualizarIntercambios();
                Practica2.CargarArea("Intercambio", Practica2.Intercambios, ""+i, ""+(i+gaps),Practica2.datos[i],Practica2.datos[i+gaps]);
                Thread.sleep(Practica2.velocidad);
            }else{
              Practica2.colores[i] = Color.BLUE;
             Practica2.colores[i+gaps] = Color.BLUE;
             PonerGrafica();
             Thread.sleep(Practica2.velocidad);
            
            }
          }
         }
          gaps=gaps/2;
       }
       //Terminado
       for(int i=0; i<Practica2.datos.length; i++){
            Practica2.colores[i] = Color.GREEN;
       }
       PonerGrafica();
       long fin = System.nanoTime();
       Practica2.CargarTiempo(inicio, fin);
       ResumenEjecucion();
    }
    
    public static void Shell_sort_Descendente() throws InterruptedException{
       boolean paso=true; int gaps=Practica2.datos.length/2;
        long inicio = System.nanoTime();
       while(gaps>0){
           paso=true;
           Practica2.Iteraciones++;
           ActualizarIteraciones();
         while(paso){
             paso=false;
          for(int i=0; i<Practica2.datos.length-gaps; i++){
              
              //Comparando
             Practica2.colores[i] = Color.ORANGE;
             Practica2.colores[i+gaps] = Color.ORANGE;
             PonerGrafica();
             Practica2.Comparaciones++;
             ActualizarComparaciones();
             Practica2.CargarArea("Comparando", Practica2.Comparaciones, ""+i, ""+(i+gaps),Practica2.datos[i],Practica2.datos[i+gaps]);
             Thread.sleep(Practica2.velocidad);
             
            if(Practica2.datos[i]<Practica2.datos[i+gaps]){
                
                //Intercambiando
                Practica2.colores[i] = Color.RED;
                Practica2.colores[i+gaps] = Color.RED;
                PonerGrafica();
                Thread.sleep(Practica2.velocidad);
                
              int aux=Practica2.datos[i+gaps];
              Practica2.datos[i+gaps]=Practica2.datos[i];
              Practica2.datos[i]=aux;
              
                Practica2.colores[i] = Color.RED;
                Practica2.colores[i+gaps] = Color.RED;
                PonerGrafica();
                Thread.sleep(Practica2.velocidad);
                
              paso=true;
              
              //Reposo
                Practica2.colores[i] = Color.BLUE;
                Practica2.colores[i+gaps] = Color.BLUE;
                PonerGrafica();
                Practica2.Intercambios++;
                ActualizarIntercambios();
                Practica2.CargarArea("Intercambio", Practica2.Intercambios, ""+i, ""+(i+gaps),Practica2.datos[i],Practica2.datos[i+gaps]);
                Thread.sleep(Practica2.velocidad);
            }else{
              Practica2.colores[i] = Color.BLUE;
             Practica2.colores[i+gaps] = Color.BLUE;
             PonerGrafica();
             Thread.sleep(Practica2.velocidad);
            
            }
          }
         }
          gaps=gaps/2;
       }
       //Terminado
       for(int i=0; i<Practica2.datos.length; i++){
            Practica2.colores[i] = Color.GREEN;
       }
       PonerGrafica();
       long fin = System.nanoTime();
       Practica2.CargarTiempo(inicio, fin);
       ResumenEjecucion();
    }
    
    
}

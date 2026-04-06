package practica.pkg2.Algoritmos;

import java.awt.Color;
import static practica.pkg2.Archivos.ResumenEjecucion;
import static practica.pkg2.MenuPrincipal.PonerGrafica;
import practica.pkg2.Practica2;
import static practica.pkg2.Practica2.ActualizarComparaciones;
import static practica.pkg2.Practica2.ActualizarIntercambios;
import static practica.pkg2.Practica2.ActualizarIteraciones;


public class Quick_sort {
   
    public static long primero=0;
    public static void Quick_sort_Ascendente(int []datos, int inicio, int fin) throws InterruptedException{
      
      
        //Para ir contando
        if(inicio==0){
           
         primero = System.nanoTime();
        }
        
        
        if(inicio < fin){
           //iteraciones
            Practica2.Iteraciones++;
            ActualizarIteraciones();
            Practica2.Particiones++;
            Practica2.CargarParticion("Particion", Practica2.Particiones, ""+inicio, ""+fin, Practica2.datos[inicio], Practica2.datos[fin]);
            int pivote = particionar(Practica2.datos, inicio, fin);
            
            //iteraciones
            Practica2.Iteraciones++;
            ActualizarIteraciones();
            Quick_sort_Ascendente(Practica2.datos, inicio, pivote - 1);
           
            
            //iteraciones
            Practica2.Iteraciones++;
            ActualizarIteraciones();
            Quick_sort_Ascendente(Practica2.datos, pivote + 1, fin);
        
    }
    if(inicio == 0 && fin == Practica2.datos.length - 1){
        for(int i = 0; i < Practica2.datos.length; i++){
            Practica2.colores[i] = Color.GREEN;
        }
        PonerGrafica();
        long fin2 = System.nanoTime();
        Practica2.CargarTiempo(primero, fin2);
        ResumenEjecucion();
    }
    
   
}
    
  public static int particionar(int[] arr, int inicio, int fin) throws InterruptedException{
    int pivote = arr[fin];
    int i = inicio - 1;
    
    for(int j = inicio; j < fin; j++){
    
    // comparando j con pivote
    Practica2.colores[j] = Color.ORANGE;
    Practica2.colores[fin] = Color.ORANGE;
    PonerGrafica();
    Practica2.Comparaciones++;
    ActualizarComparaciones();
    Practica2.CargarArea("Comparando", Practica2.Comparaciones, ""+j, ""+(fin),Practica2.datos[j],Practica2.datos[fin]);
    Thread.sleep(Practica2.velocidad);
    
    if(arr[j] <= pivote){
        i++;
        
        if(i != j){
            Practica2.colores[i] = Color.ORANGE;
            Practica2.colores[j] = Color.ORANGE;
            PonerGrafica();
            Thread.sleep(Practica2.velocidad);
            
            Practica2.colores[i] = Color.RED;
            Practica2.colores[j] = Color.RED;
            PonerGrafica();
            Thread.sleep(Practica2.velocidad);
            
            int aux = arr[i];
            arr[i] = arr[j];
            arr[j] = aux;
            
            Practica2.colores[i] = Color.BLUE;
            Practica2.colores[j] = Color.BLUE;
            Practica2.colores[fin] = Color.ORANGE;
            PonerGrafica();
            Practica2.Intercambios++;
            ActualizarIntercambios();
            Practica2.CargarArea("Intercambio", Practica2.Intercambios, ""+i, ""+(j),Practica2.datos[i],Practica2.datos[j]);
            Thread.sleep(Practica2.velocidad);
        } else {
            int aux = arr[i];
            arr[i] = arr[j];
            arr[j] = aux;
            
            Practica2.colores[i] = Color.BLUE;
            Practica2.colores[fin] = Color.ORANGE;
            PonerGrafica();
            Practica2.Intercambios++;
            ActualizarIntercambios();
            Practica2.CargarArea("Intercambio", Practica2.Intercambios, ""+i, ""+(fin),Practica2.datos[i],Practica2.datos[fin]);
            Thread.sleep(Practica2.velocidad);
        }
        
    } else {
        
        Practica2.colores[j] = Color.BLUE;
        Practica2.colores[fin] = Color.ORANGE;
        PonerGrafica();
        Thread.sleep(Practica2.velocidad);
    }
}
    
    
    Practica2.colores[i+1] = Color.RED;
    Practica2.colores[fin] = Color.RED;
    PonerGrafica();
    Thread.sleep(Practica2.velocidad);
    
    int aux = arr[i+1];
    arr[i+1] = arr[fin];
    arr[fin] = aux;
    
    // pivote ya en su posicion final, verde
    Practica2.colores[i+1] = Color.GREEN;
    Practica2.colores[fin] = Color.BLUE;
    PonerGrafica();
    Practica2.Intercambios++;
    ActualizarIntercambios();
    Practica2.CargarArea("Intercambio", Practica2.Intercambios, ""+(i+1), ""+(fin),Practica2.datos[i+1],Practica2.datos[fin]);
    Thread.sleep(Practica2.velocidad);
    
    return i + 1;

  }
  
  public static void Quick_sort_Descendente(int []datos, int inicio, int fin) throws InterruptedException{
      
      //Para ir contando
        if(inicio==0){
           
         primero = System.nanoTime();
        }
        
      
      if(inicio < fin){
            
            //iteraciones
            Practica2.Iteraciones++;
            ActualizarIteraciones();
            Practica2.Particiones++;
            Practica2.CargarParticion("Particion", Practica2.Particiones, ""+inicio, ""+fin, Practica2.datos[inicio], Practica2.datos[fin]);
            int pivote = particionar2(Practica2.datos, inicio, fin);
            
            //iteraciones
            Practica2.Iteraciones++;
            ActualizarIteraciones();
            Quick_sort_Descendente(Practica2.datos, inicio, pivote - 1);
            
            //iteraciones
            Practica2.Iteraciones++;
            ActualizarIteraciones();
            Quick_sort_Descendente(Practica2.datos, pivote + 1, fin);
        
    }
    if(inicio == 0 && fin == Practica2.datos.length - 1){
        for(int i = 0; i < Practica2.datos.length; i++){
            Practica2.colores[i] = Color.GREEN;
        }
        PonerGrafica();
        long fin2 = System.nanoTime();
        Practica2.CargarTiempo(primero, fin2);
        ResumenEjecucion();
    }
    
   
}
    
  public static int particionar2(int[] arr, int inicio, int fin) throws InterruptedException{
    int pivote = arr[fin];
    int i = inicio - 1;
    
    for(int j = inicio; j < fin; j++){
    
    // comparando j con pivote
    Practica2.colores[j] = Color.ORANGE;
    Practica2.colores[fin] = Color.ORANGE;
    PonerGrafica();
    Practica2.Comparaciones++;
    ActualizarComparaciones();
    Practica2.CargarArea("Comparando", Practica2.Comparaciones, ""+j, ""+(fin),Practica2.datos[j],Practica2.datos[fin]);
    Thread.sleep(Practica2.velocidad);
    
    if(arr[j] >= pivote){
        i++;
        
        if(i != j){
            Practica2.colores[i] = Color.ORANGE;
            Practica2.colores[j] = Color.ORANGE;
            PonerGrafica();
            Thread.sleep(Practica2.velocidad);
            
            Practica2.colores[i] = Color.RED;
            Practica2.colores[j] = Color.RED;
            PonerGrafica();
            Thread.sleep(Practica2.velocidad);
            
            int aux = arr[i];
            arr[i] = arr[j];
            arr[j] = aux;
            
            Practica2.colores[i] = Color.BLUE;
            Practica2.colores[j] = Color.BLUE;
            Practica2.colores[fin] = Color.ORANGE;
            PonerGrafica();
            Practica2.Intercambios++;
            ActualizarIntercambios();
            Practica2.CargarArea("Intercambio", Practica2.Intercambios, ""+i, ""+(j),Practica2.datos[i],Practica2.datos[j]);
            Thread.sleep(Practica2.velocidad);
        } else {
            int aux = arr[i];
            arr[i] = arr[j];
            arr[j] = aux;
            
            Practica2.colores[i] = Color.BLUE;
            Practica2.colores[fin] = Color.ORANGE;
            PonerGrafica();
            Practica2.Intercambios++;
            ActualizarIntercambios();
            Practica2.CargarArea("Intercambio", Practica2.Intercambios, ""+i, ""+(fin),Practica2.datos[i],Practica2.datos[fin]);
            Thread.sleep(Practica2.velocidad);
        }
        
    } else {
        // este else faltaba! regresa j y fin a azul
        Practica2.colores[j] = Color.BLUE;
        Practica2.colores[fin] = Color.ORANGE;
        PonerGrafica();
        Thread.sleep(Practica2.velocidad);
    }
}
    
    // coloca pivote en su posicion final
    Practica2.colores[i+1] = Color.RED;
    Practica2.colores[fin] = Color.RED;
    PonerGrafica();
    Thread.sleep(Practica2.velocidad);
    
    int aux = arr[i+1];
    arr[i+1] = arr[fin];
    arr[fin] = aux;
    
    // pivote ya en su posicion final, verde
    Practica2.colores[i+1] = Color.GREEN;
    Practica2.colores[fin] = Color.BLUE;
    PonerGrafica();
    Practica2.Intercambios++;
    ActualizarIntercambios();
    Practica2.CargarArea("Intercambio", Practica2.Intercambios, ""+(i+1), ""+(fin),Practica2.datos[i+1],Practica2.datos[fin]);
    Thread.sleep(Practica2.velocidad);
    
    return i + 1;

  }
}
      
    


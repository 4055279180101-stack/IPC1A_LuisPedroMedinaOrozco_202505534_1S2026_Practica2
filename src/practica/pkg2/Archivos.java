package practica.pkg2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import practica.pkg2.Constructor_historial;

public class Archivos extends MenuPrincipal{
    //Contador para ir viendo las ejecuciones
    private static int cont=0;
    
    //Arreglo para llevar el hsitorial
    private static Constructor_historial[] historial = new Constructor_historial[100];
    
    public static void ResumenEjecucion(){
    cont++;
    String texto="";
    MenuPrincipal.perfilUsuario[7] = "Numero de elementos procesador: "+Practica2.datos.length+"\n";
    MenuPrincipal.perfilUsuario[8] = "Tiempo total de ejecucion: " +Practica2.ms+"ms";
      try{
       BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Dell01\\OneDrive\\Desktop\\Paractica2\\EjecucionNo "+cont+".html", false));
       bw.write("<html>");  bw.newLine();
        bw.write("<head>");  bw.newLine();
        bw.write("<title>EjecucionNo. "+cont+"</title>");  bw.newLine();
       bw.write("</head>");  bw.newLine();
       
       bw.write("<body>");  bw.newLine();
       
       bw.write("<h1><center>Reporte sobre la ejecuion No. "+cont+"</center></h1>");  bw.newLine();
       bw.write("<h4><center>Datos de la ejecucion</center></h4>"); bw.newLine();
       
       bw.write("<h5>Algortimo utilizado: </h5>"); bw.write("<p>"+MenuPrincipal.Algoritmos+"</p>"); bw.newLine();
       bw.write("<h5>Orden utilizado: </h5>"); bw.write("<p>"+MenuPrincipal.Orden+"</p>"); bw.newLine();
       
       //Arreglo original
       bw.write("<h5>Arreglo original: </h5>"); 
       
       for(int i=0; i<Practica2.datos_antiguo.length; i++){
        texto +=""+Practica2.datos_antiguo[i]+", ";
       }
       bw.write("<p>"+texto+"</p>");
       bw.newLine();
       
       bw.write("<h5>Arreglo ordenado: </h5>"); 
       
       //Arreglo ordenado
       texto="";
       for(int i=0; i<Practica2.datos.length; i++){
        texto +=""+Practica2.datos[i]+", ";
       }
       bw.write("<p>"+texto+"</p>");
       bw.newLine();
       
       bw.write("<h5>Pasos realizados: </h5>"); bw.newLine();
        bw.write("<table border=1>"); bw.newLine();
       
        bw.write("<tr>"); bw.newLine();
          bw.write("<th>Comparacaciones</th>"); bw.newLine();
          bw.write("<th>Intercambios</th>"); bw.newLine();
          bw.write("<th>Iteraciones</th>"); bw.newLine();
        bw.write("</tr>"); bw.newLine();
        
         bw.write("<tr>"); bw.newLine();
          bw.write("<td><center>"+Practica2.Comparaciones+"</center></td>"); bw.newLine();
          bw.write("<td><center>"+Practica2.Intercambios+"</center></td>"); bw.newLine();
          bw.write("<td><center>"+Practica2.Iteraciones+"</center></td>"); bw.newLine();
        bw.write("</tr>"); bw.newLine();
        
        bw.write("</table>"); bw.newLine();
       
        bw.write("<h5>Tiempo de ejecucion: </h5>"); bw.write("<p>"+Practica2.ms+" ms </p>"); bw.newLine();
        bw.write("<h5>Velocidad utilizada: </h5>"); bw.write("<p>"+MenuPrincipal.Velocidad+"</p>");bw.newLine();
        
         bw.write("<h5>Perfil de sistema: </h5>"); bw.newLine();
         MenuPrincipal.area.setText(area.getText()+"\n \n --- Perfil del sistema ---- \n");
         for(int i=0; i<9; i++){
          bw.write("<p>"+MenuPrincipal.perfilUsuario[i]+"</p>"); bw.newLine();
          MenuPrincipal.area.setText(area.getText()+MenuPrincipal.perfilUsuario[i]+"");
         }
        
       bw.write("</body>");  bw.newLine();
       
        bw.write("</html>");  bw.newLine();
       
       
        
        for(int i=0; i<historial.length; i++){
          if(historial[i]==null){
            historial[i]= new Constructor_historial();
            historial[i].setNumero(cont);
            historial[i].setAlgoritmo(""+MenuPrincipal.Algoritmos);
            historial[i].setOrden(""+MenuPrincipal.Orden);
            historial[i].setTamaño(Practica2.datos.length);
            historial[i].setComparaciones(""+Practica2.Comparaciones);
            historial[i].setIntercambios(""+Practica2.Intercambios);
            historial[i].setIteraciones(""+Practica2.Iteraciones);
            historial[i].setTiempo(""+Practica2.ms);
            JOptionPane.showMessageDialog(null, "Guardado con exito");
            break;
          }
        
        }
        
       bw.close();
    }catch(Exception e){
       

            }
    }
    
    public static void Historial(){
      try{
       BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Dell01\\OneDrive\\Desktop\\Paractica2\\Historial de ejecucion.html", false));
       bw.write("<html>");  bw.newLine();
        bw.write("<head>");  bw.newLine();
        bw.write("<title>Historial</title>");  bw.newLine();
       bw.write("</head>");  bw.newLine();
       
       bw.write("<body>");  bw.newLine();
       
       bw.write("<h1><center>Historial de las ejecuciones</center></h1>");  bw.newLine();
       bw.write("<h4><center>Datos de la ejecucion</center></h4>"); bw.newLine();
       
       bw.write("<table border=1><center>"); bw.newLine();
       
        bw.write("<tr>"); bw.newLine();
          bw.write("<th>No.</th>"); bw.newLine();
          bw.write("<th>Algoritmo</th>"); bw.newLine();
          bw.write("<th>Orden</th>"); bw.newLine();
          bw.write("<th>Tamaño</th>"); bw.newLine();
          bw.write("<th>Comparaciones</th>"); bw.newLine();
          bw.write("<th>Intercambios</th>"); bw.newLine();
          bw.write("<th>Iteraciones</th>"); bw.newLine();
          bw.write("<th>Tiempo</th>"); bw.newLine();
        bw.write("</tr>"); bw.newLine();
       
        for(int i=0; i<historial.length; i++){
            if(historial[i]!=null){
        bw.write("<tr>"); bw.newLine();
          bw.write("<td><center>"+historial[i].getNumero()+"</center></td>"); bw.newLine();
          bw.write("<td><center>"+historial[i].getAlgoritmo()+"</center></td>"); bw.newLine();
          bw.write("<td><center>"+historial[i].getOrden()+"</center></td>"); bw.newLine();
          bw.write("<td><center>"+historial[i].getTamaño()+"</center></td>"); bw.newLine();
          bw.write("<td><center>"+historial[i].getComparaciones()+"</center></td>"); bw.newLine();
          bw.write("<td><center>"+historial[i].getIntercambios()+"</center></td>"); bw.newLine();
          bw.write("<td><center>"+historial[i].getIteraciones()+"</center></td>"); bw.newLine();
          bw.write("<td><center>"+historial[i].getTiempo()+"</center></td>"); bw.newLine();
        bw.write("</tr>"); bw.newLine();
            }
        }
        
       bw.write("</center></table>"); bw.newLine();
       
       bw.write("</body>");  bw.newLine();
       bw.write("</html>"); bw.newLine();
       bw.close();
    }catch(Exception e){
       

            }
     
    }
}

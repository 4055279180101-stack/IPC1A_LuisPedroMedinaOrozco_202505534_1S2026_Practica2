# Práctica 2 


## 1. Como esta organizado el proyecto

Todo el proyecto vive dentro de la carpeta Practica 2/src/practica/pkg2/. El archivo más importante es Practica2.java, que es donde arranca el programa y donde se guardan las variables que todos los demás archivos necesitan usar. La ventana principal que ve el usuario está en MenuPrincipal.java, y esta usa JFreeChart para mostrar las barras animadas. Hay otra ventanita llamada ArregloAlea.java que sirve únicamente para generar números aleatorios. El archivo Archivos.java es el encargado de crear los reportes y el historial en formato HTML. La clase Constructor_historial.java solo existe para guardar los datos de cada ejecución de forma ordenada. Y por último, los tres algoritmos de ordenamiento están en su propia carpetita llamada Algoritmos/, cada uno en su propio archivo: Bubble_sort.java, Shell_sort.java y Quick_sort.java.

---

## 2. Librerias que se usaron

Para hacer la interfaz visual, o sea las ventanas, botones y todo eso, se usó Java Swing, que es la libreria estándar de Java para eso. Las barras animadas que muestran cómo se van ordenando los números las hace JFreeChart, que permite actualizar la gráfica en tiempo real con colores personalizados para cada barra.

Para leer información del hardware de la computadora, como el procesador, la memoria RAM y la velocidad del reloj, se usó una librería llamada OSHI. Esta libreria a su vez necesita otras dos librerias de apoyo llamadas JNA y JNA Platform para poder acceder a esa información del sistema sin importar en qué sistema operativo estés.

Para registrar errores que puedan pasar mientras los algoritmos estan corriendo, se usó SLF4J en su versión más simple. Y finalmente, para leer y escribir archivos en la computadora se usaron clases normales de Java como BufferedReader y FileWriter, que leen archivos .txt y generan los reportes en HTML. Los números aleatorios se generan con java.util.Random.

---

## 3. Como funciona el programa en general

El programa le muestra al usuario de forma animada cómo funcionan distintos algoritmos de ordenamiento. Primero, el usuario mete los números que quiere ordenar, ya sea escribiéndolos a mano separados por comas, cargando un archivo .txt desde su computadora, o pidiéndole al programa que genere números aleatorios. Después escoge qué algoritmo quiere ver en acción: puede ser Bubble Sort, Shell Sort o Quick Sort. También elige si quiere ordenarlos de menor a mayor o al revés, y qué tan rápida quiere que sea la animación.

Cuando le da al botón de "Iniciar", el algoritmo empieza a correr en un hilo separado, lo que significa que la interfaz no se congela y el usuario puede ver en vivo cómo las barras se van moviendo y ordenando. Cuando termina, el programa guarda automáticamente un reporte en HTML con todas las estadísticas de esa ejecución y actualiza el historial.

Todas las variables que los archivos necesitan compartir, como el arreglo de números, los colores de las barras y los contadores, se guardan de forma estática en Practica2.java para que cualquier clase pueda acceder a ellas facilmente.

---

## 4. Explicacion de cada clase y sus metodos

### 4.1 Practica2.java — Variables globales y metodos de apoyo

Esta clase es como el almacén central del programa. Aqui se guardan todas las variables que las demas clases necesitan usar, como el arreglo datos[] que contiene los números y va cambiando conforme el algoritmo los va moviendo, datos_antiguo[] que guarda una copia del arreglo original antes de que se ordenara (para poder mostrarlo en el reporte), y colores[] que guarda el color que debe tener cada barra en la gráfica. También guarda la velocidad que determina qué tan rápida es la animación, los contadores de Comparaciones, Intercambios, Iteraciones y Particiones, y el tiempo que tardó el algoritmo en milisegundos en la variable ms.

Los métodos ActualizarComparaciones(), ActualizarIntercambios() e ActualizarIteraciones() hacen algo muy sencillo: agarran el número del contador correspondiente, lo convierten en texto y lo muestran en la etiqueta de estadísticas de la ventana principal.

El método CargarArea() recibe información sobre una operación que acaba de pasar, como si fue una comparación o un intercambio, en qué posiciones del arreglo ocurrió y cuáles eran los valores. Con eso arma un mensajito de texto y lo agrega al área de log de la ventana, para que el usuario pueda ver paso a paso lo que está haciendo el algoritmo.

El método CargarTiempo() recibe el momento en que empezó y terminó el algoritmo en nanosegundos, calcula cuánto tiempo pasó, lo convierte a milisegundos y a segundos, y agrega esa información al log. El valor en milisegundos también lo guarda en Practica2.ms para usarlo después en el reporte.

El método CargarParticion() es parecido a CargarArea() pero especificamente para el Quick Sort: registra en el log el número de partición, qué parte del arreglo se está procesando y cuáles son los valores en esas posiciones.

<img width="318" height="200" alt="VariablesStaticas" src="https://github.com/user-attachments/assets/2387c894-2924-4925-af93-35303ca489e8" />

---

### 4.2 MenuPrincipal.java — La ventana principal

Esta clase es la ventana que el usuario ve cuando abre el programa. Hereda de JFrame de Java Swing. Cuando se crea, inicializa todos los botones, etiquetas y demás componentes, y muestra una gráfica de barras vacía con fondo negro usando JFreeChart.

El método crearGrafica() simplemente genera una gráfica vacía con un valor de cero para que haya algo que mostrar antes de que el usuario meta datos.

<img width="556" height="202" alt="image" src="https://github.com/user-attachments/assets/3493e1b4-2a59-4d44-ac4b-8efc14206c5d" />


El método estático PonerGrafica() es el que hace que la gráfica se actualice durante la animación. Se asegura de ejecutarse en el hilo correcto de Swing para que no haya problemas visuales, borra la gráfica anterior, crea una nueva con los datos actuales y aplica los colores de cada barra tomándolos del arreglo Practica2.colores[]. Luego obliga a la pantalla a redibujar todo.

<img width="636" height="530" alt="image" src="https://github.com/user-attachments/assets/ad2e7808-da71-48f5-998b-5113094ed8d8" />

El método crearGrafica2() recorre el arreglo de datos actual y crea una barra por cada número.

<img width="544" height="192" alt="image" src="https://github.com/user-attachments/assets/ac121310-5c40-4ca8-a671-4d1711f98862" />

El método cargarActionPerformed() se activa cuando el usuario presiona "Cargar". Toma el texto que el usuario escribió, lo divide por las comas, llena los arreglos de datos, pone todos los colores en azul y muestra la gráfica. Si el texto está vacio o mal escrito, muestra un mensajito de error.

<img width="589" height="367" alt="image" src="https://github.com/user-attachments/assets/5d6bd72c-5c5f-4a8f-bb7a-ab7e07237cd7" />


El método jButton3ActionPerformed() abre una ventana para que el usuario busque y seleccione un archivo .txt desde su computadora.

El método MostrarDatos() abre el archivo que el usuario seleccionó, lee su contenido línea por línea y lo pega en el campo de texto, como si el usuario lo hubiera escrito a mano.

El método jButton2ActionPerformed() abre la ventanita de ArregloAlea para generar números al azar.
<img width="582" height="154" alt="image" src="https://github.com/user-attachments/assets/4998dfc8-69d8-47c8-b8ce-27035b74f1c9" />
<img width="336" height="237" alt="image" src="https://github.com/user-attachments/assets/99980b7a-91b6-4cfc-b10d-412fe10aa114" />

El método jButton4ActionPerformed() es el más largo y es el que se activa al presionar "Iniciar". Primero le pregunta a la computadora sus datos de hardware usando OSHI. Luego revisa qué algoritmo, qué orden y qué velocidad escogió el usuario, reinicia todos los contadores y lanza el algoritmo en un hilo separado para que la interfaz no se congele mientras corre.

El método historialActionPerformed() le dice a Archivos.java que genere y abra el historial en HTML.

<img width="948" height="529" alt="image" src="https://github.com/user-attachments/assets/7ca6dc96-7669-4328-b413-acf8fab40f69" />


---

### 4.3 Archivos.java — Guarda los reportes en HTML

Esta clase hereda de MenuPrincipal y se encarga de todo lo relacionado con guardar información en archivos. Tiene un contador estático que lleva la cuenta de cuántas ejecuciones han pasado, y un arreglo con espacio para guardar hasta 100 registros de historial.

El método ResumenEjecucion() se llama automaticamente cuando un algoritmo termina. Aumenta el contador, recopila toda la información de esa ejecución y escribe un archivo HTML con un nombre tipo EjecucionNo 1.html. Ese archivo incluye qué algoritmo se usó, el orden, cómo estaba el arreglo antes y después de ordenarse, una tabla con los contadores de operaciones, cuánto tiempo tardó, la velocidad que se usó y los datos del hardware. También guarda esa ejecución en el arreglo del historial para poder consultarla después.
<img width="948" height="529" alt="image" src="https://github.com/user-attachments/assets/7ca6dc96-7669-4328-b413-acf8fab40f69" />

El método Historial() genera un archivo HTML llamado Historial de ejecucion.html que tiene una tabla con todas las ejecuciones que se han hecho, mostrando los datos más importantes de cada una.

<img width="973" height="537" alt="image" src="https://github.com/user-attachments/assets/3951ca03-f89b-4542-8b1e-9a691ba939ac" />


---

### 4.4 Constructor_historial.java — Guarda los datos de una ejecucion

Esta clase es muy sencilla, no hace nada inteligente por sí sola. Su único trabajo es ser como una cajita donde se guardan los datos de una ejecución: el número de ejecución, el algoritmo que se usó, el orden, las comparaciones, intercambios, iteraciones, el tiempo y el tamaño del arreglo. Tiene dos constructores, uno que crea la cajita vacía y otro que la llena con todos los datos de una vez. Cada dato tiene su método para leerlo y su método para cambiarlo. Nada más.

<img width="993" height="507" alt="image" src="https://github.com/user-attachments/assets/54129988-19d8-4956-98d4-7bcae6d5064a" />


---

### 4.5 ArregloAlea.java — Genera numeros al azar

Esta es una ventanita extra que aparece cuando el usuario quiere que el programa genere los números solo. El usuario escribe un mínimo y un máximo para el tamaño del arreglo. El método craerActionPerformed() revisa que el mínimo no sea menor a 5 ni el máximo mayor a 30. Si los valores son válidos, decide aleatoriamente cuántos números va a generar, los llena con valores entre 1 y 100, convierte todo en una cadena de números separados por comas y la escribe directamente en el campo de texto de la ventana principal. Después cierra la ventanita y el usuario ya puede presionar "Cargar".

[Captura aquí]

---

### 4.6 Bubble_sort.java — Como funciona el Bubble Sort

Tiene dos versiones del algoritmo: una para ordenar de menor a mayor y otra para ordenar de mayor a menor. La lógica es la misma en ambas, solo cambia el signo de la comparación.

El algoritmo usa una bandera llamada paso que empieza en true. Al inicio de cada recorrido se pone en false. Si en algún momento se hace un intercambio, vuelve a ponerse en true. Si termina un recorrido completo sin ningún intercambio, significa que ya todo está ordenado y el algoritmo para sin necesidad de seguir dando más vueltas.

Dentro del recorrido, se comparan dos elementos que están uno al lado del otro. Antes de compararlos, ambos se pintan de naranja y se registra la operación. Si hay que intercambiarlos, se pintan de rojo, se hace el cambio y luego regresan a azul. Si no hay intercambio, simplemente regresan a azul. En ambos casos se actualiza la gráfica y se espera un momento para que la animación sea visible. Al terminar, todos se pintan de verde y se guarda el reporte.

[Captura aquí]

---

### 4.7 Shell_sort.java — Como funciona el Shell Sort

También tiene dos versiones, una ascendente y una descendente, que solo difieren en el operador de comparación.

Este algoritmo empieza comparando elementos que están muy separados en el arreglo, y poco a poco va reduciendo esa distancia hasta que al final compara elementos adyacentes como el Bubble Sort. La distancia inicial es la mitad del tamaño del arreglo. Mientras esa distancia sea mayor a cero, el algoritmo recorre el arreglo comparando elementos separados por esa distancia y los intercambia si es necesario. Repite eso hasta que en un recorrido completo no haya ningún intercambio, y entonces divide la distancia a la mitad para empezar la siguiente fase. Cuando la distancia llega a cero, el arreglo ya está ordenado.

Los colores funcionan igual que en el Bubble Sort: naranja al comparar, rojo al intercambiar, azul al descansar. Al terminar todos los pasos, todo se pinta de verde y se guarda el reporte.

[Captura aquí]

---

### 4.8 Quick_sort.java — Como funciona el Quick Sort

Tiene cuatro métodos: dos principales que son recursivos (Quick_sort_Ascendente() y Quick_sort_Descendente()) y dos que se encargan de la particion (particionar() y particionar2()).

Los métodos principales funcionan de forma recursiva, lo que significa que se llaman a sí mismos. Reciben el arreglo y las posiciones de inicio y fin del pedazo que están procesando. Si el inicio es igual a cero, guardan el tiempo de inicio para medir cuánto tarda todo. Luego llaman a la función de partición para saber dónde quedó el pivote, y después se llaman a sí mismos dos veces: una para ordenar la parte izquierda y otra para ordenar la parte derecha. Cuando la llamada inicial termina completamente, todos los colores se ponen en verde y se guarda el reporte.

El método particionar() agarra el último elemento del pedazo como pivote y recorre todo el pedazo comparando cada elemento con ese pivote. Si un elemento es menor o igual al pivote, lo mueve a la izquierda. Al terminar el recorrido, el pivote queda en su posición final y se pinta de verde porque ya no se va a mover más. El método devuelve la posición donde quedó el pivote. particionar2() hace exactamente lo mismo pero para ordenar de mayor a menor.

[Captura aquí]

---

## 5. Como se ven los colores en la animacion

Todos los algoritmos usan el mismo sistema de colores para que sea fácil entender qué está pasando. El azul significa que una barra está quieta, sin hacer nada. El naranja significa que dos barras se están comparando en ese momento. El rojo significa que dos barras se están intercambiando de lugar. Y el verde significa que una barra ya llegó a su posición final y no se va a mover más, o que el arreglo ya terminó de ordenarse por completo.

La animación funciona así: el algoritmo cambia los colores en el arreglo Practica2.colores[], llama a PonerGrafica() para que la gráfica se actualice, y luego hace una pequeña pausa con Thread.sleep() para que el ojo humano pueda ver lo que pasó. Todo esto ocurre en un hilo separado para que la ventana del programa no se quede congelada mientras el algoritmo trabaja.


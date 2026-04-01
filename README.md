# Práctica 2 — Visualizador de Algoritmos de Ordenamiento

**Lenguaje:** Java | **IDE:** Apache NetBeans | **Paquete base:** `practica.pkg2`

---

## 1. Estructura del Proyecto

El proyecto se organiza dentro de la carpeta `Practica 2/src/practica/pkg2/`. La clase principal es `Practica2.java`, que contiene el método `main` y las variables globales. La interfaz gráfica se gestiona desde `MenuPrincipal.java`, que hace uso de JFreeChart para las visualizaciones. La ventana auxiliar `ArregloAlea.java` permite generar arreglos aleatorios, mientras que `Archivos.java` se encarga del manejo de reportes e historial en formato HTML. La clase `Constructor_historial.java` actúa como modelo de datos para el historial. Los algoritmos de ordenamiento se encuentran en el subpaquete `Algoritmos/`, con archivos independientes para `Bubble_sort.java`, `Shell_sort.java` y `Quick_sort.java`.

---

## 2. Librerías Implementadas

Para la construcción de la interfaz gráfica se utilizó **Java Swing**, que provee todos los componentes visuales como ventanas, botones, comboboxes y áreas de texto. La visualización animada del arreglo se logra con **JFreeChart**, que genera las gráficas de barras y permite actualizarlas en tiempo real mediante un `BarRenderer` personalizado.

Para obtener información del hardware del sistema (modelo de procesador, frecuencia de reloj, memoria RAM) se integró **OSHI**, la cual depende internamente de **JNA** y **JNA Platform** para acceder a recursos nativos del sistema operativo de forma multiplataforma.

El registro de eventos durante la ejecución se maneja a través de **SLF4J**, usando su implementación simple para capturar errores en los hilos de los algoritmos. Finalmente, las clases del paquete estándar `java.io` (`BufferedReader`, `BufferedWriter`, `FileWriter`, `FileReader`) se emplean para la lectura de archivos `.txt` y la generación de reportes en HTML, mientras que `java.util.Random` se usa para generar los valores aleatorios del arreglo.

---

## 3. Lógica General

La aplicación es un visualizador interactivo de algoritmos de ordenamiento. El usuario comienza ingresando datos de forma manual separados por comas, cargando un archivo `.txt`, o generando un arreglo aleatorio. A continuación, selecciona el algoritmo deseado entre Bubble Sort, Shell Sort y Quick Sort, define el orden (ascendente o descendente) y ajusta la velocidad de animación. Al presionar "Iniciar", el algoritmo se ejecuta en un hilo separado, lo que permite observar en tiempo real cómo se ordenan las barras en la gráfica sin bloquear la interfaz. Al finalizar la ejecución, se guarda automáticamente un reporte HTML con las estadísticas y se actualiza el historial.

El estado compartido entre clases —arreglo de datos, colores y contadores— se gestiona mediante variables estáticas públicas definidas en `Practica2.java`.

---

## 4. Clases y Métodos Importantes

### 4.1 `Practica2.java` — Estado Global y Utilidades

Actúa como contenedor de estado global y punto de entrada de la aplicación. Declara como variables estáticas públicas el arreglo `datos[]` (que se va modificando durante el ordenamiento), `datos_antiguo[]` (copia del arreglo original para mostrarlo en el reporte), el arreglo `colores[]` que controla el color de cada barra en la gráfica, la variable `velocidad` que determina el tiempo de pausa entre pasos, y los contadores `Comparaciones`, `Intercambios`, `Iteraciones` y `Particiones`. También almacena el tiempo total de ejecución en milisegundos en la variable `ms`.

Los métodos `ActualizarComparaciones()`, `ActualizarIntercambios()` e `ActualizarIteraciones()` convierten el valor entero del contador correspondiente a texto y lo muestran directamente en el `JLabel` del panel de estadísticas en `MenuPrincipal`.

El método `CargarArea()` recibe el tipo de operación (`"Comparando"` o `"Intercambio"`), el número de operación, las posiciones involucradas y los valores de ambos elementos. Con esto construye un bloque de texto que agrega al `JTextArea` del log, indicando qué operación se realizó, en qué posiciones y con qué valores.

El método `CargarTiempo()` recibe el tiempo de inicio y fin en nanosegundos, calcula la diferencia, la convierte a milisegundos y a segundos, y añade esa información al área de log. El valor en milisegundos también queda guardado en `Practica2.ms` para ser usado posteriormente en el reporte HTML.

El método `CargarParticion()` cumple una función similar a `CargarArea()` pero orientado al Quick Sort: registra en el log el número de partición, el rango del subarreglo (posición inicio y fin) y los valores en esas posiciones.

[Captura aquí]

---

### 4.2 `MenuPrincipal.java` — Ventana Principal

Hereda de `javax.swing.JFrame` y gestiona la interfaz gráfica completa. Su constructor inicializa los componentes visuales generados por NetBeans y crea una gráfica de barras vacía con JFreeChart usando un dataset con un valor de 0, estableciendo el fondo negro tanto del gráfico como del área de la gráfica.

El método `crearGrafica()` genera un `DefaultCategoryDataset` vacío con un valor placeholder de 0, usado únicamente al iniciar la ventana antes de que el usuario cargue datos.

El método estático `PonerGrafica()` es el encargado de refrescar la visualización durante la animación. Se ejecuta dentro de `SwingUtilities.invokeLater()` para garantizar que la actualización ocurra en el hilo del EDT de Swing. Elimina el contenido anterior del panel, construye un nuevo gráfico de barras con `crearGrafica2()`, le aplica un `BarRenderer` personalizado que toma el color de cada barra directamente desde `Practica2.colores[column]`, y finalmente llama a `revalidate()` y `repaint()` para que el panel se actualice visualmente.

El método `crearGrafica2()` recorre `Practica2.datos[]` y agrega cada valor al dataset usando su índice como categoría, lo que produce una barra por elemento del arreglo.

El método `cargarActionPerformed()` se dispara al presionar el botón "Cargar". Toma el texto del campo `Dato`, lo divide por comas, inicializa los arreglos `datos[]` y `datos_antiguo[]` con los valores ingresados, reinicia los contadores y el área de log, inicializa todos los colores a azul, y llama a `PonerGrafica()` para mostrar el arreglo en pantalla. Si el texto está vacío o tiene un formato incorrecto, muestra un `JOptionPane` de error.

El método `jButton3ActionPerformed()` abre un `JFileChooser` configurado para seleccionar únicamente archivos `.txt`. Si el usuario selecciona un archivo válido, llama a `MostrarDatos()` con la ruta absoluta.

El método `MostrarDatos()` abre el archivo seleccionado con un `BufferedReader` y copia su contenido al campo de texto `Dato`, línea por línea, para que el usuario pueda cargarlo como si lo hubiera escrito manualmente.

El método `jButton2ActionPerformed()` abre la ventana `ArregloAlea` para que el usuario configure un arreglo aleatorio.

El método `jButton4ActionPerformed()` es el más extenso y se ejecuta al presionar "Iniciar". Primero recopila información del hardware usando OSHI: sistema operativo, arquitectura, núcleos, memoria RAM total y disponible, modelo del procesador y frecuencia de reloj. Luego obtiene el algoritmo, orden y velocidad seleccionados en los comboboxes, reinicia todos los contadores, traduce la opción de velocidad seleccionada a milisegundos (500, 100 o 20), y finalmente lanza el algoritmo correspondiente en un hilo nuevo `Thread` para no bloquear la interfaz durante la animación.

El método `historialActionPerformed()` llama a `Archivos.Historial()` para generar y abrir el archivo HTML del historial de ejecuciones.

[Captura aquí]

---

### 4.3 `Archivos.java` — Persistencia HTML

Hereda de `MenuPrincipal`. Mantiene un contador estático `cont` que lleva la numeración de ejecuciones y un arreglo estático de `Constructor_historial[]` con capacidad para 100 registros.

El método `ResumenEjecucion()` se invoca automáticamente al finalizar cada algoritmo. Incrementa el contador, completa los campos del perfil del sistema con el número de elementos procesados y el tiempo total de ejecución, y escribe un archivo HTML completo en disco con el nombre `EjecucionNo N.html`. El reporte incluye el algoritmo usado, el orden, el arreglo original, el arreglo ya ordenado, una tabla HTML con las comparaciones, intercambios e iteraciones realizadas, el tiempo de ejecución en milisegundos, la velocidad utilizada y el perfil del sistema. Además, recorre el arreglo `historial[]` buscando el primer espacio vacío, crea un nuevo objeto `Constructor_historial` con todos los datos de esa ejecución y lo almacena en ese índice.

El método `Historial()` genera un archivo HTML llamado `Historial de ejecucion.html` que contiene una tabla con una fila por cada ejecución registrada en el arreglo `historial[]`, mostrando el número de ejecución, algoritmo, orden, tamaño del arreglo, comparaciones, intercambios, iteraciones y tiempo.

[Captura aquí]

---

### 4.4 `Constructor_historial.java` — Modelo de Datos

Clase POJO (Plain Old Java Object) que encapsula los datos de cada ejecución para el historial. Cuenta con dos constructores: uno vacío y uno parametrizado que recibe los ocho campos del registro. Los atributos son `Numero` (entero), `Algoritmo`, `Orden`, `Comparaciones`, `Intercambios`, `Iteraciones` y `Tiempo` (todos String), más `Tamaño` (entero que indica cuántos elementos tenía el arreglo). Cada atributo tiene su getter y setter correspondiente. Esta clase no contiene lógica de negocio; su único propósito es transportar los datos de una ejecución hacia el reporte HTML.

[Captura aquí]

---

### 4.5 `ArregloAlea.java` — Generador de Arreglo Aleatorio

Ventana auxiliar (`JFrame`) que permite al usuario definir un rango mínimo y máximo para generar un arreglo aleatorio. El método `craerActionPerformed()` valida que el mínimo no sea menor a 5 y que el máximo no supere 30. Con esos límites válidos, usa `Random.nextInt(Min, Max)` para determinar aleatoriamente el tamaño del arreglo, luego lo llena con valores enteros aleatorios entre 1 y 100. Finalmente, convierte el arreglo a una cadena de números separados por comas y la escribe directamente en el campo `Dato` de `MenuPrincipal`. Una vez hecho esto, cierra la ventana con `dispose()` para que el usuario pueda continuar desde la ventana principal.

[Captura aquí]

---

### 4.6 `Bubble_sort.java` — Algoritmo Bubble Sort

Contiene dos métodos: `Bublle_sort_Ascendente()` y `Bublle_sort_Descendente()`, ambos con lógica idéntica salvo por el operador de comparación (`>` para ascendente, `<` para descendente).

Cada método utiliza un bucle externo `while(paso)` controlado por una bandera booleana. Al inicio de cada iteración del `while`, `paso` se establece en `false`. Si durante el recorrido del arreglo se realiza al menos un intercambio, `paso` vuelve a `true`, lo que provoca que el `while` continúe. Si en un recorrido completo no hubo ningún intercambio, el arreglo ya está ordenado y el algoritmo termina anticipadamente sin necesidad de completar todas las pasadas posibles.

Dentro del bucle `for` se comparan los elementos adyacentes `datos[i]` y `datos[i+1]`. Antes de la comparación, ambos se pintan de naranja y se registra la operación en el log y en el contador. Si se determina que hay un intercambio, ambos se pintan de rojo, se realiza el swap usando una variable auxiliar `aux`, y al terminar regresan a azul. Si no hay intercambio, simplemente regresan a azul directamente. En ambos casos se llama a `PonerGrafica()` y se pausa con `Thread.sleep()` para que la animación sea visible. Al terminar el `while`, todos los colores pasan a verde y se genera el reporte con `ResumenEjecucion()`.

[Captura aquí]

---

### 4.7 `Shell_sort.java` — Algoritmo Shell Sort

Contiene dos métodos: `Shell_sort_Ascendente()` y `Shell_sort_Descendente()`, que difieren únicamente en el operador de comparación.

El algoritmo parte con un `gaps` inicial igual a `datos.length / 2`. Mientras `gaps > 0`, ejecuta un bucle interno `while(paso)` que recorre el arreglo comparando elementos separados por esa distancia (`datos[i]` con `datos[i+gaps]`). Al igual que en Bubble Sort, la bandera `paso` hace que el recorrido se repita hasta que no haya más intercambios con el gap actual. Cuando el recorrido interno termina sin intercambios, el gap se divide entre 2 y comienza una nueva fase. Este proceso continúa hasta que `gaps` llega a 0, lo que indica que el arreglo está ordenado.

La animación sigue el mismo patrón de colores: naranja al comparar, rojo al intercambiar y azul al regresar al reposo. Cada operación queda registrada en el log y en los contadores. Al finalizar todos los gaps, todos los colores pasan a verde y se llama a `ResumenEjecucion()`.

[Captura aquí]

---

### 4.8 `Quick_sort.java` — Algoritmo Quick Sort

Contiene cuatro métodos: `Quick_sort_Ascendente()`, `Quick_sort_Descendente()`, y sus funciones de partición `particionar()` y `particionar2()` respectivamente.

Los métodos principales son recursivos y reciben el arreglo junto con los índices `inicio` y `fin` del subarreglo actual. Al ser llamados con `inicio == 0`, capturan el tiempo de inicio con `System.nanoTime()` para medir el tiempo total de ejecución. Si `inicio < fin`, incrementan los contadores de iteraciones y particiones, registran la partición en el log, y llaman a la función de partición para obtener el índice del pivote. Luego se invocan recursivamente sobre el subarreglo izquierdo (de `inicio` a `pivote - 1`) y el subarreglo derecho (de `pivote + 1` a `fin`). Cuando la llamada raíz termina (cuando `inicio == 0` y `fin == datos.length - 1`), todos los colores se ponen en verde y se genera el reporte.

El método `particionar()` toma como pivote el último elemento del subarreglo (`arr[fin]`) y usa dos índices: `j` recorre el subarreglo de izquierda a derecha comparando cada elemento con el pivote (pintando ambos en naranja), mientras que `i` avanza solo cuando se encuentra un elemento menor o igual al pivote. Cuando eso ocurre, se incrementa `i` y se intercambian `arr[i]` con `arr[j]`, pintándolos en rojo durante el swap. Al terminar el recorrido, el pivote se coloca en su posición final intercambiando `arr[i+1]` con `arr[fin]`, y ese elemento se pinta de verde para indicar que ya quedó en su lugar definitivo. El método devuelve `i + 1`, que es el índice donde quedó el pivote. El método `particionar2()` funciona de forma idéntica pero con la condición `arr[j] >= pivote` para ordenar de forma descendente.

[Captura aquí]

---

## 5. Patrón de Animación

Todos los algoritmos comparten el mismo esquema de visualización por colores. El color **azul** indica que un elemento está en estado normal o en reposo. El **naranja** señala que dos elementos están siendo comparados en ese momento. El **rojo** marca los elementos que están siendo intercambiados. Finalmente, el **verde** indica que un elemento ya se encuentra en su posición final, o bien que el arreglo ha sido ordenado por completo.

La animación se logra modificando el arreglo `Practica2.colores[]`, llamando al método `PonerGrafica()` y pausando la ejecución con `Thread.sleep(Practica2.velocidad)`. Los algoritmos corren en hilos separados para no bloquear el EDT de Swing.


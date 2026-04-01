# IPC1A_LuisPedroMedinaOrozco_202505534_1S2026_Practica2
# Práctica 2 — Visualizador de Algoritmos de Ordenamiento
Lenguaje: Java  
IDE: Apache NetBeans  
Paquete base: `practica.pkg2`

---

## 1. Estructura del Proyecto

```
Practica 2/
└── src/
    └── practica/pkg2/
        ├── Practica2.java              # Clase principal (main + variables globales)
        ├── MenuPrincipal.java          # Ventana principal (GUI con JFreeChart)
        ├── ArregloAlea.java            # Ventana auxiliar para arreglo aleatorio
        ├── Archivos.java               # Manejo de archivos HTML (reportes e historial)
        ├── Constructor_historial.java  # Clase modelo para el historial
        └── Algoritmos/
            ├── Bubble_sort.java        # Implementación de Bubble Sort
            ├── Shell_sort.java         # Implementación de Shell Sort
            └── Quick_sort.java         # Implementación de Quick Sort
```

---

## 2. Librerías Implementadas

Para la construcción de la interfaz gráfica se utilizó Java Swing, que provee todos los componentes visuales como ventanas, botones, comboboxes y áreas de texto. La visualización animada del arreglo se logra con JFreeChart, que genera las gráficas de barras y permite actualizarlas en tiempo real mediante un `BarRenderer` personalizado.

Para obtener información del hardware del sistema (modelo de procesador, frecuencia de reloj, memoria RAM) se integró OSHI, la cual depende internamente de JNA y JNA Platform para acceder a recursos nativos del sistema operativo de forma multiplataforma.

El registro de eventos durante la ejecución se maneja a través de SLF4J, usando su implementación simple para capturar errores en los hilos de los algoritmos. Finalmente, las clases del paquete estándar java.io (`BufferedReader`, `BufferedWriter`, `FileWriter`, `FileReader`) se emplean para la lectura de archivos `.txt` y la generación de reportes en HTML, mientras que java.util.Random se usa para generar los valores aleatorios del arreglo.

---

## 3. Lógica General

La aplicación es un visualizador interactivo de algoritmos de ordenamiento. El usuario puede:

1. Ingresar datos manualmente (separados por comas), cargar un archivo `.txt`, o generar un arreglo aleatorio.
2. Seleccionar el algoritmo (Bubble Sort, Shell Sort o Quick Sort), el orden (ascendente o descendente) y la velocidad de animación.
3. Presionar "Iniciar" para ejecutar el algoritmo en un hilo separado, observando en tiempo real cómo se ordenan las barras en la gráfica.
4. Al finalizar, se guarda automáticamente un reporte HTML con las estadísticas de la ejecución y se actualiza el historial.

El estado compartido entre clases (arreglo de datos, colores, contadores) se gestiona mediante variables estáticas públicas en `Practica2.java`.

---

## 4. Clases y Métodos Importantes

### 4.1 `Practica2.java` — Estado Global y Utilidades

Actúa como contenedor de estado global y punto de entrada de la aplicación.

[Captura aquí]

---

### 4.2 `MenuPrincipal.java` — Ventana Principal

Hereda de `javax.swing.JFrame` y gestiona la interfaz gráfica completa.

[Captura aquí]

---

### 4.3 `Archivos.java` — Persistencia HTML

Hereda de `MenuPrincipal`. Maneja la escritura de reportes con `BufferedWriter` y `FileWriter`.

[Captura aquí]

---

### 4.4 `Constructor_historial.java` — Modelo de Datos

Clase POJO (Plain Old Java Object) que encapsula los datos de cada ejecución para el historial.

[Captura aquí]

---

### 4.5 `ArregloAlea.java` — Generador de Arreglo Aleatorio

Ventana auxiliar (`JFrame`) que permite al usuario definir un rango (mínimo 5, máximo 30) para generar un arreglo aleatorio.

[Captura aquí]

---

### 4.6 `Bubble_sort.java` — Algoritmo Bubble Sort

Implementación de Bubble Sort con bandera `paso` para optimización (termina si no hubo intercambios).

[Captura aquí]

---

### 4.7 `Shell_sort.java` — Algoritmo Shell Sort

Implementación con reducción de `gaps` (brecha inicial = `length/2`, se divide entre 2 en cada iteración externa).

[Captura aquí]

---

### 4.8 `Quick_sort.java` — Algoritmo Quick Sort

Implementación recursiva con función de partición. El pivote es el último elemento del subarreglo y queda en su posición final al terminar cada partición.

[Captura aquí]

---

## 5. Patrón de Animación

Todos los algoritmos siguen el mismo patrón de visualización:

| Color | Significado |
|---|---|
| 🔵 Azul | Estado normal / en reposo |
| 🟠 Naranja | Elementos siendo comparados |
| 🔴 Rojo | Elementos siendo intercambiados |
| 🟢 Verde | Elemento en su posición final / arreglo ordenado |

La animación se logra modificando `Practica2.colores[]`, llamando a `PonerGrafica()` y pausando la ejecución con `Thread.sleep(Practica2.velocidad)`. Los algoritmos corren en hilos separados para no bloquear el EDT de Swing.

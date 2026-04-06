# Práctica 2 


## 1.¿Que es este programa?
Este programa es un visualizador donde podras ver dinamicamente como es que se ordena una arreglo de n tamaño, este arreglo sera de numero enteros, con un rango de los numeros de 1-100 con esto ustedes podra ingresar los nuemros que quiera asi como poder elegir el algortimo dependiendo de loq ue guste, tambien podra modificar la velocidad con la que este ira, esto quiere decir que usted decidira si ira rapido o lento o que la velocidad sea mediana.

Usted podra ver en la parte de el algoritmos donde dice "Visualizador" en esta parte podra ver como se ordenan los algoritmos dinamicamente de forma que pueda ver la diferencia de operaciones que realiza cada tipo de algoritmo, esta visuzalizacion afecta si es ascendente o descendente cosa que podra modificar de igual manera.

Aqui puede como se veria la interfaz al empezar el programa.

<img width="1061" height="714" alt="image" src="https://github.com/user-attachments/assets/a2268916-4ece-4e0b-972f-af2b9d8608e4" />

## 2. Panel de control
En esta parte podra usted colocar el vector que quiera realizar de tres maneras que es de forma manual por ejemplo 12,12,3,8,10 o de forma aleatoria donde usted pone el rango aleatorio de espacios que quiera que tenga el arreglo con un minimo de 5 y un maximo de 30 y la ultima seria abrir un archivo que tengo un formate de numero como en el primer ejemplo y ingresarlo, algunos ejemplos

### I. Manual
<img width="401" height="160" alt="image" src="https://github.com/user-attachments/assets/b87b8307-1d72-4465-b28b-c4c20a1a2dfd" />

### II. Aleatorio

Apretamos el boton donde dice aleatorio.

<img width="326" height="248" alt="image" src="https://github.com/user-attachments/assets/691ae0cc-24e2-483f-bd3c-dc6fc41bbe8f" />

Luego colocamos el rango, si pones un rango que que esta fuera del limite tendras este error:
<img width="331" height="243" alt="image" src="https://github.com/user-attachments/assets/79cd5954-ab5b-48dd-9b5e-5fab8c0ff72e" />
<img width="291" height="122" alt="image" src="https://github.com/user-attachments/assets/4797b7dd-c72a-4c21-992c-79c779822300" />

Pero si lo colocos bien tendra un mensaje de exito y se colocara en JTextArea para que puedas verlo o modificarlo
<img width="404" height="168" alt="image" src="https://github.com/user-attachments/assets/f057ece2-eac4-4321-bb5a-864146236d08" />

### III. Mediante archivos

Aqui usted podra colocar un archivo solamente de tipo .txt porque es donde es mas facil colocarlo, por ejemplo tenemos este tipo de archivo y le ponemos de nombre Prueba y le pones numero de la forma n,m,b y asi sucesivamente.

<img width="251" height="81" alt="image" src="https://github.com/user-attachments/assets/f9510f74-80cd-4090-b30c-37e52087246a" />

Luego lo guardas y te vas a panel de control donde presion el boton de seleccioanr archivo que tendra un colo verde y se abrira una interfaz para escoger el archivo que se veria algo asi:

<img width="500" height="359" alt="image" src="https://github.com/user-attachments/assets/e17f53cb-e03f-4516-9c9c-dafb8df71b74" />

Ahora lo abres y se pondra en el JtextArea:

<img width="400" height="170" alt="image" src="https://github.com/user-attachments/assets/e2ac6d0f-377e-4620-88c4-69733f173b48" />

Ahora presionamos en el boton cargar para que puedas ver si se pone en la parte de Visualizador, cuando presionar cargar:

<img width="261" height="119" alt="image" src="https://github.com/user-attachments/assets/c38a0844-c9c4-4574-9a1b-774e2f7a7a99" />

Luego se pondra en visualizar:

<img width="558" height="291" alt="image" src="https://github.com/user-attachments/assets/61b9939b-d4b6-489f-bd15-1f2d88185853" />

Abajo en contienuando en la seccion de panel de control podemos encontrar las otras opciones que nos serviran para personalizar como se comportara el programa al momento de ordenar lo que es el vector o el arreglo que hayamos puesto en el JtextField, ahora bien lo que usted eliga es conforme a usted quiera visualizar el algoritmo en el grafico.

<img width="1050" height="708" alt="image" src="https://github.com/user-attachments/assets/81b6888e-9cae-4797-ab7b-d9c7cb21dbf6" />

### I. Algoritmo
Aqui podras elegir el tipo de algotimo que quieras que ordene el arreglo, ya sea Quick Sort, Shell Sort o el mas simple el cual es Bubble Sort pero todos llegan al mismo camino.

<img width="324" height="56" alt="image" src="https://github.com/user-attachments/assets/c3838ce4-37bf-463c-8ecc-f8a25419b980" />


### II. Orden
Aqui podras poner la forma en que el algoritmo lo colocara el arreglo cuando se termino de ordenar ya se de forma Ascendente (menor a mayor) o de forma Descendente (mayor a menor).

<img width="328" height="53" alt="image" src="https://github.com/user-attachments/assets/79b12c05-7e83-4be2-9af5-f865de89e6b0" />

### III. Velocidad
Aqui colocaras que tan rapido quieres de se ordene ya se que cada paso se tarde el tiempo que tu especificas lento (500ms), medio (200ms) y rapido (20ms).

<img width="330" height="59" alt="image" src="https://github.com/user-attachments/assets/58c71d64-1829-461e-b99a-8215520c0a7f" />

Para cuando hayas seleccionado todo a tu preferencia le daras al boton de inciar para que inicie el proceso.

<img width="335" height="40" alt="image" src="https://github.com/user-attachments/assets/70b90488-14a5-4aaf-9f00-ffb54cbc8e7d" />

## 3. Visualizador
Aqui podras ver todo el proceso que este haciendo el algoritmo azul es cuando el espacio este en reposo

<img width="567" height="282" alt="image" src="https://github.com/user-attachments/assets/3f0ccd06-ec73-48b4-b96d-87ad7c3bbe78" />

Cuando esta amarillo es que el arreglo se esta comparando con otro y cuando sea rojo se intercambiaran pronto 

<img width="550" height="278" alt="image" src="https://github.com/user-attachments/assets/0e7ff212-1c92-4931-8d0a-9820b7b0601d" />

<img width="556" height="273" alt="image" src="https://github.com/user-attachments/assets/33c42aad-8882-44a9-9a73-e039992da391" />

Por ultimo cuando se haya terminado el arreglo se pondra en verde

<img width="576" height="289" alt="image" src="https://github.com/user-attachments/assets/c6acb894-529e-42f9-a355-b756442dd0c3" />

## 4. Estadisticas
Aqui podras ver cuantos procesos realizo o realiza el programa de esta manera podras ver cual hace mas pasos que otros entre algoritmos, este numero se actualiza en tiempo real por lo que no tendras que esperar a que se termine el programa para verlos, comparaciones, intercambios y iteraciones(cuando el agloritmo completo una vuelta en el).

<img width="367" height="156" alt="image" src="https://github.com/user-attachments/assets/f0f60ba6-9e6f-405a-b1d5-0675c028b006" />


<img width="402" height="144" alt="image" src="https://github.com/user-attachments/assets/441eec15-10f6-4d50-a2c8-9b2c309b8f51" />


<img width="406" height="147" alt="image" src="https://github.com/user-attachments/assets/f82cb25a-b6f0-4b93-99d4-fe76cbf8ed4a" />

## 5. Log de operaciones
Aqui podras ver que hace mas profundamente el programa en el codigo, te dira que numero de celda y cuando vale ademas de señalar el tipo de operacion que se esta realizando con el numero de ese tipo que le corresponde.

Al principio cuando cargues el arreglo de "arreglo cargado" señalando que ya se cargo en el sistemas.

<img width="544" height="224" alt="image" src="https://github.com/user-attachments/assets/ff0c74a7-b9a8-458b-a51e-1662b2d5804f" />

Cuando empieze el programa podras ver todo proceso y como este se va actualizando en cada paso, ejemplo:

<img width="537" height="222" alt="image" src="https://github.com/user-attachments/assets/6a17c97e-4167-4b60-821c-d892019e77b8" />

<img width="542" height="224" alt="image" src="https://github.com/user-attachments/assets/0876b9cf-1a6b-47fd-93a1-ec4022d3c4fd" />

Por ultimo cuando termine el programa podras ver datos de tu computadora que serviran como guia y podras analizar el tiempo total trancurido, donde podras decir si fue mas lento por los recursos que tuvo tu pc y sacar tus conclusiones.

<img width="241" height="23" alt="image" src="https://github.com/user-attachments/assets/cef3a625-1689-4f55-80d2-aee50a84e189" />

<img width="544" height="224" alt="image" src="https://github.com/user-attachments/assets/97068aac-c8fe-439b-818d-de7673195862" />

## 5. Resumen de operacion
Este archivo html se crea automaticamente en la carpeta del archivo del programa aqui podras ver el perfil mismo del sistema y el numero de ejecucion del cual se trata.

## 6. Historial de ejecuciones
Aqui podras ver absolutamente todas las ejecuciones que realizaste en una tabla y con el numero de ejecucion.

<img width="305" height="65" alt="image" src="https://github.com/user-attachments/assets/fd1c3b4c-1e01-4162-84f5-5591cbe6232b" />

<img width="903" height="188" alt="image" src="https://github.com/user-attachments/assets/018b0ab4-871c-46b7-b64a-b756b9ef4712" />



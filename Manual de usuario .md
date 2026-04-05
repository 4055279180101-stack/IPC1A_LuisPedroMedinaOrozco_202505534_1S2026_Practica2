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




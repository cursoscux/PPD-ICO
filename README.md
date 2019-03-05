
# PPD-ICO
## Programación Paralela y Distribuida _[Códigos de ejemplo]_

**Multi Threading**

|Programa|Descripción|
|--|--|
| Hilos_Lab01 |Programa que usa Threads Heredados ```(extends Thread)``` e Implementados ```(implements Runnable)``` |
|Hilos_Lab02 |Programa que muestra como crear un arreglo de 100 Threads concurrentes que actualizan un widget de tipo ```JTextField```|
|Hilos_Lab03|Programa que muestra como crear en consola un arreglo de Threads mostrando el nombre del thread en ejecución|
|Reloj_v1|Programa que muestra como crear una ventana ```(JFrame)``` que despliega un reloj dentro de un ```JTextField``` actualizándolo cada segundo ```Thread.sleep(1000)```|
|Reloj_v2|Programa que muestra como implementar la clase Reloj como un ```Thread``` o como un objeto de tipo ```Runnable```|
|Reloj_v3|Programa que muestra como tener varios relojes en el mismo ```JFrame```, adicionalmente se pueden agregar alarmas individuales a cada reloj que serán desplegadas dentro de un objeto tipo ```JOptionPane```|
|PelotaAnimada_v1|Programa que muestra como mover una imagen dentro de un ```JPanel```|
|PelotaAnimada_v2|Programa que usa ```Thread``` para mover una imagen dentro de un ```JPanel```|
|PelotaAnimada_v3|Programa que muestra como mover varias imagenes con un solo ```Thread```|
|PelotaAnimada_v4|Programa que muestra como usar la técnica de ```DoubleBuffer``` en un  ```JPanel``` para evitar el efecto "Flikker" al animar/mover un objeto gráfico|
|GeneraAleatorios_v1|Programa muestra como varios procesos ```(Threads)``` pueden acceder a un ```widget (JList)```de Swing|
|GeneraAleatorios_v2|Programa muestra como varios procesos ```(Threads)``` pueden acceder a un objeto compartido generando ```ConcurrentModificationException```|
|GeneraAleatorios_v3|Programa muestra como varios procesos ```(Threads)``` pueden acceder a objeto compartido de forma segura empleando la tecnica de sincronización de bloques ```synchronized()```|

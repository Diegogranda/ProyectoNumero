import java.util.*;
public class ProyectNumero {
    public static void main (String[]args){
        MenuPrincipal();
    }


    //PARTES DEL PROGRAMA

    //En primer lugar se declara que el usuario cuenta con 20 $ para utilizar en el juego.

    private static int creditos = 20;// Declaramos la variable a la que llamamos créditos y es private para que solo se pueda acceder desde esta clase y static para permitir el acceso a los datos
    private static Scanner escrito = new Scanner(System.in);//Creamos la clase de tipo Scanner y la importamos del paquete java.util.*

    //Para crear un menú utilizamos el bucle con varios switch con sus respectivos case para darle las opciones
    private static void MenuPrincipal() {
        boolean Escape = false;//implementamos boolean para poder salir del juego si se desea.
        while (!Escape) {
            try {//Se usa para prevenir excepciones  y en caso de que falle se ejecuta el catch
                System.out.println("Que te interesa realizar: ");
                System.out.println("-Si desea iniciar el juego seleccione 1");
                System.out.println("-Mirar tu crédito, si desea mirar las estadisticas seleccione 2");
                System.out.println("-Salir del juego 3");
                switch (Integer.parseInt(escrito.nextLine())) {
                    case 1 -> Comienzo();
                    case 2 -> tienescreditos();
                    case 3 -> Escape = true;
                }
            } catch (Exception e) {// ocurre esta respuesta en caso de que el try arrroje una excepción
                System.out.println(e.getMessage());
            }
        }
    }
    //En este apartado del programa podemos observar el credito del que dispones
    private static void tienescreditos() {
        System.out.println("Tus creditos son : " + creditos + " $");
    }


    //En este apartado el juego comienza.
    private static void Comienzo() {
        System.out.println("1$ introducido en el juego");
        creditos--;// En este apartado se introduce el dolar en la máquina y es cuando lo utilizas
        boolean correcto = false; int oportunidades = 5; int i;

        int[] numUsado = new int[5];

        int numIncognita = (int) (Math.random() * 99 + 1);//número aleatorio que se tiene que adivinar creado






        while (oportunidades > 0 && !correcto) {

            System.out.println("Te quedan " + oportunidades + " intentos");
            System.out.print("Introduce el numero a adivinar: ");
            i = Integer.parseInt(escrito.nextLine());


            numUsado[oportunidades - 1] = i;
            oportunidades--; //Cada numero utilizado resta una oportunidad
            //Te dice si el numero es mayor o menor dependiendo del numero que añades
            if (i == numIncognita) {
                correcto = true;
            } else if (numIncognita > i) {
                System.out.println("El numero ha de ser mayor.");
            } else {
                System.out.println("El numero ha de ser menor.");
            }
        }



        // Te dice si acertaste el número y la cantidad de intentos utilizados
        if (correcto) {
            System.out.println("Número correcto, para ello has utilizado esta cantidad" + oportunidades);

            creditos += 5; //Se te suma 5 euros si aciertas.En este apartado
        } else {//Te equivocas en el número
            System.out.println("El número introducido es erróneo, has fallado. El número era: " + numIncognita + "Oportunidades utilizadas son: " + oportunidades);
        }


        for (i = 0; i < numUsado.length; i++) { // En esta estructura de control  se nos permite ejecutar  un contador del numero de intentos, gracias al metodo legth se obtiene la lomgitud de la cadena.
            System.out.println("El numero de intento:" + numUsado [i] );

        }
    }}


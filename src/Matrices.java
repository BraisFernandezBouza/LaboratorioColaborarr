import java.util.Arrays;
import java.util.Scanner;

public class Matrices {

    static Scanner sc = new Scanner (System.in);

    public static void main(String[] args){

        int opcion = 0;

        do {
            Menu();
            opcion=validaInt();
            sc.nextLine();
            actividades(opcion);

        }while (opcion!=6);



    }

    public static int validaInt(){
        int opcion;

            while(!sc.hasNextInt()){
                System.out.println("Eso no es un número entero");
                sc.next();
            }
        return sc.nextInt();
    }

    public static double validaDouble(){
        double opcion;

        while(!sc.hasNextDouble()){
            System.out.println("Eso no es un número entero");
            sc.next();
        }
        return sc.nextDouble();
    }

    public static int validaIntNeg() {
        int opcion;

        do {
            opcion = validaInt();
            if (opcion < 0) {
                System.out.println("Introduce un valor superior a 0");
            }
        } while(opcion < 0);
        return opcion;
    }

    public static void Menu(){
        System.out.println("1. Actividad 1");
        System.out.println("2. Actividad 2");
        System.out.println("3. Actividad 3");
        System.out.println("4. Actividad 4");
        System.out.println("5. Actividad 5");
        System.out.println("6. Salir de menú");
    }

    public static void actividades(int opcion){

        switch (opcion){

            case 1 ->Actividad1();
            case 2 ->Actividad2();
            case 3 ->Actividad3();
            case 4 ->Actividad4();
            case 5 ->Actividad5();

            default -> System.out.println("Usa las opciones que se te ofrecen");
        }
    }

    public static void Actividad1(){

    //1. Crea un programa que cree una matriz de tamaño 5x5 que almacene los números del 1 al 25 y luego muestre la matriz por pantalla.

    int[][] matriz = new int[5][5];
    int numero=1;

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {

            matriz[i][j]=numero;
            numero++;
        }
        }
        for (int i = 0; i < matriz.length ; i++) {
            System.out.println(Arrays.toString(matriz[i]));
        }
    }




    public static void Actividad2() {

        //2. Crea un programa que cree una matriz de 10x10 e introduzca los valores de las tablas de
        // multiplicar del 1 al 10 (cada tabla en una fila). Luego mostrará la matriz por pantalla.

        int[][] matriz = new int[10][10];



        for (int i = 0; i < matriz.length; i++) {




            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (i+1)*(j+1);

            }

        }

        for (int i = 0; i < matriz.length; i++) {

            // agregado \n por sout
            System.out.println(Arrays.toString(matriz[i]) + "\n");
            // System.out.println();
        }
    }

    public static void Actividad3(){

    //3. Crea un programa que cree una matriz de tamaño NxM (tamaño introducido por teclado) e introduzca en ella NxM valores
        // (también introducidos por teclado). Luego deberá recorrer la matriz y al final mostrar por pantalla cuántos valores son
        // mayores que cero, cuántos son menores que cero y cuántos son igual a cero.
        int mayor=0;
        int menor=0;
        int igual=0;
        int valor = 0;

        System.out.println("Introduce las filas");
        int N = validaIntNeg();

        System.out.println("Introduce las columnas");
        int M = validaIntNeg();

        int[][] matriz = new int[N][M];


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println("Introduce un valor");
                valor = validaInt();
                matriz[i][j] = valor;

                if (matriz[i][j]>0){
                    mayor++;
                }
                else if (matriz[i][j]<0){
                    menor++;
                }
                else if (matriz[i][j]==0){
                    igual++;
                }
                }
            }

        System.out.println("Los valores mayores son: "+mayor);
        System.out.println("Los valores menores son: "+menor);
        System.out.println("Los valores iguales son: "+igual);
        }






    public static void Actividad4(){

    //4. Necesitamos crear un programa para almacenar las notas de 4 alumnos (llamados “Alumno 1”, “Alumno 2”, etc.) y 5 asignaturas.
        // El usuario introducirá las notas por teclado y luego el programa mostrará la nota mínima, máxima y media de cada alumno.
        int nota;
        int[][] matriz = new int[5][6];
        int max;
        int min;
        int media=0;
        int suma=0;

        for (int i = 0; i < matriz.length; i++) {
            max=Integer.MIN_VALUE;
            min=Integer.MAX_VALUE;
            media = 0;

            System.out.println("Introduce la nota del alumno "+(i+1));
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Introduce la nota de la asignatura "+(j+1));
                do {
                    nota = validaInt();
                    if (nota>10 || nota<0){
                        System.err.println("Introduce un valor correcto");
                    }
                }while (nota>10 || nota<0);
                matriz[i][j] = nota;

                if (nota > max) max = nota;
                if (nota < min) min = nota;

                media+=matriz[i][j];

            }
            suma = media/matriz[i].length;

            System.out.println("La nota media del alumno "+(i+1)+" es: "+suma);
            System.out.println("La nota maxima del alumno "+(i+1)+" es: "+max);
            System.out.println("La nota minima del alumno "+(i+1)+" es: "+min);




            }
        }



    public static void Actividad5(){

    //5. Necesitamos crear un programa para registrar sueldos de hombres y mujeres de una empresa y detectar si existe brecha salarial entre ambos.
        // El programa pedirá por teclado la información de N personas distintas (valor también introducido por teclado). Para cada persona, pedirá su género (0 para varón y 1 para mujer) y su sueldo.
        // Esta información debe guardarse en una única matriz. Luego se mostrará por pantalla el sueldo medio de cada género.

        int cantidad;
        int sueldo;
        int varon = 0;
        int mujer=0;
        int genero=0;

        System.out.println("Escribe la cantidad de personas que trabajan en la empresa");
        cantidad=validaIntNeg();

        int [][] matriz = new int[cantidad][2];

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Escribe el sueldo que tiene la persona " + (i + 1));
            sueldo = validaInt();


            System.out.println("Es usted hombre o mujer. Si es hombre pulse 0 y si es mujer pulse 1");


            do {
                genero = validaInt();

                if (genero < 0 || genero > 1) {
                    System.err.println("Introduce un valor correcto");
                }

            } while (genero < 0 || genero > 1);

            matriz[i][0] = genero;
            matriz[i][1] = sueldo;
            /*
             ///Codigo anterior///
            if (genero==0){

                varon+=sueldo;
            }
            else if (genero==1){
                mujer+=sueldo;
            }
            */
            // Codigo nuevo
            switch (genero){
                case 0 -> varon+=sueldo;
                case 1-> mujer+=sueldo;
            }
        }
        System.out.println("El sueldo medio de las mujeres es: "+(mujer/cantidad));
        System.out.println("El sueldo medio de las mujeres es: "+(varon/cantidad));

    }

}

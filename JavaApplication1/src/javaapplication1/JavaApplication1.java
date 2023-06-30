/*
 * Haga que la función WordSplit( strArr ) lea la matriz de cadenas almacenadas en strArr , que contendrá 2 elementos: el primer elemento será una secuencia de caracteres y el segundo elemento será una larga cadena de palabras separadas por comas, en orden alfabético , que representa un diccionario de una longitud arbitraria. Por ejemplo: strArr puede ser: ["holagato", "manzana,murciélago,gato,adiós,hola,amarillo,por qué"]. Su objetivo es determinar si el primer elemento de la entrada se puede dividir en dos palabras, donde ambas palabras existen en el diccionario que se proporciona en la segunda entrada. En este ejemplo, el primer elemento se puede dividir en dos palabras: hola y gato.porque ambas palabras están en el diccionario.
 * Su programa debe devolver las dos palabras que existen en el diccionario separadas por una coma. Entonces, para el ejemplo anterior, su programa debería devolver hello,cat . Solo habrá una forma correcta de dividir el primer elemento de caracteres en dos palabras. Si no hay forma de dividir la cadena en dos palabras que existen en el diccionario, devuelve la cadena imposible . El primer elemento en sí nunca existirá en el diccionario como una palabra real.
 */
package javaapplication1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author osorioaquino@hotmail.com
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] Arr = {"baseball", "a,ja,ba,sell,aba,ball,base,ase"};

        WordSplit(Arr);
    }

    public static void WordSplit(String[] arrst) {

        String first_element = arrst[0];
        String[] lista = arrst[1].split(",");
        String first_word = null, second_word = null;
        for (String lista1 : lista) {
            Pattern pat = Pattern.compile("^" + lista1 + ".*");
            Matcher mat = pat.matcher(first_element);
            if (mat.matches()) {
                first_word = lista1;
                String sub = first_element.substring(lista1.length(), first_element.length());
                second_word = secondWord(lista, sub);
            }
        }
        if (first_element.equals(first_word + second_word)) {
            System.out.println(first_word + "," + second_word);
        } else {
            System.out.println("Imposible");
        }

    }

    private static String secondWord(String[] lista, String sub) {
        String secondWord = null;

        for (String lista1 : lista) {
            Pattern pat = Pattern.compile(lista1 + "$");
            Matcher mat = pat.matcher(sub);
            if (mat.matches()) {
                secondWord = lista1;
            }
        }

        return secondWord;
    }

}

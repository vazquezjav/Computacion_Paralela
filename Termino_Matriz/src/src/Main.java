package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String Args[]) throws IOException {

        Termino termino = new Termino();

        FileReader archivoContador = new FileReader("C:\\Users\\javie\\Desktop\\8vo\\Computacion_Paralela\\tweets.txt");
        BufferedReader bf = new BufferedReader(archivoContador);
        int numDocs = 0;
        
        //Obtener el numero documentos en el archivo, en este caso numero lineas
        
        while (bf.readLine() != null) {
            numDocs++;
        }
        archivoContador.close();
        bf.close();
        
        DocumentProperties[] propiedadesDoc = new DocumentProperties[numDocs];

        int count = 0;
        FileReader f = new FileReader("C:\\Users\\javie\\Desktop\\8vo\\Computacion_Paralela\\tweets.txt");
        BufferedReader br = new BufferedReader(f);
        String linea;
        
        ArrayList<String> aux= new ArrayList<>();
        
        long init = System.currentTimeMillis();
        
        HashMap<String, Integer> frecuenciaTermino2 = new HashMap<String,Integer>();;
        termino.constructor(numDocs);
        ArrayList<String> matString2= new ArrayList<>();
        
        while ((linea = br.readLine()) != null) {       
//            System.out.println("\n"+linea);
            propiedadesDoc[count] = new DocumentProperties();
            HashMap<String, Integer> contadorPalabras = termino.terminosTexto(linea);
            propiedadesDoc[count].setWordCountMap(contadorPalabras);
            HashMap<String, Integer> frecuenciaTermino = termino.calcularFrecuenciaTerminos(propiedadesDoc[count].DocWordCounts);
            
            //OBTENER VALORES HASHMAP
            frecuenciaTermino2 = termino.calcularFrecuenciaTerminos(propiedadesDoc[count].DocWordCounts);
            
            Iterator<Entry<String,Integer>> it = contadorPalabras.entrySet().iterator();
            int cont=0;
            while (it.hasNext()) {
             Entry<String, Integer> e = it.next();
             String doc="Documento_"+String.valueOf(count);
             String terminoP=doc+"  "+e.getKey()+" "+e.getValue();
             matString2.add(terminoP);
             cont++;
            }
            propiedadesDoc[count].setTermFreqMap(frecuenciaTermino);
            count++;
        }
        
        termino.mat(matString2,numDocs);
        long fin = System.currentTimeMillis();
        System.out.println("TIEMPO FINAL "+(fin-init)/1000+" segundos");

    }

}

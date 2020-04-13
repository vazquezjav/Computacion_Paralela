package src;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Termino_Hilo extends Thread{

	private List<String> documentos= new ArrayList<>();
	private DocumentProperties[] propiedades;
	private int initDocs, finDocs;
	private long initialTime;
	
	SortedSet<String> wordList = new TreeSet(String.CASE_INSENSITIVE_ORDER);
	
	 public Termino_Hilo(List<String> documentos, DocumentProperties[] propiedades, int initDocs, int finDocs) {
		// TODO Auto-generated constructor stub
		 this.documentos=documentos;
		 this.propiedades=propiedades;
		 this.initDocs=initDocs;
		 this.finDocs=finDocs;
	}
	 
	@Override
	public void run() {

		int contador=0;
		long init = System.currentTimeMillis();
		DocumentProperties[] docProperties = this.propiedades;
		
        HashMap<String, Integer> frecuenciaTermino2 = new HashMap<String,Integer>();;
        ArrayList<String> matString2= new ArrayList<>();

		for (int i = initDocs; i < finDocs; i++) {
//			System.out.println("HORACION "+documentos.get(i));
			docProperties[contador]= new DocumentProperties();
			HashMap<String, Integer> contadorPalabras = this.terminosTexto(documentos.get(i));
			docProperties[contador].setWordCountMap(contadorPalabras);
			HashMap<String, Integer> frecuenciaTermino = this.calcularFrecuenciaTerminos(docProperties[contador].DocWordCounts);
			
            Iterator<Entry<String,Integer>> it = frecuenciaTermino.entrySet().iterator();
            int cont=0;
            while (it.hasNext()) {
             Entry<String, Integer> e = it.next();
             
             String doc="Documento_"+String.valueOf(contador);
             String terminoP=doc+"  "+e.getKey()+" "+e.getValue();
             matString2.add(terminoP);
             cont++;
            }
		    
            docProperties[contador].setTermFreqMap(frecuenciaTermino);
			contador++;

		}
		this.generarMatriz(matString2);
		long fin = (System.currentTimeMillis()-init)/1000;
//        System.out.println("Tiempo: " + fin +" segundos");

	}

   //convertir el texto del documento a hashmap 
    
    public HashMap<String, Integer> terminosTexto(String linea) {
        HashMap<String, Integer> contadorPalabras = new HashMap<>();
        HashMap<String, Integer> finalMap = new HashMap<>();
        String[] palabras = linea.toLowerCase().split(" ");
        for (String palabra : palabras) {
        	
//        	System.out.println("Termino "+palabra);
        	
            wordList.add(palabra);
            
            //sumar terminos, recorrer hashmap
            
            if (contadorPalabras.containsKey(palabra)) {
            	//System.out.println(contadorPalabras.get(palabra));
                contadorPalabras.put(palabra, contadorPalabras.get(palabra) + 1);
            } else {
                contadorPalabras.put(palabra, 1);
            }
        }
        
        // ordenar
        
        Map<String, Integer> treeMap = new TreeMap<>(contadorPalabras);
        finalMap = new HashMap<>(treeMap);
        return finalMap;
    }
    
    //calcular la frecuencia de los terminos
    
    public HashMap<String, Integer> calcularFrecuenciaTerminos(HashMap<String, Integer> documento) {

        HashMap<String, Integer> terminoFrecuencia = new HashMap<>();
    
        
        //Obtener la suma de los elementos del hashmap 
        
//        for (float val : documento.values()) {
//            suma += val;
//        }
       
        
        //crear nuevo hashmap 
        
//        for (Map.Entry pair : documento.entrySet()) {
//			int sum=(int) pair.getValue();
//			terminoFrecuencia.put((pair.getKey().toString()), sum);
//		}
        
        Iterator it = documento.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            int frecuencia = (int) pair.getValue();
//            System.out.println("Palabra: "+ pair.getKey().toString() + " = " + frecuencia);
            terminoFrecuencia.put((pair.getKey().toString()), frecuencia);
        }
        return terminoFrecuencia;
    }

    
    public void generarMatriz(ArrayList<String> m) {

    	String [][] l=new String[m.size()][3];
    	
    	for (int i = 0; i < m.size(); i++) {
			String n=m.get(i);
			String [] o=n.toLowerCase().split(" ");
			l[i][0]=o[0];
			l[i][1]=o[2];
			l[i][2]=o[3];
		}
//    	
//    	for (int i = 0; i < l.length; i++) {
//			for (int j = 0; j < l[0].length; j++) {
//				System.out.print(" | "+l[i][j]+" | ");
//			}
//			System.out.println();
//		}
    }
    
 
}

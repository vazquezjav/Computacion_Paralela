package src;


import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Termino {

	private String[][] matriz;
	private int contMatriz;
    SortedSet<String> wordList = new TreeSet(String.CASE_INSENSITIVE_ORDER);
    
    public void constructor(int numDocs) {
    	this.matriz= new String[numDocs][3];
    	this.contMatriz=0;
    }
    //calcular la frecuencia de los terminos
    
    public HashMap<String, Integer> calcularFrecuenciaTerminos(HashMap<String, Integer> documento) {

        HashMap<String, Integer> terminoFrecuencia = new HashMap<>();
        int suma=0;
        
        Iterator it = documento.entrySet().iterator();
        int cont=0;
        while (it.hasNext()) {
        	
            Map.Entry pair = (Map.Entry) it.next();
            int frecuencia = (int) pair.getValue();
//            System.out.println("Palabra: "+ pair.getKey().toString() + " = " + frecuencia);
            terminoFrecuencia.put((pair.getKey().toString()), frecuencia);
            cont++;
        }
        return terminoFrecuencia;
    }

    //terminos por cada texto
    
    public HashMap<String, Integer> terminosTexto(String linea) {
        HashMap<String, Integer> contadorPalabras = new HashMap<>();
        HashMap<String, Integer> finalMap = new HashMap<>();
        String[] palabras = linea.toLowerCase().split(" ");
        for (String palabra : palabras) {
        	
            wordList.add(palabra);
            
            //sumar terminos
            if (contadorPalabras.containsKey(palabra)) {
//            	System.out.println(contadorPalabras.containsKey(palabra));
                contadorPalabras.put(palabra, contadorPalabras.get(palabra) + 1);
            } else {
                contadorPalabras.put(palabra, 1);
            }
        }
        // hashmap
        Map<String, Integer> treeMap = new TreeMap<>(contadorPalabras);
        finalMap = new HashMap<>(treeMap);
        return finalMap;
    }
    
    public String [][] mat(ArrayList<String> m,int numDocs) {
    	
    	String [][] l=new String[m.size()][3];
    	
    	for (int i = 0; i < m.size(); i++) {
			String n=m.get(i);
			String [] o=n.toLowerCase().split(" ");
			l[i][0]=o[0];
			l[i][1]=o[2];
			l[i][2]=o[3];
			
		}
    	return l;
    	
    }

	public String[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(String[][] matriz) {
		this.matriz = matriz;
	}
    
}

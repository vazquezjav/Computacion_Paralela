package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainHilos {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		 FileReader archivoContador = new FileReader("C:\\Users\\javie\\Desktop\\8vo\\Computacion_Paralela\\tweets.txt");
	        BufferedReader b = new BufferedReader(archivoContador);
	        int numDocs = 0;
	        
	        //Obtener el numero documentos en el archivo, en este caso numero lineas
	        
	        while (b.readLine() != null) {
	            numDocs++;
	        }
	        archivoContador.close();
	        b.close();
	        
	        
	        DocumentProperties[] propiedades= new DocumentProperties[numDocs];

	        int count = 0;
	        FileReader f = new FileReader("C:\\Users\\javie\\Desktop\\8vo\\Computacion_Paralela\\tweets.txt");
	        BufferedReader br = new BufferedReader(f);
	        String linea;
	        
	        List<String> aux= new ArrayList<>();
	        while ((linea = br.readLine()) != null) {  
	        	aux.add(linea);
	        }
	       
	        System.out.println("docs "+numDocs);
//	       
	        long in,fb=0;
	        //2 HILOS
	        
	        Termino_Hilo hilo1 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs/2)], 0,Math.round(numDocs/2));
	        Termino_Hilo hilo2 = new Termino_Hilo(aux, new DocumentProperties[numDocs- (Math.round(numDocs/2))], Math.round(numDocs/2)+1,numDocs);
	        hilo1.start();
	        hilo2.start();
	        try {
	        	in=System.currentTimeMillis();
				hilo1.join();
				hilo2.join();
				fb=System.currentTimeMillis()-in;
				System.out.println("Tiempo 2 Hilos "+fb/1000+" segundos");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
  
	       
	        //4 HILOS
	        
//	        Termino_Hilo hilo1 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs/4)], 0,Math.round(numDocs/4));
//	        Termino_Hilo hilo2 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs/2)-(Math.round(numDocs/4)+1)], Math.round(numDocs/4)+1,Math.round(numDocs/2));
//	        Termino_Hilo hilo3 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs*3/4)-(Math.round(numDocs/2)+1)], Math.round(numDocs/2)+1,Math.round(numDocs*3/4));
//	        Termino_Hilo hilo4 = new Termino_Hilo(aux, new DocumentProperties[numDocs- (Math.round(numDocs*3/4)+1)], Math.round(numDocs*3/4)+1,numDocs);
//	        
//	        hilo1.start();
//	        hilo2.start();
//	        hilo3.start();
//	        hilo4.start();
//	      
//	        try {
//	        	in=System.currentTimeMillis();
//	        	hilo1.join();
//	        	hilo2.join();
//	        	hilo3.join();
//				hilo4.join();
//				fb=System.currentTimeMillis()-in;
//				System.out.println("Tiempo 4 Hilos "+fb/1000+" segundos");
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
	        
	       //6 hilos 
	       
//	        Termino_Hilo hilo1 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs/6)], 0,Math.round(numDocs/6));
//	        Termino_Hilo hilo2 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs*1/3)-(Math.round(numDocs/6)+1)], Math.round(numDocs/6)+1,Math.round(numDocs*1/3));
//	        Termino_Hilo hilo3 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs/2)-(Math.round(numDocs*1/3)+1)], Math.round(numDocs*1/3)+1,Math.round(numDocs/2));
//	        Termino_Hilo hilo4 = new Termino_Hilo(aux, new DocumentProperties[(Math.round(numDocs*2/3))- (Math.round(numDocs/2)+1)], Math.round(numDocs/2)+1,Math.round(numDocs*2/3));
//	        Termino_Hilo hilo5 = new Termino_Hilo(aux, new DocumentProperties[(Math.round(numDocs*5/6))- (Math.round(numDocs*2/3)+1)], Math.round(numDocs*2/3)+1,Math.round(numDocs*5/6));
//	        Termino_Hilo hilo6 = new Termino_Hilo(aux, new DocumentProperties[numDocs-(Math.round(numDocs*5/6)+1)], Math.round(numDocs*5/6)+1,numDocs);
//	        
//	        hilo1.start();
//	        hilo2.start();
//	        hilo3.start();
//	        hilo4.start();
//	        hilo5.start();
//	        hilo6.start();
//	        
//	        try {
//	        	in=System.currentTimeMillis();
//	        	hilo1.join();
//	        	hilo2.join();
//	        	hilo3.join();
//				hilo4.join();
//				hilo5.join();
//				hilo6.join();
//				fb=System.currentTimeMillis()-in;
//				System.out.println("Tiempo 6 Hilos "+fb/1000+" segundos");
//				
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//	        
	        
	        
	        //8 HILOS 
//	        Termino_Hilo hilo1 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs/8)], 0,Math.round(numDocs/8));
//	        Termino_Hilo hilo2 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs/4)-(Math.round(numDocs/8)+1)], Math.round(numDocs/8)+1,Math.round(numDocs/4));
//	        Termino_Hilo hilo3 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs*3/8)-(Math.round(numDocs/4)+1)], Math.round(numDocs/4)+1,Math.round(numDocs*3/8));
//	        Termino_Hilo hilo4 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs/2)-(Math.round(numDocs*3/8)+1)], Math.round(numDocs*3/8)+1,Math.round(numDocs/2));
//	        Termino_Hilo hilo5 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs*5/8)-(Math.round(numDocs/2)+1)], Math.round(numDocs/2)+1,Math.round(numDocs*5/8));
//	        Termino_Hilo hilo6 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs*3/4)-(Math.round(numDocs*5/8)+1)], Math.round(numDocs*5/8)+1,Math.round(numDocs*3/4));
//	        Termino_Hilo hilo7 = new Termino_Hilo(aux, new DocumentProperties[Math.round(numDocs*7/8)-(Math.round(numDocs*3/4)+1)], Math.round(numDocs*3/4)+1,Math.round(numDocs*7/8));
//	        Termino_Hilo hilo8 = new Termino_Hilo(aux, new DocumentProperties[numDocs-(Math.round(numDocs*7/8)+1)], Math.round(numDocs*7/8)+1,numDocs);
//	        
//	        hilo1.start();
//	        hilo2.start();
//	        hilo3.start();
//	        hilo4.start();
//	        hilo5.start();
//	        hilo6.start();
//	        hilo7.start();
//	        hilo8.start();
//	       
//	        try {
//        	in=System.currentTimeMillis();
//        	hilo1.join();
//        	hilo2.join();
//        	hilo3.join();
//			hilo4.join();
//			hilo5.join();
//			hilo6.join();
//			hilo7.join();
//			hilo8.join();
//			fb=System.currentTimeMillis()-in;
//			System.out.println("Tiempo 8 Hilos "+fb/1000+" segundos");
////			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	        
	                
//        Hilos
//		    
//	        long init = System.currentTimeMillis();
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        
//        for (String string : aux) {
////        	System.out.println("kkkkk 0"+aux);
//			Runnable hilo=new Termino_Hilo(aux,propiedades,numDocs);
//			executor.execute(hilo);
//		}
//        executor.shutdown();	
//        
//        while (!executor.isTerminated()) {
//        	
//        	// Espera a que terminen de ejecutarse todos los procesos 
//        }
//        long fin = System.currentTimeMillis();
//        System.out.println("Tiempo Fin "+(fin-init));
////        
	}

}

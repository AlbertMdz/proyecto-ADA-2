/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import proyectog.ErdosRenyi;
import proyectog.Gilbert;
import proyectog.ModeloGeografico;
import proyectog.BarabasiAlbert;
import proyectog.BFS;
import proyectog.DFS;
/**
 *
 * @author alber
 */
public class prueba {
    public static void main(String[] args) {
        // TODO code application logic here
        try { 
        
        int[] nodos = new int[2];   
        nodos[0] = 20;
        nodos[1] = 100;
            
        for(int numNodos : nodos){
            CrearGrafos(numNodos);
        } 
        }
        catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }        
    }
    
    public static void CrearGrafos(int numNodos){
        ModeloGeografico geo = new ModeloGeografico (numNodos, 0.65f, false, false);
        geo.ConstruyeGrafo();
        geo.EscribeArchivo();
        
        BFS arbolBFS = new BFS(geo, 0);
        try{
            arbolBFS.ConstruyeGrafo();
            arbolBFS.ExploraBFS();
        }
        catch(Exception ex){
            System.out.println("ErrorDeBusqueda: " + ex.getMessage());
        }            
        arbolBFS.EscribeArchivo();
        
        DFS arbolDFS = new DFS(geo, 0);
        try{
            arbolDFS.ConstruyeGrafo();
            arbolDFS.DFSRecursivo(0);
            arbolDFS.EscribeArchivo(); 
            arbolDFS.DFSIterativo(0);
            arbolDFS.EscribeArchivo(); 
            
        }
        catch(Exception ex){
            System.out.println("ErrorDeBusqueda: " + ex.getMessage());
        } 
        
        ErdosRenyi erdos = new ErdosRenyi (numNodos, numNodos, false, false);
        erdos.ConstruyeGrafo();
        erdos.EscribeArchivo();
        
        BFS bfsErdos = new BFS(erdos, 0);
        try{
            bfsErdos.ConstruyeGrafo();
            bfsErdos.ExploraBFS();
        }
        catch(Exception ex){
            System.out.println("ErrorDeBusqueda: " + ex.getMessage());
        }            
        bfsErdos.EscribeArchivo();
        
        
        DFS dfsErdos = new DFS(erdos, 0);
        try{
            dfsErdos.ConstruyeGrafo();
            dfsErdos.DFSRecursivo(0);
            dfsErdos.EscribeArchivo(); 
            dfsErdos.DFSIterativo(0);
            dfsErdos.EscribeArchivo(); 
            
        }
        catch(Exception ex){
            System.out.println("ErrorDeBusqueda: " + ex.getMessage());
        } 
        
        
        Gilbert gil = new  Gilbert(numNodos, 0.6f, false, false);
        gil.ConstruyeGrafo();
        gil.EscribeArchivo();
        BFS bfsGilbert = new BFS(gil, 0);
        try{
            bfsGilbert.ConstruyeGrafo();
            bfsGilbert.ExploraBFS();
        }
        catch(Exception ex){
            System.out.println("ErrorDeBusqueda: " + ex.getMessage());
        }            
        bfsGilbert.EscribeArchivo();
        
        DFS dfsGilbert = new DFS(gil, 0);
        try{
            dfsGilbert.ConstruyeGrafo();
            dfsGilbert.DFSRecursivo(0);
            dfsGilbert.EscribeArchivo(); 
            dfsGilbert.DFSIterativo(0);
            dfsGilbert.EscribeArchivo(); 
            
        }
        catch(Exception ex){
            System.out.println("ErrorDeBusqueda: " + ex.getMessage());
        } 
        
        
        
        BarabasiAlbert barabasi = new BarabasiAlbert(numNodos,(int)(numNodos/5),false, false);
        barabasi.ConstruyeGrafo();
        barabasi.EscribeArchivo();
        int nodo_origen = numNodos -1;
        
        DFS dfsBarabasi = new DFS(barabasi, nodo_origen);
        try{
            dfsBarabasi.ConstruyeGrafo();
            dfsBarabasi.DFSRecursivo(nodo_origen);
            dfsBarabasi.EscribeArchivo(); 
            dfsBarabasi.DFSIterativo(nodo_origen);
            dfsBarabasi.EscribeArchivo(); 
            
        }
        catch(Exception ex){
            System.out.println("ErrorDeBusqueda: " + ex.getMessage());
        } 
        
        BFS bfsBarabasi = new BFS(barabasi, nodo_origen);
        try{
            bfsBarabasi.ConstruyeGrafo();
            bfsBarabasi.ExploraBFS();
        }
        catch(Exception ex){
            System.out.println("ErrorDeBusqueda: " + ex.getMessage());
        }            
        bfsBarabasi.EscribeArchivo();
    }
}
        
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectog;
import java.util.HashMap;
import java.util.Random;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author alber
 */
public abstract class MatrizPrincipal {
    public HashMap<Integer,Nodo> _nodos;
    public HashMap<String,Edge> _aristas;
    protected int _paresDeAristas;
    protected int _numNodos;
    protected boolean _esDirigido;
    protected boolean _aceptaCiclos;
    protected float _probability;
    protected String _algoritmo;
    private int[][] _matrizAdyacencia;
    private List<List<Integer>> _listaAdjacencia;
    
    public abstract Grafo ConstruyeGrafo();
    
    protected HashMap<Integer,Nodo> GeneraNodos(int numNodos){
        _nodos = new HashMap<Integer,Nodo>();
        Nodo n = null;
        try{
            for(int i = 0; i < numNodos; i++){            
                n = new Nodo(i, "N_" + i);            
                _nodos.put(i, n);
            }
        }
        catch(Exception ex){
            System.out.println("GeneraNodosError: " + ex.getMessage());
        }
        return _nodos;
    }
    
    protected HashMap<String,Edge> GeneraAristas(){
        _aristas = new HashMap<String,Edge>();
        int cantidadNodos = _nodos.size();
        int aristasCreadas = 0;
        while(aristasCreadas < this._paresDeAristas){
            for(int nodoOrigen = 0; nodoOrigen < cantidadNodos; nodoOrigen++){
                for(int nodoDestino = 0; nodoDestino < cantidadNodos; nodoDestino++){
                    if( nodoOrigen != nodoDestino ||this._aceptaCiclos){
                        if(SeCreaArista() && !ExisteArista(nodoOrigen, nodoDestino)){                             
                            this._aristas.put(getNombreArista(nodoOrigen, nodoDestino) , new Edge(this._nodos.get(nodoOrigen), this._nodos.get(nodoDestino)));
                            aristasCreadas++;
                            if (aristasCreadas == this._paresDeAristas) return this._aristas;
                        }
                    }
                }
            }
        }
        return this._aristas;
    }
    
    public boolean ExisteArista(int origen, int destino){        
         return this._aristas.containsKey(getNombreArista(origen,destino)) 
                 || this._aristas.containsKey(getNombreArista(destino,origen));
    }
    
    protected String getNombreArista(int origen, int destino){
        String union = this._esDirigido ? "->" : "--";
        return "N_"+origen +" " + union +" N_"+destino;
    }
    
    protected boolean SeCreaArista(){
        boolean seCrea = false;
        Random rand = new Random();        
        float randVal = rand.nextFloat();
        if(randVal <= this._probability){
            seCrea = true;
        }
        return seCrea;       
    }  
    
    protected void ObtenAristasMaximas(int vertices){
        _paresDeAristas = (vertices)*(vertices - 1) / 2;
    }
    
    public List<Integer> getListaAdjacencia(int origen) {
        return _listaAdjacencia.get(origen);
    }

    public int getMatrizAdyacencia(int origen, int destino) {
        return _matrizAdyacencia[origen][destino];
    }
    
    @Override
    public String toString(){
        StringBuilder grafoString = new StringBuilder();
        String tipoGrafo = _esDirigido ? "digraph" : "graph";
        grafoString.append(tipoGrafo);
        grafoString.append(" grafo {\n");
        this._aristas.forEach((key, value) -> {
            grafoString.append(key);
            grafoString.append(";\n");                
        });
        grafoString.append("}");
        System.out.println(grafoString.toString());        
        return grafoString.toString();
    }
    
    public void EscribeArchivo(){        
        try{          
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                     new FileOutputStream( this._algoritmo + "_" + this._numNodos + ".gv"), "utf-8"));
            writer.write(this.toString());
            writer.close();
        }catch(Exception ex){
            System.out.println("Error al imprimir: " + ex.getMessage());
        }   
    }    
}

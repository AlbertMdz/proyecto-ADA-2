/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectog;
import java.util.HashMap;
/**
 *
 * @author alber
 */
public class Grafo {
    protected HashMap<Integer,Nodo> _nodos;
    protected HashMap<String,Edge> _aristas;
    
    private Integer _indiceNodo;
    private Integer _indiceArista;
    public String _algoritmo;

    public Grafo(HashMap<Integer, Nodo> _nodos, HashMap<String, Edge> _aristas) {
        this._nodos = _nodos;
        this._aristas = _aristas;
        _indiceNodo = 0;
        _indiceArista = 0;
        _indiceArista = 0;
    }   
        
    public Grafo() {
        this._nodos = new HashMap<Integer,Nodo>();
        this._aristas = new HashMap<String,Edge>();
        _indiceNodo = 0;
        _indiceArista = 0;
    }

    public HashMap<Integer,Nodo> getNodos() {
        return _nodos;
    }

    public HashMap<String,Edge> getAristas() {
        return _aristas;
    }

    public void setNodos(HashMap<Integer,Nodo> _nodos) {
        this._nodos = _nodos;
    }

    public void setAristas(HashMap<String,Edge> _aristas) {
        this._aristas = _aristas;
    }
    
    public void CrearNodo(Nodo nodo){
        _nodos.put(_indiceNodo, nodo);
        _indiceNodo++;
    }
    
    public void CrearArista(Edge arista){
        _aristas.put(arista.getOrigen().toString() + "_" +arista.getDestino().toString() , arista);        
    }
    
    public void setAlgoritmo(String _algoritmo) {
        this._algoritmo = _algoritmo;
    }

    public String getAlgoritmo() {
        return _algoritmo;
    }
}

package com.emergentes.modelo;
    import java.util.ArrayList;
    import java.util.Iterator;
public class GestorDatos {
    private ArrayList<Datos> lista;
    
    public GestorDatos(){
        lista = new ArrayList<Datos>();
    }

    public ArrayList<Datos> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Datos> lista) {
        this.lista = lista;
    }
    
    public void insertarDatos(Datos item){
        lista.add(item);
    }
    public void modificarDatos(int pos, Datos item){
        lista.set(pos, item);
    }
    public void eliminarDatos (int pos){
        lista.remove(pos);
    }
    public int obtieneId(){
        int idaux = 0;
        for (Datos item : lista){
            idaux = item.getId();
        }
        return idaux + 1;
    }
    public int ubicarDatos(int id){
        int pos = -1;
        Iterator<Datos> it = lista.iterator();
        
        while (it.hasNext()){
            ++pos;
            Datos aux = it.next();
            if(aux.getId() == id){
                break;
            }
        }
        return pos;
    }
}


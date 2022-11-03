public class ListaEnlazada {

    Nodo cabeza;
    int size;

    public ListaEnlazada(){
        cabeza=null;
        size=0;
    }

    public Object obtenerValorIndice(int index){
        if(cabeza==null){
            return "La lista esta vacia";
        }else{
            int contador=0;
            Nodo temporal=cabeza;
            while(contador<index){
                temporal=temporal.obtenerSiguiente();
                contador++;
            }
            return temporal.obtenerValor();
        }
    }

    public Object buscar(Object valor){
        if(cabeza==null){
            return "La lista se encuentra vacia!";
        }else{
            Nodo temp = cabeza;
            while(temp!=null){
                if(temp.obtenerValor()==valor){
                    return "Valor encontrado: " + valor; 
                }
                temp=temp.obtenerSiguiente();
            }
            return "Valor no encontrado";
        }
    }

    //Eliminar un elemento de la lista
    public void eliminarValor(Object valor){
        if(cabeza==null){                                               //si la lista esta vacia me muestra un mensaje
            System.out.println("La lista se encuentra vacia");
        }else{                                                          //si la lista tiene aunque sea 1 elemento 
            Nodo temp = cabeza;                                         //creamos un temporal y lo igualamos a la cabeza
            if(temp.obtenerValor()==valor){                             //Este sera el caso que el valor se encuentra en la cabeza de la lista
                cabeza=temp.obtenerSiguiente();                         // cabeza tendra el valor del siguiente eleneto del temp ya que queremos eliminar ese elemento que es la cabeza
                size--;                                                 //al eliminar un elemento de la lista debemos  disminuir su tamaño
            }else{
                boolean x = false;                                      // una variable booleana que cambiara a true si es que se encuentra el valor
                while(temp.obtenerSiguiente()!=null && x==false){                           //vamos a recorrer la lista hasta saber que el nodo siguiente es null o en otras palabras que la lista se termino
                    if(temp.obtenerSiguiente().obtenerValor()==valor){                      //si ese siguiente valor es el que estamos buscando se tendra que eliminar.
                        temp.enlazarSiguiente(temp.obtenerSiguiente().obtenerSiguiente());      //para eliminar ese siguiente elemento del temporal 
                        size--;                                                                 //nuevamente se disminuye el tamaño
                        x=true;                                                                 //la variable booleana cambia a true que nos ayudara a salir del bucle
                    }else{                                                      //si en cada interaccion no se encuentra el valor pues seguimos avanzando en la lista
                        temp=temp.obtenerSiguiente();
                    }
                }
                if(temp.obtenerValor()==valor){    //salimos del bucle por 1 de estas 2 razones: hemos llegado al ultimo elemento de la lista sin analizarlo "o" hemos encontrado el valor en la lista
                    temp=null;
                    size--;
                    x=true;
                }
                if(x==false){                                                           //entramos aqui solo si la variable boolena nunca cambio a true
                    System.out.println("El valor no se encuentra en la lista");
                }
            }

        }
    }



    public void addPrimero(Object valor){
        if(cabeza==null){
            cabeza = new Nodo(valor);
        }else{
            Nodo nuevo = new Nodo(valor);
            nuevo.siguiente=cabeza;
            cabeza=nuevo;
        }
        size++;
    }

    public void addFinal(Object valor){
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente=null;
        if(cabeza==null){
            cabeza=nuevo;
        }else{
            Nodo temp = cabeza;
            while(temp.obtenerSiguiente()!=null){
                temp=temp.obtenerSiguiente();
            }
            temp.enlazarSiguiente(nuevo);
        }
        size++;
    }



    public boolean estaVacia(){
        return (cabeza==null)?true:false;
    }

    public int size(){
        return size;
    }

    public void mostrarLista(){
        Nodo nodo=cabeza;
        while(nodo!=null){
            System.out.print(nodo.obtenerValor()+"=>");
            nodo=nodo.obtenerSiguiente();
        }
    }
    
}

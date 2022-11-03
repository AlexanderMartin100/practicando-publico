public class main {
    
    public static void main(String[] args) {
    
        ListaEnlazada lista = new ListaEnlazada();

        System.out.println("Esta vacia: "+lista.estaVacia());

        lista.addPrimero(1);
        lista.addPrimero(2);
        lista.addPrimero("Alex");
        lista.addPrimero(4);
        System.out.println("la lista se encuentra vacia, puede agregar los datos para utilizarla");

        lista.mostrarLista();

        lista.eliminarValor(1);

        System.out.println();
        lista.mostrarLista();
        System.out.println();
        System.out.println(lista.obtenerValorIndice(2));
        System.out.println("solo se esta agregando datos para el comflico con la rama1");
        System.out.println("Ejemplode edicion para ignorar archivos");
    }
}

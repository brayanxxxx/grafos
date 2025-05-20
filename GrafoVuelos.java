/**
 * Clase que representa un nodo en la multilista
 */
class Nodo {
    String ciudad;    
    Nodo siguiente;   
    Arista adyacente; 
    
    public Nodo(String ciudad) {
        this.ciudad = ciudad;
        this.siguiente = null;
        this.adyacente = null;
    }
}

/**
 * Clase que representa una arista (vuelo) entre ciudades
 */
class Arista {
    Nodo destino;     
    int peso;         
    Arista siguiente; 
    
    public Arista(Nodo destino, int peso) {
        this.destino = destino;
        this.peso = peso;
        this.siguiente = null;
    }
}

/**
 * Clase principal que implementa el grafo como multilista
 */
public class GrafoVuelos {
    private Nodo primero; 
    
    public GrafoVuelos() {
        this.primero = null;
    }
    
    /**
     * Agrega una nueva ciudad al grafo
     */
    public void agregarCiudad(String nombreCiudad) {
        // Verificar si la ciudad ya existe
        if (buscarCiudad(nombreCiudad) != null) {
            System.out.println("La ciudad " + nombreCiudad + " ya existe");
            return;
        }
        
        // Crear nuevo nodo para la ciudad
        Nodo nuevo = new Nodo(nombreCiudad);
        
        // Si es la primera ciudad
        if (primero == null) {
            primero = nuevo;
            System.out.println("Ciudad " + nombreCiudad + " agregada como primera ciudad");
            return;
        }
        
        // Agregar al final de la lista
        Nodo actual = primero;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevo;
        System.out.println("Ciudad " + nombreCiudad + " agregada correctamente");
    }
    
    /**
     * Busca una ciudad en el grafo
     */
    private Nodo buscarCiudad(String nombreCiudad) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.ciudad.equals(nombreCiudad)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }
    
    /**
     * Agrega un vuelo (arista) entre dos ciudades
     */
    public void agregarVuelo(String origen, String destino, int peso) {
        // Buscar las ciudades
        Nodo nodoOrigen = buscarCiudad(origen);
        Nodo nodoDestino = buscarCiudad(destino);
        
        // Verificar si ambas ciudades existen
        if (nodoOrigen == null || nodoDestino == null) {
            System.out.println("Error: Una o ambas ciudades no existen");
            return;
        }
        
        // Agregar arista de origen a destino
        agregarArista(nodoOrigen, nodoDestino, peso);
        
        // Agregar arista de destino a origen (grafo no dirigido)
        agregarArista(nodoDestino, nodoOrigen, peso);
        
        System.out.println("Vuelo agregado entre " + origen + " y " + destino);
    }
    
    /**
     * Método auxiliar para agregar una arista entre dos nodos
     */
    private void agregarArista(Nodo origen, Nodo destino, int peso) {
        // Crear nueva arista
        Arista nueva = new Arista(destino, peso);
        
        // Si es la primera arista para esta ciudad
        if (origen.adyacente == null) {
            origen.adyacente = nueva;
            return;
        }
        
        // Verificar si ya existe un vuelo al mismo destino
        Arista actual = origen.adyacente;
        while (actual.siguiente != null) {
            if (actual.destino.ciudad.equals(destino.ciudad)) {
                // Actualizar el peso si ya existe
                actual.peso = peso;
                return;
            }
            actual = actual.siguiente;
        }
        
        // Verificar la última arista
        if (actual.destino.ciudad.equals(destino.ciudad)) {
            actual.peso = peso;
            return;
        }
        
        // Agregar al final de la lista de aristas
        actual.siguiente = nueva;
    }
    
    /**
     * Muestra todos los vuelos disponibles en el sistema
     */
    public void mostrarVuelos() {
        if (primero == null) {
            System.out.println("No hay ciudades registradas");
            return;
        }
        
        System.out.println("\n===== VUELOS DISPONIBLES =====");
        Nodo actual = primero;
        
        while (actual != null) {
            System.out.println("\nDesde " + actual.ciudad + " hacia:");
            if (actual.adyacente == null) {
                System.out.println("  No hay vuelos disponibles");
            } else {
                Arista arista = actual.adyacente;
                while (arista != null) {
                    System.out.println("  → " + arista.destino.ciudad + 
                                       " (Distancia/Costo: " + arista.peso + ")");
                    arista = arista.siguiente;
                }
            }
            actual = actual.siguiente;
        }
    }
    
    /**
     * Verifica si existe un vuelo directo entre dos ciudades
     */
    public boolean existeVueloDirecto(String origen, String destino) {
        Nodo nodoOrigen = buscarCiudad(origen);
        
        if (nodoOrigen == null) {
            return false;
        }
        
        Arista arista = nodoOrigen.adyacente;
        while (arista != null) {
            if (arista.destino.ciudad.equals(destino)) {
                return true;
            }
            arista = arista.siguiente;
        }
        
        return false;
    }
    
    /**
     * Programa principal para probar la estructura
     */
    public static void main(String[] args) {
        GrafoVuelos grafo = new GrafoVuelos();
        
        // Agregar ciudades
        grafo.agregarCiudad("Madrid");
        grafo.agregarCiudad("Barcelona");
        grafo.agregarCiudad("Valencia");
        grafo.agregarCiudad("Sevilla");
        
        // Agregar vuelos
        grafo.agregarVuelo("Madrid", "Barcelona", 600);
        grafo.agregarVuelo("Madrid", "Valencia", 350);
        grafo.agregarVuelo("Barcelona", "Valencia", 350);
        grafo.agregarVuelo("Valencia", "Sevilla", 650);
        
        // Mostrar todos los vuelos
        grafo.mostrarVuelos();
        
        // Comprobar vuelo directo
        String origen = "Madrid";
        String destino = "Barcelona";
        boolean hayVuelo = grafo.existeVueloDirecto(origen, destino);
        System.out.println("\n¿Existe vuelo directo de " + origen + " a " + 
                           destino + "? " + (hayVuelo ? "Sí" : "No"));
    }
} 
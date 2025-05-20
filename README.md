# ✈️ Grafo de Vuelos en Java (Multilista)

Este proyecto implementa un grafo no dirigido utilizando una estructura de **multilista** para representar vuelos entre distintas ciudades. Cada ciudad se conecta con otras a través de aristas (vuelos), que almacenan el destino y el costo/distancia.

---


---

## 🚀 Cómo ejecutar el proyecto

### ✅ Requisitos

- Tener instalado [Java JDK](https://jdk.java.net/) (versión 8 o superior).
- Tener [Visual Studio Code](https://code.visualstudio.com/) con la extensión **Java Extension Pack**.

### ▶️ Pasos

1. Abre VSCode y abre la carpeta del proyecto `GrafoVuelos`.
2. Asegúrate de tener el archivo `GrafoVuelos.java` con el código fuente.
3. Abre una terminal en VSCode (menú superior: `Terminal → Nueva terminal`).
4. Ejecuta los siguientes comandos:

```bash
javac GrafoVuelos.java   # Compila el archivo Java
java GrafoVuelos         # Ejecuta el programa


📌 Funcionalidades
📍 Agregar nuevas ciudades al grafo.

✈️ Conectar ciudades mediante vuelos (aristas con peso).

🗺️ Mostrar todos los vuelos registrados.

🔍 Verificar si existe un vuelo directo entre dos ciudades.

📋 Ejemplo de salida
Ciudad Madrid agregada como primera ciudad
Ciudad Barcelona agregada correctamente
Ciudad Valencia agregada correctamente
Ciudad Sevilla agregada correctamente
Vuelo agregado entre Madrid y Barcelona
Vuelo agregado entre Madrid y Valencia
Vuelo agregado entre Barcelona y Valencia
Vuelo agregado entre Valencia y Sevilla

===== VUELOS DISPONIBLES =====

Desde Madrid hacia:
  → Barcelona (Distancia/Costo: 600)
  → Valencia (Distancia/Costo: 350)

Desde Barcelona hacia:
  → Madrid (Distancia/Costo: 600)
  → Valencia (Distancia/Costo: 350)

Desde Valencia hacia:
  → Madrid (Distancia/Costo: 350)
  → Barcelona (Distancia/Costo: 350)
  → Sevilla (Distancia/Costo: 650)

Desde Sevilla hacia:
  → Valencia (Distancia/Costo: 650)

¿Existe vuelo directo de Madrid a Sevilla? No

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Verifica si se proporcionó la ruta del archivo de alineación como argumento
        if (args.length != 1) {
            System.err.println("Debes proporcionar la ruta del archivo de alineación.");
            return;
        }

        // Obtiene la ruta del archivo de alineación del primer argumento
        String archivoAlineacion = args[0];

        // Crea una lista de jugadores con información predeterminada
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("paquito", 25, "Delantero"));
        jugadores.add(new Jugador("juan", 30, "Centrocampista"));
        jugadores.add(new Jugador("lonchas", 28, "Defensor"));
        jugadores.add(new Jugador("zapatin", 27, "Portero"));
        jugadores.add(new Jugador("cilantro", 29, "Centrocampista"));
        jugadores.add(new Jugador("pablito", 25, "Delantero"));
        jugadores.add(new Jugador("saulin", 30, "Centrocampista"));
        jugadores.add(new Jugador("carlos", 28, "Defensor"));
        jugadores.add(new Jugador("leni", 27, "Portero"));
        jugadores.add(new Jugador("jose", 29, "Centrocampista"));
        jugadores.add(new Jugador("alfredo", 29, "Centrocampista"));

        // Lista para almacenar los números de alineación
        ArrayList<Integer> numerosAlineacion = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoAlineacion))) {
            String line;
            // Lee cada línea del archivo y agrega el número de alineación a la lista
            while ((line = reader.readLine()) != null) {
                numerosAlineacion.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de alineación: " + e.getMessage());
            return;
        }

        // Genera el archivo "Generador de alineación" con la información de los jugadores correspondientes
        try (PrintWriter writer = new PrintWriter(new FileWriter("Generador de alineacion.txt"))) {
            for (Integer numero : numerosAlineacion) {
                if (numero >= 1 && numero <= jugadores.size()) {
                    Jugador jugador = jugadores.get(numero - 1);
                    writer.println("Número: " + numero);
                    writer.println(jugador);
                    writer.println();
                } else {
                    System.err.println("Número de alineación no válido: " + numero);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo de generación de alineación: " + e.getMessage());
        }
    }
}
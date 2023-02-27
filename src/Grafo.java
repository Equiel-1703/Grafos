import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Grafo {
    private Byte[][] matrizAdjacencia;
    private HashMap<String, Integer> vertices = new HashMap<>();
    private List<String> verticesByIndex = new LinkedList<>();
    private int numVertices = 0;
    private int size;

    public Grafo(int size)
    {
        this.matrizAdjacencia = new Byte[size][size];
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                matrizAdjacencia[i][j] = 0;
            }
        }

        this.size = size;
    }

    public void inserirVertice(String nomeVertice) {
        if(numVertices == size)
            throw new ArrayIndexOutOfBoundsException("O número de vértices não pode ser maior que 20.");

        verticesByIndex.add(nomeVertice);
        vertices.put(nomeVertice, numVertices++);
    }

    public void inserirAresta(String v1, String v2, byte peso) {
        Integer x = vertices.get(v1);
        Integer y = vertices.get(v2);

        if(x == null || y == null)
            throw new InvalidParameterException("Um dos vértices não existe.");

        matrizAdjacencia[x][y] = peso;
    }

    public Byte[][] getMatrizAdjacencia() {
        return matrizAdjacencia;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public String getVerticeByIndex(int i) {
        return verticesByIndex.get(i);
    }

}

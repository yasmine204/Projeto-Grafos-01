import java.util.LinkedList;

class Grafo {
    
    private int vertices;
    private int grauEntrada;
    private int grauSaida;
    private int consulta;
    private LinkedList<LinkedList<Integer>> listaAdjacencia;

    // CONSTRUTOR
    Grafo (int vertices, int consulta) {
        this.vertices = vertices;
        this.consulta = consulta;
        listaAdjacencia = new LinkedList<LinkedList<Integer>>();
    }

    public void build () {
        for (int i = 0; i <= vertices; i ++) {
            listaAdjacencia.add(new LinkedList<Integer>());
        }
    }

    public void addEdge (int vertice1, int vertice2) {
        listaAdjacencia.get(vertice1).add(vertice2);
    }

    public void countDegree () {
        grauSaida = listaAdjacencia.get(consulta).size();

        int cont = 0;

        for (int i = 0; i <= vertices; i ++) {
            if (listaAdjacencia.get(i).contains(consulta)) {
                cont ++;
            }
        }

        grauEntrada = cont;
    }

    public void printInformation () {
        System.out.println("\nInformações sobre o vértice consultado [" + consulta + "]");
        System.out.println("\nGrau de saída do vértice -> " + grauSaida);
        System.out.println("Grau de entrada do vértice -> " + grauEntrada);

        System.out.print("Conjunto dos seus sucessores -> [ ");
        if (listaAdjacencia.get(consulta).size() != 0) {
            for (int j: listaAdjacencia.get(consulta)) {
                System.out.print(j + " ");
            }
            System.out.println("]");
        }

        System.out.print("Conjunto dos seus predecessores -> [ ");
        for (int j = 0; j <= vertices; j ++) {
            if (listaAdjacencia.get(j).contains(consulta)) {
                System.out.print(j + " ");
            }
        }
        System.out.println("]\n");
    }

}

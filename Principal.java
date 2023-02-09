import java.util.Scanner;

public class Principal {

    public static void main (String[] args) {
        Scanner enter = new Scanner(System.in);

        String path;
        String[] numeros;
        int vertices, consulta;
        int vertice1, vertice2;

        System.out.println("\n--------- Bem-vindo(a) ao sistema! ---------\n");

        System.out.println("Digite o nome do arquivo que deseja abrir.");
        System.out.print("> ");
        path = enter.nextLine();

        System.out.println("\nDigite o vértice que deseja consultar.");
        System.out.print("> ");
        consulta = enter.nextInt();

        // Instancia um abjeto arquivo do tipo <MANIPULADOR> 
        Manipulador arquivo = new Manipulador(path);

        // Guarda informações
        numeros = arquivo.read();
        vertices = Integer.parseInt(numeros[0]);

        // Instancia um objeto gf do tipo <GRAFO> e constrói a lista de adjacência
        Grafo gf = new Grafo(vertices, consulta);
        gf.build();

        // Lê o arquivo todo e adiciona as arestas do grafo
        while ((numeros = arquivo.read()) != null) {
            vertice1 = Integer.parseInt(numeros[0]); 
            vertice2 = Integer.parseInt(numeros[1]);

            gf.addEdge(vertice1, vertice2);            
        }

        // Conta os graus do vértice consultado
        gf.countDegree();

        // Printa as iformações necessárias 
        gf.printInformation();

        arquivo.close();
        enter.close();
    }
}
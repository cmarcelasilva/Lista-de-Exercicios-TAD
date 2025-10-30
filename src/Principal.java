import java.util.Scanner;
public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista lista = new Lista(); // Instancia as TADs
        Pilha pilha = new Pilha();
        Fila fila = new Fila();
        int opcao = -1;


        // =================================================================
                             // MAIN E MENUS INTERATIVOS
        // =================================================================
        while (opcao != 0) {
            System.out.println("\n*** Menu TAD (Estruturas de Dados) ***");
            System.out.println("1. Testar Lista");
            System.out.println("2. Testar Pilha");
            System.out.println("3. Testar Fila");
            System.out.println("0. Encerrar os testes");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        menuLista(scanner, lista);
                        break;
                    case 2:
                        menuPilha(scanner, pilha);
                        break;
                    case 3:
                        menuFila(scanner, fila);
                        break;
                    case 0:
                        System.out.println("Saindo do programa. Até mais!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                opcao = -1;
            }
        }
        scanner.close();
    }

    // Métodos de menu

    private static void menuLista(Scanner scanner, Lista lista) {
        int opcaoLista = -1;
        while (opcaoLista != 0) {
            System.out.println("\n--- Teste de Lista ---");
            System.out.println("1. Inserir valor");
            System.out.println("2. Mostrar lista");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcaoLista = scanner.nextInt();
                scanner.nextLine();

                switch (opcaoLista) {
                    case 1:
                        System.out.print("Digite o valor inteiro para inserir: ");
                        if (scanner.hasNextInt()) {
                            lista.inserir(scanner.nextInt());
                            scanner.nextLine();
                        } else {
                            System.out.println("Entrada inválida.");
                            scanner.nextLine();
                        }
                        break;
                    case 2:
                        lista.mostrar();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                opcaoLista = -1;
            }
        }
    }

    private static void menuPilha(Scanner scanner, Pilha pilha) {
        int opcaoPilha = -1;
        while (opcaoPilha != 0) {
            System.out.println("\n--- Teste de Pilha ---");
            System.out.println("1. Empilhar valor");
            System.out.println("2. Desempilhar valor");
            System.out.println("3. Mostrar pilha");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcaoPilha = scanner.nextInt();
                scanner.nextLine();

                switch (opcaoPilha) {
                    case 1:
                        System.out.print("Digite o valor inteiro para empilhar: ");
                        if (scanner.hasNextInt()) {
                            pilha.empilhar(scanner.nextInt());
                            scanner.nextLine();
                        } else {
                            System.out.println("Entrada inválida.");
                            scanner.nextLine();
                        }
                        break;
                    case 2:
                        int desempilhado = pilha.desempilhar();
                        if (desempilhado != -1) {
                            System.out.println("Valor desempilhado: " + desempilhado);
                        }
                        break;
                    case 3:
                        pilha.mostrar();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                opcaoPilha = -1;
            }
        }
    }

    private static void menuFila(Scanner scanner, Fila fila) {
        int opcaoFila = -1;
        while (opcaoFila != 0) {
            System.out.println("\n--- Teste de Fila ---");
            System.out.println("1. Enfileirar valor");
            System.out.println("2. Desenfileirar valor");
            System.out.println("3. Mostrar fila");
            System.out.println("0. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcaoFila = scanner.nextInt();
                scanner.nextLine();

                switch (opcaoFila) {
                    case 1:
                        System.out.print("Digite o valor inteiro para enfileirar: ");
                        if (scanner.hasNextInt()) {
                            fila.enfileirar(scanner.nextInt());
                            scanner.nextLine();
                        } else {
                            System.out.println("Entrada inválida.");
                            scanner.nextLine();
                        }
                        break;
                    case 2:
                        int desenfileirado = fila.desenfileirar();
                        if (desenfileirado != -1) {
                            System.out.println("Valor desenfileirado: " + desenfileirado);
                        }
                        break;
                    case 3:
                        fila.mostrar();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scanner.nextLine();
                opcaoFila = -1;
            }
        }
    }
}



    // =================================================================
    //                           CLASSE LISTA
    // =================================================================

    class Lista {
        private int[] dados;
        private int tamanhoAtual;
        private final int CAPACIDADE = 5;

        public Lista() {

            this.dados = new int[CAPACIDADE];
            this.tamanhoAtual = 0;
        }

        // Método para inserir um valor na lista
        public boolean inserir(int valor) {
            if (tamanhoAtual < CAPACIDADE) {
                dados[tamanhoAtual] = valor;
                tamanhoAtual++;
                return true;
            } else {
                System.out.println("Lista cheia! Não foi possível inserir " + valor);
                return false;
            }
        }

        // Método para exibir o estado atual da estrutura
        public void mostrar() {
            System.out.print("Lista: [");
            for (int i = 0; i < tamanhoAtual; i++) {
                System.out.print(dados[i]);
                if (i < tamanhoAtual - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");


        }
    }


    // =================================================================
                              // CLASSE PILHA
    // =================================================================
    class Pilha {
        private int[] dados; // O ARRAY de inteiros para armazenar os elementos
        private int topo;
        private final int CAPACIDADE = 5;

        public Pilha() {
            this.dados = new int[CAPACIDADE];
            this.topo = -1; // Pilha vazia
        }

        // Método para empilhar um valor
        public boolean empilhar(int valor) {
            if (topo < CAPACIDADE - 1) {
                topo++;
                dados[topo] = valor; // Insere no topo do array
                return true;
            } else {
                System.out.println("Pilha cheia! Não foi possível empilhar " + valor);
                return false;
            }
        }

        // Método para desempilhar um valor
        public int desempilhar() {
            if (topo >= 0) {
                int valor = dados[topo]; // Pega o valor do topo do array
                topo--;
                return valor;
            } else {
                System.out.println("Pilha vazia! Não é possível desempilhar.");
                return -1;
            }
        }

        // Método para exibir o estado atual da estrutura
        public void mostrar() {
            System.out.print("Pilha: [");
            for (int i = 0; i <= topo; i++) {
                System.out.print(dados[i]);
                if (i < topo) {
                    System.out.print(" -> ");
                }
            }
            System.out.println("]");
        }
    }

    // =================================================================
    //                            CLASSE FILA
    // =================================================================
    class Fila {
        private int[] dados;
        private int inicio;
        private int fim;
        private int tamanhoAtual;
        private final int CAPACIDADE = 5;

        public Fila() {
            this.dados = new int[CAPACIDADE];
            this.inicio = 0;
            this.fim = 0;
            this.tamanhoAtual = 0;
        }

        // Método enfileirar(int valor)
        public boolean enfileirar(int valor) {
            if (tamanhoAtual < CAPACIDADE) {
                dados[fim] = valor;
                fim = (fim + 1) % CAPACIDADE; // Fila Circular
                tamanhoAtual++;
                return true;
            } else {
                System.out.println("Fila cheia! Não foi possível enfileirar " + valor);
                return false;
            }
        }

        // Método desenfileirar()
        public int desenfileirar() {
            if (tamanhoAtual > 0) {
                int valor = dados[inicio];
                inicio = (inicio + 1) % CAPACIDADE; // Fila Circular
                tamanhoAtual--;
                return valor;
            } else {
                System.out.println("Fila vazia! Não é possível desenfileirar.");
                return -1;
            }
        }

        // Método mostrar()
        public void mostrar() {
            System.out.print("Fila (Elementos: " + tamanhoAtual + "/" + CAPACIDADE + "): [");
            if (tamanhoAtual > 0) {
                for (int i = 0; i < tamanhoAtual; i++) {
                    int indice = (inicio + i) % CAPACIDADE;
                    System.out.print(dados[indice]);
                    if (i < tamanhoAtual - 1) {
                        System.out.print(" <- "); // Ordem do Início para o Fim
                    }
                }
            }
            System.out.println("]");
        }
    }




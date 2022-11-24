import java.util.Random;
import java.util.Scanner;

public class Program {

    public static int[] vetorDoBubble;
    public static  int[] vetorDoSelection;
    public static int[] vetorDoInsertion;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Digite o tamanho do vetor");
        int tamanho = sc.nextInt();
        vetorDoBubble = new int[tamanho];
        vetorDoInsertion = new int[tamanho];
        vetorDoSelection = new int[tamanho];
        System.out.println("Digite 1 para ter valores escolhidos pelo usuário ou 2 para valores aleatórios");
        int escolha = sc.nextInt();

        if(escolha == 1){
            perguntarValoresAoUsuario(tamanho);
        }else{
            gerarValoresAleatorios(tamanho);
        }

        System.out.println("Vetor antes das mudanças: ");
        printarVetor(vetorDoBubble);
        System.out.println("Vetor com o selection sorter");
        selectionSort(vetorDoSelection);
        System.out.println("Vetor com o bubble sorter: ");
        bubbleSorter(vetorDoBubble);
        System.out.println("Vetor com o insertion sorter: ");
        insertionSort(vetorDoInsertion);


    }

    public static void selectionSort(int[] list) {
        int trocas = 0;
        for (int i = 0; i < list.length - 1; i++) {
            
            int menorAtual = list[i];
            int menorAtualIndex = i;
            for (int j = i + 1; j < list.length; j++) { 
                if (menorAtual > list[j]) { 
                    menorAtual = list[j];
                    menorAtualIndex = j;
                }
            }
            
            if (menorAtualIndex != i) { 
                list[menorAtualIndex] = list[i];
                list[i] = menorAtual;
                trocas += 2;
            }
        }
        System.out.println("Trocas realizadas pelo selection sorter: " + trocas);
        printarVetor(list);
    }

    public static void bubbleSorter(int[] vetor){
        int trocas = 0;

        for(int bigCount = 0; bigCount < vetor.length; bigCount++) {
            for (int count = 0; count < vetor.length - 1; count++) {
                int current = vetor[count];

                if (vetor[count] > vetor[count + 1]) {
                    vetor[count] = vetor[count + 1];
                    vetor[count + 1] = current;
                    trocas += 2;
                }
            }
        }
        System.out.println("Trocas realizadas pelo bubble sorter: " + trocas);
        printarVetor(vetor);
    }

    public static void insertionSort(int[] vetor){
        int trocas = 0;
        int temp;

        for (int i = 1; i < vetor.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(vetor[j] < vetor[j-1]){
                    temp = vetor[j];
                    vetor[j] = vetor[j-1];
                    vetor[j-1] = temp;
                    trocas +=2;
                }
            }
        }
        System.out.println("Trocas realizadas pelo insertion sorter: " + trocas);
        printarVetor(vetor);
    }

    public static void printarVetor(int[] vetor){
        for(int count = 0; count < vetor.length; count++){
            System.out.println(vetor[count]);
        }
    }

    public static void perguntarValoresAoUsuario(int tamanhoDoVetor){
        Scanner sc = new Scanner(System.in);

        for(int count = 0; count < tamanhoDoVetor; count++){
            System.out.println("Digite o valor da posição " + count+1);
            int numero = sc.nextInt();
            vetorDoBubble[count] = numero;
            vetorDoInsertion[count] = numero;
            vetorDoSelection[count] = numero;
        }

    }

    public static void gerarValoresAleatorios(int tamanhoDoVetor){

        Random random = new Random();

        for(int count = 0; count < tamanhoDoVetor; count++){
            int numero = random.nextInt(30);
            vetorDoBubble[count] = numero;
            vetorDoSelection[count] = numero;
            vetorDoInsertion[count] = numero;
        }
    }


}

import java.util.Random;
import java.util.Scanner;

public class Program {

    public static int[] vetorDoBubble;
    public static  int[] vetorDoSelection;
    public static int[] vetorDoInsertion;

    public static int trocasDoBubble = 0;
    public static int trocasDoInsertion = 0;
    public static int trocasDoSelection = 0;

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

        System.out.println("Vetor com o bubble sorter: ");
        bubbleSorter(vetorDoBubble);
        System.out.println("Vetor com o selection sorter");
        selectionSort(vetorDoSelection);
        System.out.println("Vetor com o insertion sorter: ");
        insertionSort(vetorDoInsertion);

        int min = Math.min(trocasDoBubble, Math.min(trocasDoInsertion, trocasDoSelection));



        if(min == trocasDoInsertion){
            System.out.println("Insertion é o mais eficiente");
        }

        if(min == trocasDoBubble){
            System.out.println("Bubble é o mais eficiente");
        }

        if(min == trocasDoSelection){
            System.out.println("Selection é o mais eficiente");
        }


    }

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            
            int menorAtual = list[i];
            int menorAtualIndex = i;
            trocasDoSelection +=2;
            for (int j = i + 1; j < list.length; j++) { 
                if (menorAtual > list[j]) { 
                    menorAtual = list[j];
                    menorAtualIndex = j;
                    trocasDoSelection +=2;
                }
            }
            
            if (menorAtualIndex != i) { 
                list[menorAtualIndex] = list[i];
                list[i] = menorAtual;
                trocasDoSelection += 2;
            }
        }
        System.out.println("Trocas realizadas pelo selection sorter: " + trocasDoSelection);
        printarVetor(list);
    }

    public static void bubbleSorter(int[] vetor){

        for(int bigCount = 0; bigCount < vetor.length; bigCount++) {
            for (int count = 0; count < vetor.length - 1; count++) {
                int current = vetor[count];
                trocasDoBubble+=1;

                if (vetor[count] > vetor[count + 1]) {
                    vetor[count] = vetor[count + 1];
                    vetor[count + 1] = current;
                    trocasDoBubble += 2;
                }
            }
        }
        System.out.println("Trocas realizadas pelo bubble sorter: " + trocasDoBubble);
        printarVetor(vetor);
    }

    static void insertionSort(int vetor[]) {
        for (int i = 1, j; i < vetor.length; i++) {
            int temp = vetor[i];
            trocasDoInsertion +=1;
            for (j = i; j > 0 && temp < vetor[j - 1]; j--) {
                vetor[j] = vetor[j - 1];
                trocasDoInsertion+=1;
            }
            vetor[j] = temp;
            trocasDoInsertion+=1;
        }

        System.out.println("Trocas realizadas pelo insertion sorter: " + trocasDoInsertion);
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

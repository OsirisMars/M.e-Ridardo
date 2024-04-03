import javax.swing.*; // comando para gerenciar as interfaces gráficas
import java.util.Scanner;// função para identificar o que está sendo escrito no teclado

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arvore arvorebinaria = new Arvore();

        int opcao = -1;
        int numero = 0;
        while (opcao != 0){
            System.out.println("MENU");
            System.out.println("1 - Inserir valor na árvore");
            System.out.println("2 - Nível de um nó");
            System.out.println("3 - Nível da árvore");
            System.out.println("4 - Profundidade do nó");
            System.out.println("5 - Profundidade da árvore");
            System.out.println("6 - Altura do nó");
            System.out.println("7 - Altura da árvore");
            System.out.println("8 - Impressão da árvore");
            System.out.println("9 - Nós percurso LRN (pós-ordem)");
            System.out.println("10 - Nós percurso NLR (pré-ordem)");
            System.out.println("11 - Nós percurso LNR (em-ordem)");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt(); // prints das opções com os scanners

            switch (opcao){ // comando "JOptionPane.showInputDialog" é o responsavel por mostrar o pop up para inserir as informações e mostrar as respostas do código
                case 1: // comando para inserir os numeros da arvore
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um Valor: "));
                    arvorebinaria.insereValor(numero);
                    break;
                case 2: // comando para mostrar o nível do nó
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um Valor do Nó: "));
                    int nivel = arvorebinaria.nivelProfundidadeNo(numero);
                    if (nivel == -1) { // sempre retornará "-1" se o valor informado for um valor inesistente na arvore
                        JOptionPane.showMessageDialog(null, "Nó: "+ numero + " não existe na árvore");
                    } else if (nivel == 0) {
                        JOptionPane.showMessageDialog(null, "Nó: "+ numero + " é a RAIZ da árvore, Nível: 0");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó: "+ numero + " tem o nível: " + nivel);
                    }
                    break;
                case 3: // comando para mostrar  nível de uma árvore
                    int nivelarvore = arvorebinaria.nivelProfundidadeAlturaArvore();
                    if (nivelarvore == -1) { // sempre retornará "-1" se não existir nenhuma arvore
                        JOptionPane.showMessageDialog(null, "Não existe árvore");
                    } else {
                        JOptionPane.showMessageDialog(null, "O Nível da árvore é: " + nivelarvore);
                    }
                    break;
                case 4: // comando para mostrar  a profundidade do nó
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um Valor do Nó: "));
                    int profundidade = arvorebinaria.nivelProfundidadeNo(numero);
                    if (profundidade == -1) {
                        JOptionPane.showMessageDialog(null, "Nó: "+ numero + " não existe na árvore");
                    } else if (profundidade == 0) {
                        JOptionPane.showMessageDialog(null, "Nó: "+ numero + " é a RAIZ da árvore, Profundidade: 0");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó: "+ numero + " tem a profundidade: " + profundidade);
                    }
                    break;
                case 5: // comando para mostrar a profundidade da árvore
                    int profundidadearvore = arvorebinaria.nivelProfundidadeAlturaArvore();
                    if (profundidadearvore == -1) {
                        JOptionPane.showMessageDialog(null, "Não existe árvore");
                    } else {
                        JOptionPane.showMessageDialog(null, "A profundidade da árvore é: " + profundidadearvore);
                    }
                    break;
                case 6: // comando para mostrar a autura do nó
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um Valor do Nó: "));
                    int altura = arvorebinaria.alturaNo(numero);
                    if (altura == -1) {
                        JOptionPane.showMessageDialog(null, "Nó: "+ numero + " não existe na árvore");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nó: "+ numero + " tem a altura: " + altura);
                    }
                    break;
                case 7: // comando para mostrar a autura da árvore
                    int alturaarvore = arvorebinaria.nivelProfundidadeAlturaArvore();
                    if (alturaarvore == -1) {
                        JOptionPane.showMessageDialog(null, "Não existe árvore");
                    } else {
                        JOptionPane.showMessageDialog(null, "A altura da árvore é: " + alturaarvore);
                    }
                    break;
                case 8: // comando para imprimir a arvore
                    arvorebinaria.imprimeArvore();
                    break;
                case 9: // comando para imprimir os valores da arvore em pos ordem
                    arvorebinaria.arvorePosOrdem();
                    break;
                case 10: // comando para imprimir os valores da arvore em pre ordem
                    arvorebinaria.arvorePreOrdem();
                    break;
                case 11: // comando para imprimir os valores da arvore em in ordem
                    arvorebinaria.arvoreInOrdem();
                    break;
            }
        }
    }
}
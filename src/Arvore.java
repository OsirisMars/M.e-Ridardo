public class Arvore { // classe criadora da Árvore
    No raiz; // identifica o nó raiz

    Arvore() {
        this.raiz = null; // define o nó raiz como nulo no começo da operação
    }

    public void insereValor(int valor){ // função que recebe o valor
        if (this.raiz == null) { // se o valor da raiz ainda for nulo, o valor inserido será a raiz
            raiz = new No(valor);
        } else { // se o valor da raiz não for nulo, o valor inserido será enviado para a função "insereFilho"
            raiz = insereFilho(raiz, valor);
        }
    }

    public No insereFilho(No no, int valor) { // função que cria os nós filhos
        if (no == null) { // se o nó filho daquela raiz for nulo, ele criara um novo nó
            return new No(valor);
        }
        if (valor < no.valor) { // se o valor desse nó for menor que o nó anterior (ou nó pai), ele irá ser posicionado no lado esquerdo
            no.esquerda = insereFilho(no.esquerda, valor);
        } else if (valor > no.valor) { // se o valor desse nó for maior que o nó anterior (ou nó pai), ele irá ser posicionado no lado direito
            no.direita = insereFilho(no.direita, valor);
        }
        return no;
    }

    public int nivelProfundidadeNo(int valor) { // função para identificar a profundidade do nó
        if (raiz.valor == valor) { // se o valor recebido for igual ao valor da raiz, então ele retornara o valor "0"
            return 0;
        } else { // se não, ele chamará a função "nivelProfundidadeFilho"
            return nivelProfundidadeFilho(raiz, valor, 0);
        }
    }

    public int nivelProfundidadeFilho(No no, int valor, int niveleprofundidade) { // função para identifica a profundidade do nó filho
        if (no == null) { // se o valor recebido não estiver dentro da árvore ele retornará o valor -1 (que identifica um erro)
            return -1;
        }
        if (no.valor == valor) {
            return niveleprofundidade;
        }
        if (no.valor > valor) {
            niveleprofundidade = nivelProfundidadeFilho(no.esquerda, valor, niveleprofundidade + 1);
        } else {
            niveleprofundidade = nivelProfundidadeFilho(no.direita, valor, niveleprofundidade + 1);
        }
        return niveleprofundidade; // se o valor recebido estiver dentro da árvore ele irá executar até achar esse valor e passar a posição de onde ele esta
    }

    public int nivelProfundidadeAlturaArvore() { // função que referencia 3 opções de escolha do usuário
        return verificaProfundidade(raiz, -1);
    }

    public int verificaProfundidade(No no, int valor) { // função responsável pela verificação da profundidade da árvore pesquisando os nós filhos
        if (no == null) { // se no == null significa que chegou no final da árvore e retorna o valor que é a profundidade da árvore
            return valor;
        }
        int esquerda = verificaProfundidade(no.esquerda, valor +1); // chama os valores da esquerda
        int direita = verificaProfundidade(no.direita, valor + 1); // chama os valores da direita

        if (esquerda > direita) { // se o valor da esquerda for maior que o da direita, ele retornará o valor da esquerda
            return esquerda;
        } else { // se não, ele irá voltar o valor da direita
            return direita;
        }
    }

    public int alturaNo(int valor) { //função responsável para achar a altura de um nó
        return buscaNo(raiz, valor);
    }

    public int buscaNo(No no, int valor) {  // função para achar o nó específico
        if (no == null) { // se o valor passado não estiver dentro da árvore (ou seja dar como nulo) ele irá retornar o valor com uma mensagem de erro
            return -1;
        }
        if (no.valor == valor) { // se o valor do nó for igual a o da raiz, ele retornará "-1" representando a raiz
            return verificaAlturaFilho(no, -1);
        } else if (no.valor > valor) { // se o valor do nó for menor que o valor do nó "pai", ele chama a função novamente para verificar pelo nó da esquerda
            return buscaNo(no.esquerda, valor);
        } else if (no.valor < valor){ // se o valor do nó for menor que o valor do nó "pai", ele chama a função novamente para verificar pelo nó da direita
            return buscaNo(no.direita, valor);
        }
        return -1;
    }

    public int verificaAlturaFilho(No no, int altura) { // função para verificar a altura dos nós filhos
        if (no == null) { // se no == null significa que chegou no final da árvore e retorna o valor que é a altura da árvore
            return altura;
        }

        int esquerda = verificaAlturaFilho(no.esquerda, altura + 1); // chama os nós da esquerda
        int direita = verificaAlturaFilho(no.direita, altura + 1); // chama os nós da direita

        if (esquerda > direita) { // se o valor da esquerda for maior que o da direita, ele retorna o valor da esquerda
            return esquerda;
        } else { // se não, ele retornará o valor da direita
            return direita;
        }
    }

    public void imprimeArvore() { // função que mostra a árvore montada
        imprimeArvoreFormatada(raiz,0);
    }

    public void imprimeArvoreFormatada(No no, int posicao) { // função para imprimir a árvore formatada na horizontal, onde imprime todo o lado direito da raiz, depois a raiz e por fim vai imprimir o lado esquerdo da raiz
        if (no != null) {
            imprimeArvoreFormatada(no.direita, posicao + 1);
            for (int i = 0; i < posicao; i++) {
                System.out.print("\t");
            }
            System.out.println(no.valor);
            imprimeArvoreFormatada(no.esquerda, posicao + 1);
        }
    }

    public void arvoreInOrdem(){ // essa função passará o template para exibição dos valores
        System.out.println();
        System.out.println("Árvore no percurso LNR (InOrdem)");
        System.out.print("( ");
        arvoreInOrdemFilho(raiz);
        System.out.println(")");
        System.out.println();
    }

    public void arvoreInOrdemFilho(No no) { //essa função vai exibir os números "InOrdem" onde vai exibir primeiro o filho da esquerda, depois o no "pai" e por fim o filho da direita
        if (no != null) {
            arvoreInOrdemFilho(no.esquerda);
            System.out.print(no.valor + " ");
            arvoreInOrdemFilho(no.direita);
        }
    }

    public void arvorePreOrdem(){ // essa função passará o template para exibição dos valores
        System.out.println();
        System.out.println("Árvore no percurso NLR (PreOrdem)");
        System.out.print("( ");
        arvorePreOrdemFilho(raiz);
        System.out.println(")");
        System.out.println();
    }

    public void arvorePreOrdemFilho(No no) { //essa função vai exibir os números "PreOrdem" onde vai exibir primeiro o nó "pai, depois o filho esquerdo e por fim o filho direito
        if (no != null) {
            System.out.print(no.valor + " ");
            arvorePreOrdemFilho(no.esquerda);
            arvorePreOrdemFilho(no.direita);
        }
    }

    public void arvorePosOrdem(){ // essa função passará o template para exibição dos valores
        System.out.println();
        System.out.println("Árvore no percurso LRN (PosOrdem)");
        System.out.print("( ");
        arvorePosOrdemFilho(raiz);
        System.out.println(")");
        System.out.println();
    }

    public void arvorePosOrdemFilho(No no) { //essa função vai exibir os números "PosOrdem" onde vai exibir primeiro o filho da esquerda, depois o filho da direita e por fim o nó "pai"
        if (no != null) {
            arvorePosOrdemFilho(no.esquerda);
            arvorePosOrdemFilho(no.direita);
            System.out.print(no.valor + " ");
        }
    }
}
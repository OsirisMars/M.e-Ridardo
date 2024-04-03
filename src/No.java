public class No {
    // classe onde o Nó vai ser criado
    int valor;
    No esquerda; // criação do Nó esquerdo
    No direita;  // criação do Nó direito

    No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    } // inicia passando o valor dos Nós como nulo
}
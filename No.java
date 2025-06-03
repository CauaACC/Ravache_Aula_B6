public class No {
        String valor;
    No esquerda;
    No direita;
    int altura;

    public No(String valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.altura = 1;
    }
}

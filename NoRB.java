public class NoRB {
    int chave;
    NosRB cor;
    NoRB esquerda, direita, pai;

    public NoRB(int chave) {
        this.chave = chave;
        this.cor = NosRB.Red;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }

    public boolean isRed() {
        return this.cor == NosRB.Red;
    }

    public void setCor(NosRB cor) {
        this.cor = cor;
    }

    enum NosRB {
        Red, Black;
    }
}

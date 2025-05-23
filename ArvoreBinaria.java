public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        construirArvore();
    }

    private void construirArvore() {
        No A = new No("A");
        No B = new No("B");
        No C = new No("C");
        No D = new No("D");
        No E = new No("E");
        No F = new No("F");

        A.esquerda = B;
        A.direita = C;

        B.esquerda = D;
        B.direita = E;

        C.direita = F;

        this.raiz = A;
    }

    public int contarNos() {
        return contarNos(raiz);
    }

    private int contarNos(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }  

    public void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

    public void imprimirPreOrdem() {
        preOrdem(raiz);
    }

    public void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdem(no.direita);
        }
    }

    public void imprimirEmOrdem() {
        emOrdem(raiz);
    }

        public void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.esquerda);
            posOrdem(no.direita);
            System.out.print(no.valor + " ");
        }
    }

    public void imprimirPosOrdem() {
        posOrdem(raiz);
    }

        public void preOrdemIterativo(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdemIterativo(no.esquerda);
            preOrdemIterativo(no.direita);
        }
    }

    public void imprimirPreOrdemIterativo() {
        preOrdemIterativo(raiz);
    }
}

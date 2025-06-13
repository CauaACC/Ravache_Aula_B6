public class ArvoreBinariaRB {
    private NoRB raiz;

    public void inserir(int chave) {
        NoRB novo = new NoRB(chave);
        raiz = inserirRB(raiz, novo);
        corrigirInsercao(novo);
    }

    private NoRB inserirRB(NoRB atual, NoRB novo) {
        if (atual == null) return novo;

        if (novo.chave < atual.chave) {
            atual.esquerda = inserirRB(atual.esquerda, novo);
            atual.esquerda.pai = atual;
        } else {
            atual.direita = inserirRB(atual.direita, novo);
            atual.direita.pai = atual;
        }
        return atual;
    }

    private void corrigirInsercao(NoRB no) {
        while (no != raiz && no.pai.isRed()) {
            NoRB avo = no.pai.pai;
            if (no.pai == avo.esquerda) {
                NoRB tio = avo.direita;
                if (tio != null && tio.isRed()) {
                    no.pai.setCor(NoRB.NosRB.Black);
                    tio.setCor(NoRB.NosRB.Black);
                    avo.setCor(NoRB.NosRB.Red);
                    no = avo;
                } else {
                    if (no == no.pai.direita) {
                        no = no.pai;
                        rotacaoEsquerda(no);
                    }
                    no.pai.setCor(NoRB.NosRB.Black);
                    avo.setCor(NoRB.NosRB.Red);
                    rotacaoDireita(avo);
                }
            } else {
                NoRB tio = avo.esquerda;

                if (tio != null && tio.isRed()) {
                    no.pai.setCor(NoRB.NosRB.Black);
                    tio.setCor(NoRB.NosRB.Black);
                    avo.setCor(NoRB.NosRB.Red);
                    no = avo;
                } else {
                    if (no == no.pai.esquerda) {
                        no = no.pai;
                        rotacaoDireita(no);
                    }
                    no.pai.setCor(NoRB.NosRB.Black);
                    avo.setCor(NoRB.NosRB.Red);
                    rotacaoEsquerda(avo);
                }
            }
        }
        raiz.setCor(NoRB.NosRB.Black);
    }

    private void rotacaoEsquerda(NoRB x) {
        NoRB y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != null) y.esquerda.pai = x;
        y.pai = x.pai;

        if (x.pai == null) {
            raiz = y;
        } else if (x == x.pai.esquerda) {
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }

        y.esquerda = x;
        x.pai = y;
    }

    private void rotacaoDireita(NoRB y) {
        NoRB x = y.esquerda;
        y.esquerda = x.direita;
        if (x.direita != null) x.direita.pai = y;
        x.pai = y.pai;

        if (y.pai == null) {
            raiz = x;
        } else if (y == y.pai.direita) {
            y.pai.direita = x;
        } else {
            y.pai.esquerda = x;
        }

        x.direita = y;
        y.pai = x;
    }

    public void emOrdem() {
        emOrdem(raiz);
        System.out.println();
    }

    private void emOrdem(NoRB no) {
        if (no != null) {
            emOrdem(no.esquerda);
            System.out.print(no.chave + "(" + no.cor + ") ");
            emOrdem(no.direita);
        }
    }
}

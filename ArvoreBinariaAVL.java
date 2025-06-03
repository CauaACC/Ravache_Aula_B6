public class ArvoreBinariaAVL {
    private No raizAVL;

    public ArvoreBinariaAVL() {
        construirArvore();
    }

    private void construirArvore() {
        raizAVL = inserir(raizAVL, "A");
        raizAVL = inserir(raizAVL, "B");
        raizAVL = inserir(raizAVL, "C");
        raizAVL = inserir(raizAVL, "D");
        raizAVL = inserir(raizAVL, "E");
        raizAVL = inserir(raizAVL, "F");
    }

    public void inserir(String valor) {
        raizAVL = inserir(raizAVL, valor);
    }

    public void remover(String valor) {
        raizAVL = remover(raizAVL, valor);
    }

    private No inserir(No no, String valor) {
        if (no == null) return new No(valor);

        if (valor.compareTo(no.valor) < 0)
            no.esquerda = inserir(no.esquerda, valor);
        else if (valor.compareTo(no.valor) > 0)
            no.direita = inserir(no.direita, valor);
        else
            return no;

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int balanceamento = altura(no.esquerda) - altura(no.direita);

        if (balanceamento > 1 && valor.compareTo(no.esquerda.valor) < 0)
            return rotacaoDireita(no);

        if (balanceamento < -1 && valor.compareTo(no.direita.valor) > 0)
            return rotacaoEsquerda(no);

        if (balanceamento > 1 && valor.compareTo(no.esquerda.valor) > 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && valor.compareTo(no.direita.valor) < 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private No remover(No no, String valor) {
        if (no == null) return null;

        if (valor.compareTo(no.valor) < 0) {
            no.esquerda = remover(no.esquerda, valor);
        } else if (valor.compareTo(no.valor) > 0) {
            no.direita = remover(no.direita, valor);
        } else {
            if (no.esquerda == null) return no.direita;
            if (no.direita == null) return no.esquerda;

            No sucessor = menorValor(no.direita);
            no.valor = sucessor.valor;
            no.direita = remover(no.direita, sucessor.valor);
        }
        atualizarAltura(no);
        return balancear(no);
    }

    private int altura(No no) {
        return (no == null) ? 0 : no.altura;
    }

    private void atualizarAltura(No no) {
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
    }

    private int fatorBalanceamento(No no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private No balancear(No no) {
        int fb = fatorBalanceamento(no);

        if (fb > 1) {
            if (fatorBalanceamento(no.esquerda) < 0)
                no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }
        if (fb < -1) {
            if (fatorBalanceamento(no.direita) > 0)
                no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }
        return no;
    }

    private No menorValor(No no) {
        while (no.esquerda != null)
            no = no.esquerda;
        return no;
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));
        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));

        return y;
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdem(raizAVL);
    }

    private void imprimirEmOrdem(No no) {
        if (no == null) return;
        imprimirEmOrdem(no.esquerda);
        System.out.println(no.valor + " (altura: " + no.altura + ")");
        imprimirEmOrdem(no.direita);
    }
}

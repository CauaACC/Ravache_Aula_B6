import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

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

    public void imprimirPorNivel() {
        int altura = altura(raiz);
        for (int i = 1; i <= altura; i++) {
            imprimirEmNivel(raiz, i);
        }
    }
    private void imprimirEmNivel(No no, int nivel) {
        if (no == null) return;
        if (nivel == 1) {
            System.out.print(no.valor + " ");
        } else {
            imprimirEmNivel(no.esquerda, nivel - 1);
            imprimirEmNivel(no.direita, nivel - 1);
        }
    }
    private int altura(No no) {
        if (no == null) return 0;
        int alturaEsq = altura(no.esquerda);
        int alturaDir = altura(no.direita);
        return Math.max(alturaEsq, alturaDir) + 1;
    }


    public void imprimirPreOrdemIterativo() {
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.print(atual.valor + " ");

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }
            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }
    }

    public void imprimirEmOrdemIterativo() {
        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerda;
            }

            atual = pilha.pop();
            System.out.print(atual.valor + " ");

            atual = atual.direita;
        }
    }

    public void imprimirPosOrdemIterativo() {
        if (raiz == null) return;

        Stack<No> pilha1 = new Stack<>();
        Stack<No> pilha2 = new Stack<>();

        pilha1.push(raiz);

        while (!pilha1.isEmpty()) {
            No atual = pilha1.pop();
            pilha2.push(atual);

            if (atual.esquerda != null) {
                pilha1.push(atual.esquerda);
            }
            if (atual.direita != null) {
                pilha1.push(atual.direita);
            }
        }

        while (!pilha2.isEmpty()) {
            System.out.print(pilha2.pop().valor + " ");
        }
    }

    public void ImprimirEmnivelIterativo() {
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.valor + " ");

            if (atual.esquerda !=null) fila.add(atual.esquerda);
            if (atual.direita !=null) fila.add(atual.direita);
        }
    }

    public int contarNosIterativo() {
        if (raiz == null) return 0;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);
        int totalNosIterativo = 0;

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            totalNosIterativo++;

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }
            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }
        return totalNosIterativo;
    }


    public int contarNosFolhas() {
        return contarNosFolhas(raiz);
    }
    private int contarNosFolhas(No no) {
        if (no == null) {
            return 0;
        }

        if (no.esquerda == null && no.direita == null) {
            return 1;
        }

        return contarNosFolhas(no.esquerda) + contarNosFolhas(no.direita);
    }


    public int contarNosFolhasIterativo() {
        if (raiz == null) return 0;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);
        int contadorNosFolha = 0;

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();

            if (atual.esquerda == null && atual.direita == null) {
                contadorNosFolha++;
            }

            if (atual.direita != null) pilha.push(atual.direita);
            if (atual.esquerda != null) pilha.push(atual.esquerda);
        }

        return contadorNosFolha;
    }
}

public class Main {
        public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        ArvoreBinariaAVL arvoreAVL = new ArvoreBinariaAVL();

        int totalNos = arvore.contarNos();
        System.out.println("Total de nós na árvore binária: " + totalNos);
        System.out.println();

        System.out.println("Elementos em pré-ordem:");
        arvore.imprimirPreOrdem();
        System.out.println();

        System.out.println("Elementos em-ordem:");
        arvore.imprimirEmOrdem();
        System.out.println();

        System.out.println("Elementos em pós-ordem:");
        arvore.imprimirPosOrdem();
        System.out.println();

        System.out.println("Elementos em nivel:");
        arvore.imprimirPorNivel();
        System.out.println();

        System.out.println("Elementos em pré-ordem (Iterativo):");
        arvore.imprimirPreOrdemIterativo();
        System.out.println();

        System.out.println("Elementos em-ordem (Iterativo):");
        arvore.imprimirEmOrdemIterativo();
        System.out.println();

        System.out.println("Elementos em pós-ordem (Iterativo):");
        arvore.imprimirPosOrdemIterativo();
        System.out.println();

        System.out.println("Elementos em nivel (Iterativo):");
        arvore.ImprimirEmnivelIterativo();
        System.out.println();

        int totalNosIterativo = arvore.contarNosIterativo();
        System.out.println("Total de nós na árvore binária: " + totalNosIterativo);
        System.out.println();

        int totalFolhas = arvore.contarNosFolhas();
        System.out.println("Total de nós folha: " + totalFolhas);
        System.out.println();

        int totalNosFolhas = arvore.contarNosFolhasIterativo();
        System.out.println("Total de nós folha (iterativo): " + totalNosFolhas);
        System.out.println();

        int totalNosFolhasFila = arvore.contarNosFolhasIterativoFila();
        System.out.println("Total de nós folha (iterativo e fila): " + totalNosFolhasFila);
        System.out.println();

        //ÁRVORE AVL (TODAS "EM_ORDEM")

        arvoreAVL.inserir("A");
        arvoreAVL.inserir("B");
        arvoreAVL.inserir("C");
        arvoreAVL.inserir("D");
        arvoreAVL.inserir("E");
        arvoreAVL.inserir("F");

        System.out.println("Árvore original:");
        arvore.imprimirEmOrdem();

        System.out.println("Inserindo G (rotação simples à esquerda esperada):");
        arvoreAVL.inserir("G");
        arvoreAVL.imprimirEmOrdem();

        System.out.println("Inserindo 0 (zero) (rotação simples à direita esperada):");
        arvoreAVL.inserir("0");
        arvoreAVL.imprimirEmOrdem();

        System.out.println("Inserindo H (rotação dupla esperada):");
        arvoreAVL.inserir("H");
        arvoreAVL.imprimirEmOrdem();

        System.out.println("Removendo G:");
        arvoreAVL.remover("G");
        arvoreAVL.imprimirEmOrdem();

        System.out.println("\nRemovendo 0:");
        arvoreAVL.remover("0");
        arvoreAVL.imprimirEmOrdem();

        System.out.println("Removendo H:");
        arvoreAVL.remover("H");
        arvoreAVL.imprimirEmOrdem();
    }
}

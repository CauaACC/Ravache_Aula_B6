public class Main {
        public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

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
    }
}

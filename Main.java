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

        System.out.println("Elementos em pré-ordem (Iterativo):");
        arvore.imprimirPreOrdemIterativo();
        System.out.println();
    }
}

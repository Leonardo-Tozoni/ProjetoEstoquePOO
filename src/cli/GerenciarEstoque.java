package cli;

import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarEstoque {
    public List<Produto> listaProduto = new ArrayList<>();

    public static void main(String[] args) {
        GerenciarEstoque gerenciar =new GerenciarEstoque();
        Scanner scan = new Scanner(System.in);
        int option   = 0;
        do{
            option = construirMenu(gerenciar, scan);
        }while(option!=9);
    }

    private static int construirMenu(GerenciarEstoque gerenciar, Scanner scan) {
        int option;
        System.out.println("---------MENU-----------");
        System.out.println("1. Cadastro de Novo Produto");
        System.out.println("2. Repor Estoque");
        System.out.println("3. Retirar Estoque");
        System.out.println("4. Pesquisar Produto");
        System.out.println("5. Relatório de Produtos Cadastrados");
        System.out.println("9. Sair");
        System.out.println("Digite uma opção: ");
        option = Integer.parseInt(scan.nextLine());
        switch (option) {
            case 1:
                gerenciar.execRegistrarProduto(scan);
                break;
            case 2:
                gerenciar.execAddEstoque(scan);
                break;
            case 3:
                gerenciar.execRemoverEstoque(scan);
                break;
            case 4:
                gerenciar.execMostrarProduto(scan);
                break;
            case 5:
                gerenciar.execMostrarTodo();
                break;
            case 9:
                System.out.println("FIM");
                break;
            default:
                System.out.println("Opção inválida");
        }
        return option;
    }

    public void execRegistrarProduto(Scanner sc){
        Produto produto = new Produto();
        System.out.println("Digite o código do produto: ");
        int codigo = Integer.parseInt(sc.nextLine());

        if(!codigoExiste(codigo)){
            produto.setSku(codigo);
        }else{
            System.out.println("Código já cadastrado");
            return;
        }

        System.out.println("Informe o nome do produto: ");
        produto.setNomeProduto(sc.nextLine());
        System.out.println("Informe a quantidade do produto: ");
        produto.setQuantidadeProduto(Double.parseDouble(sc.nextLine()));
        System.out.println("Informe o valor do produto: ");
        produto.setPrecoProduto(Double.parseDouble(sc.nextLine()));

        listaProduto.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void execAddEstoque(Scanner sc){

        Produto produto = getProduto(sc);

        if(produto != null){
            System.out.println("Informe quanto deseja acrescentar no estoque: ");
            boolean ok = produto.acrescentar(Double.parseDouble(sc.nextLine()));
            if(ok){
                System.out.println("Adicionada com sucesso!");
            }else{
                System.out.println("ERRO! Deve ser maior que zero.");
            }
        }else{
            System.out.println("Produto não cadastrado");
        }
    }

    public void execRemoverEstoque(Scanner sc){

        Produto produto = getProduto(sc);

        if(produto != null){
            System.out.println("Informe quanto deve ser removido do estoque: ");
            boolean ok = produto.remover(Double.parseDouble(sc.nextLine()));
            if(ok){
                System.out.println("Removido com Sucesso!");
            }else{
                System.out.println("ERRO! Produto não possui estoque.");
            }
        }else{
            System.out.println("Produto não cadastrado");
        }
    }

    public void execMostrarProduto(Scanner sc){

        Produto produto = getProduto(sc);

        if(produto != null){
            System.out.println(produto.toString());
        }
    }

    public void execMostrarTodo(){
        for(Produto produto : listaProduto){
            System.out.println(produto.toString());
        }
    }

    private Produto getProduto(Scanner scan) {
        System.out.println("Informe o SKU do produto: ");
        int procurar = Integer.parseInt(scan.nextLine());
        Produto produto = null;

        for(Produto p : listaProduto){
            if(p.getSku() == procurar){
                produto = p;
                break;
            }
        }
        return produto;
    }

    private boolean codigoExiste(Integer codigo) {
        for (Produto p : listaProduto) {
            if(p.getSku() == codigo){
                return true;
            }
        }
        return false;
    }
}
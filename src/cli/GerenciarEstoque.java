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
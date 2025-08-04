package org.example;
import java.sql.*;
import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual ação quer realizar?" +
                "\n1.Ver cleintes devedores" +
                "\n2.Ver todos os clientes" +
                "\n3.Incluir um cliente" +
                "\n4.Insere uma nova dívida"
        );
        int userInput = scanner.nextInt();
        scanner.nextLine();
        Conexao.conectar();

        ResultSet rs = null;
        switch(userInput){
            case 1:
                rs = Conexao.buscarClDevedores();
                while(rs.next()){
                    System.out.println("Nome: " + rs.getString("nome")
                    + "\n, Sobrenome: " + rs.getString("sobrenome")
                    + "\n, Loja: " + rs.getString("loja")
                    + "\n, Telefone: " + rs.getString("telefone"));
                }
            break;
            case 2:
                rs = Conexao.buscarTodosCl();
                while(rs.next()){
                    System.out.println("Nome: " + rs.getString("nome")
                    + ", Sobrenome: " + rs.getString("sobrenome")
                    + ", Loja: " + rs.getString("loja")
                    + ", Telefone: " + rs.getString("telefone"));
                }
            break;
            case 3:
                System.out.println("Digite o nome do cliente: ");
                String nomeCliente = scanner.nextLine();
                System.out.println("Digite o sobrenome do cliente:");
                String sobrenomeCliente = scanner.nextLine();
                System.out.println("Digite o nome da Loja: ");
                String lojaCliente = scanner.nextLine();
                System.out.println("Digite o telefone: ");
                String telefoneCliente = scanner.nextLine();
                int retornoQueryInsert = Conexao.insereNovoCliente(nomeCliente, sobrenomeCliente, lojaCliente, telefoneCliente);
                System.out.println("Retorno da chamada: " + retornoQueryInsert);
            break;
            case 4:
                System.out.println("Id do cliente: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Qual da data?");
                String data = scanner.nextLine();
                System.out.println("Valor:");
                float valor = scanner.nextFloat();
                System.out.println("Em quantas parcelas?");
                int parcelas = scanner.nextInt();
                int retornoInsert = Conexao.insereDivida(id, data, valor, parcelas);
                System.out.println("Retorno do Insert: " + retornoInsert);
            break;
        }
    }
}
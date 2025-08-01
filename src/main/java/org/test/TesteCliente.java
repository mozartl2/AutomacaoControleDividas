package org.test;
import org.example.Cliente;

public class TesteCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "João");
        cliente.exibirInfos();
    }
}

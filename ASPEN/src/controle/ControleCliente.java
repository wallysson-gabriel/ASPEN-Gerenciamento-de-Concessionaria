/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TypedQuery;
import modelo.Cliente;

/**
 *
 * @author wally
 */

public class ControleCliente{
    private static ArrayList<Cliente> listClientes = new ArrayList<>();
        
    public void adicionar(Cliente cliente)
    {
         EntityManager gerente = GerenciadorConexao.getGerente();
        
        // inicio uma transação com o banco de dados
        gerente.getTransaction().begin();
        
        // incluir a categoria no banco de dados Persistir
        gerente.persist(cliente);
        
        // finalizar a transação
        gerente.getTransaction().commit();
        
        // finalizo a conexao
        gerente.close();
    }
    
    public void remover(Cliente cliente)
    {
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        // localiza a categoria entes de excluir
        Cliente clienteExcluir = gerente.find(Cliente.class, 
                                                  cliente.getCodigo());
        
        // inicio uma transação com o banco de dados
        gerente.getTransaction().begin();
        
        // alterar a categoria no banco de dados
        gerente.remove(clienteExcluir);
        
        // finalizar a transação
        gerente.getTransaction().commit();
        
        // finalizo a conexao
        gerente.close();
    }
    
    public void alterar(Cliente cliente)
    {
         // crio um gerente de entidades para fazer a alteração no
        // banco de dados
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        // inicio uma transação com o banco de dados
        gerente.getTransaction().begin();
        
        // alterar a categoria no banco de dados
        gerente.merge(cliente);
        
        // finalizar a transação
        gerente.getTransaction().commit();
        
        // finalizo a conexao
        gerente.close();
    }
    
    public List<Cliente> getTodos()
    {
        
        // criar uma conexao com o banco
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        // criar um objeto do tipo Consulta
        TypedQuery<Cliente> consulta = 
                    gerente.createNamedQuery("Cliente.todos", Cliente.class);
        
        // retorna a lista de objetos da consulta
        return consulta.getResultList();
        
    }
    
    public List<Cliente> getPorNome(String nomePesquisar)
    {
        
        // criar uma conexao com o banco
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        // criar um objeto do tipo Consulta
        TypedQuery<Cliente> consulta = 
                    gerente.createNamedQuery("Cliente.porNome", Cliente.class);
        
        consulta.setParameter("nomequalquer", "%"+nomePesquisar+"%");
        
        // retorna a lista de objetos da consulta
        return consulta.getResultList();
        
    }    
}

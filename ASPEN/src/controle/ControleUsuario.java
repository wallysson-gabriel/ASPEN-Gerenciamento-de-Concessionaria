/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Usuario;

/**
 *
 * @author Aluno
 */
public class ControleUsuario {
    private static ArrayList<Usuario> listUsuarios = new ArrayList<>();
        
    public void adicionar(Usuario usuario)
    {
         EntityManager gerente = GerenciadorConexao.getGerente();
        
        // inicio uma transação com o banco de dados
        gerente.getTransaction().begin();
        
        // incluir a categoria no banco de dados Persistir
        gerente.persist(usuario);
        
        // finalizar a transação
        gerente.getTransaction().commit();
        
        // finalizo a conexao
        gerente.close();
    }
    
    public void remover(Usuario usuario)
    {
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        // localiza a categoria entes de excluir
        Usuario clienteExcluir = gerente.find(Usuario.class, 
                                                  usuario.getCodigo());
        
        // inicio uma transação com o banco de dados
        gerente.getTransaction().begin();
        
        // alterar a categoria no banco de dados
        gerente.remove(clienteExcluir);
        
        // finalizar a transação
        gerente.getTransaction().commit();
        
        // finalizo a conexao
        gerente.close();
    }
    
    public void alterar(Usuario usuario)
    {
         // crio um gerente de entidades para fazer a alteração no
        // banco de dados
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        // inicio uma transação com o banco de dados
        gerente.getTransaction().begin();
        
        // alterar a categoria no banco de dados
        gerente.merge(usuario);
        
        // finalizar a transação
        gerente.getTransaction().commit();
        
        // finalizo a conexao
        gerente.close();
    }
    
    public List<Usuario> getTodos()
    {
        
        // criar uma conexao com o banco
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        // criar um objeto do tipo Consulta
        TypedQuery<Usuario> consulta = 
                    gerente.createNamedQuery("Usuario.todos", Usuario.class);
        
        // retorna a lista de objetos da consulta
        return consulta.getResultList();
        
    }
    
    public List<Usuario> getPorNome(String nomePesquisar)
    {
        
        // criar uma conexao com o banco
        EntityManager gerente = GerenciadorConexao.getGerente();
        
        // criar um objeto do tipo Consulta
        TypedQuery<Usuario> consulta = 
                    gerente.createNamedQuery("Usuario.porNome", Usuario.class);
        
        consulta.setParameter("nomequalquer", "%"+nomePesquisar+"%");
        
        // retorna a lista de objetos da consulta
        return consulta.getResultList();
        
    }    
}

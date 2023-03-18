/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public class GerenciadorConexao {
    private static EntityManagerFactory emf;
    
    public static EntityManagerFactory getFabrica()
    {
        // verifica se a fábrica não existe
        if(emf == null)
        {
            // cria uma EntityManagerFactory e associa a emf
            emf = Persistence.createEntityManagerFactory("ASPENPU");
        }
        return emf;
    }
    
    public static EntityManager getGerente()
    {
        // retorna uma entitmanager a partir da fábrica existente
        return getFabrica().createEntityManager();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author wally
 */
@Entity

@NamedQueries({
    @NamedQuery(name = "Cliente.todos", 
                query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.porNome",
                query = "SELECT c FROM Cliente c "
                        + "WHERE c.nome LIKE :nomequalquer")
})

@Table(name = "cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cliente")
    private int codigo;
    
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf; 
    
    @Column(name = "telfone", length = 17, nullable = false)
    private String telefone;
    
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
    
    @Column(name = "cidade", length = 50, nullable = false)
    private String cidade;
    
    @Column(name = "estado", length = 2, nullable = false)
    private String estado;
    
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;
    
    @Column(name = "email", length = 50, nullable = false)
    private String email;  

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String cpf, String telefone, String endereco, String cidade, String estado, String cep, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return this.codigo == other.codigo;
    }
    
    
    
}

package model.dao;

import model.entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PessoaDAO {

    private static final Logger logger = Logger.getLogger(PessoaDAO.class.getName());

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("pessoas");
    private EntityManager em = factory.createEntityManager();

    // Método para buscar uma pessoa pelo ID
    public Pessoa getPessoa(int id) {
        return em.find(Pessoa.class, id);
    }

    // Método para buscar todas as pessoas
    public List<Pessoa> getAllPessoas() {
        TypedQuery<Pessoa> query = em.createQuery("SELECT p FROM Pessoa p", Pessoa.class);
        return query.getResultList();
    }

    // Método para inserir uma pessoa
    public boolean inserirPessoa(Pessoa pessoa) {
        try {
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
            logger.log(Level.INFO, "Pessoa inserida com sucesso: " + pessoa);
            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao inserir pessoa: " + e.getMessage(), e);
            return false;
        }
    }

    // Método para atualizar uma pessoa
    public boolean atualizarPessoa(Pessoa pessoa) {
        try {
            em.getTransaction().begin();
            em.merge(pessoa);
            em.getTransaction().commit();
            logger.log(Level.INFO, "Pessoa atualizada com sucesso: " + pessoa);
            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao atualizar pessoa: " + e.getMessage(), e);
            return false;
        }
    }

    // Método para deletar uma pessoa
    public boolean deletarPessoa(int id) {
        try {
            em.getTransaction().begin();
            Pessoa pessoa = em.find(Pessoa.class, id);
            em.remove(pessoa);
            em.getTransaction().commit();
            logger.log(Level.INFO, "Pessoa deletada com sucesso: ID = " + id);
            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao deletar pessoa: " + e.getMessage(), e);
            return false;
        }
    }

    // Método para buscar uma pessoa pelo nome
    public Pessoa listarPessoa(String id) {
        try {
            return em.createQuery("SELECT p FROM Pessoa p WHERE p.id = :id", Pessoa.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            logger.log(Level.WARNING, "Nenhuma pessoa encontrada com o nome: " + id);
            return null;
        }
    }

    // Método para buscar todas as pessoas por ID de endereço
    public List<Pessoa> getPessoasByEndereco(int idEndereco) {
        try {
            return em.createQuery("SELECT p FROM Pessoa p WHERE p.endereco.id = :idEndereco", Pessoa.class)
                    .setParameter("idEndereco", idEndereco)
                    .getResultList();
        } catch (NoResultException e) {
            logger.log(Level.WARNING, "Nenhuma pessoa encontrada para o endereço com ID: " + idEndereco);
            return null;
        }
    }
}
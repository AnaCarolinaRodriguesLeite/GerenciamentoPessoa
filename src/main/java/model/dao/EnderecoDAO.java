package model.dao;

import model.entities.Endereco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoDAO {

    private static final Logger logger = Logger.getLogger(EnderecoDAO.class.getName());

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("enderecos");
    private EntityManager em = factory.createEntityManager();

    // Método para buscar um endereço pelo ID
    public Endereco getEndereco(int id) {
        return em.find(Endereco.class, id);
    }

    // Método para buscar todos os endereços
    public List<Endereco> getAllEnderecos() {
        TypedQuery<Endereco> query = em.createQuery("SELECT e FROM Endereco e", Endereco.class);
        return query.getResultList();
    }

    // Método para inserir um endereço
    public boolean inserirEndereco(Endereco endereco) {
        try {
            em.getTransaction().begin();
            em.persist(endereco);
            em.getTransaction().commit();
            logger.log(Level.INFO, "Endereço inserido com sucesso: " + endereco);
            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao inserir endereço: " + e.getMessage(), e);
            return false;
        }
    }

    // Método para atualizar um endereço
    public boolean atualizarEndereco(Endereco endereco) {
        try {
            em.getTransaction().begin();
            em.merge(endereco);
            em.getTransaction().commit();
            logger.log(Level.INFO, "Endereço atualizado com sucesso: " + endereco);
            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao atualizar endereço: " + e.getMessage(), e);
            return false;
        }
    }

    // Método para deletar um endereço
    public boolean deletarEndereco(int id) {
        try {
            em.getTransaction().begin();
            Endereco endereco = em.find(Endereco.class, id);
            em.remove(endereco);
            em.getTransaction().commit();
            logger.log(Level.INFO, "Endereço deletado com sucesso: ID = " + id);
            return true;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Erro ao deletar endereço: " + e.getMessage(), e);
            return false;
        }
    }

    // Método para buscar um endereço pelo estado
    public List<Endereco> listarEndereco(String estado) {
        try {
            return em.createQuery("SELECT e FROM Endereco e WHERE e.estado = :estado", Endereco.class)
                    .setParameter("estado", estado)
                    .getResultList();
        } catch (NoResultException e) {
            logger.log(Level.WARNING, "Nenhum endereço encontrado com o estado: " + estado);
            return null;
        }
    }
}

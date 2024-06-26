package dao;

import models.Pessoa;
import persistence.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.List;

public class PessoaDAO implements DAO<Pessoa> {
    private EntityManagerFactory factory;
    private EntityManager manager;

    public PessoaDAO() {
        this.factory = PersistenceUtil.getEntityManagerFactory();
        this.manager = factory.createEntityManager();
    }

    @Override
    public void insert(Pessoa pessoa) {
        manager.getTransaction().begin();
        manager.persist(pessoa);
        manager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Pessoa pessoa = this.get(id);
        if (pessoa != null) {
            manager.getTransaction().begin();
            manager.remove(pessoa);
            manager.getTransaction().commit();
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        if (this.get(pessoa.getId()) != null) {
            manager.getTransaction().begin();
            manager.merge(pessoa);
            manager.getTransaction().commit();
        }
    }

    @Override
    public List<Pessoa> list(int limit, int offset) {
        return manager.createQuery("FROM Pessoa", Pessoa.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    @Override
    public Pessoa get(int id) {
        return manager.find(Pessoa.class, id);
    }
}

package io.github.indigo.domain.repository;

import io.github.indigo.domain.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Clientes {

//    private static String INSERT = "insert into cliente (nome) values (?)"; //used for jdbc

//    private static String SELECT_ALL = "SELECT * FROM CLIENTE ";

//    private static String UPDATE = "update cliente set nome = ? where id = ?";

//    private static String DELETE = "delete from cliente where id = ?";

  //  private static String SEARCH_BY_NAME = "select * from cliente where id = ? and nome = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;



    @Transactional //ocorre uma transação
    public Cliente salvar(Cliente cliente){
   //         jdbcTemplate.update( INSERT, new Object[]{cliente.getNome()} ); // JDBC
            entityManager.persist(cliente); //persistence with jpa
            return cliente;
    }

    @Transactional
    public Cliente atualizar(Cliente cliente){
//        jdbcTemplate.update(UPDATE, new Object[]{
//                cliente.getNome(),
//                cliente.getId()
//        });
        entityManager.merge(cliente); // jpa method to att
        return cliente;
    }

    @Transactional
    public void delete(Cliente cliente){
//        delete(cliente.getId()); // jdbc
        entityManager.remove(cliente);
    }

    @Transactional
    public void delete(Integer id){
//        jdbcTemplate.update(DELETE, new Object[]{id});
        Cliente cliente = entityManager.find(Cliente.class, id);
        delete(cliente);
    }

    @Transactional (readOnly = true)
    public List<Cliente> buscarPorNome(String nome){
//        return jdbcTemplate.query(
//                SELECT_ALL.concat("where nome like ?"),
//                new Object[]{"%"+nome+"%"},
//                obterClienteMapper()
//        );
        String jpql = "select c from Cliente c where c.nome like :nome ";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome","%" + nome + "%");
        return query.getResultList();
    }

    @Transactional
    public List<Cliente> obterTodos(){
//        return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
        return entityManager
                .createQuery("from Cliente", Cliente.class)
                .getResultList();
    }

//    private static RowMapper<Cliente> obterClienteMapper() {
//        return new RowMapper<Cliente>() {
//            @Override
//            public Cliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//                Integer id = resultSet.getInt("id");
//                String nome = resultSet.getString("nome");
//                return new Cliente(id, nome);
//            }
//        };
//    }

}

package app.proyecto.SistemaBancario.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import app.proyecto.SistemaBancario.Entidades.Cliente;

@Stateless
public class ClienteDAO {

	@PersistenceContext
	private EntityManager em;

	public void crearCliente(Cliente cliente){
		System.out.println("en dao" + cliente.toString());

		this.em.persist(cliente);

	}

	/*
	 * public Cuenta buscarCuenta(String nombres) { String jpql =
	 * "SELECT a FROM Autor a JOIN FETCH a where a.nombres = :nombres"; Query query
	 * = em.createQuery(jpql, Autor.class); query.setParameter("nombres", nombres);
	 * Autor autor = (Autor) query.getSingleResult(); return autor; }
	 */

	public List<Cliente> mostrarClientes() {
		String jpql = "SELECT a FROM Cliente a";
		Query query = em.createQuery(jpql, Cliente.class);
		List<Cliente> clientes = query.getResultList();

		return clientes;
	}

}
package api.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import api.model.Pessoa;
public class PessoaDAO {

		EntityManagerFactory emf;
		EntityManager em;
		
		public PessoaDAO() {
			// Aqui diz a unidade de persistência especificada no arquivo persistance.xml
			emf = Persistence.createEntityManagerFactory("exemplo-jpa"); 
			em = emf.createEntityManager();
		}
		
		public void salvar(Pessoa pessoa) {
			
			try {
				em.getTransaction().begin();
				// Id for null significa que e um novo registro
				if(pessoa.getId() == null){
					em.persist(pessoa);
				}else{
					// Se id estiver preenchido, logo deve ser atualizado
					em.merge(pessoa);
				}
			  	em.getTransaction().commit();
				emf.close();
				
			} catch (Exception e) {
				System.out.println(" erro ao Salvar:" +e.getMessage());
			}
	       
		}

		public void remover(Pessoa pessoa) {
			try {
				// Busco o registro de pessoa, para remove-lo
				em.getTransaction().begin();
				Pessoa p = em.find(Pessoa.class,pessoa.getId());
				em.remove(p);
				em.getTransaction().commit();
				emf.close();
				
			} catch (Exception e) {
				System.out.println(" erro ao Salvar :" +e.getMessage());
				em.getTransaction().rollback();
			}
			
		}
		
		
		
		public Pessoa findByObject(Pessoa pessoa) {
			Pessoa p = null;
			try {
				// Busco o registro de pessoa, para remove-lo
				
				em.getTransaction().begin();
				p = em.find(Pessoa.class,pessoa.getId());
				em.getTransaction().commit();
				emf.close();
				
			} catch (Exception e) {
				System.out.println(" erro ao Buscar :" +e.getMessage());
			}
			return p;
		}
		
		public Pessoa findById(final int id) {
		    Pessoa p = null;
			try {
				em.getTransaction().begin();
				p = em.find(Pessoa.class,id);
				em.getTransaction().commit();
				emf.close();
				
				
			} catch (Exception e) {
				System.out.println(" erro ao Buscar :"+e.getMessage());
			}
			return p;
		}
		
		public List<Pessoa> findAll(){
			try {
				em.getTransaction().begin();
				// Abaixo importado do jaxa.persistance
				Query consulta = em.createQuery("FROM "+Pessoa.class.getName()); // Não é um SQL puro, é SQL do JPA // consulta JPA
				// abaixo cria uma lista temporaria de clientes		                                                                
				List<Pessoa> lista = consulta.getResultList();
				
				em.getTransaction().commit();
				emf.close();
				
				return lista;
			} catch (Exception e) {
				System.out.println(" erro ao Listar :" +e.getMessage());
			}

					
			return null;
		}
}

package business;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.Chamado;
import enuns.chamado.Status;
import enuns.chamado.Tipo;
import infra.hibernate.HibernateUtil;


public class ChamadoBus {

	public Long inserir(Chamado chamado) {
		chamado.setDataRegistro(new Date());
		chamado.setStatus(Status.NOVO);
		chamado.setTipo(Tipo.SOLICITACAO);
		chamado.setUsuario(UsuarioBus.selecionarAluno());
		chamado.setUsuarioStatus(UsuarioBus.selecionarAluno());

		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(chamado);
		t.commit();

		return chamado.getId();
	}

	public void alterar(Chamado chamado) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.merge(chamado);
		t.commit();
	}

	public void excluir(Long id) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Chamado c = selecionar(id);
		Transaction t = s.beginTransaction();
		s.delete(c);
		t.commit();
	}

	public Chamado selecionar(Long id) {
		return (Chamado) HibernateUtil.getSessionFactory().openSession().get(Chamado.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Chamado> listar() {
		return (List<Chamado>) HibernateUtil.getSessionFactory().openSession().createQuery("from Chamado").list();
	}

}

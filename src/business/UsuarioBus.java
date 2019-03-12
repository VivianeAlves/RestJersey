package business;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.Usuario;
import enuns.usuario.Tipo;
import infra.hibernate.HibernateUtil;

public class UsuarioBus {

	public static Usuario selecionarAluno() {
		@SuppressWarnings("deprecation")
		Usuario aluno = (Usuario) HibernateUtil.getSessionFactory().openSession()
				.createQuery("from Usuario where login =:login").setString("login", "aluno").uniqueResult();

		if (aluno == null) {
			aluno = new Usuario();
			aluno.setLogin("aluno");
			aluno.setSenha(DigestUtils.sha256Hex("123"));
			aluno.setNome("Aluno teste");
			aluno.setTipo(Tipo.SUPORTE);
			aluno.setDataRegistro(new Date());
			aluno.setAtivo(true);

			UsuarioBus usuarioBus = new UsuarioBus();
			usuarioBus.inserir(aluno);
		}

		return aluno;
	}

	public Long inserir(Usuario usuario) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(usuario);
		t.commit();

		return usuario.getId();
	}

	public Usuario selecionar(Long id) {
		return (Usuario) HibernateUtil.getSessionFactory().openSession().get(Usuario.class, id);
	}

}

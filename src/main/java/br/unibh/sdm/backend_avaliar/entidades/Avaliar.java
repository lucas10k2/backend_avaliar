package br.unibh.sdm.backend_avaliar.entidades;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_avaliar")
public class Avaliar {



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long  id;

	@NotBlank
	@Column(length = 100)
	@Size(min = 3, max = 30)
	private String nome; // nome do cliente 

	@NotBlank
	@Size(min = 3, max = 300 )
	@Column(length = 300)
	private String opiniao; // sugestão geral do cliente ou critica

	@NotBlank
	@Size(max = 100)
	@Column(length = 100, unique = true)
	private String pros;

	@NotBlank
	@Size(max = 100)
	@Column(length = 100, unique = true)
	private String contras;

	@NotBlank
	@Column(length = 40, unique = true)
	@Size(min = 10, max = 40)
	private String email;
	
	@NotBlank
	@Column(length = 8)
	private String senha;
	
	public Avaliar() {
		super();
	}

	public Avaliar(Long id, String nome, String opiniao,String pros, String contras, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.opiniao = opiniao;
		this.pros = pros;
		this.contras = contras;
		this.email = email;
		this.senha = senha;
	}

	public Long  getId() {
		return id;
	}

	public void setId(Long  id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getOpiniao() {
		return opiniao;
	}

	public void setOpiniao(String opiniao) {
		this.opiniao = opiniao;
	}

	public String getPros() {
		return pros;
	}

	public void setPros(String pros) {
		this.pros = pros;
	}

	public String getContras() {
		return contras;
	}

	public void setContras(String contras) {
		this.contras = contras;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((opiniao == null) ? 0 : opiniao.hashCode());
		result = prime * result + ((pros == null) ? 0 : pros.hashCode());
		result = prime * result + ((contras == null) ? 0 : contras.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avaliar other = (Avaliar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (opiniao == null) {
			if (other.opiniao != null)
				return false;
		} else if (!opiniao.equals(other.opiniao))
			return false;
		if (pros == null) {
			if (other.pros != null)
				return false;
		} else if (!pros.equals(other.pros))
			return false;
		if (contras == null) {
			if (other.contras != null)
				return false;
		} else if (!contras.equals(other.contras))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Avaliar [id=" + id + ", nome=" + nome + ", opiniao=" + opiniao + ", pros=" + pros + ", contras="
				+ contras + ", email=" + email + ", senha=" + senha + "]";
	}

	


	
	
		
}

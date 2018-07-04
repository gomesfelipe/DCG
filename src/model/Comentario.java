package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comentario {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private Date registrationDate;
	
	@Column(nullable = false)
	private String texto;
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}

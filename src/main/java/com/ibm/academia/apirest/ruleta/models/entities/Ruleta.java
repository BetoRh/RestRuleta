package com.ibm.academia.apirest.ruleta.models.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ibm.academia.apirest.ruleta.enums.Estatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ruletas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ruleta implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "No debe de ser nulo")
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 5, max = 50)
	@Column(name = "nombre", nullable = false)
	private String nombreRuleta;

	@NotNull(message = "No debe de ser nulo")
	@NotEmpty(message = "No puede ser vacio")
	@Size(min = 5, max = 50)
	@Column(name = "usuario_creacion", nullable = false)
	private String usuarioCreacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;

	@Column(name = "estatus")
	@Enumerated(EnumType.STRING)
	private Estatus estatus;

	private static final long serialVersionUID = 6243372716450426127L;

}

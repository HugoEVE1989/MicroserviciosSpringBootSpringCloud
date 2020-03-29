package com.formacionbdi.springboot.app.productos.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="productos") //nombre de la tabla de base de datos si no se especifica toma el nombre de la clase
public class Producto  implements Serializable{
	
	@Id  //notacion que indica que es el atributo primario
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Notacion que establece la generación de el campo id
	private Long id;
	
	
	private String nombre;
	private Double precio;
	
	@Transient
	private Integer port;
	
	@Column(name="create_at") //Atributos de la base de datos, si no se especifica se toman los nombres de la variable, deben de ser iguales a los de la tabla en la base de datos
	@Temporal(TemporalType.DATE) // para parsear el tipo de dato date 
	private Date createAt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	
	
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}



	private static final long serialVersionUID = 1L;

}

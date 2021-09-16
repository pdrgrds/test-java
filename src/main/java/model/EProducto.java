package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name="tb_productos")
//@Setter
//@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EProducto {
	
	@Id
	private String idprod;
	private String descripcion;
	private int stock;
	private double precio;
	private int idcategoria;
	private boolean estado;
	
	/*public EProducto(String idprod, String descripcion, int stock, double precio, int idcategoria, boolean estado) {
		super();
		this.idprod = idprod;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.idcategoria = idcategoria;
		this.estado = estado;
	}
	
	
	public EProducto() {
		super();
	}*/


	/*
	public String getIdprod() {
		return idprod;
	}
	public void setIdprod(String idprod) {
		this.idprod = idprod;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}*/
	
}

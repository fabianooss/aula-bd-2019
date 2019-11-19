package org.senac.bd.vo;

import java.math.BigDecimal;

public class MarcaTotal {
	
	private String marca;
	
	private BigDecimal total;
	
	public MarcaTotal(String marca, BigDecimal total) {
		super();
		this.marca = marca;
		this.total = total;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	

}

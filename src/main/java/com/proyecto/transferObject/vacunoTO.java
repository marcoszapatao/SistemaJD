package com.proyecto.transferObject;
import java.sql.Date;
public class vacunoTO {
	   private String diio;
	    private String tipo;
	    private Date fechaIngreso;
	    private String raza;

	    public void setDiio(String diio) {
	        this.diio = diio;
	    }

	    public void setTipo(String tipo) {
	        this.tipo = tipo;
	    }

	    public void setFechaIngreso(Date fechaIngreso) {
	        this.fechaIngreso = fechaIngreso;
	    }

	    public void setRaza(String raza) {
	        this.raza = raza;
	    }


	    public String getDiio() {
	        return diio;
	    }

	    public String getTipo() {
	        return tipo;
	    }

	    public Date getFechaIngreso() {
	        return fechaIngreso;
	    }

	    public String getRaza() {
	        return raza;
	    }
	    
}

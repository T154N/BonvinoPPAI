package models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "COBRO_PREMIUM")
public class CobroPremium {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nro_operacion_mercado_pago")
	private Integer nroOperacionMercadoPago;
	@Column(name = "es_anual")
	private Boolean esAnual;
	@Column(name = "fecha_pago")
	private LocalDateTime fechaPago;
	private Double monto;
	@OneToOne
	private Usuario idUsuario;


	public Boolean getEsAnual() {
		return esAnual;
	}

	public void setEsAnual(Boolean esAnual) {
		this.esAnual = esAnual;
	}


	public LocalDateTime getFechaPago() {
		return fechaPago;
	}


	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}


	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Integer getNroOperacionMercadoPago() {
		return nroOperacionMercadoPago;
	}

	public void setNroOperacionMercadoPago(Integer nroOperacionMercadoPago) {
		this.nroOperacionMercadoPago = nroOperacionMercadoPago;
	}
}
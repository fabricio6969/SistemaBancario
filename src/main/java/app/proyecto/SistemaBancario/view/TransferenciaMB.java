package app.proyecto.SistemaBancario.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import app.proyecto.SistemaBancario.Entidades.Transferencia;
import app.proyecto.SistemaBancario.Entidades.Cuenta;
import app.proyecto.SistemaBancario.negocio.TransferenciaON;

@ManagedBean
public class TransferenciaMB {
	@Inject
	TransferenciaON transferenciaon;
	
	private Transferencia transferencia;
	private List<Transferencia> transferencias;
	
	@PostConstruct
	public void init() {
		this.transferencia = new Transferencia();
		listarTransferencias();
	}

	public String agregarTransferencia() {
		this.transferenciaon.crearTransferencia(transferencia);
		this.transferencia = null;
		return null;
	}
	
	public void listarTransferencias() {
		this.transferencias =  this.transferenciaon.mostrarTransferencias();

	}

	public Transferencia getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;
	}

	public List<Transferencia> getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(List<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}
	
	

}
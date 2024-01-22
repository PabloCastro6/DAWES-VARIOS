package com.pablo.tienda.dtos;

public class PedidoDTO {

	private Integer idPedido;
	private Integer idCliente;
	private String fechaPedido;
	private Integer estadoid;

	public PedidoDTO(Integer idPedido, Integer idCliente, String fechaPedido, Integer estadoid) {
		super();
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.fechaPedido = fechaPedido;
		this.estadoid = estadoid;
	}

}

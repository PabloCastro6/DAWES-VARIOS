package com.pablo.tienda.dao.tndhibernateimpl;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.pablo.tienda.dao.IPedidosDAO;
import com.pablo.tienda.dtos.PedidoDTO;
import com.pablo.tienda.entities.ClientesEntity;
import com.pablo.tienda.utils.DBUtils;



@Component("PedidosHibernateImpl")
public class PedidosDAOHibernate {
	
//		@Override
//		public List<PedidoDTO> buscarPedidos(String idPedido, String idCliente, String idEstado, String fecha)
//				throws ClassNotFoundException, SQLException {
//
//			String hql = "SELECT new com.chuchi.tienda.dtos.PedidosDTO (pr.id, c.id, c.nombre, ep.id, pr.id, pr.nombre, pe.fecha, dp.cantidad, dp.precio, dp.id)"
//					+ " FROM PedidosEntity pe"
//			        + " INNER JOIN pe.detallesPedidos dp"
//			        + " INNER JOIN dp.producto pr"
//			        + " INNER JOIN pe.cliente c"
//			        + " INNER JOIN pe.estado ep"
//					+ " WHERE pe.fecha >= :fecha";
//			
//			String hqlId = " AND pe.id = :id";
//			String hqlCliente = "AND c.id = :cliente";
//			String hqlEstado = "AND ep.id = :estado";
//			
//			SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
//			Session session = sessionFactory.getCurrentSession();
//			session.beginTransaction();
//			
//			StringBuilder sbHql = new StringBuilder(hql);
//			
//			if(idPedido != "") {
//				sbHql.append(hqlId);		
//			}
//			if(idCliente != "") {
//				sbHql.append(hqlCliente);		
//			}
//			if(idEstado != "") {
//				sbHql.append(hqlEstado);		
//			}
//			
//			Query<PedidoDTO> query = session.createQuery(sbHql.toString(), PedidosDTO.class)
//					.setParameter("fecha", fecha);
//			
//			if(idPedido != "") {
//				query.setParameter("id", idPedido);		
//			}
//			if(idCliente != "") {
//				query.setParameter("cliente", idCliente);			
//			}
//			if(idEstado != "") {
//				query.setParameter("estado", idEstado);		
//			}
//			
//			List<PedidosDTO> listaPedidos = query.getResultList();
//			session.close();
//			
//			return listaPedidos;
//		}
//
//		@Override
//		public Integer insertarPedidos(String idCliente, Connection connection)
//				throws ClassNotFoundException, SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public Integer recuperarUltimoPedido(Connection connection) throws ClassNotFoundException, SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public Integer actualizarInventario(String idProducto, String cantidad, Connection connection)
//				throws ClassNotFoundException, SQLException {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public Integer actualizarPedidos(String iD, String iD_Cliente, String idDetalle, String iD_Producto,
//				String cantidad, String precio) throws ClassNotFoundException, SQLException {
//
//			SessionFactory sessionFactory = DBUtils.creadorSessionFactory();
//	        Session session = sessionFactory.getCurrentSession();
//	        session.beginTransaction();
//	        
//	        PedidosEntity pedido = session.get(PedidosEntity.class, Integer.parseInt(iD));
//	        DetallesPedidosEntity detallePedido = session.get(DetallesPedidosEntity.class, Integer.parseInt(idDetalle));
//	        
//	       
//	        	pedido.setCliente(session.find(ClientesEntity.class, Integer.parseInt(iD_Cliente)));
//	        	detallePedido.setProducto(session.find(ProductosEntity.class, Integer.parseInt(iD_Producto)));
//	        	detallePedido.setCantidad(Integer.parseInt(cantidad));
//	        	detallePedido.setPrecio(Double.parseDouble(precio));
//	        	
//	        	session.merge(pedido);
//	        	session.merge(detallePedido);
//	        	session.getTransaction().commit();
//	        	session.close();
//				return 1;
//	            
//	        
//	        
//	      
//		
//		}


	}



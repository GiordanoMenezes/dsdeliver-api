package com.devsuperior.dsdeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dtos.OrderDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.entities.OrderStatus;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> Orders = repository.findOrdersWithProducts();
		return Orders.stream().map(o -> new OrderDTO(o)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO orderDTO) {
		Order order = new Order(null,orderDTO.getAddress(),orderDTO.getLatitude(),orderDTO.getLongitude(),
				Instant.now(), OrderStatus.PENDING);
		orderDTO.getProducts().forEach(p -> order.getProducts().add(productRepository.getOne(p.getId())));
		Order savedOrder = repository.save(order);
        return new OrderDTO(savedOrder);			
	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DEIVERED);
		order = repository.save(order);
		return new OrderDTO(order);
	}
}

//package Service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import com.accenture.ws.entity.Order;
//import com.accenture.ws.repository.OrderRepository;
//
//
//@Service
//public class OrderService {
//	
//	@Autowired
//	private OrderRepository repository;
//	
//	public Order saveOrder(Order order) {
//		return repository.save(order);
//	}
//	
//	public List<Order> getOrder() {
//		return repository.findAll();
//	}
//	
//	public Order getOrderById(int id) {
//		return repository.findById(id).orElse(null);
//	}
//	
//	public String deleteOrder(int id) {
//		repository.deleteById(id);
//		return "deleted"+id;
//	}
//	
//	public Order updateOrder(Order order) {
//		Order existingOrder=repository.findById(order.getId()).orElse(null);
//		existingOrder.setOrderName(order.getOrderName());
//		existingOrder.setPrice(order.getPrice());
////		existingOrder.setIsDiscounted(getIsDiscounted());
//		existingOrder.setIsDiscountedPercentage(order.getIsDiscountedPercentage());
//		return repository.save(existingOrder);
//	}
//	
//}

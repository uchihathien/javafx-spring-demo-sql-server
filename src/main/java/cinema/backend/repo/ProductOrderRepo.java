package cinema.backend.repo;

import cinema.backend.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductOrderRepo extends JpaRepository<ProductOrder, Integer> {

    //tim tat ca cac san pham cua mot don hang
    List<ProductOrder> findByOrderID(int orderID);

}

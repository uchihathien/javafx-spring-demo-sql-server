package cinema.backend.repo;

import cinema.backend.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PaymentMethodRepo extends JpaRepository<PaymentMethod, Integer> {

    // Tìm phương thức thanh toán theo tên
    Optional<PaymentMethod> findByMethodName(String name);
}

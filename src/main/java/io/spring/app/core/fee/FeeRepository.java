package io.spring.app.core.fee;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeeRepository extends CrudRepository<Fee, Long> {
    List<Fee> findFeesByStudent_StudentCode(String studentCode);
}

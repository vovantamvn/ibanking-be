package io.spring.app.repository;

import io.spring.app.model.Fee;
import org.springframework.data.repository.CrudRepository;

public interface FeeRepository extends CrudRepository<Fee, Long> {}

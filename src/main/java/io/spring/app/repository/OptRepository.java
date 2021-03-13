package io.spring.app.repository;

import io.spring.app.model.Otp;
import org.springframework.data.repository.CrudRepository;

public interface OptRepository extends CrudRepository<Otp, Long> {}

package com.example.EventAccounting.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataEventRepository extends JpaRepository<EventJpaEntity, Long> {}

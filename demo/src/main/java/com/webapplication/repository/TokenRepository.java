package com.webapplication.repository;

import com.webapplication.model.Tokens;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TokenRepository extends CrudRepository<Tokens, Long> {
    List<Tokens> findByOp(Integer tokens);
}

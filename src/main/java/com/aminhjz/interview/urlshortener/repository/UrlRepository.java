package com.aminhjz.interview.urlshortener.repository;

import com.aminhjz.interview.urlshortener.repository.entity.UrlEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UrlRepository extends CassandraRepository<UrlEntity, String> {
}

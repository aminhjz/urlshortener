package com.aminhjz.interview.urlshortner.urlshortner.repository;

import com.aminhjz.interview.urlshortner.urlshortner.repository.entity.UrlEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UrlRepository extends CassandraRepository<UrlEntity, String> {
}

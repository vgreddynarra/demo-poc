package com.sanelahealth.poc.repository;

import org.springframework.data.repository.CrudRepository;

import com.sanelahealth.poc.entity.MovieCatalog;

public interface MovieCatalogRepository extends CrudRepository<MovieCatalog, String> {

}

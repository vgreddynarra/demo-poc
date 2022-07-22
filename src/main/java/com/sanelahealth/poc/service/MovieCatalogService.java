package com.sanelahealth.poc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanelahealth.poc.bean.MovieCatalogBean;
import com.sanelahealth.poc.entity.MovieCatalog;
import com.sanelahealth.poc.repository.MovieCatalogRepository;

@Service
public class MovieCatalogService {

	@Autowired
	private MovieCatalogRepository catalogRepository;

	public MovieCatalogBean saveMovieCatalog(MovieCatalogBean movieCatalogBean) {
		MovieCatalog movieCatalog = new MovieCatalog();
		BeanUtils.copyProperties(movieCatalogBean, movieCatalog);
		movieCatalog = catalogRepository.save(movieCatalog);
		BeanUtils.copyProperties(movieCatalog, movieCatalogBean);
		return movieCatalogBean;
	}

	public MovieCatalogBean updateMovieCatalog(MovieCatalogBean movieCatalogBean) {

		MovieCatalog movieCatalog = new MovieCatalog();
		BeanUtils.copyProperties(movieCatalogBean, movieCatalog);
		movieCatalog = catalogRepository.save(movieCatalog);
		BeanUtils.copyProperties(movieCatalog, movieCatalogBean);
		return movieCatalogBean;
	}

	public List<MovieCatalogBean> getMovieCatalogs() {
		Iterable<MovieCatalog> catalogs = catalogRepository.findAll();
		List<MovieCatalogBean> catalogBeans = new ArrayList<>();
		for (MovieCatalog catalog : catalogs) {
			MovieCatalogBean catalogBean = new MovieCatalogBean();
			BeanUtils.copyProperties(catalog, catalogBean);
			catalogBeans.add(catalogBean);
		}
		return catalogBeans;

	}

	public MovieCatalogBean getMovieCatalogById(String id) {
		Optional<MovieCatalog> catalog = catalogRepository.findById(id);
		if (catalog.isPresent()) {
			MovieCatalogBean catalogBean = new MovieCatalogBean();
			BeanUtils.copyProperties(catalog.get(), catalogBean);
			return catalogBean;
		}
		return null;
	}

	public void removeCatalog(String id) {
		Optional<MovieCatalog> catalog = catalogRepository.findById(id);
		if (catalog.isPresent()) {
			catalogRepository.delete(catalog.get());
		}
	}
}

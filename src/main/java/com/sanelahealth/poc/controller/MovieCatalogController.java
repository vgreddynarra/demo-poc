package com.sanelahealth.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanelahealth.poc.bean.MovieCatalogBean;
import com.sanelahealth.poc.bean.ResponseBean;
import com.sanelahealth.poc.service.MovieCatalogService;

@RestController
@CrossOrigin
@RequestMapping("/movieCatalog")
public class MovieCatalogController {

	@Autowired
	private MovieCatalogService catalogService;

	private String saveMessage = "Saved Successfully";
	
	private String updateMessage = "Updated Successfully";

	private String errorMessage = "No Data Found";

	private String successMessage = "Data Getting Successfully";
	
	private String deleteMessage = "Data Deleted Successfully";

	@PostMapping
	public ResponseEntity<Object> saveMovieCatalog(@RequestBody MovieCatalogBean catalogBean) {
		catalogBean = catalogService.saveMovieCatalog(catalogBean);
		ResponseBean bean = new ResponseBean();
		bean.setData(catalogBean);
		bean.setId(catalogBean.getId());
		bean.setMessage(saveMessage);
		bean.setStatus(HttpStatus.CREATED.value());

		return new ResponseEntity<>(bean, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateMovieCatalog(@RequestBody MovieCatalogBean catalogBean,
			@PathVariable String id) {

		MovieCatalogBean movieCatalogBean = catalogService.getMovieCatalogById(id);
		if (movieCatalogBean == null) {
			ResponseBean bean = new ResponseBean();
			bean.setMessage(errorMessage);
			bean.setStatus(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<>(bean, HttpStatus.BAD_REQUEST);
		}
		catalogBean = catalogService.saveMovieCatalog(catalogBean);
		ResponseBean bean = new ResponseBean();
		bean.setData(catalogBean);
		bean.setId(catalogBean.getId());
		bean.setMessage(updateMessage);
		bean.setStatus(HttpStatus.OK.value());

		return new ResponseEntity<>(bean, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<Object> getMovieCatalogs() {
		ResponseBean bean = new ResponseBean();
		bean.setData(catalogService.getMovieCatalogs());
		bean.setMessage(successMessage);
		bean.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(bean, HttpStatus.OK);
	}

	@GetMapping("/byId/{id}")
	public ResponseEntity<Object> saveMovieCatalog(@PathVariable String id) {
		MovieCatalogBean catalogBean = catalogService.getMovieCatalogById(id);
		ResponseBean bean = new ResponseBean();
		if(catalogBean != null) {
		bean.setData(catalogBean);
		bean.setId(catalogBean.getId());
		bean.setMessage(successMessage);
		bean.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(bean, HttpStatus.OK);
		}else {
			bean.setMessage(errorMessage);
			bean.setStatus(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<>(bean, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteMovieCatalog(@PathVariable String id) {
		MovieCatalogBean movieCatalogBean = catalogService.getMovieCatalogById(id);
		if (movieCatalogBean == null) {
			ResponseBean bean = new ResponseBean();
			bean.setMessage(errorMessage);
			bean.setStatus(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<>(bean, HttpStatus.BAD_REQUEST);
		}
		catalogService.removeCatalog(id);
		ResponseBean bean = new ResponseBean();
		bean.setData(catalogService.getMovieCatalogById(id));
		bean.setMessage(deleteMessage);
		bean.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(bean, HttpStatus.OK);
	}

}

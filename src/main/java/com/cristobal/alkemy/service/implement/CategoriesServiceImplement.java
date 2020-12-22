package com.cristobal.alkemy.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristobal.alkemy.models.entity.Categories;
import com.cristobal.alkemy.models.repository.ICategoriesRepository;
import com.cristobal.alkemy.service.interfeces.ICategoriesService;

@Service
public class CategoriesServiceImplement implements ICategoriesService {
	
	@Autowired
	private ICategoriesRepository categoriesRep;

	@Override
	public Categories registrar(Categories obj) {

		return categoriesRep.save(obj);
	}

	@Override
	public Categories modificar(Categories obj) {

		return categoriesRep.save(obj);
	}

	@Override
	public List<Categories> listar() {
		
		return categoriesRep.findAll();
	}

	@Override
	public Categories leerPorId(Integer id) {
		
		Optional<Categories> categorie = categoriesRep.findById(id);
		return categorie.get();
	}

	@Override
	public boolean eliminar(Integer id) {
		
		categoriesRep.deleteById(id);
		return true;
	}

}

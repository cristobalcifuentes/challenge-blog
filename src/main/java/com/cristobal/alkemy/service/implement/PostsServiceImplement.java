package com.cristobal.alkemy.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristobal.alkemy.models.entity.Posts;
import com.cristobal.alkemy.models.repository.IPostsRepository;
import com.cristobal.alkemy.service.interfeces.IPostsService;

@Service
public class PostsServiceImplement implements IPostsService {
	
	@Autowired
	private IPostsRepository postRep;

	@Override
	public Posts registrar(Posts obj) {
		
		
		return postRep.save(obj);
	}

	@Override
	public Posts modificar(Posts obj) {

		return postRep.save(obj);
	}

	@Override
	public List<Posts> listar() {

		return postRep.findAll();
	}

	@Override
	public Posts leerPorId(Integer id) {
		
		Optional<Posts> post = postRep.findById(id);
		return post.get();
	}

	@Override
	public boolean eliminar(Integer id) {
		
		postRep.deleteById(id);
		return false;
	}

}

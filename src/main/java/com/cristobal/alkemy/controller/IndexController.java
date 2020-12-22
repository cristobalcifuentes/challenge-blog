package com.cristobal.alkemy.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cristobal.alkemy.models.entity.Categories;
import com.cristobal.alkemy.models.entity.Posts;
import com.cristobal.alkemy.service.interfeces.ICategoriesService;
import com.cristobal.alkemy.service.interfeces.IPostsService;


@Controller
public class IndexController {
	
	@Autowired
	private ICategoriesService categoriesSer;
	
	@Autowired
	private IPostsService postSer;
	
	
	
	@GetMapping(value= {"Home", "", "/", "index"})
	public String home(Model model) {
		
		List<Posts> posts = postSer.listar();
		model.addAttribute("posts", posts);
		
		return "/Home";
	}
	
	
	@GetMapping("/nuevo-post")
	public ModelAndView nuevoPost() {
		
		ModelAndView mav = new ModelAndView("NuevoPost");
		List<Categories> categories = categoriesSer.listar();
		mav.addObject("categories", categories);
		mav.addObject("post", new Posts());
		
		return mav;
	}
	
	@PostMapping("/posts")
	public String crearPost(Posts post, @RequestParam Integer categorie,  Model model){
		
		Categories categoria = categoriesSer.leerPorId(categorie);
		post.setCategoria(categoria);
		post.setDate(new Date());
		postSer.registrar(post);
		model.addAttribute("post", post);
		
		return "redirect:/index";
	}
	
	@GetMapping("detalle/{id}")
	public ModelAndView detalle(@PathVariable int id) {
		
		
		ModelAndView mav = new ModelAndView("Detalle");
		Posts post = postSer.leerPorId(id);
		mav.addObject("post", post);
		
		return mav;
	}
	
	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable int id, Model model) {
		
		ModelAndView mav = new ModelAndView("NuevoPost");
		Posts post = postSer.leerPorId(id);
		List<Categories> categories = categoriesSer.listar();
		mav.addObject("categories", categories);
		mav.addObject("post", post);
		
		return mav;
	}
	
	@GetMapping("eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		
		postSer.eliminar(id);
		
		return "redirect:/index";
	}

}

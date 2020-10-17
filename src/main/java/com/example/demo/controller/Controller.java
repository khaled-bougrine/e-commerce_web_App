package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.dao.RepoAccesoire;
import com.example.demo.dao.RepoImage;
import com.example.demo.dao.RepoTissus;
import com.example.demo.dao.Repositorytel;
import com.example.demo.model.Accesoire;
import com.example.demo.model.ImageModel;
import com.example.demo.model.Model;
import com.example.demo.model.Tissus;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {
	@Autowired
	Repositorytel repositorymodel;
	
	@Autowired
	RepoImage repoImage;
	
	@Autowired
	RepoTissus repoTissus;
	
	@Autowired
	RepoAccesoire repoAccesoire;
	
	
	/*
	 private Integer id ;
	
	private  String name;
	
	private String description;

	private Long price;

	private boolean isnew;
	private boolean isbestprice;
	private Integer solde;
	private  Integer[] composants;
	
	private Integer[]  images;
	 */
	@GetMapping("test")
	public void test() {
		  repoImage.deleteAll();
	}
	//=====================================POST MODEL===========
	@PostMapping("/addModel")
	public  void addModel(@RequestBody Model mod) {
		
		System.out.println(mod);
	repositorymodel.save(mod);
		System.out.println(repositorymodel.getallId());
		System.out.println(repositorymodel.findAll());
		

	}
	//========================Post Tissus===================
	@PostMapping("/addTissus")
	public void  addTissue(@RequestBody Tissus tissus) {
		repoTissus.save(tissus);
		System.out.println(repoTissus.findAll());

	}
	//===========================POST ACCESOIRE=================
	@PostMapping("/addAccesiore")
	public void addAccesiore(@RequestBody Accesoire accesoire) {
		
		repoAccesoire.save( accesoire);
		System.out.println(repoAccesoire.findAll());
		
	}
	
	////////////////////////////////////////////////////////////////////
	////////////////////////////GET////////////////////////////////////
	///////////////////////////////////////////////////////////////////
	//=====================GET ALL IMAGES=============

	//===================GET ALL MODEL==================
	@GetMapping("getallModels")
	public List<Model> getAllModel(){
		return repositorymodel.findAll();
	}
	
	
	//=================GET ALL ACCESOIREU=====================
	@GetMapping("getallAccesoire")
	public List<Accesoire> getAllAccesoire(){
		return repoAccesoire.findAll();
	}
	//==================GET ALL TISSUS========================
	@GetMapping("getallTissus")
	public List<Tissus> getAllTissus(){
		return repoTissus.findAll();
	}

	//======================GET--MODEL--PAR --ID===================
	@GetMapping("/getById/model/{id}")
	public Optional<Model> getModelParId(@PathVariable int id) {
		return repositorymodel.findById(id);
		
		
	}

	// ====================Get model by Utilisation=============
	@GetMapping("get/model/{pourquoi}")
	public List<Model> getByUtilisation(@PathVariable String pourquoi){
		return this.repositorymodel.findBypourquoi(pourquoi);
		
		
	}
	//=================Get Accesoire by type==================
		 @GetMapping("get/getaccesoire/{type}")
		 public List<Accesoire> getAccesoire(@PathVariable String type){
			 
			 return this.repoAccesoire.findBytype(type);
			 
		 }
		 //==========GET TISSUS PAR TYPE============================
		 @GetMapping("get/tissus/{type}")
		 public List<Accesoire> getTissus(@PathVariable String type){
			 
			 return this.repoTissus.findByfabric(type);
			 
		 }
	//===================GET ACCESOIRE BY NBSERIE==========
		 @GetMapping("getByNbserie/accesoire/{nbserie}")
		 public List<Accesoire> getAccesoireByNbserie(@PathVariable String nbserie){
			 return this.repoAccesoire.findBynbserie(nbserie);
			 }
   //=====================GET ACCESOIRE BY ID============
		 @GetMapping("/getById/accesoire/{id}")
		 public Optional<Accesoire> getAccesoireParId(@PathVariable int id) {
				return repoAccesoire.findById(id);}
				

			//=====================GET---TISSUS--PAR--ID==============
			@GetMapping("/getById/tissus/{id}")
			public Optional<Tissus> getTissusParId(@PathVariable int id) {
				return repoTissus.findById(id);
				
				
			}
			//===========================GET tISSUS PAR NBSERIE=========
			 @GetMapping("getByNbserie/tissus/{nbserie}")
			 public List<Tissus> getTissusByNbserie(@PathVariable String nbserie){
				 return this.repoTissus.findBynbserie(nbserie);
				 }
			 
			
		
	
	@PostMapping("/upload")
	public void uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {

		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));
		repoImage.save(img);
		
		
		
	}
	////////////////////////DELETE///////////////////////////////

	@DeleteMapping("delete/model/{id}")
	public void deleteModel(@PathVariable int id) {
		
	Model model=  repositorymodel.findByid(id);
	    System.out.println(model);
		List<String> list = model.getImages();
		System.out.println(list);
		
		if(list != null) {
		for(String name :list) {
			System.out.println(name);
			Optional<ImageModel> retrievedImage=repoImage.findByName(name);
			System.out.println("55555"+retrievedImage.get().getName());
			repoImage.delete(retrievedImage.get());
			System.out.println("ggggg"+retrievedImage.get().getName());
		}
		}
		repositorymodel.deleteById(id);
	
		
		
	}
	/////////////////////////DELETE ACCESOIRE//////////////////////
	@DeleteMapping("delete/accesoire/{id}")
	public void deleteAcessoire(@PathVariable int id) {
		
	Optional<Accesoire> model=  repoAccesoire.findById(id);
	    System.out.println(model);
		List<String> list = model.get().getImages();
		System.out.println(list);
		
		if(list != null) {
		for(String name :list) {
			System.out.println(name);
			Optional<ImageModel> retrievedImage=repoImage.findByName(name);
			System.out.println("55555"+retrievedImage.get().getName());
			repoImage.delete(retrievedImage.get());
			System.out.println("ggggg"+retrievedImage.get().getName());
		}
		}
		repoAccesoire.deleteById(id);
	
	}
	/////////////////////////DELETE TISSUS//////////////////////
	@DeleteMapping("delete/tissus/{id}")
	public void deleteTissus(@PathVariable int id) {
		
	Optional<Tissus> model=  repoTissus.findById(id);
	    System.out.println(model);
	    
		List<String> list = model.get().getImages();
		System.out.println(list);
		if(list != null) {
		for(String name :list) {
			System.out.println(name);
			Optional<ImageModel> retrievedImage=repoImage.findByName(name);
			System.out.println("55555"+retrievedImage.get().getName());
			repoImage.delete(retrievedImage.get());
			System.out.println("ggggg"+retrievedImage.get().getName());
		}
		}
		repoTissus.deleteById(id);
	
	  
		
		
	}
	


	 
	// compress the image bytes before storing it in the database
		public static byte[] compressBytes(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

			return outputStream.toByteArray();
		}

		// uncompress the image bytes before returning it to the angular application
		public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}
		@GetMapping(path = { "/get/{imageName}" })
		public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {

			 Optional<ImageModel> retrievedImage = repoImage.findByName(imageName);
			ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
					decompressBytes(retrievedImage.get().getPicByte()));
			return img;
		}
	
	

	
	
	
}

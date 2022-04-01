package com.projet.stock.services;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.projet.stock.model.Expert;
import com.projet.stock.model.Generaliste;
import com.projet.stock.repository.ExpertRepository;
import com.projet.stock.repository.GeneralisteRepository;

@Service
public class GeneralisteService {
	protected String gender ;
	protected long telephone;

	
	@Autowired
	GeneralisteRepository generalisteRepository;

	public void  saveGeneraliste(long id , MultipartFile image /*,String username ,String  email , String password*/ 
			 )
	{
		Generaliste expert = new Generaliste();
		expert= generalisteRepository.findById(id).get();
		String fileName = StringUtils.cleanPath(image.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			expert.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

        
		generalisteRepository.save(expert);
	}
	/*public List<Product> getAllProduct()
	{
		return productRepo.findAll();
	}
    public void deleteProductById(Long id)
    {
    	productRepo.deleteById(id);
    }
    public void chageProductName(Long id ,String name)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setName(name);
    	productRepo.save(p);    
    }
    public void changeProductDescription(Long id , String description)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setDescription(description);
    	productRepo.save(p);
    }
    public void changeProductPrice(Long id,int price)
    {
    	Product p = new Product();
    	p = productRepo.findById(id).get();
    	p.setPrice(price);
    	productRepo.save(p);
    }*/
	
	

}

package gikart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import gikart.entities.Seller;
import gikart.models.LoginDTO;
import gikart.models.Response;
import gikart.models.UpdateStatusDTO;
import gikart.services.SellerService;

@CrossOrigin
@RestController
@RequestMapping("/api/sellers")
public class SellerController {

	@Autowired private SellerService sellerService;
	
	@PostMapping
	public ResponseEntity<?> save(Seller seller) {
		System.out.println("Inside Seller Registration");
		Seller existingSeller = sellerService.findByUsername(seller.getUserid());
		if (existingSeller != null) {
			return ResponseEntity.badRequest().body("Username already exists");
	    } else {
	        sellerService.registerSeller(seller);
	        return Response.success(seller);
	    }
	}
	
	@PostMapping("status")
	public ResponseEntity<?> updateStatus(@RequestBody UpdateStatusDTO dto) {
		sellerService.updateStatus(dto);
		return Response.success("Status updated successfully");
	}
	
	@GetMapping
	public ResponseEntity<?> findAllCustomers() {
		List<Seller> result = sellerService.allSellers();
		return Response.success(result);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findSellerProfile(@PathVariable("id") int id) {
		Seller result = sellerService.findById(id);
		return Response.success(result);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteSeller(@PathVariable("id") int id) {
		sellerService.deleteSeller(id);
		return Response.status(HttpStatus.OK);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody LoginDTO dto) {
		System.out.println(dto);
		Seller user=sellerService.validate(dto.getUserid(),dto.getPwd());
		if(user!=null && !user.isIsactive())
			return Response.error("Seller not verified");
		else if(user!=null && user.isIsactive())
			return Response.success(user);
		else
			return Response.error("Invalid username or password");
	}
	
}

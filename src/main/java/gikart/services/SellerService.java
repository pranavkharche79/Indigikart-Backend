package gikart.services;

import java.util.List;
import gikart.entities.Seller;
import gikart.models.UpdateStatusDTO;

public interface SellerService {
	void registerSeller(Seller seller);
	List<Seller> allSellers();
	Seller findById(int id);
	Seller validate(String userid,String pwd);
	void deleteSeller(int id);
	void updateStatus(UpdateStatusDTO dto);
	Seller findByUsername(String userid);
}

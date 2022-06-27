package poly.bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poly.bookshop.dto.PayInDTO;

@Service
public interface IPayInService {
	PayInDTO save(PayInDTO payInDTO);

	PayInDTO findOneById(int id);

	int getTotalItem();

	int delete(int ids[]);

	List<PayInDTO> findAll(int page, int limit, String sortBy, String sortName);

	List<PayInDTO> search(String keyword, int page, int limit, String sortBy, String sortName);

	Integer getToTalItemSearch(String keyword);
}

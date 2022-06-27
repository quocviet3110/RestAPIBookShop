package poly.bookshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import poly.bookshop.dto.PayInDetailDTO;

@Service
public interface IPayInDetailService {

	PayInDetailDTO save(PayInDetailDTO model);

	List<PayInDetailDTO> findAll(int page, int limit, String sortBy, String sortName);

	List<PayInDetailDTO> findAllByID(int id);

}

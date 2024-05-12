package _2024.creativeproject.utils.api;

import _2024.creativeproject.network.dto.foreign.ItemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface SearchAPI {
	List<ItemDTO> search(String query) throws JsonProcessingException;
}

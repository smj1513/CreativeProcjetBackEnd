package _2024.creativeproject.network.dto.foreign;

import _2024.creativeproject.utils.dto.foreign.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ItemDTO {
	private String title;
	private String sellerLink;
	private String imageLink;
	private Integer lowPrice;
	private String mallName;

	public static ItemDTO from(Item item){
		return ItemDTO.builder()
				.title(item.getTitle().replace("<b>","").replace("</b>",""))
				.sellerLink(item.getLink())
				.imageLink(item.getImage())
				.mallName(item.getMallName())
				.lowPrice(Integer.parseInt(item.getLprice()))
				.build();
	}
}

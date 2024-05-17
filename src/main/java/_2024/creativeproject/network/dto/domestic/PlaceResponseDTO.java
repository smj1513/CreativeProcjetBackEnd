package _2024.creativeproject.network.dto.domestic;

import _2024.creativeproject.utils.dto.domestic.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaceResponseDTO {
	private String title;
	private String mainAddress;
	private String detailAddress;
	private String distance;
	private String imageURL;
	private String xPos;
	private String yPos;
	private String tel;
	private String contentId;
	private Integer contentTypeId;

	public static PlaceResponseDTO from(Item item){
		return PlaceResponseDTO.builder()
				.title(item.getTitle())
				.mainAddress(item.getAddr1())
				.detailAddress(item.getAddr2())
				.distance(item.getDist())
				.xPos(item.getMapy()) //카카오맵에서는 xy 좌표 반전하여 사용함
				.yPos(item.getMapx())
				.imageURL(item.getFirstimage2())
				.tel(item.getTel())
				.contentId(item.getContentid())
				.contentTypeId(Integer.parseInt(item.getContenttypeid()))
				.build();
	}
}

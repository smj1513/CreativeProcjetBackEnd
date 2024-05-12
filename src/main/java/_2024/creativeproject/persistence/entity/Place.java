package _2024.creativeproject.persistence.entity;

import _2024.creativeproject.utils.Enum.TourismType;
import _2024.creativeproject.utils.dto.domestic.Item;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Place {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String address1;
	private String address2;
	private String areaCode;
	private LocalDateTime createdTime;
	private double distance;
	private String title;
	private String telephone;
	private String firstImageURL;
	private String secondImageURL;
	private double xPos;
	private double yPos;

	@Enumerated(EnumType.STRING)
	private TourismType contentTypeId;

	public static Place from(Item item){
		return Place.builder()
				.address1(item.getAddr1())
				.address2(item.getAddr2())
				.title(item.getTitle())
				.distance(Double.parseDouble(item.getDist()))
				.contentTypeId(TourismType.valueOf(Integer.parseInt(item.getContentid())))
				.telephone(item.getTel())
				.firstImageURL(item.getFirstimage())
				.secondImageURL(item.getFirstimage2())
				.createdTime(LocalDateTime.parse(item.getCreatedtime(), DateTimeFormatter.ofPattern("yyyyMMddHHmmss")))
				.areaCode(item.getAreacode())
				.build();
	}
}

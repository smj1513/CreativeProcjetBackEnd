package _2024.creativeproject.utillity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class NaverShoppingDTO {
	@Getter(onMethod_ = {@JsonProperty("lastBuildDate")})
	@Setter(onMethod_ = {@JsonProperty("lastBuildDate")})
	private String lastBuildDate;
	@Getter(onMethod_ = {@JsonProperty("total")})
	@Setter(onMethod_ = {@JsonProperty("total")})
	private long total;
	@Getter(onMethod_ = {@JsonProperty("start")})
	@Setter(onMethod_ = {@JsonProperty("start")})
	private long start;
	@Getter(onMethod_ = {@JsonProperty("display")})
	@Setter(onMethod_ = {@JsonProperty("display")})
	private long display;
	@Getter(onMethod_ = {@JsonProperty("items")})
	@Setter(onMethod_ = {@JsonProperty("items")})
	private List<Item> items;

}


package _2024.creativeproject.utillity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Item {
	@Getter(onMethod_ = {@JsonProperty("title")})
	@Setter(onMethod_ = {@JsonProperty("title")})
	private String title;
	@Getter(onMethod_ = {@JsonProperty("link")})
	@Setter(onMethod_ = {@JsonProperty("link")})
	private String link;
	@Getter(onMethod_ = {@JsonProperty("image")})
	@Setter(onMethod_ = {@JsonProperty("image")})
	private String image;
	@Getter(onMethod_ = {@JsonProperty("lprice")})
	@Setter(onMethod_ = {@JsonProperty("lprice")})
	private String lprice;
	@Getter(onMethod_ = {@JsonProperty("hprice")})
	@Setter(onMethod_ = {@JsonProperty("hprice")})
	private String hprice;
	@Getter(onMethod_ = {@JsonProperty("mallName")})
	@Setter(onMethod_ = {@JsonProperty("mallName")})
	private String mallName;
	@Getter(onMethod_ = {@JsonProperty("productId")})
	@Setter(onMethod_ = {@JsonProperty("productId")})
	private String productID;
	@Getter(onMethod_ = {@JsonProperty("productType")})
	@Setter(onMethod_ = {@JsonProperty("productType")})
	private String productType;
	@Getter(onMethod_ = {@JsonProperty("brand")})
	@Setter(onMethod_ = {@JsonProperty("brand")})
	private String brand;
	@Getter(onMethod_ = {@JsonProperty("maker")})
	@Setter(onMethod_ = {@JsonProperty("maker")})
	private String maker;
	@Getter(onMethod_ = {@JsonProperty("category1")})
	@Setter(onMethod_ = {@JsonProperty("category1")})
	private String category1;
	@Getter(onMethod_ = {@JsonProperty("category2")})
	@Setter(onMethod_ = {@JsonProperty("category2")})
	private String category2;
	@Getter(onMethod_ = {@JsonProperty("category3")})
	@Setter(onMethod_ = {@JsonProperty("category3")})
	private String category3;
	@Getter(onMethod_ = {@JsonProperty("category4")})
	@Setter(onMethod_ = {@JsonProperty("category4")})
	private String category4;
}

package _2024.creativeproject.utils.dto.domestic;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Item {
    @Getter(onMethod_ = {@JsonProperty("addr1")})
    @Setter(onMethod_ = {@JsonProperty("addr1")})
    private String addr1;
    @Getter(onMethod_ = {@JsonProperty("addr2")})
    @Setter(onMethod_ = {@JsonProperty("addr2")})
    private String addr2;
    @Getter(onMethod_ = {@JsonProperty("areacode")})
    @Setter(onMethod_ = {@JsonProperty("areacode")})
    private String areacode;
    @Getter(onMethod_ = {@JsonProperty("booktour")})
    @Setter(onMethod_ = {@JsonProperty("booktour")})
    private String booktour;
    @Getter(onMethod_ = {@JsonProperty("cat1")})
    @Setter(onMethod_ = {@JsonProperty("cat1")})
    private String cat1;
    @Getter(onMethod_ = {@JsonProperty("cat2")})
    @Setter(onMethod_ = {@JsonProperty("cat2")})
    private String cat2;
    @Getter(onMethod_ = {@JsonProperty("cat3")})
    @Setter(onMethod_ = {@JsonProperty("cat3")})
    private String cat3;
    @Getter(onMethod_ = {@JsonProperty("contentid")})
    @Setter(onMethod_ = {@JsonProperty("contentid")})
    private String contentid;
    @Getter(onMethod_ = {@JsonProperty("contenttypeid")})
    @Setter(onMethod_ = {@JsonProperty("contenttypeid")})
    private String contenttypeid;
    @Getter(onMethod_ = {@JsonProperty("createdtime")})
    @Setter(onMethod_ = {@JsonProperty("createdtime")})
    private String createdtime;
    @Getter(onMethod_ = {@JsonProperty("dist")})
    @Setter(onMethod_ = {@JsonProperty("dist")})
    private String dist;
    @Getter(onMethod_ = {@JsonProperty("firstimage")})
    @Setter(onMethod_ = {@JsonProperty("firstimage")})
    private String firstimage;
    @Getter(onMethod_ = {@JsonProperty("firstimage2")})
    @Setter(onMethod_ = {@JsonProperty("firstimage2")})
    private String firstimage2;
    @Getter(onMethod_ = {@JsonProperty("cpyrhtDivCd")})
    @Setter(onMethod_ = {@JsonProperty("cpyrhtDivCd")})
    private String cpyrhtDivCD;
    @Getter(onMethod_ = {@JsonProperty("mapx")})
    @Setter(onMethod_ = {@JsonProperty("mapx")})
    private String mapx;
    @Getter(onMethod_ = {@JsonProperty("mapy")})
    @Setter(onMethod_ = {@JsonProperty("mapy")})
    private String mapy;
    @Getter(onMethod_ = {@JsonProperty("mlevel")})
    @Setter(onMethod_ = {@JsonProperty("mlevel")})
    private String mlevel;
    @Getter(onMethod_ = {@JsonProperty("modifiedtime")})
    @Setter(onMethod_ = {@JsonProperty("modifiedtime")})
    private String modifiedtime;
    @Getter(onMethod_ = {@JsonProperty("sigungucode")})
    @Setter(onMethod_ = {@JsonProperty("sigungucode")})
    private String sigungucode;
    @Getter(onMethod_ = {@JsonProperty("tel")})
    @Setter(onMethod_ = {@JsonProperty("tel")})
    private String tel;
    @Getter(onMethod_ = {@JsonProperty("title")})
    @Setter(onMethod_ = {@JsonProperty("title")})
    private String title;
}

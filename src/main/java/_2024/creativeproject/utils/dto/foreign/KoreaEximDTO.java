package _2024.creativeproject.utils.dto.foreign;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class  KoreaEximDTO {
    @Getter(onMethod_ = {@JsonProperty("result")})
    @Setter(onMethod_ = {@JsonProperty("result")})
    private long result;
    @Getter(onMethod_ = {@JsonProperty("cur_unit")})
    @Setter(onMethod_ = {@JsonProperty("cur_unit")})
    private String curUnit;
    @Getter(onMethod_ = {@JsonProperty("ttb")})
    @Setter(onMethod_ = {@JsonProperty("ttb")})
    private String ttb;
    @Getter(onMethod_ = {@JsonProperty("tts")})
    @Setter(onMethod_ = {@JsonProperty("tts")})
    private String tts;
    @Getter(onMethod_ = {@JsonProperty("deal_bas_r")})
    @Setter(onMethod_ = {@JsonProperty("deal_bas_r")})
    private String dealBasR;
    @Getter(onMethod_ = {@JsonProperty("bkpr")})
    @Setter(onMethod_ = {@JsonProperty("bkpr")})
    private String bkpr;
    @Getter(onMethod_ = {@JsonProperty("yy_efee_r")})
    @Setter(onMethod_ = {@JsonProperty("yy_efee_r")})
    private String yyEfeeR;
    @Getter(onMethod_ = {@JsonProperty("ten_dd_efee_r")})
    @Setter(onMethod_ = {@JsonProperty("ten_dd_efee_r")})
    private String tenDDEfeeR;
    @Getter(onMethod_ = {@JsonProperty("kftc_bkpr")})
    @Setter(onMethod_ = {@JsonProperty("kftc_bkpr")})
    private String kftcBkpr;
    @Getter(onMethod_ = {@JsonProperty("kftc_deal_bas_r")})
    @Setter(onMethod_ = {@JsonProperty("kftc_deal_bas_r")})
    private String kftcDealBasR;
    @Getter(onMethod_ = {@JsonProperty("cur_nm")})
    @Setter(onMethod_ = {@JsonProperty("cur_nm")})
    private String curNm;
}

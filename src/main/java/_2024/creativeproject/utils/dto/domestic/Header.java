package _2024.creativeproject.utils.dto.domestic;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

@lombok.Data
public class Header {
    @Getter(onMethod_ = {@JsonProperty("resultCode")})
    @Setter(onMethod_ = {@JsonProperty("resultCode")})
    private String resultCode;
    @Getter(onMethod_ = {@JsonProperty("resultMsg")})
    @Setter(onMethod_ = {@JsonProperty("resultMsg")})
    private String resultMsg;
}

package _2024.creativeproject.utils.dto.domestic;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Body {
    @Getter(onMethod_ = {@JsonProperty("items")})
    @Setter(onMethod_ = {@JsonProperty("items")})
    private Items items;
    @Getter(onMethod_ = {@JsonProperty("numOfRows")})
    @Setter(onMethod_ = {@JsonProperty("numOfRows")})
    private long numOfRows;
    @Getter(onMethod_ = {@JsonProperty("pageNo")})
    @Setter(onMethod_ = {@JsonProperty("pageNo")})
    private long pageNo;
    @Getter(onMethod_ = {@JsonProperty("totalCount")})
    @Setter(onMethod_ = {@JsonProperty("totalCount")})
    private long totalCount;
}

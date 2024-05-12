package _2024.creativeproject.utils.dto.domestic;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Response {
    @Getter(onMethod_ = {@JsonProperty("header")})
    @Setter(onMethod_ = {@JsonProperty("header")})
    private Header header;
    @Getter(onMethod_ = {@JsonProperty("body")})
    @Setter(onMethod_ = {@JsonProperty("body")})
    private Body body;
}

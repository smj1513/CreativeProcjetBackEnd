package _2024.creativeproject.utils.dto.domestic;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class TourismDTO {
    @Getter(onMethod_ = {@JsonProperty("response")})
    @Setter(onMethod_ = {@JsonProperty("response")})
    private Response response;
}

package _2024.creativeproject.utils.dto.domestic;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Items {
    @Getter(onMethod_ = {@JsonProperty("item")})
    @Setter(onMethod_ = {@JsonProperty("item")})
    private List<Item> item;
}

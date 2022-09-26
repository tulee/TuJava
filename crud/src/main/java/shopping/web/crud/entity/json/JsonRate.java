package shopping.web.crud.entity.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonRate {
    @JsonProperty(value = "USD")
    private float USD;

    @JsonProperty(value = "XAU")
    private float XAU;
}

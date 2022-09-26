package shopping.web.crud.deserializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import shopping.web.crud.entity.json.JsonRate;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class PriceDeserializer {
    @JsonProperty(value = "timestamp")
    private Timestamp timestamp;

    @JsonProperty(value = "date")
    private Date date;

    @JsonProperty(value = "status")
    private String status;

    @JsonProperty(value = "base")
    private String base;

    @JsonProperty(value = "rate")
    private String rate;

    @JsonProperty(value = "unit")
    private String unit;
}

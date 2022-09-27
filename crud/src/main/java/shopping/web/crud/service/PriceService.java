package shopping.web.crud.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import shopping.web.crud.deserializer.PriceDeserializer;
import shopping.web.crud.entity.Prices;
import shopping.web.crud.entity.repository.PricesRepository;
import shopping.web.crud.utils.JsonUtils;

import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class PriceService {
	@Autowired
	PricesRepository pricesRepository;

	private static final String openMapURL = "https://metals-api.com/api/latest?access_key=";
	private static final String apiParams = "&base=USD&symbols=XAU";

	@Value(value = "89qcrnvpsr1712qovonnobhhz5z4hci3gc6s7kja69jmb053kz9m152m9a11")
	private String apiKey;

	@Autowired
	@Qualifier("RestTemplate")
	private RestTemplate restTemplate;

	@Transactional
	public Prices getApiPrice() throws JsonProcessingException {
		//cách 2
//        RestTemplate restTemplate = new RestTemplate();

		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
		HttpHeaders openPriceHeaders = new HttpHeaders();
		HttpEntity<String> openPriceEntity = new HttpEntity<>(openPriceHeaders);
		final ResponseEntity<String> openPriceResponse = restTemplate.exchange(
				openMapURL + apiKey + apiParams,
				HttpMethod.GET, openPriceEntity, String.class);

		PriceDeserializer priceDeserializer = JsonUtils.toValue(openPriceResponse.getBody(), PriceDeserializer.class);

		return Prices.builder().timestamp(priceDeserializer.getTimestamp())
				.date(priceDeserializer.getDate())
				.base(priceDeserializer.getBase())
				.rate(priceDeserializer.getRate())
				.status(priceDeserializer.getStatus())
				.unit(priceDeserializer.getUnit())
				.build();
	}
}

package tech.pragmat.geolite2.web;

import com.maxmind.geoip2.exception.GeoIp2Exception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tech.pragmat.geolite2.service.GeoLite2CountryService;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/Geo2LiteCountry")
public class Geo2LiteCountryController {

    private final GeoLite2CountryService geoLite2CountryService;

    public Geo2LiteCountryController( GeoLite2CountryService geoLite2CountryService){
        this.geoLite2CountryService=geoLite2CountryService;
    }

    @GetMapping("/getCountryByIp")
    public String getCountryName(@RequestParam String ip) throws IOException, GeoIp2Exception {
        log.info("try get name of country by ip");
       return   geoLite2CountryService.getNameOfCountry(ip);
    }


}

package pragmat.tech.geolite2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pragmat.tech.geolite2.service.GeoLite2CountryService;

@RestController
@RequestMapping("/Geo2LiteCountry")
public class Geo2LiteCountryController {

    private GeoLite2CountryService geoLite2CountryService;

    public Geo2LiteCountryController( GeoLite2CountryService geoLite2CountryService){
        this.geoLite2CountryService=geoLite2CountryService;
    }

    @GetMapping("/getCountryByIp")
    public String getCountryName(@RequestParam String ip){
       return   geoLite2CountryService.getNameOfCountry(ip);
    }
}

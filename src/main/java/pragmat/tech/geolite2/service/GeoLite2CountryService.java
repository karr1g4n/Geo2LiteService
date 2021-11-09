package pragmat.tech.geolite2.service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.Country;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.net.InetAddress;


@Service
public class GeoLite2CountryService {
    public String getNameOfCountry(String ip){
        String url = "D:\\GeoLite2\\GeoLite2-Country.mmdb";
        FileInputStream database;
        try {
            database = new FileInputStream(url);
            DatabaseReader reader = new DatabaseReader.Builder(database).build();
            InetAddress ipAddress = InetAddress.getByName(ip);
            CountryResponse response = reader.country(ipAddress);
//            Country country = response.getCountry();
            Country country=response.getRegisteredCountry();
            return country.getName();
        } catch (Exception e) {
            return "not found";
        }
    }
}

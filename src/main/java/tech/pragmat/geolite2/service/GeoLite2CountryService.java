package tech.pragmat.geolite2.service;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;

@Slf4j
@Service
public class GeoLite2CountryService {

    private FileInputStream database;
    private DatabaseReader reader;
    @Value("${geolite2.url}")
    private String urlString;

    @PostConstruct
    void init() throws IOException {
        log.info(urlString);
        log.info(urlString);
        this.database = new FileInputStream(urlString);
        this.reader = new DatabaseReader.Builder(this.database).build();
    }

    public String getNameOfCountry(String ip) {
        try {
            InetAddress ipAddress = InetAddress.getByName(ip);
            CountryResponse response = reader.country(ipAddress);
            Country country = response.getCountry();
            return country.getName();
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return null;

    }
}

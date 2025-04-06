package nettee.cors.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "app.cors") //custom했다는 의미로 app.cors을 붙여주었음.
@ConfigurationPropertiesBinding
public record CorsProperties(
        @NestedConfigurationProperty
        MappedCorsProperties[] endpoints
) {
    //compact constructor
    //record는 allArgsConstructor에서 인스턴트 생성
    // 그 직전에 compact 생성
    public CorsProperties {
        for (var item: endpoints){
            System.out.println(item);
        }
    }
}

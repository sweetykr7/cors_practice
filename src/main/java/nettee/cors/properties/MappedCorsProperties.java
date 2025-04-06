package nettee.cors.properties;

import nettee.cors.properties.allowed.CorsAllowedProperties;
import nettee.cors.properties.exposed.CorsExposedProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationPropertiesBinding
public record MappedCorsProperties(
        String path,
        @NestedConfigurationProperty
        CorsAllowedProperties allowed,//allowed 객체
        @NestedConfigurationProperty
        CorsExposedProperties exposed, //exposed 객체
        long maxAge
) {
        public MappedCorsProperties {
                if (maxAge == 0){
                        maxAge = 3600L;
                }
        }
}

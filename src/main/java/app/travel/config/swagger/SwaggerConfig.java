package app.travel.config.swagger;

import app.travel.value.AppCoreValue;
import app.travel.value.OpenApiValue;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SwaggerConfig {

    OpenApiValue openApiValue;

    AppCoreValue appCoreValue;

    @Bean
    public OpenAPI openAPI(){

        Server server = new Server();
        server.setUrl(openApiValue.getServerUrl());
        server.setDescription(openApiValue.getServerDescription());

        Server resource = new Server();
        resource.setUrl(appCoreValue.getBackendDomain());
        resource.setDescription("Prefix Domain URL for request resourcing system.");

        final String securitySchemaName = "Bearer Authorization";

        return new OpenAPI()
                .servers(List.of(server, resource))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemaName))
                .info(info())
                .components(components(securitySchemaName));
    }

    public Info info(){

        Contact contact = new Contact();
        contact.setUrl(openApiValue.getContactUrl());
        contact.setName(openApiValue.getContactName());
        contact.setEmail(openApiValue.getContactEmail());

        License license = new License();
        license.setUrl(openApiValue.getLicenseUrl());
        license.setName(openApiValue.getLicenseName());

        Info info = new Info();
        info.setTitle(openApiValue.getInfoTitle());
        info.setVersion(openApiValue.getInfoVersion());
        info.setDescription(openApiValue.getInfoDescription());
        info.setContact(contact);
        info.setLicense(license);

        return info;
    }

    public Components components(String securitySchemaName){

        SecurityScheme securityScheme = new SecurityScheme();
        securityScheme.setName(securitySchemaName);
        securityScheme.setType(SecurityScheme.Type.HTTP);
        securityScheme.setScheme("bearer");
        securityScheme.setBearerFormat("JWT");

        Components components = new Components();
        components.addSecuritySchemes(securitySchemaName, securityScheme);

        return components;
    }

    @Bean
    public OpenApiCustomizer removeApiPrefixCustomizer(){

        return openApi -> {

            Paths paths = new Paths();

            openApi.getPaths().keySet().forEach(
                    path -> {

                        if(path.startsWith(appCoreValue.getContextPath())){

                            String pathWithoutPrefix = path.substring(appCoreValue.getContextPath().length());

                            paths.put(pathWithoutPrefix, openApi.getPaths().get(path));

                        }
                        else paths.put(path, openApi.getPaths().get(path));
                    }
            );

            openApi.setPaths(paths);
        };
    }

}

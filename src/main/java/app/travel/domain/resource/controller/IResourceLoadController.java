package app.travel.domain.resource.controller;

import app.travel.common.constant.other.ContentDispositionType;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface IResourceLoadController {

    @GetMapping("/{key:.+}")
    @Operation(
            summary = "Endpoint for load resource system.",
            description = "Select server include [Prefix Domain URL for load resource system.] then using this endpoint."
    )
    byte[] getResource(
            @PathVariable("key") String key,
            @RequestParam(value = "type", required = false) ContentDispositionType type,
            HttpServletResponse servletResponse
    ) throws Exception;

}

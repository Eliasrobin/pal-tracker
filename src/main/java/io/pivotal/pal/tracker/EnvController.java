package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private final String port;
    private final String memoryLimit;
    private final String cfInstanceIndex;
    private final String cfInstanceAddress;

    public EnvController(
            // Injects the PORT environment variable, defaults to NOT SET
            @Value("${port:NOT SET}") String port,
            // Injects the MEMORY_LIMIT environment variable, defaults to NOT SET
            @Value("${memory.limit:NOT SET}") String memoryLimit,
            // Injects the CF_INSTANCE_INDEX environment variable, defaults to NOT SET
            @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
            // Injects the CF_INSTANCE_ADDR environment variable, defaults to NOT SET
            @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddress
    ) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddress = cfInstanceAddress;
    }

    // Maps GET requests to /env
    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> result = new HashMap<>();
        result.put("PORT", port);
        result.put("MEMORY_LIMIT", memoryLimit);
        result.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        result.put("CF_INSTANCE_ADDR", cfInstanceAddress);
        return result;
    }
}

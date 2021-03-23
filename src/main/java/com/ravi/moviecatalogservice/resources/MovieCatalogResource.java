package com.ravi.moviecatalogservice.resources;


import com.ravi.moviecatalogservice.model.CatalogItem;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @RequestMapping("/{userId}")
    List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        List<CatalogItem> catalogItems = Collections.singletonList(
                new CatalogItem("Transformer", "why only 3", 5)
        );

        return catalogItems;
    }
}

package com.kushagra.smartcare_allocator.controller;

import com.kushagra.smartcare_allocator.entity.Resource;
import com.kushagra.smartcare_allocator.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getResource(@PathVariable int id){
        return resourceService.getResource(id);
    }
    @PostMapping
    public ResponseEntity<?> createResource(@RequestBody Resource resource){
        return resourceService.createResource(resource);
    }
    @PutMapping ("/id/{id}")
    public ResponseEntity<?> editResource(@PathVariable int id,@RequestBody Resource resource){
        return resourceService.editResource(id,resource);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteResource(@PathVariable int id){
        return resourceService.deleteResource(id);
    }
}

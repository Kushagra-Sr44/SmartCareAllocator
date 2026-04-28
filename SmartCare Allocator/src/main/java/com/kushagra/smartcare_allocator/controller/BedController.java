package com.kushagra.smartcare_allocator.controller;

import com.kushagra.smartcare_allocator.entity.Bed;
import com.kushagra.smartcare_allocator.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bed")
public class BedController {
    @Autowired
    private BedService bedService;

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getBed(@PathVariable int id) {
        return bedService.getBed(id);
    }

    @PostMapping("/post/{id}")
    public ResponseEntity<?> addBed(@RequestBody Bed bed) {
        return bedService.addBed(bed);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<?> editBed(@PathVariable int id, @RequestBody Bed bed) {
        return bedService.editBed(id, bed);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBed(@PathVariable int id) {
        return bedService.deleteBed(id);
    }
}

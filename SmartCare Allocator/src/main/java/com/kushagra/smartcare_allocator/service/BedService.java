package com.kushagra.smartcare_allocator.service;

import com.kushagra.smartcare_allocator.entity.Bed;
import com.kushagra.smartcare_allocator.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class BedService {
    @Autowired
    private BedRepository bedRepository;

    public ResponseEntity<?> addBed(Bed bed) {
        bedRepository.save(bed);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> getBed(int id) {
        Bed bed = bedRepository.findById(id).orElse(null);
        if (bed == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(bed, HttpStatus.OK);

    }

    public ResponseEntity<?> editBed(int id, Bed bed) {
        Bed oldbed = bedRepository.findById(id).orElse(null);
        if (oldbed == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else if (bed == null) return new ResponseEntity<>(HttpStatus.OK);
        oldbed.setBedNo(bed.getBedNo());
        oldbed.setStatus(bed.getStatus());
        oldbed.setWard(bed.getWard());
        bedRepository.save(oldbed);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> deleteBed(int id) {
        if (bedRepository.findById(id).orElse(null) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        bedRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

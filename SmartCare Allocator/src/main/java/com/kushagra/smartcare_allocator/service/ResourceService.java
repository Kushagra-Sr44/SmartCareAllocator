package com.kushagra.smartcare_allocator.service;
import com.kushagra.smartcare_allocator.entity.Resource;
import com.kushagra.smartcare_allocator.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    public ResponseEntity<?> getResource(int id){
        Resource resource=resourceRepository.findById(id).orElse(null);
        if(resource==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(resource,HttpStatus.OK);
    }

    public ResponseEntity<?> createResource(Resource resource){
        if(!resourceRepository.findById(resource.getRsId()).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        resourceRepository.save(resource);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<?> editResource(int id,Resource resource){
       resourceRepository.deleteById(id);
       resource.setRsId(id);
       resourceRepository.save(resource);
        return new ResponseEntity<>(resource,HttpStatus.OK);
    }
    public ResponseEntity<?> deleteResource(int id){
        Resource resource=resourceRepository.findById(id).orElse(null);
        if(resource==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        resourceRepository.deleteById(id);
        return new ResponseEntity<>(resource,HttpStatus.OK);
    }
}

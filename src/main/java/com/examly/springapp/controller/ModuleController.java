package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class ModuleController {
    
    @GetMapping
    public ResponseEntity<List<Object>> getAllModules() {
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getModuleById(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
    
    @PostMapping
    public ResponseEntity<Object> createModule(@RequestBody Object module) {
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateModule(@PathVariable Long id, @RequestBody Object module) {
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}

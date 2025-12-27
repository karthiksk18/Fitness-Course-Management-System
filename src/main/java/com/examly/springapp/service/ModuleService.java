package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Module;

public interface ModuleService {
    
    Module addModule(Module module);
    List<Module> getAllModules();
    Module getModuleById(int id);
    Module updateModule(int id, Module module);
}

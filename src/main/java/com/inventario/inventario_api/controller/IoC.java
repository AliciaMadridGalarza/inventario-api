package com.inventario.inventario_api.controller;

import com.inventario.inventario_api.repository.*;
import com.inventario.inventario_api.service.*;

public class IoC {
    private UsuarioRepository usuarioRepository;
    private SoftwareRepository softwareRepository;
    private AsignacionesRepository asignacionesRepository;
    private MantenimientoRepository mantenimientoRepository;
    private EquipoRepository equipoRepository;

    // Services
    private UsuarioService usuarioService;
    private SoftwareService softwareService;
    private AsignacionesService asignacionesService;
    private MantenimientoService mantenimientoService;
    private EquipoService equipoService;

    public IoC(
            UsuarioRepository usuarioRepository,
            SoftwareRepository softwareRepository,
            AsignacionesRepository asignacionesRepository,
            MantenimientoRepository mantenimientoRepository,
            EquipoRepository equipoRepository
    ) {
        this.usuarioRepository = usuarioRepository;
        this.softwareRepository = softwareRepository;
        this.asignacionesRepository = asignacionesRepository;
        this.mantenimientoRepository = mantenimientoRepository;
        this.equipoRepository = equipoRepository;

        this.usuarioService = new UsuarioService(usuarioRepository);
        this.softwareService = new SoftwareService(softwareRepository);
        this.asignacionesService = new AsignacionesService(asignacionesRepository);
        this.mantenimientoService = new MantenimientoService(mantenimientoRepository);
        this.equipoService = new EquipoService(equipoRepository);
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public SoftwareRepository getSoftwareRepository() {
        return softwareRepository;
    }

    public AsignacionesRepository getAsignacionesRepository() {
        return asignacionesRepository;
    }

    public MantenimientoRepository getMantenimientoRepository() {
        return mantenimientoRepository;
    }

    public EquipoRepository getEquipoRepository() {
        return equipoRepository;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public SoftwareService getSoftwareService() {
        return softwareService;
    }

    public AsignacionesService getAsignacionesService() {
        return asignacionesService;
    }

    public MantenimientoService getMantenimientoService() {
        return mantenimientoService;
    }

    public EquipoService getEquipoService() {
        return equipoService;
    }
}

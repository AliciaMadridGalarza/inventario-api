package com.inventario.inventario_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

public enum  TipoLicencia {
    PERPETUA, SUSCRIPTION, OPEN_SOURCE, FREEWARE
}
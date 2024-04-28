package com.angel.curso.springboot.springbootjpa.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Embeddable
public class Audit {
    @Column(name = "create_at")
    private LocalDateTime creatAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public LocalDateTime getCreatAt() {
        return creatAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @PrePersist
    public void prePersist() {
        System.out.println("Evento del ciclo de vida del objeto entity: pre-persist");
        this.creatAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        System.out.println("Evento del ciclo de vida del objeto entity: pre-update");
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "creatAt=" + this.getCreatAt() +
                ", updatedAt=" + this.getUpdatedAt();
    }
}

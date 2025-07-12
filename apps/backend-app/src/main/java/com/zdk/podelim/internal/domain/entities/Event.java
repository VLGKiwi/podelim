package com.zdk.podelim.internal.domain.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * domain entity event
 * @throws IllegalArgumentException if expiresAt before createdAt
 */
public class Event {
    private final UUID id;
    private String name;
    private final LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    public Event(UUID id, String name, LocalDateTime createdAt, LocalDateTime expiresAt) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(createdAt);
        Objects.requireNonNull(expiresAt);
        if (expiresAt.isBefore(createdAt)) throw new IllegalArgumentException("expiresAt cant't be before createdAt");
        
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public String toString() {
        return "Event [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", expiresAt=" + expiresAt + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Event event = (Event) obj;
        return Objects.equals(id, event.id);
    }
    
    

}

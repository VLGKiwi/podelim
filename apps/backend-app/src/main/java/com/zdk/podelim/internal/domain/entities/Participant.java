package com.zdk.podelim.internal.domain.entities;

import java.util.Objects;
import java.util.UUID;

/**
 * domain entity participant
 */
public class Participant {
    private final UUID eventId;
    private final long id;
    private String name;
    /**
     * userId field can be null if user is temporary
     */
    private final UUID userId;

    public Participant(UUID eventId, int id, String name, UUID userId) {
        Objects.requireNonNull(eventId);
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        
        this.eventId = eventId;
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    public UUID getEventId() {
        return eventId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Participant [eventId=" + eventId + ", id=" + id + ", name=" + name + ", userId=" + userId + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant participant = (Participant) obj;
        return Objects.equals(id, participant.id);
    }
}

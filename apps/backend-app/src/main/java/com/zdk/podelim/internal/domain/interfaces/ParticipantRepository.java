package com.zdk.podelim.internal.domain.interfaces;

import java.util.List;
import java.util.UUID;

import com.zdk.podelim.internal.domain.entities.Participant;

public interface ParticipantRepository {
    public void save(Participant participant);
    public List<Participant> findAllByEventId(UUID eventId);
    public Participant findById(long participantId);
    public void updateById(Participant participant, long participantId);
    public void deleteById(long participantId);
}

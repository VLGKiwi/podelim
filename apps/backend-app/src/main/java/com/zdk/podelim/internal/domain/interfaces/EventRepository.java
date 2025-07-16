package com.zdk.podelim.internal.domain.interfaces;

import java.util.List;
import java.util.UUID;

import com.zdk.podelim.internal.domain.entities.Event;

// TODO: рассмотреть вариант замены на Optional<Event> в readAll и findById
public interface EventRepository {
    public void save(Event event);
    public List<Event> readAll(); // в перспективе можно сделать возврат всех событий для конкретного зарегистрированного пользователя readAll(UUID userId);
    public Event findById(UUID id);
    public void updateById(Event event, UUID id);
    public void deleteById(UUID id);
}

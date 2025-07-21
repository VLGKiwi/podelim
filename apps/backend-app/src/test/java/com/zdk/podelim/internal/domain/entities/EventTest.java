package com.zdk.podelim.internal.domain.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.ZonedDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;

import com.zdk.podelim.internal.domain.entities.exceptions.EntityExceptions;

public class EventTest {
    @Test
    void testConstructor() {
        UUID id = UUID.randomUUID();
        ZonedDateTime createdAt = ZonedDateTime.now();
        String name = "Rock concert";
        ZonedDateTime expiresAt = createdAt.plusWeeks(3);

        Event event = new Event(id, name, createdAt, expiresAt);

        assertAll(
            "Проверка полей после Event конструктора",
            () -> assertEquals(id, event.getId()),
            () -> assertEquals(name, event.getName()),
            () -> assertEquals(createdAt, event.getCreatedAt()),
            () -> assertEquals(expiresAt, event.getExpiresAt())
            );
    }

    @Test
    void testConstructor_expiresAtIsBeforeCreationAt_invariant() {
        UUID id = UUID.randomUUID();
        ZonedDateTime createdAt = ZonedDateTime.now();
        String name = "Rock concert";
        ZonedDateTime expiresAt = createdAt.minusWeeks(3);

        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class, 
            () -> new Event(id, name, createdAt, expiresAt),
            "expected IllegalArgumentException when expiresAt is before creationAt"
            );
        assertEquals(ex.getMessage(), "expiresAt cant't be before createdAt", "should throw another error message");
    }

    @Test
    void testConstructor_nameIsBlank_throwError() {
        UUID id = UUID.randomUUID();
        ZonedDateTime createdAt = ZonedDateTime.now();
        String name = "    ";
        ZonedDateTime expiresAt = createdAt.plusWeeks(3);

        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class, 
            () -> new Event(id, name, createdAt, expiresAt),
            "expected IllegalArgumentException when name is blank"
            );
        assertEquals(ex.getMessage(), EntityExceptions.EVENT_NAME_CANNOT_BE_BLANK, "should throw another error message");
    }

    @Test
    void testConstructor_nullException_whenFieldsIsNull() {
        NullPointerException ex = assertThrows(
            NullPointerException.class, 
            () -> new Event(null, null, null, null),
            "expected NullPointerException when fields is null"
            );
        assertEquals(ex.getClass(), NullPointerException.class);
    }

    @Test
    void testGettersAndSetters() {
        UUID id = UUID.randomUUID();
        ZonedDateTime createdAt = ZonedDateTime.now();

        Event event = new Event(id, createdAt);

        String name = "Rock concert";
        ZonedDateTime expiresAt = createdAt.plusWeeks(3);
        event.setName(name);
        event.setExpiresAt(expiresAt);

        assertAll(
            "Проверка полей Event после геттеров и сеттеров",
            () -> assertEquals(id, event.getId()),
            () -> assertEquals(name, event.getName()),
            () -> assertEquals(createdAt, event.getCreatedAt()),
            () -> assertEquals(expiresAt, event.getExpiresAt())
        );
    }

    @Test
    void testEqualsAndHashCode() {
        UUID id = UUID.randomUUID();
        Event event1 = new Event(id, "Rock concert", ZonedDateTime.now(), ZonedDateTime.now().plusWeeks(3));
        Event event2 = new Event(id, "Rock festival", ZonedDateTime.now(), ZonedDateTime.now().plusWeeks(3));
        Event event3 = new Event(UUID.randomUUID(), "Rock concert", ZonedDateTime.now(), ZonedDateTime.now().plusWeeks(3));

        assertTrue(event1.equals(event2)); // event1 and event2 has identical ids.
        assertTrue(event1.hashCode() == event2.hashCode()); // event1 and event2 has identical hashCodes.
        assertFalse(event1.equals(event3)); // should return false because ev1 and ev2 has different ids.
        assertFalse(event1.hashCode() == event3.hashCode()); // should return false because ev1 and ev2 has different ids.
    }

    @Test
    void testToString() {
        UUID id = UUID.randomUUID();
        ZonedDateTime createdAt = ZonedDateTime.now();
        String name = "Rock concert";
        ZonedDateTime expiresAt = createdAt.plusWeeks(3);

        Event event = new Event(id, name, createdAt, expiresAt);

        String str = event.toString();

        assertAll(
            "str should contains all fields from class",
            () -> assertTrue(str.contains(id.toString())),
            () -> assertTrue(str.contains(name)),
            () -> assertTrue(str.contains(createdAt.toString())),
            () -> assertTrue(str.contains(expiresAt.toString()))
        );
    }
}

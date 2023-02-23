package org.launchcode.codingevents.models;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class EventData {
    //need a place to put events
    private static final Map<Integer, @Valid Event> events = new HashMap<>();

    //get all events
    public static Collection<org.launchcode.codingevents.models.@Valid Event> getAll() {
        return events.values();
    }

    //get a single event
    public static org.launchcode.codingevents.models.@Valid Event getById(int id) {
        return events.get(id);
    }

    // add an event
    public static void add(org.launchcode.codingevents.models.@Valid Event event) {
        events.put(event.getId(), event);
    }

    //remove an event
    public static void remove(int id) {
        events.remove(id);
    }

}

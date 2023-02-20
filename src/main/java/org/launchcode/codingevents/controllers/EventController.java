package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) Integer[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }


        return "redirect:";
    }


    //below is not working. I really think this should pass to a form that looks more like the delete.html form.
    //from there, the user selects which event they want to edit.
    //from there the selected event id passes to the below method and then that allows user to get Name and get description

    @GetMapping("edit")
    public String displayEditEventForm(Model model) {
        model.addAttribute("title", "Select Event to Edit");
        model.addAttribute("events", EventData.getAll());
        return "events/edit";
    }

//    @GetMapping("edit/{eventId}")
//    public String displayEditForm(Model model, @PathVariable Integer eventId) {
//        Event eventToEdit = EventData.getById(eventId);
//        model.addAttribute("event", eventToEdit);
//        String title = "Edit Event " + eventToEdit.getName() + " (id=" + eventToEdit.getId() + ")";
//        model.addAttribute("title", title );
//        return "events/edit";
//    }

    @PostMapping("edit")
    public String processEditForm(Integer eventId, String name, String description) {
        Event eventToEdit = EventData.getById(eventId);
        eventToEdit.setName(name);
        eventToEdit.setDescription(description);
        return "redirect:";
    }


//
//    Update the name and description of the event with the appropriate model setter methods.
//
//    Redirect the user to /events (the event listing page).

}

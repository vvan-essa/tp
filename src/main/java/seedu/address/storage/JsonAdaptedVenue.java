package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.venue.Venue;

public class JsonAdaptedVenue {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Venue's %s field is missing!";

    private final String name;
    private final String capacity;

    /**
     * Constructs a {@code JsonAdaptedVenue} with the given venue details.
     */
    @JsonCreator
    public JsonAdaptedVenue(@JsonProperty("name") String name, @JsonProperty("capacity") String capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    /**
     * Converts a given {@code Venue} into this class for Jackson use.
     */
    public JsonAdaptedVenue(Venue source) {
        name = source.getName();
        capacity = String.valueOf(source.getCapacity());
    }


    /**
     * Converts this Jackson-friendly adapted venue object into the model's {@code Venue} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted venue.
     */
    public Venue toModelType() throws IllegalValueException {
        // needs to be changed after implementation of classes for each of the attributes
        if (name == null) {
            throw new IllegalValueException(MISSING_FIELD_MESSAGE_FORMAT);
        }

        final String modelName = name;

        if (capacity == null) {
            throw new IllegalValueException(MISSING_FIELD_MESSAGE_FORMAT);
        }

        final int modelCapacity = Integer.parseInt(capacity);

        if (modelCapacity < 1) {
            throw new IllegalValueException(MISSING_FIELD_MESSAGE_FORMAT);
        }

        return new Venue(modelName, modelCapacity);
    }

}
package seedu.booking.model.venue;

import static java.util.Objects.requireNonNull;
import static seedu.booking.commons.util.AppUtil.checkArgument;

/**
 * Represents a Venue's capacity in the booking system.
 */
public class Capacity {

    public static final String MESSAGE_CONSTRAINTS = "Capacity cannot be less than 1 or more than 500000.";
    public static final String MESSAGE_INVALID = "Invalid input! Please input a valid number in digits.";

    public final Integer venueCapacity;

    /**
     * Constructs an {@code Capacity}.
     *
     * @param capacity A valid venue capacity.
     */
    public Capacity(Integer capacity) {
        requireNonNull(capacity);
        checkArgument(isValidCapacity(capacity), MESSAGE_CONSTRAINTS);
        venueCapacity = capacity;
    }

    /**
     * Returns true if a given Integer is a valid venue capacity.
     */
    public static boolean isValidCapacity(Integer test) {
        return test > 0 && test <= 500000;
    }

    @Override
    public String toString() {
        return venueCapacity.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Capacity // instanceof handles nulls
                && venueCapacity.equals(((Capacity) other).venueCapacity)); // state check
    }

    @Override
    public int hashCode() {
        return venueCapacity.hashCode();
    }
}

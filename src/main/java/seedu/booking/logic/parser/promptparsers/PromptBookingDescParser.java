package seedu.booking.logic.parser.promptparsers;

import seedu.booking.logic.commands.PromptBookingDescCommand;
import seedu.booking.logic.parser.Parser;
import seedu.booking.logic.parser.exceptions.ParseException;
import seedu.booking.model.booking.Description;

public class PromptBookingDescParser implements Parser<PromptBookingDescCommand> {

    /**
     * Parses user input for booking description
     */
    public PromptBookingDescCommand parse(String description) throws ParseException {

        if (description.equals("")) {
            description = "No description provided.";
        }

        return new PromptBookingDescCommand(new Description(description));
    }
}

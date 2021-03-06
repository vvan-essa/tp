package seedu.booking.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_BOOKING_END;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_BOOKING_START;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_CAPACITY;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_ORIGINAL_EMAIL;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_VENUE;
import static seedu.booking.logic.parser.CliSyntax.PREFIX_VENUE_ORIGINAL;
import static seedu.booking.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.booking.commons.core.index.Index;
import seedu.booking.logic.commands.exceptions.CommandException;
import seedu.booking.model.BookingSystem;
import seedu.booking.model.Model;
import seedu.booking.model.person.NameContainsKeywordsPredicate;
import seedu.booking.model.person.Person;
import seedu.booking.model.venue.Venue;
import seedu.booking.model.venue.VenueNameContainsKeywordsPredicate;
import seedu.booking.testutil.EditBookingCommandDescriptorBuilder;
import seedu.booking.testutil.EditPersonCommandDescriptorBuilder;
import seedu.booking.testutil.EditVenueDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String NON_EXISTENT_EMAIL = "unknown@example.com";


    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_PHONE_AMY = "11111111";
    public static final String VALID_PHONE_BOB = "22222222";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_AMY_GMAIL = "amy@gmail.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_EMAIL_BOB_GMAIL = "bob@gmail.com";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_TAG_FRIEND = "friend";
    public static final String VALID_DATE_FEBRUARY = "2020-02-12";
    public static final String VALID_DATE_MARCH = "2020-03-12";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String TAG_DESC_FRIEND = " " + PREFIX_TAG + VALID_TAG_FRIEND;
    public static final String TAG_DESC_HUSBAND = " " + PREFIX_TAG + VALID_TAG_HUSBAND;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags


    public static final String VALID_VENUE_NAME_APOSTROPHE = "Jo's House";
    public static final String VALID_VENUE_NAME_COURT = "Court";
    public static final String VALID_VENUE_NAME_HALL = "Victoria Hall";
    public static final String VALID_VENUE_NAME_HYPHEN = "Jon-And-Co";
    public static final String VALID_VENUE_NAME_FIELD = "Town Green";
    public static final String VALID_VENUE_NAME_VENUE1 = "Venue1";
    public static final String VALID_VENUE_NAME_VENUE2 = "Venue2";
    public static final String VALID_VENUE_NAME_VENUE3 = "Venue3";
    public static final int VALID_VENUE_CAPACITY_HALL = 50;
    public static final int VALID_VENUE_CAPACITY_FIELD = 60;
    public static final String VALID_VENUE_DESCRIPTION_HALL = "Good for large indoor events.";
    public static final String VALID_VENUE_DESCRIPTION_FIELD = "Popular sports location.";
    public static final String VALID_VENUE_TAGS_HALL = "Indoors";

    public static final String VENUE_NAME_DESC_APOSTROPHE = " " + PREFIX_VENUE + VALID_VENUE_NAME_APOSTROPHE;
    public static final String VENUE_NAME_DESC_HALL = " " + PREFIX_VENUE + VALID_VENUE_NAME_HALL;
    public static final String VENUE_NAME_DESC_HYPHEN = " " + PREFIX_VENUE + VALID_VENUE_NAME_HYPHEN;
    public static final String VENUE_NAME_DESC_FIELD = " " + PREFIX_VENUE + VALID_VENUE_NAME_FIELD;
    public static final String VENUE_NAME_DESC_VENUE1 = " " + PREFIX_VENUE + VALID_VENUE_NAME_VENUE1;
    public static final String VENUE_NAME_DESC_VENUE2 = " " + PREFIX_VENUE + VALID_VENUE_NAME_VENUE2;
    public static final String VENUE_CAPACITY_DESC_HALL = " " + PREFIX_CAPACITY + VALID_VENUE_CAPACITY_HALL;
    public static final String VENUE_CAPACITY_DESC_FIELD = " " + PREFIX_CAPACITY + VALID_VENUE_CAPACITY_FIELD;

    public static final String VENUE_DESCRIPTION_DESC_HALL = " " + PREFIX_DESCRIPTION + VALID_VENUE_DESCRIPTION_HALL;

    public static final String VENUE_TAGS_DESC_HALL = " " + PREFIX_TAG + VALID_VENUE_TAGS_HALL;

    public static final String ORIGINAL_EMAIL_DESC_AMY = " " + PREFIX_ORIGINAL_EMAIL + VALID_EMAIL_AMY_GMAIL;

    public static final String ORIGINAL_VENUE_DESC_HALL = " " + PREFIX_VENUE_ORIGINAL + VALID_VENUE_NAME_HALL;

    public static final String INVALID_VENUE_NAME_DESC = " " + PREFIX_VENUE + "!";

    // non-numerics not allowed
    public static final String INVALID_VENUE_CAPACITY_DESC = " " + PREFIX_CAPACITY + "-3";
    // capacity cannot be negative
    public static final String INVALID_VENUE_CAPACITY_DESC2 = " " + PREFIX_CAPACITY + "-2";

    public static final String VALID_VENUE_CAPACITY_DESC = " " + PREFIX_CAPACITY + "30";


    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditPersonCommand.EditPersonDescriptor VALID_PERSON_COMMAND_DESCRIPTOR_AMY;
    public static final EditPersonCommand.EditPersonDescriptor VALID_PERSON_COMMAND_DESCRIPTOR_BOB;

    public static final EditVenueCommand.EditVenueDescriptor DESC_COURT;
    public static final EditVenueCommand.EditVenueDescriptor DESC_HALL;

    public static final EditBookingCommand.EditBookingDescriptor VALID_BOOKING_COMMAND_DESCRIPTOR_HALL;
    public static final EditBookingCommand.EditBookingDescriptor VALID_BOOKING_COMMAND_DESCRIPTOR_FIELD;

    public static final String VALID_BOOKING_VENUE_NAME_HALL = "Victoria Hall";
    public static final String VALID_BOOKING_VENUE_NAME_FIELD = "Town Green";
    public static final String VALID_BOOKING_BOOKER_EMAIL_AMY = "amy@example.com";
    public static final String VALID_BOOKING_BOOKER_EMAIL_BOB = "bob@example.com";
    public static final String VALID_BOOKING_DESCRIPTION_HALL = "For FYP meeting";
    public static final String VALID_BOOKING_DESCRIPTION_FIELD = "For sports meeting";
    public static final String VALID_BOOKING_START_HALL = "2021-02-02 07:00";
    public static final String VALID_BOOKING_START_FIELD = "2021-02-03 07:00";
    public static final String VALID_BOOKING_END_HALL = "2021-02-02 08:00";
    public static final String VALID_BOOKING_END_FIELD = "2021-02-03 08:00";
    public static final String VALID_BOOKING_TAGS_HALL = "Indoors";
    public static final String VALID_BOOKING_TAGS_FIELD = "Outdoors";

    public static final String BOOKING_VENUE_NAME_DESC_HALL = " " + PREFIX_VENUE + VALID_VENUE_NAME_HALL;
    public static final String BOOKING_VENUE_NAME_DESC_FIELD = " " + PREFIX_VENUE + VALID_VENUE_NAME_FIELD;
    public static final String BOOKING_BOOKER_EMAIL_AMY_DESC_HALL =
            " " + PREFIX_EMAIL + VALID_BOOKING_BOOKER_EMAIL_AMY;
    public static final String BOOKING_BOOKER_EMAIL_BOB_DESC_FIELD =
            " " + PREFIX_EMAIL + VALID_BOOKING_BOOKER_EMAIL_BOB;
    public static final String BOOKING_DESCRIPTION_DESC_HALL =
            " " + PREFIX_DESCRIPTION + VALID_BOOKING_DESCRIPTION_HALL;
    public static final String BOOKING_DESCRIPTION_DESC_FIELD =
            " " + PREFIX_DESCRIPTION + VALID_BOOKING_DESCRIPTION_FIELD;
    public static final String BOOKING_START_DESC_HALL = " " + PREFIX_BOOKING_START + VALID_BOOKING_START_HALL;
    public static final String BOOKING_START_DESC_FIELD = " " + PREFIX_BOOKING_START + VALID_BOOKING_START_FIELD;
    public static final String BOOKING_END_DESC_HALL = " " + PREFIX_BOOKING_END + VALID_BOOKING_END_HALL;
    public static final String BOOKING_END_DESC_FIELD = " " + PREFIX_BOOKING_END + VALID_BOOKING_END_FIELD;
    public static final String BOOKING_TAGS_DESC_HALL = " " + PREFIX_TAG + VALID_BOOKING_TAGS_HALL;
    public static final String BOOKING_TAGS_DESC_FIELD = " " + PREFIX_TAG + VALID_BOOKING_TAGS_FIELD;
    public static final String INVALID_BOOKER_EMAIL = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol

    public static final String INVALID_BOOKING_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo";
    public static final String INVALID_BOOKING_VENUE_NAME_DESC = " " + PREFIX_VENUE + "James&";
    public static final String INVALID_BOOKING_START_DESC = " " + PREFIX_BOOKING_START + "911a";
    public static final String INVALID_BOOKING_END_DESC = " " + PREFIX_BOOKING_END;
    public static final String INVALID_BOOKING_TAG_DESC = " " + PREFIX_TAG + "hubby*";



    static {

        VALID_PERSON_COMMAND_DESCRIPTOR_AMY = new EditPersonCommandDescriptorBuilder().withName(VALID_NAME_AMY)
                .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY).build();
        VALID_PERSON_COMMAND_DESCRIPTOR_BOB = new EditPersonCommandDescriptorBuilder().withName(VALID_NAME_BOB)
                .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).build();

        DESC_HALL = new EditVenueDescriptorBuilder().withVenueName("Victoria Hall")
                .withCapacity(50).build();
        DESC_COURT = new EditVenueDescriptorBuilder().withVenueName("Court")
                .withCapacity(20).build();

        VALID_BOOKING_COMMAND_DESCRIPTOR_HALL = new EditBookingCommandDescriptorBuilder()
                .withBookerEmail(VALID_BOOKING_BOOKER_EMAIL_AMY).withVenueName(VALID_BOOKING_VENUE_NAME_HALL)
                .withDescription(VALID_BOOKING_DESCRIPTION_HALL).withBookingStart(VALID_BOOKING_START_HALL)
                .withBookingEnd(VALID_BOOKING_END_HALL).withTags(VALID_BOOKING_TAGS_HALL).build();
        VALID_BOOKING_COMMAND_DESCRIPTOR_FIELD = new EditBookingCommandDescriptorBuilder()
                .withBookerEmail(VALID_BOOKING_BOOKER_EMAIL_BOB).withVenueName(VALID_BOOKING_VENUE_NAME_FIELD)
                .withDescription(VALID_BOOKING_DESCRIPTION_FIELD).withBookingStart(VALID_BOOKING_START_FIELD)
                .withBookingEnd(VALID_BOOKING_END_FIELD).withTags(VALID_BOOKING_TAGS_FIELD).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            CommandShowType showType, Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage, showType);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the booking system, filtered person list and selected person in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        BookingSystem expectedBookingSystem = new BookingSystem(actualModel.getBookingSystem());
        List<Person> expectedFilteredList = new ArrayList<>(actualModel.getFilteredPersonList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedBookingSystem, actualModel.getBookingSystem());
        assertEquals(expectedFilteredList, actualModel.getFilteredPersonList());
    }

    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s booking system.
     */
    public static void showPersonAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredPersonList().size());

        Person person = model.getFilteredPersonList().get(targetIndex.getZeroBased());
        final String[] splitName = person.getName().fullName.split("\\s+");
        model.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));
        assertEquals(1, model.getFilteredPersonList().size());
    }

    /**
     * Updates {@code model}'s filtered list to show only the venue at the given {@code targetIndex} in the
     * {@code model}'s booking system.
     */
    public static void showVenueAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredVenueList().size());

        Venue venue = model.getFilteredVenueList().get(targetIndex.getZeroBased());
        final String[] splitName = venue.getVenueName().venueName.split("\\s+");
        model.updateFilteredVenueList(new VenueNameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredVenueList().size());
    }

}

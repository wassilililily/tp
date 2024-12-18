package seedu.address.logic.parser;

import static seedu.address.logic.Messages.DELETE_COMMAND_USAGE;
import static seedu.address.logic.Messages.MESSAGE_MISSING_INDEX;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteCompanyCommand;
import seedu.address.logic.commands.DeleteContactCommand;
import seedu.address.logic.commands.DeleteJobCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new subclass of DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteContactCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCommand parse(String args) throws ParseException {


        String[] splitArgs = args.trim().split("\\s+");

        if (args.length() < 1) {
            throw new ParseException(DELETE_COMMAND_USAGE);
        } else if (splitArgs.length < 2) {
            throw new ParseException(MESSAGE_MISSING_INDEX);
        }

        String entityType = splitArgs[0]; // either "contact, "job" or "company"
        String indexString = splitArgs[1];

        Index index = ParserUtil.parseIndex(indexString);

        switch (entityType) {
        case DeleteContactCommand.ENTITY_WORD:
            return new DeleteContactCommand(index);
        case DeleteJobCommand.ENTITY_WORD:
            return new DeleteJobCommand(index);
        case DeleteCompanyCommand.ENTITY_WORD:
            return new DeleteCompanyCommand(index);
        default:
            throw new ParseException(DELETE_COMMAND_USAGE);
        }
    }
}

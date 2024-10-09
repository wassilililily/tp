package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.company.Company;


/**
 * Deletes a company identified using it's displayed index from the address book.
 */
public class DeleteCompanyCommand extends DeleteContactCommand {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the company identified by the index number used in the displayed company list.\n"
            + "Parameters: company INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " company 1";
    public static final String MESSAGE_DELETE_COMPANY_SUCCESS = "Company %1$s - %2$s - %3$s - %4$s"
            + "has been successfully deleted.";

    public DeleteCompanyCommand(Index targetIndex) {
        super(targetIndex);
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Company> lastShownList = model.getFilteredCompanyList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Company companyToDelete = lastShownList.get(super.targetIndex.getZeroBased());
        String name = companyToDelete.getName().toString();
        String address = companyToDelete.getAddress().toString();
        String billingDate = companyToDelete.getBillingDate().toString();
        String phone = companyToDelete.getPhone().toString();

        model.deleteCompany(companyToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_CONTACT_SUCCESS, name,
                address, billingDate, phone));
    }
}
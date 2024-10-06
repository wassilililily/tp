package seedu.address.model.job;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * // TODO: Not unique yet
 * A list of jobs.
 */
public class UniqueJobList implements Iterable<Job> {

    private final ObservableList<Job> internalList = FXCollections.observableArrayList();
    private final ObservableList<Job> internalUnmodifiableList = FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent person as the given argument.
     */
    //    public boolean contains(Job toCheck) {
    //        requireNonNull(toCheck);
    //        return internalList.stream().anyMatch(toCheck::isSamePerson);
    //    }

    /**
     * Adds a person to the list.
     * The person must not already exist in the list.
     */
    public void add(Job toAdd) {
        requireNonNull(toAdd);
        //        if (contains(toAdd)) {
        //            throw new DuplicatePersonException();
        //        }
        internalList.add(toAdd);
    }

    /**
     * Replaces the person {@code target} in the list with {@code editedPerson}.
     * {@code target} must exist in the list.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the 
     * list.
     */
    //    public void setPerson(Person target, Person editedPerson) {
    //        requireAllNonNull(target, editedPerson);
    //
    //        int index = internalList.indexOf(target);
    //        if (index == -1) {
    //            throw new PersonNotFoundException();
    //        }
    //
    //        if (!target.isSamePerson(editedPerson) && contains(editedPerson)) {
    //            throw new DuplicatePersonException();
    //        }
    //
    //        internalList.set(index, editedPerson);
    //    }

    /**
     * Removes the equivalent person from the list.
     * The person must exist in the list.
     */
    //    public void remove(Person toRemove) {
    //        requireNonNull(toRemove);
    //        if (!internalList.remove(toRemove)) {
    //            throw new PersonNotFoundException();
    //        }
    //    }
    public void setJobs(UniqueJobList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setJobs(List<Job> persons) {
        requireAllNonNull(persons);
        //        if (!personsAreUnique(persons)) {
        //            throw new DuplicatePersonException();
        //        }

        internalList.setAll(persons);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<Job> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Job> iterator() {
        return internalList.iterator();
    }

    //    @Override
    //    public boolean equals(Object other) {
    //        if (other == this) {
    //            return true;
    //        }
    //
    //        // instanceof handles nulls
    //        if (!(other instanceof UniquePersonList)) {
    //            return false;
    //        }
    //
    //        UniquePersonList otherUniquePersonList = (UniquePersonList) other;
    //        return internalList.equals(otherUniquePersonList.internalList);
    //    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }

    /**
     * Returns true if {@code persons} contains only unique persons.
     */
    //    private boolean personsAreUnique(List<Person> persons) {
    //        for (int i = 0; i < persons.size() - 1; i++) {
    //            for (int j = i + 1; j < persons.size(); j++) {
    //                if (persons.get(i).isSamePerson(persons.get(j))) {
    //                    return false;
    //                }
    //            }
    //        }
    //        return true;
    //    }
}

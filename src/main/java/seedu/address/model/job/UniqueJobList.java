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
     * Adds a job to the list.
     * The job must not already exist in the list.
     */
    public void add(Job toAdd) {
        requireNonNull(toAdd);
        // TODO: Add data invalidation
        internalList.add(toAdd);
    }

    public void setJobs(UniqueJobList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code jobs}.
     * {@code jobs} must not contain duplicate jobs.
     */
    public void setJobs(List<Job> jobs) {
        requireAllNonNull(jobs);
        // TODO: Add data invalidation
        internalList.setAll(jobs);
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

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }
}

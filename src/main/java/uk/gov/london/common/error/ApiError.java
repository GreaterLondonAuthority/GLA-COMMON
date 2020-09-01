/**
 * Copyright (c) Greater London Authority, 2016.
 *
 * This source code is licensed under the Open Government Licence 3.0.
 *
 * http://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/
 */
package uk.gov.london.common.error;

import java.util.List;

import static uk.gov.london.common.GlaUtils.generateRandomId;

/**
 * Details of errors returned by the OPS REST API.
 */
public class ApiError {

    private String description;

    private List<ApiErrorItem> errors;

    private String id;

    public ApiError() {
    }

    public ApiError(String description) {
        this.description = description;
        this.errors = null;
        setErrorId();
    }

    public ApiError(String description, List<ApiErrorItem> errors) {
        this.description = description;
        this.errors = errors;
        setErrorId();
    }

    private void setErrorId() {
        this.id = generateRandomId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the uk.gov.london.common.error ID, which will be a random 8 digit hexadecimal number.
     *
     * Every instance of the uk.gov.london.common.error should have its own ID, with low (though non-zero)
     * probability of collisions.
     *
     * API server code should write the uk.gov.london.common.error details, including the uk.gov.london.common.error ID, to
     * log files. Client code should provide the uk.gov.london.common.error ID to the user in any uk.gov.london.common.error
     * notification message, allowing users to provide the ID to support staff who
     * can then use it to locate the appropriate server log entries.
     */


    public String getDescription() {
        return description;
    }

    public List<ApiErrorItem> getErrors() {
        return errors;
    }

}

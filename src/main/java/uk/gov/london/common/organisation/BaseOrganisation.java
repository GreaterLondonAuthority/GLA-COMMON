/**
 * Copyright (c) Greater London Authority, 2016.
 *
 * This source code is licensed under the Open Government Licence 3.0.
 *
 * http://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/
 */
package uk.gov.london.common.organisation;

public abstract class BaseOrganisation {

    public abstract OrganisationType getType();

    public abstract void setType(OrganisationType type);

    public abstract String getExternalReference();

    public abstract void setExternalReference(String ref);
}

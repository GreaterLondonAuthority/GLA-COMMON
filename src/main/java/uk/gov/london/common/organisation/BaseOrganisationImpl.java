/**
 * Copyright (c) Greater London Authority, 2016.
 *
 * This source code is licensed under the Open Government Licence 3.0.
 *
 * http://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/
 */
package uk.gov.london.common.organisation;

public class BaseOrganisationImpl extends BaseOrganisation {

    private String externalReference;

    @Override
    public String getExternalReference() {
        return externalReference;
    }

    @Override
    public void setExternalReference(String ref) {
        this.externalReference = ref;
    }

}

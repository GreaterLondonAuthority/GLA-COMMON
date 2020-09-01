/**
 * Copyright (c) Greater London Authority, 2016.
 *
 * This source code is licensed under the Open Government Licence 3.0.
 *
 * http://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/
 */
package uk.gov.london.common.user;

import uk.gov.london.common.organisation.BaseOrganisation;

public class BaseRoleImpl extends BaseRole {

    private String name;
    private boolean approved;
    private BaseOrganisation organisation;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isApproved() {
        return approved;
    }

    @Override
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public BaseOrganisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(BaseOrganisation organisation) {
        this.organisation = organisation;
    }

}

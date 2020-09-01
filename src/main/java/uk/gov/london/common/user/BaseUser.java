/**
 * Copyright (c) Greater London Authority, 2016.
 *
 * This source code is licensed under the Open Government Licence 3.0.
 *
 * http://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/
 */
package uk.gov.london.common.user;

import uk.gov.london.common.organisation.OrganisationType;

import java.util.Set;
import java.util.stream.Collectors;

import static uk.gov.london.common.user.BaseRole.*;
import static uk.gov.london.common.user.BaseRole.GLA_FINANCE;
import static uk.gov.london.common.user.BaseRole.GLA_READ_ONLY;

public abstract class BaseUser {

    /**
     * @return true if the user has the GLA role (Admin, SPM or PM).
     */
    public boolean isGla() {
        return hasRole(OPS_ADMIN) || hasRole(GLA_ORG_ADMIN) || hasRole(GLA_SPM) || hasRole(GLA_PM) || hasRole(GLA_FINANCE) || hasRole(GLA_READ_ONLY);
    }

    public boolean hasRole(String role) {
        return getRoles().stream().filter(BaseRole::isApproved).map(BaseRole::getName).collect(Collectors.toList()).contains(role);
    }

    public abstract Set<? extends BaseRole> getRoles();

    /**
     * @param organisationType
     * @return true if the user has an approved role in an organisation of the given type.
     */
    public boolean inOrganisationOfType(OrganisationType organisationType) {
        return getRoles().stream().filter(BaseRole::isApproved).anyMatch(r -> organisationType.equals(r.getOrganisation().getType()));
    }

}

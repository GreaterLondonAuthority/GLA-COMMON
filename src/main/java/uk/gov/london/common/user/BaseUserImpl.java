/**
 * Copyright (c) Greater London Authority, 2016.
 *
 * This source code is licensed under the Open Government Licence 3.0.
 *
 * http://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/
 */
package uk.gov.london.common.user;

import java.util.HashSet;
import java.util.Set;

public class BaseUserImpl extends BaseUser {

    private Set<? extends BaseRole> roles = new HashSet<>();

    @Override
    public Set<? extends BaseRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<? extends BaseRole> roles) {
        this.roles = roles;
    }

}

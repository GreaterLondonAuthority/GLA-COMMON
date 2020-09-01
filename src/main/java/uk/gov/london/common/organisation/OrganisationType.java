/**
 * Copyright (c) Greater London Authority, 2016.
 *
 * This source code is licensed under the Open Government Licence 3.0.
 *
 * http://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/
 */
package uk.gov.london.common.organisation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum OrganisationType {

    MANAGING_ORGANISATION (1, "Managing Organisation", false, true),
    BOROUGH (2, "Borough", true, false),
    PROVIDER (3, "Registered Provider", true, false),
    OTHER (4, "Other", false, false),
    TECHNICAL_SUPPORT (5, "Technical Support", false, false),
    LEARNING_PROVIDER (6, "Learning Provider", false, false),
    SMALL_BUSINESS (7, "Small Business", false, false),
    TEAM (8, "Team", false, false);

    private final int id;
    private final String summary;
    private final boolean annualReturnsEnabled;
    private final boolean internal;

    OrganisationType(int id, String summary, boolean annualReturnsEnabled, boolean internal) {
        this.id = id;
        this.summary = summary;
        this.annualReturnsEnabled = annualReturnsEnabled;
        this.internal = internal;
    }

    public int id() {
        return id;
    }

    public String summary() {
        return summary;
    }

    public boolean isAnnualReturnsEnabled() {
        return annualReturnsEnabled;
    }

    public static OrganisationType fromId(int id) {
        for (OrganisationType type: OrganisationType.values()) {
            if (type.id == id) {
                return type;
            }
        }
        return null;
    }

    public static List<Integer> getInternalOrganisationTypesIds() {
        return Arrays.stream(values())
                .filter(ot -> ot.internal).map(organisationType -> organisationType.id)
                .collect(Collectors.toList());
    }
}

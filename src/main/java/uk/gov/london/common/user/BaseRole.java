/**
 * Copyright (c) Greater London Authority, 2016.
 *
 * This source code is licensed under the Open Government Licence 3.0.
 *
 * http://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/
 */
package uk.gov.london.common.user;

import uk.gov.london.common.organisation.BaseOrganisation;

import java.util.*;

public abstract class BaseRole {

    public static final String OPS_ADMIN = "ROLE_OPS_ADMIN";
    public static final String GLA_ORG_ADMIN = "ROLE_GLA_ORG_ADMIN";
    public static final String GLA_SPM = "ROLE_GLA_SPM";
    public static final String GLA_PM = "ROLE_GLA_PM";
    public static final String GLA_REGISTRATION_APPROVER = "ROLE_GLA_REGISTRATION_APPROVER";
    public static final String GLA_PROGRAMME_ADMIN = "ROLE_GLA_PROGRAMME_ADMIN";
    public static final String GLA_FINANCE = "ROLE_GLA_FINANCE";
    public static final String GLA_READ_ONLY = "ROLE_GLA_READ_ONLY";
    public static final String PROJECT_READER = "ROLE_PROJECT_READER";
    public static final String ORG_ADMIN = "ROLE_ORG_ADMIN";
    public static final String PROJECT_EDITOR = "ROLE_PROJECT_EDITOR";
    public static final String TECH_ADMIN = "ROLE_TECH_ADMIN";
    public static final String INTERNAL_BLOCK_EDITOR = "ROLE_INTERNAL_BLOCK_EDITOR";

    public static final String OPS_ADMIN_DESC = "OPS Admin";
    public static final String GLA_ORG_ADMIN_DESC = "GLA Organisation Admin";
    public static final String GLA_SPM_DESC = "Senior Project Manager";
    public static final String GLA_PM_DESC = "Project Manager";
    public static final String GLA_REGISTRATION_APPROVER_DESC = "Registration Approver";
    public static final String GLA_PROGRAMME_ADMIN_DESC = "Programme Admin";
    public static final String GLA_FINANCE_DESC = "GLA Finance";
    public static final String GLA_READ_ONLY_DESC = "GLA Read Only";
    public static final String PROJECT_READER_DESC = "Project Reader";
    public static final String ORG_ADMIN_DESC = "Organisation Admin";
    public static final String PROJECT_EDITOR_DESC = "Project Editor";
    public static final String TECH_ADMIN_DESC = "Technical Admin";
    public static final String INTERNAL_BLOCK_EDITOR_DESC = "Internal Block Editor";

    public static final List<String> ALL_ROLES = Arrays.asList(
            OPS_ADMIN,
            GLA_ORG_ADMIN,
            GLA_SPM,
            GLA_PM,
            GLA_REGISTRATION_APPROVER,
            GLA_PROGRAMME_ADMIN,
            GLA_FINANCE,
            GLA_READ_ONLY,
            PROJECT_READER,
            ORG_ADMIN,
            PROJECT_EDITOR,
            TECH_ADMIN,
            INTERNAL_BLOCK_EDITOR
    );

    private static final List<String> GLA_ROLES = Arrays.asList(
            OPS_ADMIN,
            GLA_ORG_ADMIN,
            GLA_SPM,
            GLA_PM,
            GLA_REGISTRATION_APPROVER,
            GLA_PROGRAMME_ADMIN,
            GLA_FINANCE,
            GLA_READ_ONLY
    );

    private static final List<String> EXTERNAL_ROLES = Arrays.asList(
            ORG_ADMIN,
            PROJECT_EDITOR,
            PROJECT_READER
    );

    public static final Map<String, String> ROLES_AND_DESCRIPTIONS = new HashMap<String, String>() {{
        put(OPS_ADMIN, OPS_ADMIN_DESC);
        put(GLA_ORG_ADMIN, GLA_ORG_ADMIN_DESC);
        put(GLA_SPM, GLA_SPM_DESC);
        put(GLA_PM, GLA_PM_DESC);
        put(GLA_REGISTRATION_APPROVER, GLA_REGISTRATION_APPROVER_DESC);
        put(GLA_PROGRAMME_ADMIN, GLA_PROGRAMME_ADMIN_DESC);
        put(GLA_FINANCE, GLA_FINANCE_DESC);
        put(GLA_READ_ONLY, GLA_READ_ONLY_DESC);
        put(PROJECT_READER, PROJECT_READER_DESC);
        put(ORG_ADMIN, ORG_ADMIN_DESC);
        put(PROJECT_EDITOR, PROJECT_EDITOR_DESC);
        put(TECH_ADMIN, TECH_ADMIN_DESC);
        put(INTERNAL_BLOCK_EDITOR, INTERNAL_BLOCK_EDITOR_DESC);
    }};

    /**
     * @return the complete list of valid assignable user roles.
     */
    public static List<String> availableRoles() {
        return ALL_ROLES;
    }

    public static List<String> glaRoles() {
        return GLA_ROLES;
    }

    public static List<String> externalRoles() {
        return EXTERNAL_ROLES;
    }

    public static String getDescription(String role) {
        return ROLES_AND_DESCRIPTIONS.get(role);
    }

    public static String getHighestPriorityRole(Set<String> roles) {
        if (roles.contains(OPS_ADMIN)) return OPS_ADMIN;
        if (roles.contains(GLA_ORG_ADMIN)) return GLA_ORG_ADMIN;
        if (roles.contains(GLA_SPM)) return GLA_SPM;
        if (roles.contains(GLA_PM)) return GLA_PM;
        if (roles.contains(GLA_REGISTRATION_APPROVER)) return GLA_REGISTRATION_APPROVER;
        if (roles.contains(GLA_PROGRAMME_ADMIN)) return GLA_PROGRAMME_ADMIN;
        if (roles.contains(GLA_FINANCE)) return GLA_FINANCE;
        if (roles.contains(GLA_READ_ONLY)) return GLA_READ_ONLY;
        if (roles.contains(ORG_ADMIN)) return ORG_ADMIN;
        if (roles.contains(PROJECT_EDITOR)) return PROJECT_EDITOR;
        if (roles.contains(PROJECT_READER)) return PROJECT_READER;
        return TECH_ADMIN;
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract boolean isApproved();

    public abstract void setApproved(boolean approved);

    public abstract BaseOrganisation getOrganisation();

}

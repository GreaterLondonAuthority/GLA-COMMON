/**
 * Copyright (c) Greater London Authority, 2016.
 *
 * This source code is licensed under the Open Government Licence 3.0.
 *
 * http://www.nationalarchives.gov.uk/doc/open-government-licence/version/3/
 */
package uk.gov.london.common.skills;

import java.math.BigDecimal;
import java.util.Objects;

public class FundingRecord {

    private Integer ukprn;

    private Integer academicYear;

    private Integer period;

    private Integer actualYear;

    private Integer actualMonth;

    private SkillsGrantType grantType;

    private String fundingLine;

    private String source;

    private String category;

    private BigDecimal monthTotal;

    private BigDecimal totalPayment;

    public FundingRecord() {}

    public FundingRecord(Integer ukprn, Integer academicYear, Integer period, Integer actualYear, Integer actualMonth, SkillsGrantType grantType, String fundingLine, String source, String category, BigDecimal monthTotal, BigDecimal totalPayment) {
        this.ukprn = ukprn;
        this.academicYear = academicYear;
        this.period = period;
        this.actualYear = actualYear;
        this.actualMonth = actualMonth;
        this.grantType = grantType;
        this.fundingLine = fundingLine;
        this.source = source;
        this.category = category;
        this.monthTotal = monthTotal;
        this.totalPayment = totalPayment;
    }

    public Integer getUkprn() {
        return ukprn;
    }

    public void setUkprn(Integer ukprn) {
        this.ukprn = ukprn;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(BigDecimal totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getFundingLine() {
        return fundingLine;
    }

    public void setFundingLine(String fundingLine) {
        this.fundingLine = fundingLine;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public BigDecimal getMonthTotal() {
        return monthTotal;
    }

    public void setMonthTotal(BigDecimal monthTotal) {
        this.monthTotal = monthTotal;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Integer academicYear) {
        this.academicYear = academicYear;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getActualYear() {
        return actualYear;
    }

    public void setActualYear(Integer actualYear) {
        this.actualYear = actualYear;
    }

    public Integer getActualMonth() {
        return actualMonth;
    }

    public void setActualMonth(Integer actualMonth) {
        this.actualMonth = actualMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FundingRecord that = (FundingRecord) o;
        return Objects.equals(ukprn, that.ukprn) &&
                Objects.equals(academicYear, that.academicYear) &&
                Objects.equals(period, that.period) &&
                grantType == that.grantType &&
                Objects.equals(totalPayment, that.totalPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ukprn, academicYear, period, grantType, totalPayment);
    }

    public SkillsGrantType getGrantType() {
        return grantType;
    }

    public void setGrantType(SkillsGrantType grantType) {
        this.grantType = grantType;
    }

    @Override
    public String toString() {
        return "FundingRecord{" +
                "ukprn=" + ukprn +
                ", academicYear=" + academicYear +
                ", period=" + period +
                ", actualYear=" + actualYear +
                ", actualMonth=" + actualMonth +
                ", grantType=" + grantType +
                ", fundingLine='" + fundingLine + '\'' +
                ", source='" + source + '\'' +
                ", category='" + category + '\'' +
                ", monthTotal=" + monthTotal +
                ", totalPayment=" + totalPayment +
                '}';
    }
}

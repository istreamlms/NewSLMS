/**
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this file,
 * You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mifosplatform.portfolio.loanaccount.loanschedule.data;

import java.math.BigDecimal;

import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 * Immutable data object that represents a period of a loan schedule.
 * 
 */
public class LoanSchedulePeriodData {

    private final Integer period;
    private final LocalDate fromDate;
    private final LocalDate dueDate;
    @SuppressWarnings("unused")
    private final LocalDate obligationsMetOnDate;
    @SuppressWarnings("unused")
    private final Boolean complete;
    private final Integer daysInPeriod;
    private final BigDecimal principalDisbursed;
    @SuppressWarnings("unused")
    private final BigDecimal principalOriginalDue;
    private final BigDecimal principalDue;
    private final BigDecimal principalPaid;
    private final BigDecimal principalWrittenOff;
    private final BigDecimal principalOutstanding;
    @SuppressWarnings("unused")
    private final BigDecimal principalLoanBalanceOutstanding;
    @SuppressWarnings("unused")
    private final BigDecimal interestOriginalDue;
    private final BigDecimal interestDue;
    private final BigDecimal interestPaid;
    private final BigDecimal interestWaived;
    private final BigDecimal interestWrittenOff;
    private final BigDecimal interestOutstanding;
    private final BigDecimal feeChargesDue;
    private final BigDecimal feeChargesPaid;
    private final BigDecimal feeChargesWaived;
    private final BigDecimal feeChargesWrittenOff;
    private final BigDecimal feeChargesOutstanding;
    private final BigDecimal penaltyChargesDue;
    private final BigDecimal penaltyChargesPaid;
    private final BigDecimal penaltyChargesWaived;
    private final BigDecimal penaltyChargesWrittenOff;
    private final BigDecimal penaltyChargesOutstanding;

    @SuppressWarnings("unused")
    private final BigDecimal totalOriginalDueForPeriod;
    @SuppressWarnings("unused")
    private final BigDecimal totalDueForPeriod;
    @SuppressWarnings("unused")
    private final BigDecimal totalPaidForPeriod;
    @SuppressWarnings("unused")
    private final BigDecimal totalPaidInAdvanceForPeriod;
    @SuppressWarnings("unused")
    private final BigDecimal totalPaidLateForPeriod;
    @SuppressWarnings("unused")
    private final BigDecimal totalWaivedForPeriod;
    @SuppressWarnings("unused")
    private final BigDecimal totalWrittenOffForPeriod;
    private final BigDecimal totalOutstandingForPeriod;
    private final BigDecimal totalOverdue;
    @SuppressWarnings("unused")
    private final BigDecimal totalActualCostOfLoanForPeriod;
    @SuppressWarnings("unused")
    private  BigDecimal residualAmount;
    @SuppressWarnings("unused")
    private  BigDecimal depositAmount;
    public static LoanSchedulePeriodData disbursementOnlyPeriod(final LocalDate disbursementDate, final BigDecimal principalDisbursed,
            final BigDecimal feeChargesDueAtTimeOfDisbursement, final boolean isDisbursed,final BigDecimal depositAmount) {
        final Integer periodNumber = Integer.valueOf(0);
        final LocalDate from = null;
        return new LoanSchedulePeriodData(periodNumber, from, disbursementDate, principalDisbursed, feeChargesDueAtTimeOfDisbursement,
                isDisbursed,depositAmount);
    }
    public static LoanSchedulePeriodData disbursementOnlyPeriod(final LocalDate disbursementDate, final BigDecimal principalDisbursed,
            final BigDecimal feeChargesDueAtTimeOfDisbursement, final boolean isDisbursed,final BigDecimal redidualAmount,final BigDecimal depositAmount) {
        final Integer periodNumber = Integer.valueOf(0);
        final LocalDate from = null;
        return new LoanSchedulePeriodData(periodNumber, from, disbursementDate, principalDisbursed, feeChargesDueAtTimeOfDisbursement,
                isDisbursed,redidualAmount,depositAmount);
    }
    private LoanSchedulePeriodData(final Integer periodNumber, final LocalDate fromDate, final LocalDate dueDate,
            final BigDecimal principalDisbursed, final BigDecimal chargesDueAtTimeOfDisbursement, final boolean isDisbursed,final BigDecimal residualAmount,
            final BigDecimal depositAmount) {
        this.period = periodNumber;
        this.fromDate = fromDate;
        this.dueDate = dueDate;
        this.obligationsMetOnDate = null;
        this.residualAmount=residualAmount;
        this.depositAmount=depositAmount;
        this.complete = null;
        if (fromDate != null) {
            this.daysInPeriod = Days.daysBetween(this.fromDate, this.dueDate).getDays();
        } else {
            this.daysInPeriod = null;
        }
        this.principalDisbursed = principalDisbursed;
        this.principalOriginalDue = null;
        this.principalDue = null;
        this.principalPaid = null;
        this.principalWrittenOff = null;
        this.principalOutstanding = null;
        this.principalLoanBalanceOutstanding = principalDisbursed == null ? principalDisbursed : principalDisbursed.setScale(2, BigDecimal.ROUND_HALF_UP);

        this.interestOriginalDue = null;
        this.interestDue = null;
        this.interestPaid = null;
        this.interestWaived = null;
        this.interestWrittenOff = null;
        this.interestOutstanding = null;

        this.feeChargesDue = chargesDueAtTimeOfDisbursement;
        if (isDisbursed) {
            this.feeChargesPaid = chargesDueAtTimeOfDisbursement;
            this.feeChargesWaived = null;
            this.feeChargesWrittenOff = null;
            this.feeChargesOutstanding = null;
        } else {
            this.feeChargesPaid = null;
            this.feeChargesWaived = null;
            this.feeChargesWrittenOff = null;
            this.feeChargesOutstanding = chargesDueAtTimeOfDisbursement;
        }

        this.penaltyChargesDue = null;
        this.penaltyChargesPaid = null;
        this.penaltyChargesWaived = null;
        this.penaltyChargesWrittenOff = null;
        this.penaltyChargesOutstanding = null;

        this.totalOriginalDueForPeriod = chargesDueAtTimeOfDisbursement;
        this.totalDueForPeriod = chargesDueAtTimeOfDisbursement;
        this.totalPaidForPeriod = this.feeChargesPaid;
        this.totalPaidInAdvanceForPeriod = null;
        this.totalPaidLateForPeriod = null;
        this.totalWaivedForPeriod = null;
        this.totalWrittenOffForPeriod = null;
        this.totalOutstandingForPeriod = this.feeChargesOutstanding;
        this.totalActualCostOfLoanForPeriod = this.feeChargesDue;
        if (dueDate.isBefore(new LocalDate())) {
            this.totalOverdue = this.totalOutstandingForPeriod;
        } else {
            this.totalOverdue = null;
        }
    }

    public static LoanSchedulePeriodData repaymentOnlyPeriod(final Integer periodNumber, final LocalDate fromDate, final LocalDate dueDate,
            final BigDecimal principalDue, final BigDecimal principalOutstanding, final BigDecimal interestDueOnPrincipalOutstanding,
            final BigDecimal feeChargesDueForPeriod, final BigDecimal penaltyChargesDueForPeriod, final BigDecimal totalDueForPeriod) {

        return new LoanSchedulePeriodData(periodNumber, fromDate, dueDate, principalDue, principalOutstanding,
                interestDueOnPrincipalOutstanding, feeChargesDueForPeriod, penaltyChargesDueForPeriod, totalDueForPeriod);
    }

    public static LoanSchedulePeriodData repaymentPeriodWithPayments(@SuppressWarnings("unused") final Long loanId,
            final Integer periodNumber, final LocalDate fromDate, final LocalDate dueDate, final LocalDate obligationsMetOnDate,
            final boolean complete, final BigDecimal principalOriginalDue, final BigDecimal principalPaid,
            final BigDecimal principalWrittenOff, final BigDecimal principalOutstanding,
            final BigDecimal outstandingPrincipalBalanceOfLoan, final BigDecimal interestDueOnPrincipalOutstanding,
            final BigDecimal interestPaid, final BigDecimal interestWaived, final BigDecimal interestWrittenOff,
            final BigDecimal interestOutstanding, final BigDecimal feeChargesDue, final BigDecimal feeChargesPaid,
            final BigDecimal feeChargesWaived, final BigDecimal feeChargesWrittenOff, final BigDecimal feeChargesOutstanding,
            final BigDecimal penaltyChargesDue, final BigDecimal penaltyChargesPaid, final BigDecimal penaltyChargesWaived,
            final BigDecimal penaltyChargesWrittenOff, final BigDecimal penaltyChargesOutstanding, final BigDecimal totalDueForPeriod,
            final BigDecimal totalPaid, final BigDecimal totalPaidInAdvanceForPeriod, final BigDecimal totalPaidLateForPeriod,
            final BigDecimal totalWaived, final BigDecimal totalWrittenOff, final BigDecimal totalOutstanding,
            final BigDecimal totalActualCostOfLoanForPeriod) {

        return new LoanSchedulePeriodData(periodNumber, fromDate, dueDate, obligationsMetOnDate, complete, principalOriginalDue,
                principalPaid, principalWrittenOff, principalOutstanding, outstandingPrincipalBalanceOfLoan,
                interestDueOnPrincipalOutstanding, interestPaid, interestWaived, interestWrittenOff, interestOutstanding, feeChargesDue,
                feeChargesPaid, feeChargesWaived, feeChargesWrittenOff, feeChargesOutstanding, penaltyChargesDue, penaltyChargesPaid,
                penaltyChargesWaived, penaltyChargesWrittenOff, penaltyChargesOutstanding, totalDueForPeriod, totalPaid,
                totalPaidInAdvanceForPeriod, totalPaidLateForPeriod, totalWaived, totalWrittenOff, totalOutstanding,
                totalActualCostOfLoanForPeriod);
    }

    /*
     * constructor used for creating period on loan schedule that is only a
     * disbursement (typically first period)
     */
    private LoanSchedulePeriodData(final Integer periodNumber, final LocalDate fromDate, final LocalDate dueDate,
            final BigDecimal principalDisbursed, final BigDecimal chargesDueAtTimeOfDisbursement, final boolean isDisbursed,final BigDecimal depositAmount) {
        this.period = periodNumber;
        this.fromDate = fromDate;
        this.dueDate = dueDate;
        this.obligationsMetOnDate = null;
        this.complete = null;
        if (fromDate != null) {
            this.daysInPeriod = Days.daysBetween(this.fromDate, this.dueDate).getDays();
        } else {
            this.daysInPeriod = null;
        }
        this.principalDisbursed = principalDisbursed;
        this.principalOriginalDue = null;
        this.principalDue = null;
        this.principalPaid = null;
        this.principalWrittenOff = null;
        this.principalOutstanding = null;
        this.principalLoanBalanceOutstanding =  principalDisbursed == null ? principalDisbursed : principalDisbursed.setScale(2, BigDecimal.ROUND_HALF_UP);

        this.interestOriginalDue = null;
        this.interestDue = null;
        this.interestPaid = null;
        this.interestWaived = null;
        this.interestWrittenOff = null;
        this.interestOutstanding = null;

        this.feeChargesDue = chargesDueAtTimeOfDisbursement;
        if (isDisbursed) {
            this.feeChargesPaid = chargesDueAtTimeOfDisbursement;
            this.feeChargesWaived = null;
            this.feeChargesWrittenOff = null;
            this.feeChargesOutstanding = null;
        } else {
            this.feeChargesPaid = null;
            this.feeChargesWaived = null;
            this.feeChargesWrittenOff = null;
            this.feeChargesOutstanding = chargesDueAtTimeOfDisbursement;
        }

        this.penaltyChargesDue = null;
        this.penaltyChargesPaid = null;
        this.penaltyChargesWaived = null;
        this.penaltyChargesWrittenOff = null;
        this.penaltyChargesOutstanding = null;

        this.totalOriginalDueForPeriod = chargesDueAtTimeOfDisbursement;
        this.totalDueForPeriod = chargesDueAtTimeOfDisbursement;
        this.totalPaidForPeriod = this.feeChargesPaid;
        this.totalPaidInAdvanceForPeriod = null;
        this.totalPaidLateForPeriod = null;
        this.totalWaivedForPeriod = null;
        this.totalWrittenOffForPeriod = null;
        this.totalOutstandingForPeriod = this.feeChargesOutstanding;
        this.totalActualCostOfLoanForPeriod = this.feeChargesDue;
        if (dueDate.isBefore(new LocalDate())) {
            this.totalOverdue = this.totalOutstandingForPeriod;
        } else {
            this.totalOverdue = null;
        }
        
        this.depositAmount = depositAmount;
    }

    /*
     * used for repayment only period when creating an empty loan schedule for
     * preview etc
     */
    private LoanSchedulePeriodData(final Integer periodNumber, final LocalDate fromDate, final LocalDate dueDate,
            final BigDecimal principalOriginalDue, final BigDecimal principalOutstanding,
            final BigDecimal interestDueOnPrincipalOutstanding, final BigDecimal feeChargesDueForPeriod,
            final BigDecimal penaltyChargesDueForPeriod, final BigDecimal totalDueForPeriod) {
        this.period = periodNumber;
        this.fromDate = fromDate;
        this.dueDate = dueDate;
        this.obligationsMetOnDate = null;
        this.complete = null;
        if (fromDate != null) {
            this.daysInPeriod = Days.daysBetween(this.fromDate, this.dueDate).getDays();
        } else {
            this.daysInPeriod = null;
        }
        this.principalDisbursed = null;
        this.principalOriginalDue = principalOriginalDue;
        this.principalDue = principalOriginalDue;
        this.principalPaid = null;
        this.principalWrittenOff = null;
        this.principalOutstanding = principalOriginalDue;
        this.principalLoanBalanceOutstanding = principalOutstanding;

        this.interestOriginalDue = interestDueOnPrincipalOutstanding;
        this.interestDue = interestDueOnPrincipalOutstanding;
        this.interestPaid = null;
        this.interestWaived = null;
        this.interestWrittenOff = null;
        this.interestOutstanding = interestDueOnPrincipalOutstanding;

        this.feeChargesDue = feeChargesDueForPeriod;
        this.feeChargesPaid = null;
        this.feeChargesWaived = null;
        this.feeChargesWrittenOff = null;
        this.feeChargesOutstanding = null;

        this.penaltyChargesDue = penaltyChargesDueForPeriod;
        this.penaltyChargesPaid = null;
        this.penaltyChargesWaived = null;
        this.penaltyChargesWrittenOff = null;
        this.penaltyChargesOutstanding = null;

        this.totalOriginalDueForPeriod = totalDueForPeriod;
        this.totalDueForPeriod = totalDueForPeriod;
        this.totalPaidForPeriod = BigDecimal.ZERO;
        this.totalPaidInAdvanceForPeriod = null;
        this.totalPaidLateForPeriod = null;
        this.totalWaivedForPeriod = null;
        this.totalWrittenOffForPeriod = null;
        this.totalOutstandingForPeriod = totalDueForPeriod;
        this.totalActualCostOfLoanForPeriod = interestDueOnPrincipalOutstanding.add(feeChargesDueForPeriod);

        if (dueDate.isBefore(new LocalDate())) {
            this.totalOverdue = this.totalOutstandingForPeriod;
        } else {
            this.totalOverdue = null;
        }
    }

    /*
     * Used for creating loan schedule periods with full information on expected
     * principal, interest & charges along with what portion of each is paid.
     */
    private LoanSchedulePeriodData(final Integer periodNumber, final LocalDate fromDate, final LocalDate dueDate,
            final LocalDate obligationsMetOnDate, final boolean complete, final BigDecimal principalOriginalDue,
            final BigDecimal principalPaid, final BigDecimal principalWrittenOff, final BigDecimal principalOutstanding,
            final BigDecimal principalLoanBalanceOutstanding, final BigDecimal interestDueOnPrincipalOutstanding,
            final BigDecimal interestPaid, final BigDecimal interestWaived, final BigDecimal interestWrittenOff,
            final BigDecimal interestOutstanding, final BigDecimal feeChargesDue, final BigDecimal feeChargesPaid,
            final BigDecimal feeChargesWaived, final BigDecimal feeChargesWrittenOff, final BigDecimal feeChargesOutstanding,
            final BigDecimal penaltyChargesDue, final BigDecimal penaltyChargesPaid, final BigDecimal penaltyChargesWaived,
            final BigDecimal penaltyChargesWrittenOff, final BigDecimal penaltyChargesOutstanding, final BigDecimal totalDueForPeriod,
            final BigDecimal totalPaid, final BigDecimal totalPaidInAdvanceForPeriod, final BigDecimal totalPaidLateForPeriod,
            final BigDecimal totalWaived, final BigDecimal totalWrittenOff, final BigDecimal totalOutstanding,
            final BigDecimal totalActualCostOfLoanForPeriod) {
        this.period = periodNumber;
        this.fromDate = fromDate;
        this.dueDate = dueDate;
        this.obligationsMetOnDate = obligationsMetOnDate;
        this.complete = complete;
        if (fromDate != null) {
            this.daysInPeriod = Days.daysBetween(this.fromDate, this.dueDate).getDays();
        } else {
            this.daysInPeriod = null;
        }
        this.principalDisbursed = null;
        this.principalOriginalDue = principalOriginalDue;
        this.principalDue = principalOriginalDue;
        this.principalPaid = principalPaid;
        this.principalWrittenOff = principalWrittenOff;
        this.principalOutstanding = principalOutstanding;
        this.principalLoanBalanceOutstanding = principalLoanBalanceOutstanding;

        this.interestOriginalDue = interestDueOnPrincipalOutstanding;
        this.interestDue = interestDueOnPrincipalOutstanding;
        this.interestPaid = interestPaid;
        this.interestWaived = interestWaived;
        this.interestWrittenOff = interestWrittenOff;
        this.interestOutstanding = interestOutstanding;

        this.feeChargesDue = feeChargesDue;
        this.feeChargesPaid = feeChargesPaid;
        this.feeChargesWaived = feeChargesWaived;
        this.feeChargesWrittenOff = feeChargesWrittenOff;
        this.feeChargesOutstanding = feeChargesOutstanding;

        this.penaltyChargesDue = penaltyChargesDue;
        this.penaltyChargesPaid = penaltyChargesPaid;
        this.penaltyChargesWaived = penaltyChargesWaived;
        this.penaltyChargesWrittenOff = penaltyChargesWrittenOff;
        this.penaltyChargesOutstanding = penaltyChargesOutstanding;

        this.totalOriginalDueForPeriod = totalDueForPeriod;
        this.totalDueForPeriod = totalDueForPeriod;
        this.totalPaidForPeriod = totalPaid;
        this.totalPaidInAdvanceForPeriod = totalPaidInAdvanceForPeriod;
        this.totalPaidLateForPeriod = totalPaidLateForPeriod;
        this.totalWaivedForPeriod = totalWaived;
        this.totalWrittenOffForPeriod = totalWrittenOff;
        this.totalOutstandingForPeriod = totalOutstanding;
        this.totalActualCostOfLoanForPeriod = totalActualCostOfLoanForPeriod;

        if (dueDate.isBefore(new LocalDate())) {
            this.totalOverdue = this.totalOutstandingForPeriod;
        } else {
            this.totalOverdue = null;
        }
    }

    private BigDecimal defaultToZeroIfNull(final BigDecimal possibleNullValue) {
        BigDecimal value = BigDecimal.ZERO;
        if (possibleNullValue != null) {
            value = possibleNullValue;
        }
        return value;
    }

    public Integer periodNumber() {
        return this.period;
    }

    public LocalDate periodFromDate() {
        return this.fromDate;
    }

    public LocalDate periodDueDate() {
        return this.dueDate;
    }

    public Integer daysInPeriod() {
        return this.daysInPeriod;
    }

    public BigDecimal principalDisbursed() {
        return defaultToZeroIfNull(this.principalDisbursed);
    }

    public BigDecimal principalDue() {
        return defaultToZeroIfNull(this.principalDue);
    }

    public BigDecimal principalPaid() {
        return defaultToZeroIfNull(this.principalPaid);
    }

    public BigDecimal principalWrittenOff() {
        return defaultToZeroIfNull(this.principalWrittenOff);
    }

    public BigDecimal principalOutstanding() {
        return defaultToZeroIfNull(this.principalOutstanding);
    }

    public BigDecimal interestDue() {
        return defaultToZeroIfNull(this.interestDue);
    }

    public BigDecimal interestPaid() {
        return defaultToZeroIfNull(this.interestPaid);
    }

    public BigDecimal interestWaived() {
        return defaultToZeroIfNull(this.interestWaived);
    }

    public BigDecimal interestWrittenOff() {
        return defaultToZeroIfNull(this.interestWrittenOff);
    }

    public BigDecimal interestOutstanding() {
        return defaultToZeroIfNull(this.interestOutstanding);
    }

    public BigDecimal feeChargesDue() {
        return defaultToZeroIfNull(this.feeChargesDue);
    }

    public BigDecimal feeChargesWaived() {
        return defaultToZeroIfNull(this.feeChargesWaived);
    }

    public BigDecimal feeChargesWrittenOff() {
        return defaultToZeroIfNull(this.feeChargesWrittenOff);
    }

    public BigDecimal feeChargesPaid() {
        return defaultToZeroIfNull(this.feeChargesPaid);
    }

    public BigDecimal feeChargesOutstanding() {
        return defaultToZeroIfNull(this.feeChargesOutstanding);
    }

    public BigDecimal penaltyChargesDue() {
        return defaultToZeroIfNull(this.penaltyChargesDue);
    }

    public BigDecimal penaltyChargesWaived() {
        return defaultToZeroIfNull(this.penaltyChargesWaived);
    }

    public BigDecimal penaltyChargesWrittenOff() {
        return defaultToZeroIfNull(this.penaltyChargesWrittenOff);
    }

    public BigDecimal penaltyChargesPaid() {
        return defaultToZeroIfNull(this.penaltyChargesPaid);
    }

    public BigDecimal penaltyChargesOutstanding() {
        return defaultToZeroIfNull(this.penaltyChargesOutstanding);
    }

    public BigDecimal totalOverdue() {
        return defaultToZeroIfNull(this.totalOverdue);
    }
    
    public LocalDate periodObligationsMetOnDate() {
    	return this.obligationsMetOnDate;
    }
    
    public BigDecimal periodResidualAmount() {
    	return defaultToZeroIfNull(this.residualAmount);
    }
    
    public BigDecimal periodPrincipalLoanBalanceOutstanding() {
    	return defaultToZeroIfNull(this.principalLoanBalanceOutstanding);
    }
    
    public BigDecimal periodInterestOriginalDue() {
    	return this.interestOriginalDue;
    }
    
    public BigDecimal totalDueForPeriod() {
    	return defaultToZeroIfNull(this.totalDueForPeriod);
    }
    
    public BigDecimal totalPaidForPeriod() {
    	return defaultToZeroIfNull(this.totalPaidForPeriod);
    }
    
    public BigDecimal totalOutstandingForPeriod() {
    	return this.totalOutstandingForPeriod;
    }
}
package com.example.mortgageapp;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.ReadablePartial;

public class CurrentDateInterestCalculator {
    Double Interest;
    public Double CalculateInterest(Long startdate1, Long currentdate1, Float ROI1, Long amountpaid1){
        LocalDate startdate = new LocalDate(startdate1);
        LocalDate currentdate = new LocalDate(currentdate1);
        Float ROI = ROI1;
        Long amountpaid = amountpaid1;
        int m = new Period((ReadablePartial) currentdate, (ReadablePartial) startdate, PeriodType.months()).getMonths();
        int d = new Period((ReadablePartial) currentdate, (ReadablePartial) startdate, PeriodType.yearMonthDay()).getDays();
        if (m == 0 && d <= 15) {
          Interest = Double.valueOf(Math.round((amountpaid*15*ROI)/3000));

        }
        else if (m == 0 && d > 15) {
            Interest = Double.valueOf(Math.round(((amountpaid * ROI * 1) / 100)));

        }
        else if (m > 0 || d > 0) {
            if(m>0 && d==0){
                Interest = Double.valueOf(Math.round((amountpaid*ROI*m)/100));
            }
            if (m>0 && (d>0 && d <= 15)) {
                Double monthinterest = Double.valueOf(Math.round((amountpaid*ROI*m)/100));
                Double dayinterest = Double.valueOf(Math.round((amountpaid*ROI*15)/3000));
                Interest = monthinterest+dayinterest;



            }
            if (m>0 && d > 15) {
                Double monthinterest = Double.valueOf(Math.round((amountpaid*ROI*m)/100));
                Double dayinterest = Double.valueOf(Math.round((amountpaid*ROI*1)/100));
                Interest = monthinterest+dayinterest;



            }

        }

        return Interest;
    }

}

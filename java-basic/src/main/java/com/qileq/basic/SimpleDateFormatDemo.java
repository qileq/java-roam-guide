package com.qileq.basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleDateFormatDemo {

	public void dateStrConvert() throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-12-25 12:00:00");
		String now = new SimpleDateFormat("yyyy/MM/dd").format(date);
		log.info("str -> date: {}, date -> str: {},", date, now);
	}

	public void yyyyAndYYYYDifference() {
		GregorianCalendar gregorianCalendar = new GregorianCalendar(2021, Calendar.DECEMBER, 26);
		Date date = gregorianCalendar.getTime();

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
		log.info("Get year by yyyy from {} is {} ", date, sdf2.format(date));

		SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY");
		log.info("Get year by YYYY from {} is {} ", date, sdf1.format(date));
	}
}

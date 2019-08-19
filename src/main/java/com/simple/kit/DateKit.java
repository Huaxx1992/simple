package com.simple.kit;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateKit {

	private static final String DEFAULT_ZONE = "UTC+8";

	private static final DateTimeFormatter TIME_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static String formatTime(Date target) {
		Instant ins = target.toInstant();
		ZonedDateTime zdt = ins.atZone(ZoneId.of(DEFAULT_ZONE));
		return zdt.format(TIME_PATTERN);
	}

	public static String formatDate(Date target) {
		Instant ins = target.toInstant();
		ZonedDateTime zdt = ins.atZone(ZoneId.of(DEFAULT_ZONE));
		return zdt.format(DATE_PATTERN);
	}

}

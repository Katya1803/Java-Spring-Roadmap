package com.company.codetointerface_ex;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.company.codetointerface_ex.entity.User;

public class IdGenerator {
	
	public static void generateId(User user) {
		
		LocalDateTime created = user.getCreatedOn() != null ? user.getCreatedOn():LocalDateTime.now(ZoneId.of("UTC"));
		
		String id = created.format(DateTimeFormatter.BASIC_ISO_DATE) + "-"+UUID.randomUUID();
		
		user.setId(id);
	}
}
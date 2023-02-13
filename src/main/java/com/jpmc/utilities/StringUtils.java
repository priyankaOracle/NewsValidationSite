package com.jpmc.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringUtils {

	static Logger log = LogManager.getLogger(StringUtils.class);

	public static String sanitizeString(String input) {
		log.debug("---Sanitize string---");
		String sanitizedString = removeSpecialChars(input.toLowerCase());
		log.debug("---Returned Sanitize string---");
		return removeUnwantedWords(sanitizedString);
	}

	private static String removeSpecialChars(String input) {
		log.debug("---Sanitize string by removing special characters---");
		log.debug("---Returned Sanitize string---");
		return input.replaceAll("[^a-zA-Z0-9\\s]", " ");

	}

	private static String removeUnwantedWords(String input) {
		log.debug("---Sanitize string by removing unwanted words---");
		log.debug("---Returned Sanitize string---");
		return input.replaceAll(getUnwantedWordsRegex(), " ");

	}

	private static String getUnwantedWordsRegex() {
		log.debug("---Get Unwanted Words regex---");
		StringBuilder pattern = new StringBuilder();
		pattern.append("(\\s+)(");
		pattern.append(String.join("|", UnwantedWords.words));
		pattern.append(")(\\s+)");
		log.debug("---Return Unwanted Words regex---");
		return pattern.toString();
	}

	public static double getMatchPercent(String source, String target) {
		log.debug("Matching Source : {} and target: {}", source, target);
		String[] headLineWords = source.split("\\s");
		double count = 0;
		for (String word : headLineWords) {
			if (target.contains(word)) {
				count++;
			}
		}
		double per = (count / headLineWords.length) * 100;
		log.debug("Matching Percentage is {}", per);
		return per;

	}

}

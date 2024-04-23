package ca.cmpt213.as4.model.characterfillers;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrap some given text to a desired width.
 * Break on space if possible.
 */
public class WordWrapper {
	private final List<String> wrappedTextLines = new ArrayList<>();
	private final int maxCharPerLine;
	private String remainingText;

	public WordWrapper(String fullText, int maxCharPerLine) {
		this.maxCharPerLine = maxCharPerLine;
		remainingText = fullText.trim();
		wrapTextToWidth();
	}

	public int getNumLines() {
		return wrappedTextLines.size();
	}

	public String getLine(int lineNum) {
		if (lineNum < wrappedTextLines.size() && lineNum >= 0) {
			return wrappedTextLines.get(lineNum);
		} else {
			return "";
		}
	}



	private void wrapTextToWidth() {
		while (remainingText.length() > 0) {
			int lineLength = getNumCharOnNextLine();

			String thisLine = remainingText.substring(0, lineLength).trim();
			remainingText = remainingText.substring(lineLength).trim();

			wrappedTextLines.add(thisLine);
		}
	}

	private int getNumCharOnNextLine() {
		int lineLength = remainingText.length();

		if (lineLength > maxCharPerLine) {
			int lastSpaceIdx = remainingText.lastIndexOf(" ", maxCharPerLine);
			if (lastSpaceIdx > 0) {
				lineLength = lastSpaceIdx;
			} else {
				lineLength = maxCharPerLine;
			}
		}
		return lineLength;
	}


}

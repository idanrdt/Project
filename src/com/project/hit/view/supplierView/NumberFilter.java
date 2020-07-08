package com.project.hit.view.supplierView;

import javax.swing.text.*;
import java.util.regex.*;

/**
 * A number filter.<br>
 * Sets the {@link JTextField} text to allow only number and between 0 to 8 characters.
 */
public class NumberFilter extends DocumentFilter
{
	private int minValue = 0;
	private int maxValue = 8;
	
    public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException
    {
        StringBuilder builder = new StringBuilder();
        builder.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        builder.insert(offset, text);
        if(!containsOnlyNumbers(builder.toString())) return;
        fb.insertString(offset, text, attr);
    }
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attr) throws BadLocationException
    {
        StringBuilder builder = new StringBuilder();
        builder.append(fb.getDocument().getText(0, fb.getDocument().getLength()));
        builder.replace(offset, offset + length, text);
        if(!containsOnlyNumbers(builder.toString())) return;
        fb.replace(offset, length, text, attr);
    }
    public boolean containsOnlyNumbers(String text)
    {
        Pattern pattern = Pattern.compile("\\d{"+minValue+","+maxValue+"}");
        Matcher matcher = pattern.matcher(text);
        boolean isMatch = matcher.matches();
        return isMatch;
    }
}
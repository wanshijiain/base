package com.czw.base.enu;

import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Zevi Chan
 * @date 2016-07-28 23:19:54
 */
public class EnumBitField {
	public static Logger log = LoggerFactory.getLogger(EnumBitField.class);
	public enum Style{ BOLD,ITALIC,UNDERLINE,STRIKETHROUGH}
	
	public void applyStyles(Set<Style> styles){
		Iterator<Style> it = styles.iterator();
		while(it.hasNext()){
			log.info("EnumBitField: "+it.next());
		}
	}
	
}
class Text{
	public static final int STYLE_BOLD				= 1<<0;
	public static final int STYLE_ITALIC			= 1<<1;
	public static final int STYLE_UNDERLINE			= 1<<2;
	public static final int STYLE_STRIKETHROUGH		= 1<<3;
	
	public static Logger log = LoggerFactory.getLogger(Text.class);
	
	public void applyStyles(int styles){
		log.info("Text: "+styles);
	}
	
}
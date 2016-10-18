/**
 * 
 */
package com.czw.model.factory.absfactory;

/**
 * @author ZeviChen , 2016-10-18 15:41:27
 */
public interface SkinFactory {
	Button createButton();
	TextField createTextField();
	ComboBox createComboBox();
}

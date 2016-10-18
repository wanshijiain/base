/**
 * 
 */
package com.czw.model.factory.absfactory;

/**
 * @author ZeviChen , 2016-10-18 15:44:11
 */
public class SummerSkinFactory implements SkinFactory {

	@Override
	public Button createButton() {
		return new SummerButton();
	}

	@Override
	public TextField createTextField() {
		return new SummberTextField();
	}

	@Override
	public ComboBox createComboBox() {
		return new SummerComboBox();
	}

}

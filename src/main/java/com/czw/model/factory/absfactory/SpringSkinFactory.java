/**
 * 
 */
package com.czw.model.factory.absfactory;

/**
 * @author ZeviChen , 2016-10-18 15:42:52
 */
public class SpringSkinFactory implements SkinFactory {

	@Override
	public Button createButton() {
		return new SpringButton();
	}

	@Override
	public TextField createTextField() {
		return new SpringTextField();
	}

	@Override
	public ComboBox createComboBox() {
		return new SpringComboBox();
	}

}

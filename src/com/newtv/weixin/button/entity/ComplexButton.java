package com.newtv.weixin.button.entity;

public class ComplexButton extends BaseButton{
private BaseButton[] sub_button;

public BaseButton[] getSub_button() {
	return sub_button;
}

public void setSubbutton(BaseButton[] sub_button) {
	this.sub_button = sub_button;
}
}

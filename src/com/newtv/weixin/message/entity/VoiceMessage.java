package com.newtv.weixin.message.entity;

public class VoiceMessage extends BaseMessage {
private Voice voice;

public Voice getVoice() {
	return voice;
}

public void setVoice(Voice voice) {
	this.voice = voice;
}
}

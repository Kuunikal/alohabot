package alohabot;

import com.sevensagas.discordbot.Command;
import com.sevensagas.discordbot.DiscordBot;
import com.sevensagas.discordbot.util.Util;

import sx.blah.discord.handle.obj.IMessage;

public class Hello extends Command {

	public Hello(DiscordBot bot, IMessage m, String[] args) {
		super(bot, m, args);
	}

	@Override
	protected void execute() throws InternalException {
		bot.say(Util.pick(new String[] {"aloha", "hello", "hey there"}) + ", " + auth + "!", ch);	// Reply with a random hello message
	}

	@Override
	public String getDesc() {
		return null;
	}

	@Override
	public String getDetailedHelp() {
		return null;
	}

}

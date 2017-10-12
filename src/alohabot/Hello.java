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
		String msg = Util.pick(new String[] {"aloha", "hello", "hey there"});
		bot.say(msg + ", " + auth + "!", ch);
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDetailedHelp() {
		// TODO Auto-generated method stub
		return null;
	}

}

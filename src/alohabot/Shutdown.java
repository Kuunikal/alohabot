package alohabot;

import com.sevensagas.discordbot.Command;
import com.sevensagas.discordbot.DiscordBot;

import sx.blah.discord.handle.obj.IMessage;

public class Shutdown extends Command {

	public Shutdown(DiscordBot bot, IMessage m, String[] args) {
		super(bot, m, args);
	}

	@Override
	protected void execute() throws InternalException {
		if (auth.getLongID() == 233260729929564170l) bot.shutdown();
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

package alohabot;

import com.sevensagas.discordbot.Command;
import com.sevensagas.discordbot.DiscordBot;
import com.sevensagas.discordbot.util.Util;

import sx.blah.discord.handle.obj.IMessage;

public class Trigger extends Command {
	
	public Trigger(DiscordBot bot, IMessage m, String[] args) {
		super(bot, m, args);
	}
	
	@Override
	protected void execute() throws InternalException {
		if (args.size() < 2 ) {
			bot.say("this command takes at least two arguments", ch);
			return;
		}
		String m = Util.concat(args.subList(1, args.size()), " ");
		
		if (bot.interpreter.getCommand(args.get(0)) != null) {
			bot.say("this trigger already exists!", ch);
			return;
		}
		
		if (!auth.getRolesForGuild(guild).contains(bot.getRolesByName("trusted", guild).get(0))) {
			return;
		}
		
		bot.interpreter.addCommand((bot, msg, args) -> {
			return new Command(bot, msg, args) {

				@Override
				protected void execute() throws InternalException {
					bot.say(m, ch);
				}

				@Override
				public String getDesc() {
					return null;
				}

				@Override
				public String getDetailedHelp() {
					return null;
				}
				
			};
		}, args.get(0));
		
		bot.getItems(guild).set("t_" + args.get(0), m);
		bot.say("trigger **" + args.get(0) + "** has been added!", ch);
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

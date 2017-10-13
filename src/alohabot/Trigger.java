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
		// If the command arguments are less than two then do nothing
		if (args.size() < 2 ) {
			bot.say("this command takes at least two arguments", ch);
			return;
		}
		
		// Create 'm' variable (message), joining all of the arguments after the first one (the trigger name)
		String m = Util.concat(args.subList(1, args.size()), " ");
		
		// If the trigger name already exists then do nothing
		if (bot.interpreter.getCommand(args.get(0)) != null) {
			bot.say("this trigger already exists!", ch);
			return;
		}
		
		// If the user isn't trusted then do nothing
		if (!auth.getRolesForGuild(guild).contains(bot.getRolesByName("trusted", guild).get(0))) {
			return;
		}
		
		// Add an anonymous command
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
		}, args.get(0));													// Command's alias is the first argument
		
		bot.getItems(guild).set("t_" + args.get(0), m);						// Save the items to the guild
		bot.say("trigger **" + args.get(0) + "** has been added!", ch);		// Inform that the trigger has been saved
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

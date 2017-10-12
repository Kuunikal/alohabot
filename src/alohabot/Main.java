package alohabot;

import com.sevensagas.discordbot.DiscordBot;
import com.sevensagas.discordbot.util.Util;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.member.UserJoinEvent;

public class Main {
	static DiscordBot bot;
	
	public static void main(String[] args) {
		
		bot = new DiscordBot(args[0]);						// Create DiscordBot from first argument, which is token
		bot.interpreter.setPrefix("!");						// Commands for the bot start with '!'
		
		// Add commands to bot; first argument is the command class and the others are command names that trigger it
		bot.interpreter.addCommand(Hello::new, "hello", "hey", "hi", "aloha");		
		
		bot.client.getDispatcher().registerListener(new Object() {
			@EventSubscriber
			public void onJoin(UserJoinEvent e) {
				String msg = Util.pick(new String[] {"welcome", "mahalo for stopping by", "aloha"});	// Pick a random message
				bot.say(msg + ", " + e.getUser() + "!", e.getGuild().getDefaultChannel());				// Use the message and ping user when they join
			}
		});
	}
	
}

package com.jonathan.ordinalcompass;

import com.google.inject.Provides;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@PluginDescriptor(name = "Example")
public final class ExamplePlugin extends Plugin {
  private static final Logger log = LoggerFactory.getLogger(ExamplePlugin.class);

  @Inject
  private Client client;

  @Inject
  private ExampleConfig config;

  @Override
  protected void startUp() throws Exception {
    log.debug("Example started!");
  }

  @Override
  protected void shutDown() throws Exception{
    log.debug("Example stopped!");
  }

  @Subscribe
  public void onGameStateChanged(GameStateChanged gameStateChanged) {
    if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {
      client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
    }
  }

  @Provides
  ExampleConfig provideConfig(ConfigManager configManager) {
    return configManager.getConfig(ExampleConfig.class);
  }
}

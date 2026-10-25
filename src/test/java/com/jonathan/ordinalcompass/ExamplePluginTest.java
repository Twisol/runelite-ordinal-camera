package com.jonathan.ordinalcompass;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

import org.junit.Test;

public final class ExamplePluginTest {
  public static void main(String[] args) throws Exception {
    ExternalPluginManager.loadBuiltin(ExamplePlugin.class);
    RuneLite.main(args);
  }

  @Test
  public void foo() {
    // yay!
  }
}

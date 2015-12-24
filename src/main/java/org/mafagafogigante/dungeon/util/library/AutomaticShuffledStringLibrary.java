/*
 * Copyright (C) 2015 Bernardo Sulzbach
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mafagafogigante.dungeon.util.library;

import org.mafagafogigante.dungeon.io.JsonObjectFactory;
import org.mafagafogigante.dungeon.logging.DungeonLogger;

import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * An automatically shuffled library of strings.
 */
public class AutomaticShuffledStringLibrary {

  private final String filename;
  private final List<String> strings = new ArrayList<>();
  private AutomaticShuffledRange automaticShuffledRange;

  public AutomaticShuffledStringLibrary(@NotNull String filename) {
    this.filename = filename;
    initialize();
  }

  private void initialize() {
    JsonObject jsonObject = JsonObjectFactory.makeJsonObject(filename);
    for (JsonValue value : jsonObject.get("strings").asArray()) {
      strings.add(value.asString());
    }
    if (strings.isEmpty()) {
      throw new IllegalStateException("no strings were loaded.");
    }
    automaticShuffledRange = new AutomaticShuffledRange(strings.size());
    DungeonLogger.info("Loaded " + strings.size() + " strings from " + filename + ".");
  }

  /**
   * Retrieves the next String in the library.
   */
  public String next() {
    return strings.get(automaticShuffledRange.getNext());
  }

}

/*
 * Copyright (C) 2014 Bernardo Sulzbach
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

package org.dungeon.game;

/**
 * Command abstract class that defines a type for command objects.
 * <p/>
 * Make anonymous classes from this one to define commands.
 * <p/>
 * Created by Bernardo Sulzbach on 11/01/15.
 */
public abstract class Command {

  public final String name;
  public final String info;

  public Command(String name) {
    this.name = name;
    this.info = null;
  }

  public Command(String name, String info) {
    this.name = name;
    this.info = info;
  }

  /**
   * Executes the Command, given an IssuedCommand.
   */
  abstract public void execute(IssuedCommand issuedCommand);

}